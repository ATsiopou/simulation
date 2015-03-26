/*Authors : Iordanis Paschalidis, 
 * 			Anthony Tsiopoulos 
 * 			
 * Class  : MyMap
 *  		The MyMap class is the class used in the mapping of the JSON file to their 
 *  		respective fields. For this reason the class contains the lists of traffic 
 *  		lights and lanes. 
 * 
 * 
 * Moded  : 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MyMap {

	List<Lane> lanes;
	ArrayList<Light> lights;
	List<Lane> sideWalks; 

	/**
	 * This returns a pedestrian walkway
	 * @return
	 */
	public List<Lane> getSideWalks() {
		return sideWalks;
	}

	/**
	 * This method sets the sidewalk
	 * @param sideWalks
	 */
	public void setSideWalks(List<Lane> sideWalks) {
		this.sideWalks = sideWalks;
	}

	/**
	 * This method returns the a list of Lane objects
	 * @return
	 */
	public List<Lane> getLanes() {
		return lanes;
	}
	
	/**
	 * This method sets a list of lanes. 
	 * @param lanes - a List of Lane objects
	 */
	public void setLanes(List<Lane> lanes) {
		this.lanes = lanes;
	}

	
	/**
	 * Returns a random lane 
	 * @return
	 */
	public Lane getRandomLane(){
		Lane randomLane = new Lane(); 
		Random rand = new Random(); 
		randomLane = lanes.get(rand.nextInt(lanes.size())); 
		return randomLane; 
	}
	
	
	
	/**
	 * This gets the list of lights loaded from the JSON file
	 * @return ArrayList
	 */
	public ArrayList<Light> getLights() {
		return lights;
	}
	
	/**
	 * Sets the Lights
	 * @param lights
	 */
	public void setLights(ArrayList<Light> lights) {
		this.lights = lights;
	}
	/**
	 * Prints the lanes start and end positions as ordered pair
	 * 
	 */
	public void printLanes() {

		int count = 1;
		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println(" Start Position --> End Position ");
		System.out.println("   (x,y)        -->     (x,y)    ");
		System.out.println("---------------------------------");
		System.out.println("");
		Iterator<Lane> lit = lanes.iterator();
		while (lit.hasNext()) {
			Lane l = lit.next();
			System.out.println("Lane " + count);
			System.out.println("(" + l.getStart().getCol() + ","
					+ l.getStart().getRow() + ")" + "-->" + "("
					+ l.getEnd().getCol() + "," + l.getEnd().getRow() + ")");
			count++;
		}
	}
	
	/**
	 * Print method for lights as an ordered pair
	 */
	public void printLights() {

		int count = 1;
		System.out.println("");
		System.out.println("----------------");
		System.out.println(" Light Position ");
		System.out.println("     (x,y)      ");
		System.out.println("----------------");
		System.out.println("");
		Iterator<Light> ittr = lights.iterator();
		while (ittr.hasNext()) {
			Light light = ittr.next();
			System.out.println("Traffic Light: " + count);
			System.out.println("(" + light.getPosition().getCol() + ","+ light.getPosition().getRow() + ")");  
			
			System.out.println(" ");
			count++;
		}
	}

	/**
	 * This method is used when a (agent) car is in a turning lane 
	 * and needs to make a turn. The current lane and the direction 
	 * of the car are taken as inputs, and a Lane object is returned. 
	 * The Lane which is returned will be given to the car after the 
	 * car has turned. 
	 * 
	 * 
	 * @param laneId
	 * @param direction
	 * @return
	 */
	public Lane getCarNewLane(int laneId, int direction){
	

		if(laneId == 3 && direction == 2){
			
			for(Lane l: lanes){
			
				if(l.getDirection() == 0 && l.getId() == 3){
					return l; 
				}
				
			}
	    }else if(laneId == 3 && direction == 0){
			
			for(Lane l: lanes){
			
				if(l.getDirection() == 3 && l.getId() == 4){
					return l; 
				}
			}
				
			}else if(laneId == 4 && direction == 3){
				
				for(Lane l: lanes){
				
					if(l.getDirection() == 1 && l.getId() == 4){
						return l; 
					}
				}
					
				}else{
					for(Lane l: lanes){
						
						if(l.getDirection() == 2 && l.getId() == 3){
							return l; 
						}
					}
				}

		return null;	
}
	
	
	
	

}
