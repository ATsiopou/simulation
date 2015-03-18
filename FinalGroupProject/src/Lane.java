/*Authors  : Iordanis Paschalidis 
 * 		 	 Anthony Tsiopoulos 
 * 
 * Class   : Lane
 * 		 	 The Lane class is responsible constructing a single lane. A lane consista of two 
 * 			 Cell objects start and end. 
 * 
 * id	   : An id is given to a single lane. The condition is that if the lane 
 * 		   	 is on the LHS of the road, the id will be odd. For a RHS lane, the
 * 			 id is even. 
 *
 *direction: The direction is one of NORTH,EAST,SOUTH,WEST
 *
 * start   : A Cell object identifying the starting cells row and col position.
 *
 * end     : A Cell object identifying the end cells row and col position. 
 * 
 * Moded  : 
 * 
 */

public class Lane {

	private int id;  	
	private	Cell start;
	private Cell end;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	/**
	 * Prints the x and y position of the lanes
	 */
	public void printLanePosition() {
		System.out.println("Lane position");
		System.out.println("(x0,y0) --> (xN,yN)");
		System.out.println("(" + start.getCol() + "," + start.getRow() + ")"
				+ "   -->  " + "(" + end.getCol() + "," + end.getRow() + ")");
	}
}
