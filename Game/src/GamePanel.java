/*Authors : Iordanis Paschalidis 
 * 			Anthony Tsiopoulos 
 * 
 * Class  : GamePanel.
 * 			This class is responsible for building the GamePanel. A GamePanel is the immediate
 * 			class in the hierarchical view of the class diagram. The class is responsible for the 
 * 			overall control of the game. 
 * 
 * Moded  : 
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
	private Thread thread;
	private boolean running; 
	private Graphics2D g;
	private BufferedImage image;
	private Map map;

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

			//Make sure that the thread value is not negative 
			//If this is not here, there is an issue with
			//the display ... MUCH strange. 
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
	 * Init will hold the map initialisation graphics and image. 
	 * @throws IOException
	 */
	private void init() throws IOException {
		running = true; 
		//This can stay like this for now
		//There may be a better way to do this -> i.e. decoupled 
		
		map = new Map("res/filemap.json",TILE);
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	 	g = (Graphics2D) image.getGraphics();
		g.setBackground(Color.WHITE);
	}


	// These methods are updating, rendering and drawing the graphics 
	// inside the run method

	
	
	
	
	/**
	 * Update the map. Used in the run method. 	
	 */
	private void update() {
		map.update();
	}

	/**
	 *method to render the image in the run method 
	 */
	private void render() {
		map.draw(g);
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
