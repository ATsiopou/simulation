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
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MyMap {

	List<Lane> lanes;
	List<TrafficLight> lights;

	public List<Lane> getLanes() {
		return lanes;
	}

	public void setLanes(List<Lane> lanes) {
		this.lanes = lanes;
	}

	public List<TrafficLight> getLights() {
		return lights;
	}

	public void setLights(List<TrafficLight> lights) {
		this.lights = lights;
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
		Iterator<TrafficLight> ittr = lights.iterator();
		while (ittr.hasNext()) {
			TrafficLight light = ittr.next();
			System.out.println("Traffic Light: " + count);
			System.out.println("(" + light.getStart().getCol() + ","+ light.getStart().getRow() + ")" + "-->" +"(" + light.getEnd().getCol() + ","+ light.getEnd().getRow() + ")");
			
			System.out.println(" ");
			count++;
		}
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

}
