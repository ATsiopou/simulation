
import java.awt.Color;
import java.awt.Graphics;

public class Forward {

	private int xLocation; // The location of the oval to be drawn
	private int yLocation = 10;
	private String direction; // For display purposes
	private int area = 10; // Area of the oval to be drawn
	private int state; 

	public Forward(String direction, int xLocation) {

		this.direction = direction;
		this.xLocation = xLocation;
	}

	/**
	 * This method draws the colors of the traffic light, given a state. A state
	 * is either green, red, or yellow.
	 * 
	 * @param g
	 * @param state
	 */
	public void drawLight(Graphics g, int state) {

		switch (state) {
		case 1:

			//1st light
			g.setColor(Color.RED);
			g.fillOval(xLocation, yLocation, area, area);
			
			//2nd light
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 10, area, area);

			//3rd light
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 20, area, area);

			break;

		case 2:
			// Forward is yellow, Turn is yellow
			// draw each light circle
			
			//1st light
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation, area, area);
			
			//2nd light
			g.setColor(Color.YELLOW);
			g.fillOval(xLocation, yLocation + 10, area, area);

			//3rd light
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 20, area, area);
			
			break;
		case 3:
			
			// Forward is green, Turn is green
			// draw each light circle
			
			//1st light
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation, area, area);
			
			
			//2nd light
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 10, area, area);

			//3rd light
			g.setColor(Color.GREEN);
			g.fillOval(xLocation, yLocation + 20, area, area);
			
			break;
	
		}
	}
	
	
	//Need of a method which will allow a delay ? 
	// thread(sleep) ? 
	// delay ( time in miliseconds to delay) 
	

	
	

}
