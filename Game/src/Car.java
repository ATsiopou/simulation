/*Authors : Iordanis Paschalidis, 
 * 			Anthony Tsiopoulos 
 * 
 * Class  : Car
 * 			This class is responsible for creating a car.
 * 			The class implements runnable, so the run() method is
 *			is provided as method in the class. An object of the 
 *			class Car is a Runnable object.   			
 * 			
 * Moded:  03/06/15
 * 			
 */


import java.awt.*;

import javax.swing.JPanel;

public class Car implements Runnable{
	
	private int x0; 
	private int y0; 
	private Cell entryPosition;
	private Lane lane; 
	private int id; 
	private int tileSize =10; 
	private int current; 

	private boolean running; 
	
	public Car(){
		this.running = true;
	}

	public Car(Lane lane){ 
		this.running = true; 
		this.lane=lane; 
		this.id = lane.getId(); 
		this.entryPosition=lane.getStart(); 
		this.x0 = entryPosition.getCol();   //initial position
		this.y0 = entryPosition.getRow();   //initial position
	}

	/**
	 * This method is responsible for moving a car. It
	 * checks the if the cell in front of it is occupied 
	 * and it proceeds to accelerate, otherwise it will 
	 * break. 
	 */
	public void move() {
		
		Cell currentCell = entryPosition; 
		//currentCell.setOccupied(true);
		//then check the next cell if it is occupied.  
		
		
		if(!currentCell.isOccupied()){
			accelerate(); 
		}else{
			brake(); 
		}
	}
	

	/**
	 * This method moves the car in a direction. The directions 
	 * is decided by first checking the id of the lane. For an even
	 * id, the car is travelling in a northbound or westbound lane. 
	 * if the id is odd: The car is in a southboun/eastbound lane. 
	 * 
	 * 		//for curved lanes
	 * foreach(Cell cell: lane.getCells()) {
	 * move your car in each cell
	 * set cell occupied
	 * set previous cell unoccoupied
	 * }
	 * 
	 * Try to remove the magic numbers => make it more general 
	 * 
	 * 
	 */
	private void accelerate(){
		
		if(isEven(id)){
			if(entryPosition.getRow() == 60){
				y0-=tileSize; 
				
			}else{
				x0-=tileSize;
			}
		}else{ //ODD
			if(entryPosition.getCol() == 0){
				x0+=tileSize; 
			}else{
				y0+=tileSize;  
			}
		}
	}
	
	/**
	 * This method (for now) will stop the car from increasing in
	 * it's current direction
	 */
	private void brake(){
		
		x0 = x0; 
		y0 = y0; 
	}
	
	private void randomize(){
      //randomly call accelerate OR randomly call brake
	}

	/**
	 * Checks if the id is odd or even 
	 * @param id
	 * @return
	 */
	private boolean isEven(int value){
		
		if(value % 2 == 0){
			return true; 
		}else{
			return false; 
		}
	}
	
	// Overriding methods 
	// The car class should be act as an independent "agent" 
	// Override the run, an the draw methods 
	@Override 
	public void run() {
		
		long startTime,timeDiff,sleep; 
		startTime = System.currentTimeMillis(); 
		
		while(running){
		
			// call the move method to move the car 
			move(); 
		
			timeDiff = System.currentTimeMillis() - startTime; 
			sleep = 300 - timeDiff; 
			
			if(sleep < 0){
				sleep = 3; 
			}
			
			try{
				Thread.sleep(sleep);
			}
			catch(InterruptedException e){
				System.out.println("Error in Car, error msg: " + e.getMessage());
			}
			startTime = System.currentTimeMillis(); 
		}
	}


	/**
	 * This method draws the car to the UI
	 * place the car on a position.
	 * @param g
	 */
	public void draw(Graphics2D g){
		drawCar(g); 
	}

	/**
	 * This method is responsible for drawing the car 
	 * 
	 * @param g
	 */
	private void drawCar(Graphics2D g){
		
		Image im1 = Toolkit.getDefaultToolkit().getImage("res/car.png"); 		
		g.drawImage(im1, x0*tileSize, y0*tileSize, tileSize, tileSize, null, null);
		//g.drawImage(im1, x0, y0, tileSize, tileSize, null, null);
	}
	
	
}
