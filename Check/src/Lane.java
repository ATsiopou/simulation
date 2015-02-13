/**
 * Class : Lane 
 *	   This Class creates a single lane. A single Lane has an entry and exit position, given by  *          an ordered pair [x,y], a direction and the position of the light. Lanes will be used to 
 *	   populate a roadway. 
 * 	   
 *
 * Last Modified: Friday 13/2015 
 * Author: Iordanis Paschalidis, Anthony Tsiopoulos
 * 
 * TODO:Crate Road class, parent of Lanes.  
 */


public class Lane {
	
    private int id;
    private int lightPosition[]=new int[2];//the position of the light
    private boolean ligtsConidition;
    
    //This should give it an [x,y] entry position 
    private int laneEntry[] = new int[2]; 
    private int laneExit[]  = new int[2];  
   
    public Lane(int laneEntry[], int laneExit[] ,int lightpo[]) {
	super();
	//entry as an ordered pair 
	this.laneEntry[0]=laneEntry[0]; 
	this.laneEntry[1]=laneEntry[1]; 
	//Exit as an ordered pair 
	this.laneExit[0]=laneExit[0]; 
	this.laneExit[1]=laneExit[1]; 
	//Create the position of the lights (This may change, with the trafficlight class)
	lightPosition[0]=lightpo[0];
	lightPosition[1]=lightpo[1]; 

    }
    
    /**
     * Gets the x from: [x,y] entry position
     * @param
     */
    public int getXEntryPos() {
	return laneEntry[0];
    }
    /**
     * Gets the y from: [x,y] entry position
     * @return
     */
    public int getYEntryPos(){
    	return laneEntry[1];
    }
    
    /**
     * Gets the x from: [x,y] exit position
     * @param
     */
    public int getXExitPos() {
	return laneEntry[0];
    }
    /**
     * Gets the y from: [x,y] exit position
     * @return
     */
    public int getYExitPos(){
    	return laneEntry[1];
    }
    
    /**
    *Set the [x,y] pair for the lane exit
    * @param xyEntryPos
    */
    public void setXYLaneEntryPos(int[] xyEntryPos){
	this.laneEntry=xyEntryPos; 

    }
   /**
    * Set the [x,y] pair for lane exit
    * @param xyExitPos
    */
    public void setXYExitPos(int[] xyExitPos){
	this.laneExit=xyExitPos; 
    }
    
    public boolean isLigtsGreen() {
	return ligtsConidition;
    }

    public void setLigtsConidition(boolean ligtsConidition) {
	this.ligtsConidition = ligtsConidition;
    }

    public int getId() {
	return id;
    }
	
    public void setId(int id) {
	this.id = id;
    }

    public int[] getLightPosition() {
	return lightPosition;
    }

    public void setLightPosition(int[] lightPosition) {
	this.lightPosition = lightPosition;
    }
	
}
