//for a single cell
public class Cell {
	
	int row,col;
	Space content;
	public Cell(int row , int col){
		this.row = row;
		this.col = col;
		clear();
	}
	public void clear() {
		content = Space.EMPTY;
		
	}
	public void paint(){
		switch (content) {
		case CROSS:
			System.out.print("X");
			
			break;
		case CIRCLE:
			System.out.print("O");
			
			break;
		case EMPTY:
			System.out.print(" ");
			
			break;

		
		}
	}

}
