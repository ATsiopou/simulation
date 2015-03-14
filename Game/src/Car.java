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

public class Car implements Runnable {

	private boolean debug = false;
	private double x0;
	private double y0;
	private int id;
	private int tileSize = 10;
	private Cell entryPosition;
	private Lane lane;
	private Graphics g;
	private Image carImage;
	private double speed = 0.01;
	private double maxSpeed = 0.005;
	private double acceleration = 0.001;
	private boolean running = true;
	private Cell currentCell;
	private Cell occupiedCell;
	private ArrayList<Cell> occupiedCells;

	public Car() {
		Image im1 = Toolkit.getDefaultToolkit().getImage("res/car.png");
		this.carImage = im1.getScaledInstance(tileSize, tileSize, 1);
	}

	public Car(Lane lane, Graphics g, ArrayList<Cell> occupiedCells) {

		Image im1 = Toolkit.getDefaultToolkit().getImage("res/car.png");
		this.carImage = im1.getScaledInstance(tileSize, tileSize, 1);
		this.g = g;
		// this.setLane(lane);
		this.id = lane.getId();
		this.entryPosition = lane.getStart();
		this.x0 = lane.getStart().getCol(); // initial position
		this.y0 = lane.getStart().getRow(); // initial position

		this.currentCell = lane.getStart();
		this.occupiedCells = occupiedCells;

	}

	/**
	 * This method is responsible for moving a car. It checks the if the cell in
	 * front of it is occupied and it proceeds to accelerate, otherwise it will
	 * brake.
	 */
	public void move() {

		// Cell currentCell = entryPosition;
		// currentCell.setOccupied(true);
		// then check the next cell if it is occupied.

		if (currentCell.listEquals(occupiedCells)) {
			currentCell.setOccupied(true);
		}

		if (!currentCell.isOccupied()) {
			accelerate();
			if (debug) {
				System.out.println("Current cell: " + currentCell);
			}
		} else {
			brake();
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
	 * 
	 */
	private void accelerate() {

		// Increase speed by dx/dy (acceleration) in either direction
		if (speed < maxSpeed) {
			speed += acceleration;
		}

		if (debug) {
			System.out.println("Lane id: " + getId());
		}

		if (isEven(this.id)) {

			if (entryPosition.getCol() == 38 || entryPosition.getCol() == 39) {

				y0 -= tileSize * speed;
				if (debug) {
					System.out.println("In y0 -= tileSize*speed;");
				}

			} else if (entryPosition.getRow() == 30
					|| entryPosition.getRow() == 31) {
				x0 -= tileSize * speed;
				if (debug) {
					System.out.println("In x0-= tileSize*speed;");
				}
			}
		} else { // ODD
			if (entryPosition.getRow() == 28 || entryPosition.getRow() == 29) {
				x0 += tileSize * speed;
				if (debug) {
					System.out.println("In x0 += tileSize*speed;");
				}
			} else if (entryPosition.getCol() == 40
					|| entryPosition.getCol() == 41) {
				y0 += tileSize * speed;
				if (debug) {
					System.out.println("In y0 += tileSize*speed;");
				}
			}
		}

		currentCell.setCol((int) x0);
		currentCell.setRow((int) y0);

	}

	/**
	 * This method (for now) will stop the car from increasing in it's current
	 * direction
	 */
	private void brake() {
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

	// Overriding methods
	// The car class should be act as an independent "agent"
	// Override the run, an the draw methods
	@Override
	public void run() {

		while (true) {

			try {
				move();
				Thread.sleep(20);
			} catch (InterruptedException ex) {
				Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null,
						ex);
			}

		}
	}

	public void setOcuupied(ArrayList<Cell> listOfCells) {

	}

	public double getX0() {
		return x0;
	}

	public double getY0() {
		return y0;
	}

	public Image getCarImage() {
		return carImage;
	}

	public void setCarImage(Image carImage) {
		this.carImage = carImage;
	}

	public Lane getLane() {
		return lane;
	}

	public void setLane(Lane lane) {
		this.lane = lane;
	}

	public int getId() {
		return this.id;
	}

}
