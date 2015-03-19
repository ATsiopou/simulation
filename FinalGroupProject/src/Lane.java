/*Authors  : Iordanis Paschalidis 
 * 		 	 Anthony Tsiopoulos 
 * 
 * Class   : Lane
<<<<<<< HEAD
 * 		 	 The Lane class is responsible constructing a single lane. A lane consists of two 
=======
 * 		 	 The Lane class is responsible constructing a single lane. A lane consista of two 
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
 * 			 Cell objects start and end. 
 * 
 * id	   : An id is given to a single lane. The condition is that if the lane 
 * 		   	 is on the LHS of the road, the id will be odd. For a RHS lane, the
 * 			 id is even. 
 *
<<<<<<< HEAD
 *direction: The direction is one of:
 *NORTH: 3 
 *EAST : 0
 *SOUTH: 2
 *WEST : 1
=======
 *direction: The direction is one of NORTH,EAST,SOUTH,WEST
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
 *
 * start   : A Cell object identifying the starting cells row and col position.
 *
 * end     : A Cell object identifying the end cells row and col position. 
 * 
 * Moded  : 
 * 
 */

public class Lane {

<<<<<<< HEAD
	private int id;
	private int direction;
	private Cell start;
	private Cell end;

	/**
	 * Returns the starting Cell of a Lane 
	 * @return
	 */
=======
	private int id;  	
	private	Cell start;
	private Cell end;

>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
	public Cell getStart() {
		return start;
	}

<<<<<<< HEAD
	/**
	 * Sets the start Cell of a Lane 
	 * @param start
	 */
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
	public void setStart(Cell start) {
		this.start = start;
	}

<<<<<<< HEAD
	/**
	 * Returns the end Cell of a Lane 
	 * @return
	 */
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
	public Cell getEnd() {
		return end;
	}

<<<<<<< HEAD
	/**
	 * Sets the end Cell of a Lane 
	 * @param end
	 */
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
	public void setEnd(Cell end) {
		this.end = end;
	}

<<<<<<< HEAD
	/*
	 * Returns the ID of the Lane
	 */
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
	public int getId() {
		return id;
	}

<<<<<<< HEAD
	/**
	 * Sets the ID of the Lane
	 * @param id
	 */
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD
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
=======

	/**
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
	 * Prints the x and y position of the lanes
	 */
	public void printLanePosition() {
		System.out.println("Lane position");
		System.out.println("(x0,y0) --> (xN,yN)");
		System.out.println("(" + start.getCol() + "," + start.getRow() + ")"
				+ "   -->  " + "(" + end.getCol() + "," + end.getRow() + ")");
	}
<<<<<<< HEAD
	
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
}
