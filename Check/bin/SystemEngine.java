import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class SystemEngine extends JPanel {
	
	private ArrayList <Car> listOfCars=new ArrayList ();
	
	Lane lane= new Lane(0,350,1200,350,0,390,1200,390);
	Lane lane2= new Lane(0,391,1200,391,0,431,1200,431);
	
	Lane lane3= new Lane(560,0,560,800,600,0,600,800);
	Lane lane4= new Lane(600,0,600,800,640,0,640,800);

	int inte=0;//a valiable we can use for putting the cars
	
	//this method will move all the cars at the same time
	// maybe we need to change it to an other class to the system class 
	int lanepo=0;

	public void moveBall() {
		
		if (inte%35==0){
			
			
			if(lanepo==0){
			
		       Car c=new Car(0,lane);
		       listOfCars.add(c);
		       lanepo=1;
			}else{
			     Car c=new Car(1,lane2);
			      listOfCars.add(c);
			       lanepo=0;
			       
			}
			
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
		
	//	e
		g2d.drawLine(lane.getLineOnex(), lane.getLineOney(), lane.getLineOneEndx(), lane.getLineOney());
		g2d.drawLine(lane.getLineTwox(), lane.getLineTwoy(), lane.getLineTwoEndx(), lane.getLineTwoy());
		
		g2d.drawLine(lane2.getLineOnex(), lane2.getLineOney(), lane2.getLineOneEndx(), lane2.getLineOney());
		g2d.drawLine(lane2.getLineTwox(), lane2.getLineTwoy(), lane2.getLineTwoEndx(), lane2.getLineTwoy());
		
		 Image img1 = Toolkit.getDefaultToolkit().getImage("car.png");
		 
			g2d.drawLine(lane3.getLineOnex(), lane3.getLineOney(), lane3.getLineOneEndx(),  lane3.getLineOneEndy());
			g2d.drawLine(lane3.getLineTwox(), lane3.getLineTwoy(), lane3.getLineTwoEndx(),  lane3.getLineTwoEndy());
			
			g2d.drawLine(lane4.getLineOnex(), lane4.getLineOney(), lane4.getLineOneEndx(),  lane4.getLineOneEndy());
			g2d.drawLine(lane4.getLineTwox(), lane4.getLineTwoy(), lane4.getLineTwoEndx(),  lane4.getLineTwoEndy());

		 

		if(listOfCars.size()>0){
	    	for(Car c: listOfCars){
			   //g2d.fillOval(c.getX(), c.getY(), 25, 25);
				 g2d.drawImage(img1, c.getX(), c.getY(),30,30, this);

	    		//System.out.println(c.getX());
			}
		
		}
		
	}

}
