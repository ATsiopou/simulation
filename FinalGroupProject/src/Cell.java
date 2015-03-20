import java.util.*;

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
		//Do Nothing 
	}

	public Cell(int col, int row) {
		this.row = row;
		this.col = col;
	}

	public Cell(int col, int row, boolean occupied ){
		this.col = col; 
		this.row = row; 
		this.occupied=occupied; 
	}
	
	/**
	 * Returns the Row (y) of the cell
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Sets the Row (y) value of the Cell 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Returns the Column (x) of the cell
	 * @return
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Sets the column (x) value of the cell
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * Returns true false if the cell is occupied
	 * true == occupied
	 * false == not occupied 
	 * @return
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * Sets the occupied value of a single cell 
	 * @param occupied
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	/**
	 * Overriding the toString method to print row and col 
	 */
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
