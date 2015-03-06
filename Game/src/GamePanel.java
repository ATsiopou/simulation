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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	public static final int DELAY = 15;
	public static final int TILE = 10; 
	public static final int TOTALNUMEROFCARS = 10; 
	private Thread thread;
	private boolean running; 
	private Graphics2D g;
	private BufferedImage image;
	private Map map;
	private Car car; 

	public GamePanel() {
		super();
		initGamePanel(); 
	}
	

	private void initGamePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	
	@Override
	public void addNotify() {
		super.addNotify();
		if(thread == null){
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
		}
		
		long startTime; // holds the starting time 
		long timeDiff;  // 
		long sleep;     //waitTime
		
		startTime = System.currentTimeMillis();
		
		while (running) {

			update();
			render();
			draw();
			
			//Calculate the time difference and then assign to sleep
			timeDiff = System.currentTimeMillis() - startTime;
			sleep = DELAY - timeDiff;

			if(sleep < 0){
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
	 * A map object is created and is instantiated with a JSON file, which 
	 * holds the information of the map and lights. The second argument, TILE, 
	 * defines the size of pixel we choose to represent a single cell object as
	 * through the draw method. 
	 * A car object is first instantiated with the position of a single cell
	 * (later to be changed to a random cell chosen from a a static array whose
	 * elements are the entry positions). 
	 * @throws IOException
	 */
	private void init() throws IOException {
		
		running = true; 
		
		
		
		
		
		map = new Map("res/filemap.json",TILE);		
		// The Second map, works like a charm 
		// map = new Map("res/map2_4Intersection.json",TILE);
		//Create a starting cell
		Cell startingPosition = new Cell(28,0);
		//create a new car
		car = new Car(startingPosition);
		//pass the car to the car thread 
		Thread carThread = new Thread(car);
		//Start the thread for the car 
		carThread.start();
		
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		
	
	}


/////////////////////////////////////////////////////////////////////
// The following called from inside the run method. 
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
	 * Draws the image in the panel. The image is
	 * anchored in the (0,0) position.   
	 */
	private void draw() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

}
