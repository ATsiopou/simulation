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
import java.util.Random;
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
	public List<Light> lights;
	private double x0;
	private double y0;
	private int tileSize = 10;
	private double speed = 0.01;
	private double maxSpeed = 0.03;
	private double acceleration = 0.001;
	private int turnProbability = 4; 

	public Car() {
		Image im1 = getCarImage(lane.getDirection());
	}

	public Car(Lane lane, Graphics g, List<Light> lights, Map map) {

		Image im = getCarImage(lane.getDirection());
		this.lane = lane;
		this.g = g;
		this.setLane(lane);
		this.currentCell = lane.getStart();
		this.x0 = currentCell.getCol(); // initial position
		this.y0 = currentCell.getRow(); // initial position
		this.lights = lights;
		this.map = map;

	}

	/**
	 * This method is responsible for moving a car. It checks the if the cell in
	 * front of it is occupied and it proceeds to accelerate, otherwise it will
	 * brake.
	 * 
	 * @throws InterruptedException
	 */
	public void move() throws InterruptedException {

		switch (lane.getDirection()) {
		case 0:

			if (!map.getCell((int) x0 + 2, (int) y0).isOccupied()) {

				if (this.canMoveFromLights()) {

					if(getProbability(turnProbability)){
						turn();
					}
					this.removePosition();
					accelerate();
					map.addPosition(x0, y0);
				
//				}else if(!map.getCell((int) x0 + 2, (int) y0).isOccupied() && map.isAgentBeside((int)x0, (int) y0,getLane().getDirection())){ 
//				  
//				  switchLanes();
//				  this.removePosition();
//				  accelerate();
//				  map.addPosition(x0, y0);
//				 
				}
			}
			break;

		case 1:

			if (!map.getCell((int) x0 - 2, (int) y0).isOccupied()) {

				if (this.canMoveFromLights()) {

					if(getProbability(turnProbability)){
						turn();
					}
					this.removePosition();
					accelerate();
					map.addPosition(x0, y0);
				}
			}
			break;

		case 2: //y++
			if (!map.getCell((int) x0, (int) y0 + 2).isOccupied()) {

				if (this.canMoveFromLights()) {

					if(getProbability(turnProbability)){
						turn();
					}
					this.removePosition();
					accelerate();
					map.addPosition(x0, y0);

				}
			}
			break;
		case 3:

			if (!map.getCell((int) x0 , (int) y0 - 2).isOccupied()) {

				if (this.canMoveFromLights()) {

					if(getProbability(turnProbability)){
						turn();
					}
					this.removePosition();
					accelerate();
					map.addPosition(x0, y0);

				}
			}
			break;
		}
	}

	/**
	 * This method moves the car in a direction. The directions is decided by
	 * first checking the id of the lane. For an even id, the car is travelling
	 * in a northbound or westbound lane. if the id is odd: The car is in a lane
	 * travelling in a southboun/eastbound direction.
	 * 
	 * 
	 * 
	 * 
	 * @throws InterruptedException
	 * 
	 */
	// private void accelerate() throws InterruptedException {
	//
	// // Increase speed by dx/dy (acceleration) in either direction
	// if (speed < maxSpeed) {
	// speed += acceleration;
	// }
	//
	// if (debug) {
	// System.out.println("Lane id: " + getId());
	// }
	//
	// if (isEven(this.id)) {
	//
	// if (currentCell.getCol() == lane.getStart().getCol()
	// && direction == 3) {
	// y0 -= tileSize * speed;
	// if (debug) {
	// System.out.println("In y0--");
	// System.out.println("Dir: 3 ");
	// }
	// } else if (currentCell.getRow() == lane.getStart().getRow()
	// && direction == 1) {
	// x0 -= tileSize * speed;
	// if (debug) {
	// System.out.println("In x0--");
	// System.out.println("Dir:  1");
	// }
	// }
	// } else { // ODD
	//
	// if (currentCell.getRow() == lane.getStart().getRow()
	// && direction == 0) {
	// x0 += tileSize * speed;
	// if (debug) {
	// System.out.println("In x0++");
	// System.out.println("Dir: 0 ");
	// }
	// } else if (currentCell.getCol() == lane.getStart().getCol()
	// && direction == 2) {
	// y0 += tileSize * speed;
	// if (debug) {
	// System.out.println("In y0++");
	// System.out.println("Dir: 2 ");
	// }
	// }
	// }
	// }

	private void accelerate() throws InterruptedException {
        //System.out.println(x0 +"           "+y0);
		// Increase speed by dx/dy (acceleration) in either direction
		if (speed < maxSpeed) {
			speed += acceleration;
		}

		if (debug) {
			System.out.println("Lane id: " + getId());
		}


		if (isEven(this.getLane().getId())) {
			if (lane.getDirection() == 3) {
				y0 -= tileSize * speed;
				if (debug) {
					System.out.println("In y0--");
					System.out.println("Dir: 3 ");
				}
			} else if (lane.getDirection() == 1) {

				x0 -= tileSize * speed;
				if (debug) {
					System.out.println("In x0--");
					System.out.println("Dir:  1");
				}
			}
		} else { // ODD

			if (lane.getDirection() == 0) {

				x0 += tileSize * speed;
				if (debug) {
					System.out.println("In x0++");
					System.out.println("Dir: 0 ");
				}
			} else if (lane.getDirection() == 2) {

				y0 += tileSize * speed;

				if (debug) {
					System.out.println("In y0++");
					System.out.println("Dir: 2 ");
				}
			}
		}
	}

	/**
	 * This method is for a vehicle to switch from their current lane to the
	 * lane next to them
	 * 
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unused")
	private void switchLanes() throws InterruptedException {

		if (isEven(lane.getId())) {

		} else { // ODD

			if (currentCell.getRow() == lane.getStart().getRow() && lane.getDirection() == 0) {
				y0 += tileSize * speed;
				x0 += tileSize * speed;

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
	 * Overloading the getCarImage with param direction. Returns the Image of
	 * the car given a direction
	 * 
	 * @return
	 */
	public Image getCarImage(int direction) {

		switch (direction) {
		case 0:
			Image im0 = Toolkit.getDefaultToolkit().getImage("res/car0.png");
			carImage = im0.getScaledInstance(tileSize * 2, tileSize * 2, 1);
			break;
		case 1:
			Image im1 = Toolkit.getDefaultToolkit().getImage("res/car1.png");
			carImage = im1.getScaledInstance(tileSize * 2, tileSize * 2, 1);
			break;
		case 2:
			Image im2 = Toolkit.getDefaultToolkit().getImage("res/car2.png");
			carImage = im2.getScaledInstance(tileSize * 2, tileSize * 2, 1);
			break;
		case 3:
			Image im3 = Toolkit.getDefaultToolkit().getImage("res/car3.png");
			carImage = im3.getScaledInstance(tileSize * 2, tileSize * 2, 1);
			break;
		}
		return carImage;
	}

	/**
	 * This method first checks the light given a direction. The light, which
	 * controls the flow of traffic in the lane, if an agent (car/bus/truck) is
	 * near the a light it will check the statue of the light, represented as a
	 * cell, and will decide weather or not to move through the light or stop at
	 * the light.
	 * 
	 * @return boolean
	 */
	public boolean canMoveFromLights() {

		switch (lane.getDirection()) {

		case 0:
		for (Light l : lights) {
			if (l.getPosition().getCol()  == (int) x0+2 && (int)y0==l.getPosition().getRow()) {
				if(l.getPosition().isOccupied()){
					return false;
				}
			}
		}
		break;

		case 1:
			for (Light l : lights) {
				if (l.getPosition().getCol()  == (int) x0 - 1 && (int)y0==l.getPosition().getRow()) {
					if(l.getPosition().isOccupied()){
						return false;
					}
				}
			}
			break;
		
	case 2:
		for (Light l : lights) {
			if (l.getPosition().getRow()==(int)y0+2 && (int)x0==l.getPosition().getCol()) {
				if(l.getPosition().isOccupied()){
					return false;
				}
			}
		}
		break;
		
	case 3:
		for (Light l : lights) {

			if (l.getPosition().getRow()==(int)y0-1  && (int)x0==l.getPosition().getCol()) {
				if(l.getPosition().isOccupied()){
					return false;
				}
			}
		}
		break;
		}
           return true;
	}

	
	
	/**
	 * This method gives a car the ability to turn. 
	 * 
	 * 
	 */
	public void turn() {

		if (lane.getId() > 2) {

			switch (lane.getDirection()) {

			case 0:
				for (Light l : lights) {
					if (l.getPosition().getCol() + 1 == (int) x0 && (int)y0 == l.getPosition().getRow()) {
						this.setLane(map.getLane(lane.getId(),lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane().getDirection()));
						break;
					}
				}
				break;
			case 1:
				for (Light l : lights) {
					if (l.getPosition().getCol() - 2 == (int) x0 && (int)y0 == l.getPosition().getRow()) {
						this.setLane(map.getLane(lane.getId(),lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane().getDirection()));
						break;
					}
				}
				break;
			case 2:
				for (Light l : lights) {
					System.out.println(y0 + "   " + l.getPosition().getRow());
					if (l.getPosition().getRow() + 1 == (int) y0 && (int) x0 == l.getPosition().getCol()) {
						this.setLane(map.getLane(lane.getId(),lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane().getDirection()));
						break;
					}
				}

				break;
			case 3:
				for (Light l : lights) {
					if (l.getPosition().getRow() - 2 == (int) y0 && (int)x0 == l.getPosition().getCol()) {
						this.setLane(map.getLane(lane.getId(),lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane().getDirection()));
						break;
					}
				}

				break;
			}

		}

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
		return lane.getId();
	}

	/**
	 * Removes the (x,y) position in the matrix
	 */
	public void removePosition() {
		map.removePosition(x0, y0);
	}

	/**
	 * Used to generate a probability. The pool is the range of the 
	 * values. If the pool is larger, smaller probability and 
	 * vice versa. 
	 * 
	 * @param pool
	 * @return
	 */
	public boolean getProbability(int pool){
		int prob; 
		Random rand = new Random(); 
		prob = rand.nextInt(pool); 
		if(prob == 1)
			return true; 
		else 
			return false; 
		
	}
	

}