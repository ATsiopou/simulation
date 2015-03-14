import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Turn {

	private int xLocation; // the paint location to paint
	private int yLocation = 10;
	private String direction; // direction of the light north east south west
	private int area = 10; // Area for the circle which the color is drawn into
	

	Turn(String direction, int xLocation) {

		this.direction = direction;
		this.xLocation = xLocation;
	}

	/**
	 * This method is responsible for drawing the LEFT turn state. The state
	 *  is either RED, YELLOW or GREEN shading in the ">" character within a 
	 *  gray oval. The LEFT turn signal is held in the 4th position of the 
	 *  light array. 
	 *  
	 * @param g
	 * @param state
	 */
	public void drawLeftTurnLight(Graphics g, int state) {

		switch (state) {
		case 1:

			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 30, area, area);

			g.setColor(Color.RED);
			g.drawString("<", xLocation, yLocation + 40);

			break;
		case 2:
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 30, area, area);

			g.setColor(Color.YELLOW);
			g.drawString("<", xLocation, yLocation + 40);
			
			break;
		case 3:

			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 30, area, area);

			g.setColor(Color.GREEN);
			g.drawString("<", xLocation, yLocation + 40);
			
			break; 
		
		case 4: 
			//turns not
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 30, area, area);

			break; 
			
		}

	}
	
	/**
	 * This method is responsible for drawing the right turn state. The state
	 *  is either RED, YELLOW or GREEN shading in the ">" character within a 
	 *  gray oval. The right turn signal is held in the 5th position of the 
	 *  light array. 
	 *  
	 * @param g
	 * @param state
	 */
	public void drawRightTurnLight(Graphics g, int state) {

		switch (state) {
		case 1:

			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 40, area, area);

			g.setColor(Color.RED);
			g.drawString(">", xLocation, yLocation + 50);

			break;
		case 2:
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 40, area, area);

			g.setColor(Color.YELLOW);
			g.drawString(">", xLocation, yLocation + 50);
			
			break;
		case 3:
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 40, area, area);

			g.setColor(Color.GREEN);
			g.drawString(">", xLocation, yLocation + 50);
			
			break; 
		
		case 4: 
			//turns not
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(xLocation, yLocation + 40, area, area);

			break; 
			
		}

	}
	
	
	//Need of a method which will allow a delay ? 
	// thread(sleep) ? 
	// delay ( time in miliseconds to delay) 
	
	

}
