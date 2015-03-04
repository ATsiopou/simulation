/*Authors : Iordanis Paschalidis 
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
 * Print method for lights a an ordered pair
 */
public void printLights(){
	
	int count = 1; 
	System.out.println("");
	System.out.println("----------------");
	System.out.println(" Light Position ");
	System.out.println("     (x,y)      ");
	System.out.println("----------------");
	System.out.println("");
	Iterator<TrafficLight> ittr = lights.iterator(); 
	while(ittr.hasNext()){
		TrafficLight light  = ittr.next(); 
		System.out.println("Traffic Light: "+ count);
		System.out.println("("+light.getPosition().getCol() +","+light.getPosition().getRow() +")");
		System.out.println(" ");
		count++; 
	}
}

/**
 * Prints the lanes start and end positions as ordered pair 
 * 
 */
public void printLanes(){
	
	int count = 1; 
	System.out.println(""); 
	System.out.println("---------------------------------");
	System.out.println(" Start Position --> End Position ");
	System.out.println("   (x,y)        -->     (x,y)    ");
	System.out.println("---------------------------------");
	System.out.println(""); 
	Iterator<Lane> lit = lanes.iterator(); 	
	while(lit.hasNext()){
		Lane l = lit.next();
		System.out.println("Lane " + count);
		System.out.println("("+l.getStart().getCol()+","+l.getStart().getRow() +")"+"-->"+
							"("+l.getEnd().getCol()+","+l.getEnd().getRow()+")");
		count++; 
	}
}
 
}