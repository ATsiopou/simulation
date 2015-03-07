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
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	public static final int DELAY = 15;
	public static final int TILE = 10;
	public static final int TOTALNUMEROFCARS = 10;
	public static final int ENTRYFREQUENCY = 5; 
	private Thread thread;
	private boolean running;
	private Graphics2D g;
	private BufferedImage image;
	private Map map;
	private Car car;
	private Lane lane; 

	public GamePanel() {
		super();
		initGamePanel();
	}

	private void initGamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {

		try {
			init();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		long startTime; // holds the starting time
		long timeDiff;  //
		long sleep;     // waitTime

		startTime = System.currentTimeMillis();

		while (running) {

			update();
			render();
			draw();

			// Calculate the time difference and then assign to sleep
			timeDiff = System.currentTimeMillis() - startTime;
			sleep = DELAY - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted msg: " + e.getMessage());
			}
			startTime = System.currentTimeMillis();
		}

	}

	/**
	 * Init will hold the map initialisation of the map and car. 
	 * A map object is instantiated with the JSON file, which holds the information
	 * of the map, lights and lane entries.
	 * A car object is first instantiated with the position of a single
	 * cell (later to be changed to a random cell chosen from a a static array
	 * whose elements are the entry positions).
	 *
	 * @throws Exception 
	 * @throws IOException
	 */
	private void init() throws Exception{

		running = true;
		initMap(); 
		initCar();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
	}

	
	///////////////////////////////////////////////////////////////////////
	//       private calls from the init() method 
	//////////////////////////////////////////////////////////////////////
	
	/**
	 * Initialises the map 
	 * @throws Exception
	 */
	private void initMap() throws Exception{
		map = new Map("res/map1_1Intersection.json", TILE);
		// The Second map, works like a charm
		// map = new Map("res/map2_4Intersection.json",TILE);
	}

	/**
	 * Initialises the cars and places the cars on the map. A call is made 
	 * to getRandomLane(), which returns a random lane. The starting cell 
	 * is then accessed and given to the car as the starting position. A thread 
	 * carThread is then instantiated with the car object and the thread is
	 * started. 
	 * 
	 * @throws Exception
	 */
	private void initCar() throws Exception {
		 
		Lane lane = map.getRandomLane(); 
		car = new Car(lane);
		// pass the car to the car thread
		Thread carThread = new Thread(car);
		// Start the thread for the car
		carThread.start();
	}
	

	
	
	//////////////////////////////////////////////////////////////////////
	// The following called from inside the run() method.
	//////////////////////////////////////////////////////////////////////
	
	/**
	 * Update the map. Used in the run method.
	 */
	private void update() {
		map.update();
	}

	/**
	 * Draw object from the classes through this mthod
	 * 
	 */
	private void render() {
		map.draw(g);
		car.draw(g);
	}

	/**
	 * Draws the image in the panel. The image is anchored in the (0,0)
	 * position.
	 */
	private void draw() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

}
