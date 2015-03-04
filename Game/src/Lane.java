/*Authors : Iordanis Paschalidis 
 * 			Anthony Tsiopoulos 
 * 
 * Class  : Lane
 * 			The Lane class is responsible constructing a single lane. A lane consista of two 
 * 			Cell objects start and end. These give the row and column for the starting position 
 * 			and the end position
 * 
 * Moded  : 
 * 
 */

public class Lane {

 Cell start;
 Cell end;

 public Cell getStart() {
  return start;
 }
 public void setStart(Cell start) {
  this.start = start;
 }
 public Cell getEnd() {
  return end;
 }
 public void setEnd(Cell end) {
  this.end = end;
 }

 /**
  * Prints the x and y position of the lanes 
  */
 public void printLanePosition(){
	 System.out.println("Lane position"); 
	 System.out.println("(x0,y0) --> (xN,yN)"); 
	 System.out.println("(" +start.getCol()+","+start.getRow()+")"+"   -->  " +"("+end.getCol()+","+end.getRow()+")"); 
 }	
}
