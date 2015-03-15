/**
 *Class   : Car 
 *
 *This class is responsible for car position
 *update the matrix information
 *decide car's move 
 *
 *
 * @author  Iordanis
 * 			Anthony 
 *
 */

import java.util.Random;

public class Car {

	private int x;// the x position of the car
	private int y;// the y position of the car

	private int direction;// 0 for right 1 for left,2 for up,3 for down

	private Lane lane;// the line the car is running on
	private Matrix matri;// //matrix object where the care will update its
							// position
	private Random random = new Random();// random class object so the car can
											// make some random decisions

	/**
	 * Constructor
	 * 
	 * decide by the direction of the car where is the start point in the lane
	 * by taking the lanes first position (x,y)
	 *
	 * @param direction
	 *            the direction the car will take (can take values 0,1,2,3 only)
	 * @param lane
	 *            in which lane the car will go
	 * @param matrix
	 *            the matrix class it will update its position
	 *
	 **/
	public Car(int direction, Lane lane, Matrix matrix) {
		super();
		this.matri = matrix;
		this.lane = lane;
		this.direction = direction;// we can change that aso it can just take
									// the direction of the lane

		if (direction == 0) {
			this.y = lane.getLineOney() + 5;
			this.x = lane.getLineTwox();
		} else if (direction == 1) {
			this.y = lane.getLineOneEndy() + 5;
			this.x = lane.getLineOneEndx();
		} else if (direction == 2) {
			this.y = lane.getLineOney();
			this.x = lane.getLineOnex() + 5;
		} else {
			this.y = lane.getLineOneEndy();
			this.x = lane.getLineOneEndx() + 5;
		}
	}

	/**
	 * 
	 * in method the car will decide to move also update the his position in the
	 * matrix and check if there is a car in front of him or ligth and their
	 * color
	 * 
	 */
	public void move() {

		// see the direction and diecide how to move
		switch (direction) {

		case 0:
			System.out.println("AS");

			if (!((checkLightDistance(0)) < 25) || checkLightCondition()) {

				if (x == lane.getLight().getX1Position() + 50) {

				}
				matri.removePosition(x, y);

				if (!matri.isCarNear(x, y, 0)) {
					x++;
				}
				matri.addPosition(x, y);
			}

			break;
		case 1:
			if (!((checkLightDistance(1)) < 25) || checkLightCondition()) {
				if (x == lane.getLight().getX1Position() - 70) {
					// turn();
				}
				matri.removePosition(x, y);

				if (!matri.isCarNear(x, y, 1)) {
					x--;
				}
				matri.addPosition(x, y);
			}
			break;
		case 2:
			if (!((checkLightDistance(2)) < 25) || checkLightCondition()) {
				matri.removePosition(x, y);

				if (!matri.isCarNear(x, y, 2)) {
					y++;
				}
				matri.addPosition(x, y);
			}
			break;
		case 3:
			if (!((checkLightDistance(2)) < 25) || checkLightCondition()) {
				matri.removePosition(x, y);

				if (!matri.isCarNear(x, y, 3)) {
					y--;
				}
				matri.addPosition(x, y);
			}
			break;
		}

	}

	/**
	 * 
	 * calculate and return the disttance beetween the car with the lights of
	 * the lane
	 * 
	 * @param directionxv
	 *            direction of the car
	 * @return the distance between the car with the next lights
	 * 
	 */
	private int checkLightDistance(int directionxv) {
		int value;
		if (directionxv == 0 || directionxv == 1) {
			value = Math.abs(x - lane.getLight().getX1Position());
		} else {
			value = Math.abs(y - lane.getLight().getY1Position());

		}

		return value;
	}

	/**
	 * @return the lights condition (red or greeen)
	 */
	private boolean checkLightCondition() {
		return lane.getLight().isCondition();
	}

	/**
	    * 
	    * 
	    * 
	    * 
	    */
	private void turn() {
		int randomLane = random.nextInt(2);
		if (direction == 0) {

			if (randomLane == 1) {
				direction = 3;
			}

		} else if (direction == 1) {
			if (randomLane == 1) {
				direction = 2;
			}
		}
	}

	/**
	 * @return x position of the car in the matrix
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets x position of the x
	 * 
	 * @param x
	 *            new position of the x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y position of the car in the matrix
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets x position of the y
	 * 
	 * @param y
	 *            new position of the y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the direction of the car
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Sets direction of the car
	 * 
	 * @param direction
	 *            of the car
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

}
