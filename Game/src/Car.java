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

	//1. Need an array of starting positions 
	//2. starting position 
	//3. current position 
	
	private int speed;
	private int x0; 
	private int y0; 
	private Cell currentCell; 
	private Cell startPosition;
	private boolean running; 
	// Thread animator; 
	
	public Car(){
		this.running = true;
		
	
	}

	public Car(Cell startPosition){ 
		this.running = true; 
		this.startPosition = startPosition; 
	//	startPosition.setOccupied(true);
	
		//animator = new Thread(this);
		//animator.start();
		
	}

	/**
	 * This method is responsible for moving a car. It
	 * checks the if the cell in front of it is occupied 
	 * and it proceeds to accelerate, otherwise it will 
	 * break. 
	 */
	public void move() {

		currentCell = startPosition; 
		System.out.println("current cell: (" + currentCell.getCol()+","+currentCell.getRow() +")");
		System.out.println("Cell occupied: " + currentCell.isOccupied()); 
		
		//How to access the next cell currnetCell+1 ? 
		if(!(currentCell).isOccupied()){
			accelerate(); 
		}else{
			brake(); 
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
	 * This method will increase the *speed* of the car as 
	 * it traverses the cells 
	 * Speed can be defined as the time spent in a current
	 * cell. 
	 * if time is large => slower speed
	 * if time is small => faster speed  
	 */
	private void accelerate(){
		x0++; 
	}
	
	/**
	 * This method (for now) will stop the car from increasing in
	 * it's current direction
	 */
	private void brake(){
		x0 = x0; 
	}
	
	private void randomize(){
      //randomly call accelerate OR randomly call brake
	}

	
	// Overriding methods 
	// The car class should be act as an independent "agent" 
	// Override the run, an the draw methods 
	@Override 
	public void run() {
		
		long startTime,timeDiff,sleep; 
		
		System.out.println("Inside the run method in car"); 
		
		x0 = startPosition.getCol();
		y0 = startPosition.getRow();
		
		startTime = System.currentTimeMillis(); 
		
		while(running){
		
			// call the move method to move the car 
			move(); 
		
			timeDiff = System.currentTimeMillis() - startTime; 
			sleep = 15 - timeDiff; 
			
			if(sleep < 2){
				sleep = 2; 
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
	 * This method is responsible for drawing the car 
	 * 
	 * @param g
	 */
	private void drawCar(Graphics2D g){
		 
		g.fillRect(x0*10, y0*10, 10, 10);
		g.setColor(Color.GREEN);
	}
	
	
}
