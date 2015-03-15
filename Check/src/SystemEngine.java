import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.util.*;

public class SystemEngine extends JPanel {
	
	private ArrayList <Car> listOfCars=new ArrayList<>();
    private Matrix matrix=new Matrix();

	
	Light l=new Light(550,350);
	Light l2=new Light(640,391);
	Light l3=new Light(560,350);
	Light l4=new Light(600,431);

	Lane lane= new Lane(0,350,1200,350,0,390,1200,390,l);
	Lane lane2= new Lane(0,391,1200,391,0,431,1200,431,l2);
	
	Lane lane3= new Lane(560,0,560,800,600,0,600,800,l3);
	Lane lane4= new Lane(600,0,600,800,640,0,640,800,l4);

	int inte=0;//a valiable we can use for putting the cars
	
	//this method will move all the cars at the same time
	// maybe we need to change it to an other class to the system class 
	int lanepo=0;

	public void moveCar() {

		if (inte%20==0){
			
          /// add carsto the  arraylist/map
			if(lanepo==0){

		      Car c=new Car(0,lane,matrix);

		       listOfCars.add(c);
		       lanepo=1;
			}else if(lanepo==1){
			     Car c=new Car(1,lane2,matrix);
			     listOfCars.add(c);
			       lanepo=2;
			       
			}else if(lanepo==2){
			     Car c=new Car(2,lane3,matrix);
			    listOfCars.add(c);
			       lanepo=3;
			       
			}else{
				 Car c=new Car(3,lane4,matrix);
			 
				 //listOfCars.add(c);
			       lanepo=0;
			}
			
		}
		//move all cars to the next position
			for (Car c : listOfCars) {
				c.move();
			}


		inte++;
	
	}
	
	//return true if the car should be removed from the lust
	@SuppressWarnings("unused")
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
	
	
	//chne some lights to red some to green
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
	
	
	//this method paints the gui
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		 Image background = Toolkit.getDefaultToolkit().getImage("back.png");
		 
        g.drawImage(background, 0, 0,null);

		
	//	draws lanes
		g2d.drawLine(lane.getLineOnex(), lane.getLineOney(), lane.getLineOneEndx(), lane.getLineOney());
		g2d.drawLine(lane.getLineTwox(), lane.getLineTwoy(), lane.getLineTwoEndx(), lane.getLineTwoy());
		
		g2d.drawLine(lane2.getLineOnex(), lane2.getLineOney(), lane2.getLineOneEndx(), lane2.getLineOney());
		g2d.drawLine(lane2.getLineTwox(), lane2.getLineTwoy(), lane2.getLineTwoEndx(), lane2.getLineTwoy());
		
		//create an object of the image(add it multiple times )
		 Image img1 = Toolkit.getDefaultToolkit().getImage("car.png");
		 Image img2 = Toolkit.getDefaultToolkit().getImage("car4.png");
		 Image img3 = Toolkit.getDefaultToolkit().getImage("car3.png");
		 Image img4 = Toolkit.getDefaultToolkit().getImage("car2.png");

		 
			//	draws lanes

			g2d.drawLine(lane3.getLineOnex(), lane3.getLineOney(), lane3.getLineOneEndx(),  lane3.getLineOneEndy());
			g2d.drawLine(lane3.getLineTwox(), lane3.getLineTwoy(), lane3.getLineTwoEndx(),  lane3.getLineTwoEndy());
			
			g2d.drawLine(lane4.getLineOnex(), lane4.getLineOney(), lane4.getLineOneEndx(),  lane4.getLineOneEndy());
			g2d.drawLine(lane4.getLineTwox(), lane4.getLineTwoy(), lane4.getLineTwoEndx(),  lane4.getLineTwoEndy());

			
			
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


			

		 // this for loop draws all the cars   
		if(listOfCars.size()>0){
	    	for(Car c: listOfCars){
	    		 if(c.getDirection()==0){
				     g2d.drawImage(img1, c.getX()-30, c.getY(),30,20, this);
	    		 }else if(c.getDirection()==1){
				     g2d.drawImage(img2, c.getX()-30, c.getY(),30,20, this);
	    		 }else if(c.getDirection()==2){
				     g2d.drawImage(img3, c.getX(), c.getY()-30,30,20, this);
	    		 }
	    		   else{
				     g2d.drawImage(img4, c.getX(), c.getY()-30,30,20, this);

	    		 }
	    		 
	    			 
			}
		
		}
		
	}

}
