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
	private Random random=new Random();

	private Image carImage;
	private Map map;
	private Cell currentCell;
	public ArrayList<Light> lights;
	private double x0;
	private double y0;
	private int tileSize = 10;
	private double speed = 0.02;
	private double maxSpeed = 0.01;
	private double acceleration = 0.001;

	public Car() {
		Image im1 = getCarImage(lane.getDirection());
	}

	public Car(Lane lane, Graphics g, ArrayList<Light> lights, Map map) {

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

<<<<<<< HEAD
			if (!map.getCell((int) x0 + 2, (int) y0).isOccupied()) {

				if (this.canMoveFromLights()) {

					turn();
                    this.removePosition();
=======
			if (!map.getCell((int) x0 + 1, (int) y0).isOccupied()) {

				if (this.canMoveFromLights()) {

					//turn();
					map.removePosition(x0, y0);
>>>>>>> origin/master
					accelerate();
					map.addPosition(x0, y0);
				}

				/*
				 * }else if(!map.getCell((int) x0 + 2, (int) y0).isOccupied() &&
				 * map.isAgentBeside((int)x0, (int) y0,
				 * getLane().getDirection())){ map.removePosition(x0, y0);
				 * switchLanes(); accelerate(); map.addPosition(x0, y0);
				 */
			}
			break;
<<<<<<< HEAD

		case 1:

			if (!map.getCell((int) x0 - 2, (int) y0).isOccupied()) {

				if (this.canMoveFromLights()) {

					turn();
                    this.removePosition();
                    accelerate();
=======

		case 1:

			if (!map.getCell((int) x0 - 1, (int) y0).isOccupied()) {

				if (this.canMoveFromLights()) {

					//turn();
					map.removePosition(x0, y0);
					accelerate();
>>>>>>> origin/master
					map.addPosition(x0, y0);
				}
			}
			break;
		/*
		 * if (!map.getCell((int) x0 - 2, (int) y0).isOccupied()) {
		 * map.removePosition(x0, y0); accelerate(); map.addPosition(x0, y0); }
		 * 
		 * break;
		 */
			
			//y++
		case 2:
<<<<<<< HEAD
			if (!map.getCell((int) x0, (int) y0 + 2).isOccupied()) {

				if (this.canMoveFromLights()) {

					turn();
                    this.removePosition();
=======
			if (!map.getCell((int) x0, (int) y0 + 1).isOccupied()) {

				if (this.canMoveFromLights()) {

					
					map.removePosition(x0, y0);
					turn();
>>>>>>> origin/master
					accelerate();
					map.addPosition(x0, y0);

				}
			}
			break;
		case 3:

<<<<<<< HEAD
			if (!map.getCell((int) x0, (int) y0 - 2).isOccupied()) {

				if (this.canMoveFromLights()) {

					turn();
                    this.removePosition();
=======
			if (!map.getCell((int) x0 - 1, (int) y0 - 1).isOccupied()) {

				if (this.canMoveFromLights()) {

					
					map.removePosition(x0, y0);
					turn();
>>>>>>> origin/master
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
<<<<<<< HEAD
=======
	 * 
>>>>>>> origin/master
	 * 
	 * 
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws InterruptedException
	 * 
	 */
<<<<<<< HEAD
	
=======
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
>>>>>>> origin/master

	private void accelerate() throws InterruptedException {

		// Increase speed by dx/dy (acceleration) in either direction
		if (speed < maxSpeed) {
			speed += acceleration;
		}

		if (debug) {
			System.out.println("Lane id: " + getId());
		}

		// if (isEven(lane.getId())) {

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

			if (currentCell.getRow() == lane.getStart().getRow()
					&& lane.getDirection() == 0) {
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
<<<<<<< HEAD
	 * the light. 
=======
	 * the light.
>>>>>>> origin/master
	 * 
	 * @return boolean
	 */
	public boolean canMoveFromLights() {

<<<<<<< HEAD
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
				if (l.getPosition().getCol()  == (int) x0-1 && (int)y0==l.getPosition().getRow()) {
					if(l.getPosition().isOccupied()){
						return false;
					}
				}
			}
			
			break;
		
		
	case 2:
		for (Light l : lights) {
			if (l.getPosition().getRow()  == (int) y0+2 && (int)x0==l.getPosition().getCol()) {
				if(l.getPosition().isOccupied()){
					return false;
				}
			}
		}
		
		break;
		
	case 3:
		for (Light l : lights) {
			//System.out.println(l.getPosition().getRow()+"  "+ ((int) y0-1)+"  "+ x0+"  "+l.getPosition().getCol());

			if (l.getPosition().getRow()  == (int) y0-1 && (int)x0==l.getPosition().getCol()) {
				//System.out.println("*****************");

				if(l.getPosition().isOccupied()){

					return false;
				}
			}
		}
		///System.out.println("********************");

		
		break;
			 
		}
           return true;
		
	}

	public void turn() {
        int propability=random.nextInt(2);
//System.out.println(propability);
        if(propability==0){ 
		
        if (lane.getId() > 2) {
=======
		for (Light lt : lights) {
			if (debug) {
				System.out.println("Method      : canMoveFromLights()");
				System.out.println("Direction   : "
						+ this.getLane().getDirection());
				System.out.println("Light State : " + lt.getState());
				System.out.println("Light State : "
						+ lt.getPosition().isOccupied());
			}

			/*
			 * if (this.getLane().getDirection() < 2) { //
			 * System.out.println(y0+"     "+lt.getPosition().getRow());
			 * 
			 * if (x0 - lt.getPosition().getCol() < 2 && y0 ==
			 * lt.getPosition().getRow()) { if (lt.getPosition().isOccupied())
			 * // if the light is occupied, ie red then stop return false; }
			 * else { // otherwise, the light is green, and return true return
			 * true; }
			 * 
			 * } else {
			 * //System.out.println(x0+"     "+lt.getPosition().getCol());
			 * //System.out.println(lt.getPosition().getCol());
			 * 
			 * if (y0 - lt.getPosition().getRow() < 2 && x0 ==
			 * lt.getPosition().getCol()) {
			 * 
			 * if (lt.getPosition().isOccupied()) { return false; } } else {
			 * return true; } }
			 */
		}

		return true;
	}

	public void turn() {

		if (lane.getId() > 2) {
>>>>>>> origin/master

			switch (lane.getDirection()) {

			case 0:
				for (Light l : lights) {
<<<<<<< HEAD
					if (l.getPosition().getCol() + 1 == (int) x0 && (int)y0==l.getPosition().getRow()) {
=======
					if (l.getPosition().getCol() + 2 == (int) x0 && y0==l.getPosition().getRow()) {
>>>>>>> origin/master
						this.setLane(map.getLane(lane.getId(),
								lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane()
								.getDirection()));
						break;
					}
				}
				break;
			case 1:
				for (Light l : lights) {
<<<<<<< HEAD
					if (l.getPosition().getCol() - 2 == (int) x0 && (int)y0==l.getPosition().getRow()) {
=======
					if (l.getPosition().getCol() - 2 == (int) x0 && y0==l.getPosition().getRow()) {
>>>>>>> origin/master
						this.setLane(map.getLane(lane.getId(),
								lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane()
								.getDirection()));
						break;
					}
				}
				break;
			case 2:
				for (Light l : lights) {
<<<<<<< HEAD
					if (l.getPosition().getRow() + 1 == (int) y0&& (int)x0 == l.getPosition().getCol()) {
=======
					System.out.println(y0+"   "+l.getPosition().getRow() );
					if (l.getPosition().getRow() + 2 == (int) y0&& x0 == l.getPosition().getCol()) {
>>>>>>> origin/master
						this.setLane(map.getLane(lane.getId(),
								lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane()
								.getDirection()));
						break;
					}
				}
<<<<<<< HEAD
=======
				System.out.println("***********");
>>>>>>> origin/master

				break;
			case 3:
				for (Light l : lights) {
<<<<<<< HEAD
					if (l.getPosition().getRow() - 2 == (int) y0 && (int)x0 == l.getPosition().getCol()) {
=======
					if (l.getPosition().getRow() - 2 == (int) y0 && x0 == l.getPosition().getCol()) {
>>>>>>> origin/master
						this.setLane(map.getLane(lane.getId(),lane.getDirection()));
						this.setCarImage(getCarImage(this.getLane().getDirection()));
						break;
					}
				}

				break;
			}

		}
<<<<<<< HEAD
        }

	}

=======

	}
>>>>>>> origin/master
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
	
	public void removePosition(){
		map.removePosition(x0, y0);

<<<<<<< HEAD
	}

=======
>>>>>>> origin/master
}