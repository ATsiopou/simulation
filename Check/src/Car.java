public class Car {

	private int x;          // x0 = x's initial position 
	private int y;          // y0 = y's initial position
	                        // Look at a hashmap for the direction ?  
	                        // OMG much crude LOL 	
	private int direction;  // 0 for right 1 for left,2 for up,3 for down
	private Lane lane;      // the line the car will enter

	// Much crass, so change in the future !  
	public Car(int direction, Lane lane) {
		super();
		this.lane = lane;
		this.x = lane.getXEntryPos();
		this.y = lane.getYEntryPos();  
		this.direction = direction;
	}

	// this method is how the car will decide to move
	// now is taking the direction is going and move one position
	// it is working for strange roads so if we decide to put round roads it
	// will change
	// if not it will just has to become more clever when to top and stuff like
	// that
	public void move() {

		switch (direction) {
		case 0:
			if (this.getVision()) {
				x++;
			}
			break;
		case 1:
			if (this.getVision()) {
				x--;
			}
			break;
		case 2:
			if (this.getVision()) {
				y++;
			}
			break;
		case 3:
			if (this.getVision()) {
				y--;
			}
			break;
		}
	}

	/**
	 * Get x's current position 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set the initial position for x 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the initial position for y  
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the initial position for y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the objects direction 
	 * @return
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Sets the Objects direction 
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	// this method will return true if the car can move to the next interation
	// false if it cant
	public boolean getVision() {
		int lightsx = lane.getLightPosition()[0];
		int lightsy = lane.getLightPosition()[1];
		System.out.println(lightsx);
		switch (direction) {
		case 0:
			if (x - lightsx < 5) {

				return true;
			} else {
				return false;
			}
		case 1:
			if (x - lightsx < 5) {
				return true;
			} else {
				return false;
			}
		case 2:
			if (y - lightsy < 5) {
				return true;
			} else {
				return false;
			}
		case 3:
			if (y - lightsy < 5) {
				return true;
			} else {
				return false;
			}
		}

		return true;
	}

}

