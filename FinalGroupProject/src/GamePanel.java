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
import java.util.*;
import java.util.logging.Level;

import javax.swing.JPanel;

import com.sun.istack.internal.logging.Logger;

public class GamePanel extends JPanel implements Runnable {

	public static final boolean debug = true;
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 800; // 600
	public static final int WIDTH = 1200; // 800
	public static final int DELAY = 15;
	public static final int TILE = 10;
<<<<<<< HEAD
	public static  int TOTALNUMEROFCARS = 30;
	public static  int ENTRYFREQUENCY = 10; // in milliseconds (2seconds)
	public static  int LIGHTMECHANISM = 350; 
=======
	public static final int TOTALNUMEROFCARS = 20;
	public static final int ENTRYFREQUENCY = 50; // in milliseconds (2seconds)
	public static final int LIGHTMECHANISM = 50; 
>>>>>>> origin/master
	private int lightCounter = 0; 
	private boolean running = true;
	private Thread animator;
	private Graphics g;
	private Map map;
	private ArrayList<Car> listOfCars;
	private ArrayList<Light> listOfLights; 
<<<<<<< HEAD
	private int inte = 0;
	private int MAPTYPE = 1;
	private TimePanel  timePanel = new TimePanel();
	
	 

	public GamePanel() {

=======
	private ArrayList<Cell> occupiedCells;
	private int inte = 0;
	private int MAPTYPE = 1;
	 

	public GamePanel() {
>>>>>>> origin/master
		setDoubleBuffered(true);
		initGamePanel();
		
	}

	/**
	 * Private method which sets the map type
	 */
	private void initGamePanel() {
		
<<<<<<< HEAD
		switch (2) {
=======
		switch (MAPTYPE) {
>>>>>>> origin/master
		case 1:
			try {
				map = new Map("res/map1_1Intersection.json", WIDTH, HEIGHT,
						TILE);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				map = new Map("res/map2_4Intersection.json", WIDTH, HEIGHT,
						TILE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
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
		listOfCars = new ArrayList<Car>();
		listOfLights = new ArrayList<Light>(); 

		
		
<<<<<<< HEAD
		
//		Lane lane = new Lane(); 
//		Cell startingCell = new Cell(0,56);
//		Cell endCell = new Cell(56,120); 
//		lane.setStart(startingCell);
//		lane.setEnd(endCell);
//		lane.setDirection(0);
//		lane.setId(3);
	
		
		
=======
		/*
		Lane lane = new Lane(); 
		Cell startingCell = new Cell(118,42);
		Cell endCell = new Cell(0,42); 
		lane.setStart(startingCell);
		lane.setEnd(endCell);
		lane.setDirection(1);
		lane.setId(4);
	*/
		
        
>>>>>>> origin/master
		while (running) {
			clearOutMApCar();
			listOfLights = map.getLightList();

			
			if( lightCounter % LIGHTMECHANISM == 0 ){
				
				this.lightMechanism();
				
			}
			lightCounter++; 

<<<<<<< HEAD
			timePanel.workTimeTraffic();
=======
			
>>>>>>> origin/master
			
			
			try {
				if ((inte % ENTRYFREQUENCY == 0)) {
					if (listOfCars.size() < TOTALNUMEROFCARS) {
<<<<<<< HEAD
				     	Lane lane = new Lane();
					    lane = map.getRandomLane();
=======
						Lane lane = new Lane();
						lane = map.getRandomLane();
>>>>>>> origin/master
						Car car = new Car(lane, g, listOfLights,map);
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
				Logger.getLogger(GamePanel.class.getName(), null).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	/**
	 * This method removes the cars from the map when they 
	 * have passed the maps boundaries. 
	 */
	public void clearOutMApCar() {
		ArrayList<Car> listOfCars2 = listOfCars;
		Iterator<Car> i = listOfCars2.iterator();
		while (i.hasNext()) {
			Car s = i.next(); // must be called before you can call i.remove()
			if (shouldRemoveFromTheList(s)) {
<<<<<<< HEAD
				s.removePosition();
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
			if (c.getX0() > c.getLane().getEnd().getCol()-2) {
				return true;
			}
		} else if (c.getLane().getDirection() == 1) {
			if (c.getX0() < c.getLane().getEnd().getCol()+2) {
				return true;
			}
		} else if (c.getLane().getDirection() == 2) {
			if (c.getY0() > c.getLane().getEnd().getRow()-2) {
				return true;
			}
		} else {
			if (c.getY0() < c.getLane().getEnd().getRow()+2) {
=======
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
>>>>>>> origin/master
				return true;
			}
		}
		return false;
	}
	
	private void printL(){
		for(Light l:listOfLights){
			System.out.println(l.getPosition().getCol()+"             "+l.getPosition().getRow());
		}
	}
	
	
	private void lightMechanism(){
		for(Light l:listOfLights){
<<<<<<< HEAD
		 	l.changeLight();
=======
			l.changeLight();
>>>>>>> origin/master
			//System.out.println(l.getPosition().isOccupied());

		}

	}
	
	

}