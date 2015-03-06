/*Authors :
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
 
 public Cell(){}
 
 public Cell(int row, int col) {
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
 
}
