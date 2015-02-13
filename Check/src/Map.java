import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

//Ceking if it its updated in github

public class Map extends JPanel {
	
	private ArrayList <Car> listOfCars=new ArrayList ();
	Lane lane= new Lane(10,100,20,100);

	int inte=0;//a valiable we can use for putting the cars
	
	//this method will move all the cars at the same time
	// maybe we need to change it to an other class to the system class 
	public void moveBall() {
		if (inte%150==0){
		    Car c=new Car(0,lane);
		    listOfCars.add(c);
		    System.out.println(listOfCars.size());
		}
		
		if(listOfCars.size()>0){
	    	for(Car c: listOfCars){
			  c.move();
			}
		
		}
		inte++;
	}

	
	//this is just a testing method which will be useleess in the future
	public void changeDirection(){
	//	c.setDirection(2);
	}
	
	
	//this method paints the gui
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(listOfCars.size()>0){
	    	for(Car c: listOfCars){
			   g2d.fillOval(c.getX(), c.getY(), 30, 30);
	    		System.out.println(c.getX());
			}
		
		}
		
	}

}
