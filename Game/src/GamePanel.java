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
	public static final int HEIGHT = 600; // 600
	public static final int WIDTH = 800; // 800
	public static final int DELAY = 20;
	public static final int TILE = 10;
	public static final int TOTALNUMEROFCARS = 10;
	public static final int ENTRYFREQUENCY = 2000; // in milliseconds (2seconds)
	private boolean running = true;
	private Thread animator;
	private Graphics g;
	private Map map;
	private ArrayList<Car> cars;
	private ArrayList<Cell> occupiedCells;

	public GamePanel() {
		initGamePanel();
	}

	private void initGamePanel() {
		setDoubleBuffered(true);
		try {
			map = new Map("res/map1_1Intersection.json", HEIGHT, WIDTH, TILE);
			// The Second map, works like a charm
			// map = new Map("res/map2_4Intersection.json",HEIGHT,WIDTH,TILE);

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
	/*
		//Draw trafficlights
		List<Cell> cells = new ArrayList<>();
		Cell cell1 = new CEll(41,0);
		Cell cell2 = new CEll(42,0);
		cells.addAll(cell1)
		TrafficLight light1 = new TrafficLight(g2d, cells);
		*/
		

		// Draw the images for the cars
		for (Car car : this.cars) {
			g2d.drawImage(car.getCarImage(), (int) car.getX0() * TILE,
					(int) car.getY0() * TILE, this);
		}

		// For testing purpose
		if (debug) {
			map.paintGrid(g2d);
		}
		repaint();
		g.dispose();
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {

		
		// Create a taffic light 
		//TrafficLight trafficLight = new TrafficLight(g,occupiedCells); 
		//trafficLight.cycleLights(0);
		
		
		// Create the list of cars
		// creatCars();
		cars = new ArrayList<>();
		// Create the occupied cells lists
		occupiedCells = createOccupiedCells();

		for (int i = 0; i < TOTALNUMEROFCARS; i++) {
			Lane lane = new Lane();
			lane = map.getRandomLane(); 
			Car car = new Car(lane, this.g, occupiedCells);
			// pass the car to the car thread
			Thread carThread = new Thread(car);
			// Start the thread for the car
			try {
				carThread.sleep(ENTRYFREQUENCY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			carThread.start();
			cars.add(car);

		}

		while (running) {

			// Set the occupied cells during the game loop
			for (Cell cell : occupiedCells) {
				cell.setOccupied(true);
			}

			try {
				for (Car car : this.cars) {
					car.move();
				}
				Thread.sleep(DELAY);
				repaint();
			} catch (InterruptedException ex) {
				Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

	}

	/**
	 * create the cells which are set as occupid a the a traffic junction
	 */

	public ArrayList<Cell> createOccupiedCells() {

		occupiedCells = new ArrayList<Cell>();

		Cell cell1 = new Cell(37, 28); // x++
		Cell cell2 = new Cell(37, 29); // x++
		Cell cell3 = new Cell(40, 27); // y++
		Cell cell4 = new Cell(41, 27); // y++
		Cell cell5 = new Cell(42, 30); // x--
		Cell cell6 = new Cell(42, 31); // x--
		Cell cell7 = new Cell(38, 32); // y--
		Cell cell8 = new Cell(39, 32); // y--

		occupiedCells.add(cell1);
		occupiedCells.add(cell2);
		occupiedCells.add(cell3);
		occupiedCells.add(cell4);
		occupiedCells.add(cell5);
		occupiedCells.add(cell6);
		occupiedCells.add(cell7);
		occupiedCells.add(cell8);

		return occupiedCells;

	}



}
