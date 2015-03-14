import java.util.ArrayList;

/*Authors : Iordanis Paschalidis, 
 * 			Anthony Tsiopoulos 
 * 
 * Class  : Cell 
 * 			The Cell class represents a coordinate on a planar grid. The object has two fields, 
 * 			which can be seen as an ordered pair - representing their coordinates on a 2D grid. 
 * 			A cell is the basis of the program, that is everything stems from this class. 
 * 
 * Moded  : 03/02/15
 * 
 */

public class Cell {

	private int row;
	private int col;
	boolean occupied;

	public Cell() {
	}

	public Cell(int col, int row) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public String toString() {
		return "Col: " + col + " Row: " + row;
	}

	/**
	 * This takes a single cell, extracts the row and col,and
	 * checks if the cells are equal.
	 * @param cell
	 * @return
	 */
	public boolean equals(Cell cell) {
		if (this.row == cell.getRow() && this.col == cell.getCol())
			return true;
		return false;
	}

	/**
	 * This method takes a list of cells, checks each element for
	 * a match and returns
	 * @param occupiedCells
	 * @return
	 */
	public boolean listEquals(ArrayList<Cell> occupiedCells) {
		
		for(Cell cell: occupiedCells){
			if(this.row == cell.getRow() && this.col == cell.getCol())
				return true;
		}
		return false; 
	}
	
	

}
