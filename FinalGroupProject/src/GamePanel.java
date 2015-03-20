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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {


	public static final boolean debug = false;
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 800; // 600
	public static final int WIDTH = 1200; // 800
	public static final int DELAY = 20;
	public static final int TILE = 10;
	public static final int TOTALNUMEROFCARS = 10;
	public static final int ENTRYFREQUENCY = 100; // in milliseconds (2seconds)
	private boolean running = true;
	private Thread animator;
	private Graphics g;
	public Map map;
	private ArrayList<Car> listOfCars;
	private ArrayList<Cell> occupiedCells;
	private int inte = 0;
	private int totalCarCounter = 0;
	private int MAPTYPE = 1;

	public GamePanel() {
		initGamePanel();
	}

	/**
	 * Private method which sets the map type
	 */
	private void initGamePanel() {
		setDoubleBuffered(true);
		switch (MAPTYPE) {
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
		// Draw traffic Lights here.

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
		occupiedCells = createOccupiedCells();
		
		while (running) {
			clearOutMApCar();
			try {
				if ((inte % ENTRYFREQUENCY == 0)) {
					if (listOfCars.size() < TOTALNUMEROFCARS) {
						Lane lane = new Lane();
						lane = map.getRandomLane();
						Car car = new Car(lane, g,occupiedCells,map);
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
				Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}
	

	@SuppressWarnings("unused")
	private void addDelay(int stoppage) {
		try {
			Thread.sleep(stoppage * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * create the cells which are set as occupid a the a traffic junction
	 */

	public ArrayList<Cell> createOccupiedCells() {

//	//	occupiedCells = new ArrayList<Cell>();
//
//		//Cell cell1 = new Cell(28, 16); // x++
//	//	Cell cell2 = new Cell(37, 29); // x++
/////		Cell cell3 = new Cell(40, 27); // y++
//		Cell cell4 = new Cell(41, 27); // y++
//		Cell cell5 = new Cell(42, 30); // x--
//		Cell cell6 = new Cell(42, 31); // x--
//		Cell cell7 = new Cell(38, 32); // y--
//		Cell cell8 = new Cell(39, 32); // y--
//
//		occupiedCells.add(cell1);
//		occupiedCells.add(cell2);
//		occupiedCells.add(cell3);
//		occupiedCells.add(cell4);
//		occupiedCells.add(cell5);
//		occupiedCells.add(cell6);
//		occupiedCells.add(cell7);
//		occupiedCells.add(cell8);
//
//		cell1.setOccupied(true);
//		cell2.setOccupied(true);
//		cell3.setOccupied(true);
//		cell4.setOccupied(true);
//		cell5.setOccupied(true);
//		cell6.setOccupied(true);
//		cell7.setOccupied(true);
//		cell8.setOccupied(true);

		return occupiedCells;

	}

	/**
	 * This method removes the cars from the map when 
	 * they have passed the maps boundaries. 
	 */
	public void clearOutMApCar() {
		ArrayList<Car> listOfCars2 = listOfCars;
		Iterator<Car> i = listOfCars2.iterator();
		while (i.hasNext()) {
			Car s = i.next(); // must be called before you can call i.remove()
			if (shouldRemoveFromTheList(s)) {
				i.remove();
			}
		}
	}

	// return true if the car should be removed from the lust
	private boolean shouldRemoveFromTheList(Car c) {
		if (c.getLane().getDirection() == 0) {
			if (c.getX0() > 120) {
				return true;
			}
		} else if (c.getLane().getDirection() == 1) {
			if (c.getX0() < 1) {
				return true;
			}
		} else if (c.getLane().getDirection() == 2) {
			if (c.getY0() > 80) {
				return true;
			}
		} else {
			if (c.getY0() < 1) {
				return true;
			}
		}
		return false;
	}

}
}
