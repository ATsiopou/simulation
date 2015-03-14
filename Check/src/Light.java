import java.awt.Color;

/**
 *Class   : Light 
 *		    This class is responsible for creating a traffic light. A traffic light has a state, a unique Identifier ID and a position.
 *		
 *ID      : Determines which light is being requested 
 *Position: The placement of the light 
 *State   : 0,1 
 *			0 == Stop 
 *			1 == forward 
 * @author Iordanis
 * 			Anthony 
 *
 */


public class Light {

	private int x1Position; 
	private int y1Position; 
	private boolean condition=true;

	
	public Light(){
		//Do nothing
		}
	
	
	//just setters getters nothing to test
	public Light(int x1Position, int y1Position) {
		
		this.x1Position = x1Position;
		this.y1Position = y1Position;

	}

	
	public int getX1Position() {
		return x1Position;
	}

	public void setX1Position(int x1Position) {
		this.x1Position = x1Position;
	}

	public int getY1Position() {
		return y1Position;
	}

	public void setY1Position(int y1Position) {
		this.y1Position = y1Position;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	
	public Color getColor(){
		if(condition){
			return Color.GREEN;
			}
		else{return Color.RED;
		}
	}
	
	
	
}
