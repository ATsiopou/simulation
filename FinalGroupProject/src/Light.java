import java.awt.*;
<<<<<<< HEAD
=======
import java.awt.Color;
>>>>>>> origin/master

/**
 *Class   : Light 
 *		    This class is responsible for creating a traffic light. A traffic light has a state, a unique Identifier ID and a position.
 *		
 *ID      : Determines which light is being requested 
 *Position: The placement of the light 
 *
 *State:
 * Red    : 0
 * Yellow : 1
 * Green  : 2
 * 
 * @author Iordanis
 * 			Anthony 
 *
 */


public class Light {
	

	private Cell position; 
	private int state;

	public Light(){
          //never used		
	}
	
	/**
	 * Instantiates a new light.
	 * @param Cell position 
	 */
	public Light(Cell position) {
		
		this.position = position;
		
	}

	public Cell getPosition() {
		return position;
	}


	public void setPosition(Cell position) {
		this.position = position;
	}


	public int getState() {
		return state;
	}

<<<<<<< HEAD

	public void setState(int state) {
		this.state = state;
	}
	
=======
	/**
	 * Sets the condition.
	 *
	 * @param condition the new condition
	 */
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
>>>>>>> origin/master
	
	/**
	 * Prints the x and y position of the lanes
	 */
	public void printLanePosition() {
		System.out.println("Lane position");
		System.out.println("(x0,y0) --> (xN,yN)");
		System.out.println("(" + position.getCol() + "," + position.getRow() + ")");
	}
<<<<<<< HEAD
	
	
	
	public void changeLight(){
		
		if(getPosition().isOccupied()){
			this.position.setOccupied(false);
		}else{
			this.position.setOccupied(true);
		}
	}
	
}
=======
}
>>>>>>> origin/master
