/*Authors : Iordanis Paschalidis, 
 * 			Anthony Tsiopoulos 
 * 
 * Class  : Car
 * 			This class is responsible for creating a car.
 * 			The class implements runnable, so the run() method is
 *			is provided as method in the class. An object of the 
 *			class Car is a Runnable object.   			
 * 			
 * Moded:  03/06/15
 * 			
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class Car {

	private boolean debug = false;
	private Lane lane;
	private Graphics g;
	private Image carImage;
	private Map map;
	private Cell currentCell;
	public ArrayList<Cell> occupiedCells;
	private double x0;
	private double y0;
	private int id;
	private int tileSize = 10;
	private double speed = 0.01;
	private double maxSpeed = 0.01;
	private double acceleration = 0.001;

	public Car() {
		Image im1 = Toolkit.getDefaultToolkit().getImage("res/car.png");
		this.carImage = im1.getScaledInstance(tileSize, tileSize, 1);
	}

	public Car(Lane lane, Graphics g, ArrayList<Cell> occupiedCells,Map map) {

		Image im1 = Toolkit.getDefaultToolkit().getImage("res/car.png");
		this.carImage = im1.getScaledInstance(tileSize * 2, tileSize * 2, 1);
		this.lane = lane;
		this.g = g;
		this.setLane(lane);
		this.id = lane.getId();
		this.currentCell = lane.getStart();
		this.x0 = currentCell.getCol(); // initial position
		this.y0 = currentCell.getRow(); // initial position
		this.occupiedCells = occupiedCells;
		this.map=map;

	}


	/**
	 * This method is responsible for moving a car. It checks the if the cell in
	 * front of it is occupied and it proceeds to accelerate, otherwise it will
	 * brake.
	 * 
	 * @throws InterruptedException
	 */
	public void move() throws InterruptedException {
       
		switch(this.getLane().getDirection()){
		case 0:

	     	if(!map.getCell((int)x0+2,(int)y0).isOccupied()){
              map.removePosition(x0,y0);
		      accelerate();
              map.addPosition(x0,y0);
	     	}
			
	     	break;
		case 1:

	     	if(!map.getCell((int)x0-2,(int)y0).isOccupied()){
            map.removePosition(x0,y0);
		    accelerate();
            map.addPosition(x0,y0);
	     	}
			
	     	break;
		case 2:
	     	if(!map.getCell((int)x0,(int)y0+1).isOccupied()){
            map.removePosition(x0,y0);
		    accelerate();
            map.addPosition(x0,y0);
	     	}
	     	break;
		case 3:
			// if(!map.getCell((int)x0-1,(int)y0-1).isOccupied()){
	     	if(!map.getCell((int)x0-2,(int)y0-2).isOccupied()){
            map.removePosition(x0,y0);
		    accelerate();
            map.addPosition(x0,y0);
	     	}
	     	break;
	   	}
	}

	/**
	 * This method moves the car in a direction. The directions is decided by
	 * first checking the id of the lane. For an even id, the car is travelling
	 * in a northbound or westbound lane. if the id is odd: The car is in a
	 * southboun/eastbound lane.
	 * 
	 * //for curved lanes foreach(Cell cell: lane.getCells()) { move your car in
	 * each cell set cell occupied set previous cell unoccoupied }
	 * 
	 * Try to remove the magic numbers => make it more general
	 * 
	 * @throws InterruptedException
	 * 
	 * 
	 */
	private void accelerate() throws InterruptedException {

		// Increase speed by dx/dy (acceleration) in either direction
		if (speed < maxSpeed) {
			speed += acceleration;
		}

		if (debug) {
			System.out.println("Lane id: " + getId());
		}

		if (isEven(this.id)) {

			if (currentCell.getCol() == lane.getStart().getCol() && lane.getDirection() == 3) {
				y0 -= tileSize * speed;
				if (debug) {
					System.out.println("In y0 -= tileSize*speed;");
				}
			} else if (currentCell.getRow() == lane.getStart().getRow() && lane.getDirection() == 1) {
				x0 -= tileSize * speed;
				if (debug) {
					System.out.println("In x0-= tileSize*speed;");
				}
			}
		} else { // ODD

			if(currentCell.getRow() == lane.getStart().getRow() && lane.getDirection() == 0){
				x0 += tileSize * speed;
				if (debug) {
					System.out.println("In x0 += tileSize*speed;");
				}
			} else if (currentCell.getCol() == lane.getStart().getCol() && lane.getDirection() == 2 ){
				y0 += tileSize * speed;
				if (debug) {
					System.out.println("In y0 += tileSize*speed;");
				}
			}
		}
	}

	/**
	 * OverLoading the brake method. This tells the thread to sleep for time in
	 * seconds.
	 * 
	 * @param stoppage
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unused")
	private void brake(int stoppage) throws InterruptedException {
		Thread.sleep(stoppage * 1000);
	}

	/**
	 * This method (for now) will stop the car from increasing in it's current
	 * direction
	 * 
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unused")
	private void brake(Cell currentCell) throws InterruptedException {

		if (debug) {
			System.out.println("In brake");
		}
		x0 = x0;
		y0 = y0;
	}

	
	@SuppressWarnings("unused")
	private void randomize() {
		// randomly call accelerate OR randomly call brake
	}

	/**
	 * Checks if the id is odd or even
	 * 
	 * @param id
	 * @return
	 */
	private boolean isEven(int value) {
		if (value % 2 == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns the current x position
	 * 
	 * @return
	 */
	public double getX0() {
		return x0;
	}

	/**
	 * Returns the current y position
	 * 
	 * @return
	 */
	public double getY0() {
		return y0;
	}

	/**
	 * Returns the Image of the car
	 * 
	 * @return
	 */
	public Image getCarImage() {
		return carImage;
	}

	/**
	 * Sets the Image of the car
	 * 
	 * @param carImage
	 */
	public void setCarImage(Image carImage) {
		this.carImage = carImage;
	}

	/**
	 * Returns the current Lane
	 * 
	 * @return
	 */
	public Lane getLane() {
		return lane;
	}

	/**
	 * Sets the current Lane
	 * 
	 * @param lane
	 */
	public void setLane(Lane lane) {
		this.lane = lane;
	}

	/**
	 * Gets the ID of the current Lane
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}

}