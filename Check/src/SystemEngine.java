import java.awt.*;
<<<<<<< Updated upstream
import javax.swing.*;
=======

import javax.swing.*;

>>>>>>> Stashed changes
import java.io.*;
import java.util.*;

public class SystemEngine extends JPanel {
	
	private ArrayList <Car> listOfCars=new ArrayList ();
	
<<<<<<< Updated upstream
	Lane lane= new Lane(0,350,1200,350,0,390,1200,390);
	Lane lane2= new Lane(0,391,1200,391,0,431,1200,431);
	
	Lane lane3= new Lane(560,0,560,800,600,0,600,800);
	Lane lane4= new Lane(600,0,600,800,640,0,640,800);
=======
	
	Light l=new Light(550,350);
	Light l2=new Light(640,391);
	Light l3=new Light(560,350);
	Light l4=new Light(600,431);

	Lane lane= new Lane(0,350,1200,350,0,390,1200,390,l);
	Lane lane2= new Lane(0,391,1200,391,0,431,1200,431,l2);
	
	Lane lane3= new Lane(560,0,560,800,600,0,600,800,l3);
	Lane lane4= new Lane(600,0,600,800,640,0,640,800,l4);
>>>>>>> Stashed changes

	int inte=0;//a valiable we can use for putting the cars
	
	//this method will move all the cars at the same time
	// maybe we need to change it to an other class to the system class 
	int lanepo=0;

<<<<<<< Updated upstream
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
			       
=======
	public void moveCar() {

		if (inte%20==0){
			

			if(lanepo==0){

		       Car c=new Car(0,lane);

		       listOfCars.add(c);
		       lanepo=1;
			}else if(lanepo==1){
			     Car c=new Car(1,lane2);
			    //  listOfCars.add(c);
			       lanepo=2;
			       
			}else if(lanepo==2){
			     Car c=new Car(2,lane3);
			   //   listOfCars.add(c);
			       lanepo=3;
			       
			}else{
				 Car c=new Car(3,lane4);
			 //     listOfCars.add(c);
			       lanepo=0;
>>>>>>> Stashed changes
			}
			
		}
		
<<<<<<< Updated upstream
		
		
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
	
=======
			for (Car c : listOfCars) {
				c.move();
			}

		

	    	
	    	
		inte++;
	
	}
	
	
	private boolean shouldRemoveFromTheList(Car c){
		 if(c.getDirection()==0){
			  
			 if(c.getX()>1200){
				return true;  
			  }
		  }else if(c.getDirection()==1){
			  
			  if(c.getX()<0){
					return true;  
				  }
		  }else if(c.getDirection()==2){
			  
			  if(c.getY()>800){
					return true;  
				  }  

			  
		  }else{
			  if(c.getY()<0){
					return true;  
				  }  
		   }
		 
		 return false;
	}
	
    public void lightsEngine(){
    	
    	if(l.isCondition()){
    	   l.setCondition(false);
    	   l2.setCondition(false);
    	   l3.setCondition(true);
    	   l4.setCondition(true);

    	}else{
     	   l.setCondition(true);
    	   l2.setCondition(true);
    	   l3.setCondition(false);
    	   l4.setCondition(false);

    	}
    	
    }
	
>>>>>>> Stashed changes
	
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

<<<<<<< Updated upstream
		 

		if(listOfCars.size()>0){
	    	for(Car c: listOfCars){
			   //g2d.fillOval(c.getX(), c.getY(), 25, 25);
				 g2d.drawImage(img1, c.getX(), c.getY(),30,30, this);

	    		//System.out.println(c.getX());
=======
			
			
			Graphics2D g2 = (Graphics2D) g;
		  	g2.setColor(l.getColor());
		    g2.fillOval(l.getX1Position(), l.getY1Position(), 10, 40);
		    
		    Graphics2D g2l = (Graphics2D) g;
		    g2l.setColor(l2.getColor());
		    g2l.fillOval(l2.getX1Position(), l2.getY1Position(), 10, 40);
		    
		    Graphics2D g2l3 = (Graphics2D) g;
		    g2l3.setColor(l3.getColor());
		    g2l3.fillOval(l3.getX1Position(), l3.getY1Position(), 40, 10);
		    
		    Graphics2D g2l4 = (Graphics2D) g;
		    g2l4.setColor(l4.getColor());
		    g2l4.fillOval(l4.getX1Position(), l4.getY1Position(), 40, 10);


			

		    
		if(listOfCars.size()>0){
	    	for(Car c: listOfCars){
				 g2d.drawImage(img1, c.getX(), c.getY(),30,20, this);
>>>>>>> Stashed changes
			}
		
		}
		
	}

}
