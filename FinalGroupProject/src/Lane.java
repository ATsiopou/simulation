/*Authors  : Iordanis Paschalidis 
 * 		 	 Anthony Tsiopoulos 
 * 
 * Class   : Lane
 * 		 	 The Lane class is responsible constructing a single lane. A lane consists of two 
 * 			 Cell objects start and end. 
 * 
 * id	   : An id is given to a single lane. The condition is that if the lane 
 * 		   	 is on the LHS of the road, the id will be odd. For a RHS lane, the
 * 			 id is even. 
 *
 *direction: The direction is one of:
 *NORTH: 3 
 *EAST : 0
 *SOUTH: 2
 *WEST : 1
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
	private int direction;
	private Cell start;
	private Cell end;

	/**
	 * Returns the starting Cell of a Lane 
	 * @return
	 */
	public Cell getStart() {
		return start;
	}

	/**
	 * Sets the start Cell of a Lane 
	 * @param start
	 */
	public void setStart(Cell start) {
		this.start = start;
	}

	/**
	 * Returns the end Cell of a Lane 
	 * @return
	 */
	public Cell getEnd() {
		return end;
	}

	/**
	 * Sets the end Cell of a Lane 
	 * @param end
	 */
	public void setEnd(Cell end) {
		this.end = end;
	}

	/*
	 * Returns the ID of the Lane
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the Lane
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the direction of the Lane
	 * @return
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Sets the direction of the Lane
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
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
