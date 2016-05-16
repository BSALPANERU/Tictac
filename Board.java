
public class Board {
	
	public static final int ROW = 3;
	public static final int COL = 3;
	
	Cell[][] cells;
	int currentRow, currentCol;
	public Board(){
		
		cells = new Cell[ROW][COL];
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				cells[row][col] = new Cell(row,col);
			}
		}
		
		
	}
	
	public void init(){
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				cells[row][col].clear();
			}
		}
		
	}
	
	public void paintthecell(){
		System.out.println("_______");
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				cells[row][col].paint();
				
				if(col < COL){
					
					
					System.out.print("|");
				}
				
		}System.out.println();
			if(row<ROW){
				System.out.println("_______");
			}
		}
	}
	
	public boolean isDraw(){
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				if(cells[row][col].content == Space.EMPTY){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean hasWon(Space markXO){
		return(cells[currentRow][0].content == markXO		//check row for similiar marks
				&&cells[currentRow][1].content == markXO
				&&cells[currentRow][2].content == markXO
				|| cells[0][currentCol].content == markXO     // check column
		                   && cells[1][currentCol].content == markXO 
		                   && cells[2][currentCol].content == markXO 
		              || currentRow == currentCol            // check the diagonal
		                   && cells[0][0].content == markXO 
		                   && cells[1][1].content == markXO 
		                   && cells[2][2].content == markXO 
		              || currentRow + currentCol == 2    //check the opposite diagonal
		                   && cells[0][2].content == markXO 
		                   && cells[1][1].content == markXO 
		                   && cells[2][0].content == markXO 
				
			
				
				);
		
	}

}
