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
<<<<<<< HEAD
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
=======
	List<Cell> entryPositions; 

	public List<Lane> getLanes() {
		return lanes;
	}

>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
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
<<<<<<< HEAD
=======
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
		
	
	}


	/**
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f
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
<<<<<<< HEAD
	
	
	
	
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f

}
