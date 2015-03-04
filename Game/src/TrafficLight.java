/*Authors : Iordanis Paschalidis 
 * 			Anthony Tsiopoulos 
 * 
 * Class  : TrafficLight 
 * 			This class is responsible for constructing a traffic light. A traffic light object 
 * 			consists of a 
 * 		
 * 			Cell object position - the x,y coordinates of the light. A light, does not sit on a
 * 			lane, rather it controls the flow of traffic on the lane. 
 * 
 * 
 * Moded  : 
 * 
 */

public class TrafficLight {

	Cell position;

	public Cell getPosition() {
		return position;
	}

	public void setPosition(Cell position) {
		this.position = position;
	} 
	 
}
