import java.awt.Color;

/**
 * Class : Light This class is responsible for creating a traffic light. A
 * traffic light has a state, a unique Identifier ID and a position.
 *
 * ID : Determines which light is being requested Position: The placement of the
 * light State : 0,1 0 == Stop 1 == forward
 * 
 * @author Iordanis Anthony
 *
 */

public class Light {

	/** The x1 position. */
	private int x1Position;

	/** The y1 position. */
	private int y1Position;

	/** The condition. */
	private boolean condition = true;

	// just setters getters nothing to test
	/**
	 * Instantiates a new light.
	 *
	 * @param x1Position
	 *            the x1 position
	 * @param y1Position
	 *            the y1 position
	 */
	public Light(int x1Position, int y1Position) {

		this.x1Position = x1Position;
		this.y1Position = y1Position;

	}

	/**
	 * Gets the x1 position.
	 *
	 * @return the x1 position
	 */
	public int getX1Position() {
		return x1Position;
	}

	/**
	 * Sets the x1 position.
	 *
	 * @param x1Position
	 *            the new x1 position
	 */
	public void setX1Position(int x1Position) {
		this.x1Position = x1Position;
	}

	/**
	 * Gets the y1 position.
	 *
	 * @return the y1 position
	 */
	public int getY1Position() {
		return y1Position;
	}

	/**
	 * Sets the y1 position.
	 *
	 * @param y1Position
	 *            the new y1 position
	 */
	public void setY1Position(int y1Position) {
		this.y1Position = y1Position;
	}

	/**
	 * Checks if is condition.
	 *
	 * @return true, if is condition
	 */
	public boolean isCondition() {
		return condition;
	}

	/**
	 * Sets the condition.
	 *
	 * @param condition
	 *            the new condition
	 */
	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		if (condition) {
			return Color.GREEN;
		} else {
			return Color.RED;
		}
	}

	/**
	 * This will delay the lights for the int vlaue delay
	 * @param delay
	 */
	public void delay(int delay) {
		try {
			Thread.sleep(delay); // do nothing for 1000 miliseconds (1 second)

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
