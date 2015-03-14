import java.util.Random;

public class Car {

	private int x;//the x position of the car
	private int y;//the y position of the car
	 
	private int direction;//0 for right 1 for left,2 for up,3 for down
	 
	private Lane lane;//the line the car will enter
    private Matrix matri;
    private Random random=new Random();
   
   //first contractor will be different in the future
   //decide by the direction of the car where is the start point in the lane
    //by taking the lanes first position
   public Car(int direction,Lane lane,Matrix matrix) {
		super();
        
      
        this.matri=matrix;
		this.lane=lane;
		this.direction=direction;//we can change that aso it can just take the direction of the lane

		if(direction==0){
		  this.y = lane.getLineOney()+5;
		  this.x = lane.getLineTwox();
		}else if(direction==1){
			 this.y = lane.getLineOneEndy()+5;
			 this.x = lane.getLineOneEndx();
		}
		else if(direction==2){
			 this.y = lane.getLineOney();
			 this.x = lane.getLineOnex()+5;
		}else{
			 this.y = lane.getLineOneEndy();
			 this.x = lane.getLineOneEndx()+5;
		}
	}	
   
   //this methos is how the car will decide to move
   //now is taking the direction is going and move one position
   //it is working for strange  roads so if we decide to put round roads it will change
   //if not it will just has to become more clever  when to top and stuff like that
   public void move(){
		
	   //see the direction and diecide how to move
		switch (direction) {

		case 0: 

			if(!((checkLightDistance(0)) < 25) || checkLightCondition()){
				if(x==lane.getLight().getX1Position()+50){
				//	turn();
				}
				matri.removePosition(x, y);	
			    
				if(!matri.isCarNear(x, y,0)){
		         	x++;
			    }
				matri.addPosition(x, y);	

		        
		    	     
			}
			
			
                break;
       case 1: 
    	   if(!((checkLightDistance(1)) < 25) || checkLightCondition()){
    		   if(x==lane.getLight().getX1Position()-70){
					//turn();
				}
    			matri.removePosition(x, y);	
		    
			if(!matri.isCarNear(x, y,1)){
	         	x--;
		    }
			matri.addPosition(x, y);
    	   }
                break;
       case 2:
    	   if(!((checkLightDistance(2)) < 25) || checkLightCondition()){
    			matri.removePosition(x, y);	
		    
			if(!matri.isCarNear(x, y,2)){
		       	y++;
		    }
			matri.addPosition(x, y);
    	   }
                break;
       case 3:  
    	   if(!((checkLightDistance(2)) < 25) || checkLightCondition()){
    		   matri.removePosition(x, y);	
		       
			if(!matri.isCarNear(x, y,3)){
		       	y--;
		    }else{
				System.out.println("as");

		    }
			matri.addPosition(x, y);
    	   }
                break;                 
		}
		
	}
	
	
	
	// this method return the distace from the lights and the car
	public int checkLightDistance(int directionxv){
		 int value ;
		if(directionxv==0||directionxv==1){
		     value = Math.abs(x - lane.getLight().getX1Position()); 
		}else{
		     value = Math.abs(y - lane.getLight().getY1Position()); 

		}
		
		return value; 	
	}
	
	
	//get the lights condition (red or greeen)
	public boolean checkLightCondition(){
		return lane.getLight().isCondition();
	}
	
	
	//working for direction 0
	//not htat dynamic too static
	//not using this one dont test it
	public void turn(){
		int randomLane=random.nextInt(2);


		if(direction==0){
			 
			 if(randomLane==1){
				 direction =3;
			 }

		}else if(direction==1){
			if(randomLane==1){
				 direction =2;
			 }
		}
	}
	
	
	//setter getters

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	 
	

	
	
	 
	
}
