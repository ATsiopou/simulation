import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

/*Authors : Iordanis Paschalidis, 
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
 * Moded  :  03/06/15
 * 
 */

@SuppressWarnings("serial")
public class TrafficLight extends JPanel {

	private Cell start;
	private Cell end;
	private Graphics g;
	private ArrayList<Cell> lightCells; 
	private int value; 
	private boolean occupied; 
	
	private Timer timer;
	
	public TrafficLight() {
		// Do nothing
	}

	public TrafficLight(Graphics g, ArrayList<Cell> lightCells){
		this.g = g; 
		this.lightCells = lightCells; 
		timer = new Timer();
		timer.scheduleAtFixedRate(new LightChangeTask(lightCells), 5000, 10000);
	}

	
	
	

	/**
	 * This method will control the painting of a single light
	 * 
	 */
	public void paintComponent(Graphics g) {

		Turn turnLeft = new Turn("Turn Left", 20);
		Turn turnRight = new Turn("Right Turn", 20);
		Forward forward = new Forward("Forward", 20);

		turnLeft.drawLeftTurnLight(g, 4);
		turnRight.drawRightTurnLight(g, 4);
		forward.drawLight(g, 3);

	}
	
	
	
	
	
	public ArrayList<Cell> getLightCells() {
		return lightCells;
	}

	public void setLightCells(ArrayList<Cell> lightCells) {
		this.lightCells = lightCells;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Cell getStart() {
		return start;
	}

	public void setStart(Cell start) {
		this.start = start;
	}

	public Cell getEnd() {
		return end;
	}

	public void setEnd(Cell end) {
		this.end = end;
	}
	
	


}
