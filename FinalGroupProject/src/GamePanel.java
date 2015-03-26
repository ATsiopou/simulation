/*Authors : Iordanis Paschalidis, 
 * 			Anthony Tsiopoulos 
 * 			
 * 
 * Class  : GamePanel.
 * 			This class is responsible for building the GamePanel. A GamePanel is the immediate
 * 			class in the hierarchical view of the class diagram. The class is responsible for the 
 * 			overall control of the game. 
 * 
 * Moded  : 03/06/15
 * 
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class GamePanel extends JPanel implements Runnable {

	public static final boolean debug = false;
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 800; // 600
	public static final int WIDTH = 1200; // 800
	public static final int DELAY = 15;
	public static final int TILE = 10;
	private int TOTALNUMBEROFCARS;
	private int CARENTRYFREQUENCY;
	private int LIGHTMECHANISM; 
	private int MAPTYPE;
	private int lightCounter = 0;
	private int inte = 0;
	private boolean running = true;
	private Thread animator;
	private Graphics g;
	private Map map;
	private double speed; 
	private String maps[];
	private List<Car> listOfCars;
	private List<Light> listOfLights; 
	
	
	 

	/**
	 * This is the default constructor for the game 
	 */
	public GamePanel() {
		setDoubleBuffered(true);
		
		this.TOTALNUMBEROFCARS = 100; 
		this.CARENTRYFREQUENCY = 10; // in miliseconds 
		this.LIGHTMECHANISM = 350; 
		this.MAPTYPE = 1; 
		initGamePanel();
	
	}

	/**
	 * This constructor sets the user specified values at the start screen
	 *  
	 * @param TOTALNUMBEROFCARS
	 * @param CARENTRYFREQUENCY
	 * @param LIGHTMECHANISM
	 * @param MAPTYPE
	 */
	public GamePanel(int TOTALNUMBEROFCARS,int CARENTRYFREQUENCY, int LIGHTMECHANISM, String []maps,int MAPTYPE,double speed) {
		setDoubleBuffered(true);
		this.TOTALNUMBEROFCARS = TOTALNUMBEROFCARS; 
		this.CARENTRYFREQUENCY = CARENTRYFREQUENCY; 
		this.LIGHTMECHANISM = LIGHTMECHANISM; 
		this.maps = maps; 
		this.MAPTYPE = MAPTYPE; 
		//this.speed = speed; 
		initGamePanel();
	}
	
	

	/**
	 * Private method which sets the map type
	 */
	private void initGamePanel() {
		try {
			map = new Map("res/"+maps[MAPTYPE], WIDTH, HEIGHT,
					TILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

	@Override
	public void addNotify() {
		super.addNotify();
		animator = new Thread(this);
		animator.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		// Draw map
		map.paintMap(g2d);
		map.drawLights(g2d);

		// Draw the images for the cars
		for (Car car : listOfCars) {
			g2d.drawImage(car.getCarImage(), (int) car.getX0() * TILE,
					(int) car.getY0() * TILE, this);
		}

		// For testing purpose
		if (debug) {
			map.paintGrid(g2d);
			map.paintMapOccupiedValues(g2d);
		}
		g.dispose();
	}

	@Override
	public void run() {

		// Create the list of cars
		//This solves the repaint bug - array list was previously unlocked, now locked and unlocked and given to thread 
		listOfCars = java.util.Collections.synchronizedList(new ArrayList<Car>()); 
		listOfLights = java.util.Collections.synchronizedList(new ArrayList<Light>());  
		
        
		while (running) {
			clearOutMApCar();
			listOfLights = map.getLightList();
			
			if( lightCounter % LIGHTMECHANISM == 0 ){
				this.lightMechanism();
			}
			lightCounter++; 

			try {
				if ((inte % CARENTRYFREQUENCY == 0)) {
					if (listOfCars.size() < TOTALNUMBEROFCARS) {
						Lane lane = new Lane();
						lane = map.getRandomLane();
						Car car = new Car(lane, g, listOfLights, map,speed);
						listOfCars.add(car);
					}
				}
				for (Car car : this.listOfCars) {
					car.move();
				}
				inte++;
				Thread.sleep(DELAY);
				repaint();
			} catch (InterruptedException ex) {
				Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE,null, ex);
			}
		}
	}

	
	/**
	 * This method removes the cars from the map when they 
	 * have passed the maps boundaries. 
	 */
	public void clearOutMApCar() {
		List<Car> listOfCars2 = listOfCars;
		Iterator<Car> i = listOfCars2.iterator();
		while (i.hasNext()) {
			Car s = i.next(); // must be called before you can call i.remove()
			if (shouldRemoveFromTheList(s)) {
				s.removePosition();
				i.remove();
			}
		}
	}

	
	/**
	 * This method checks the direction of the car and compares 
	 * it to the bounds of the map. If the cars next value exceeds 
	 * the bounds, then the car should be removed from the map. 
	 * 
	 * @param c
	 * @return boolean
	 */
	private boolean shouldRemoveFromTheList(Car c) {
		
		if (c.getLane().getDirection() == 0) {
			if (c.getX0() > c.getLane().getEnd().getCol()) {
				return true;
			}
		} else if (c.getLane().getDirection() == 1) {
			if (c.getX0() < c.getLane().getEnd().getCol()) {
				return true;
			}
		} else if (c.getLane().getDirection() == 2) {
			if (c.getY0() > c.getLane().getEnd().getRow()) {
				return true;
			}
		} else {
			if (c.getY0() < c.getLane().getEnd().getRow()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used for debugging, just to print the lights location
	 * which are read from the JSON file 
	 */
	private void printL(){
		for(Light l:listOfLights){
		}
	}
	
	
	/**
	 * This method takes each light in the the list of lights and changes 
	 * their values depending on their default state 
	 */
	private void lightMechanism(){
		for(Light l:listOfLights){
			l.changeLight();
		}
	}

	
}