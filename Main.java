import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner(System.in);

	private Board board;
	private GameState curstate;
	private Space currentPlayer;

	public Main() {
		board = new Board();
		mainInit();

		do {
			playerMove(currentPlayer);
			board.paintthecell();
			updateGame(currentPlayer);
			if(curstate == GameState.CROSS_WON){
				System.out.println("X WON");
			}else if(curstate == GameState.CIRCLE_WON){
				System.out.println("O WON");
			}else if(curstate == GameState.DRAW){
				System.out.println("DRAW ,,,,");
			}
			
			
			
			currentPlayer = (currentPlayer == Space.CROSS) ? Space.CIRCLE : Space.CROSS;
			
		} while (curstate == GameState.PLAYING);
	}

	private void updateGame(Space markXO) {
		if(board.hasWon(markXO)){
			curstate = (markXO == Space.CROSS) ? GameState.CROSS_WON : GameState.CIRCLE_WON;
			
		}else if(board.isDraw()){
			curstate = GameState.DRAW;
		}
		
	}

	private void mainInit() {
		board.init();
		curstate = GameState.PLAYING;
		currentPlayer = Space.CROSS;

	}

	private void playerMove(Space markXO) {
		boolean validInput = false;
		do {
			if (markXO == Space.CROSS) {
				System.out
						.println("Player 'X', enter your move (row[1-3] column[1-3]): ");
			} else {
				System.out
						.println("Player 'O', enter your move (row[1-3] column[1-3]): ");
			}
			int row = input.nextInt() - 1;
			int col = input.nextInt() - 1;
			if (row >= 0 && row < board.ROW && col >= 0 && col < board.COL
					&& board.cells[row][col].content == Space.EMPTY) {
				board.cells[row][col].content = markXO;
				board.currentRow = row;
				board.currentCol = col;
				validInput = true;
			} else {
				System.out.println("The (" + (row + 1) + ","
						+ (col + 1) + ") is not valid!! Try again ");
			}
		} while (!validInput);

	}

	public static void main(String[] args) {
		
		
			new Main();
		
	
	}

}
