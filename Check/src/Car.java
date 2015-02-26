import java.util.Random;

<<<<<<< Updated upstream
=======
public class Car {

>>>>>>> Stashed changes
	private int x;//the x position of the car
	private int y;//the y position of the car
	 
	private int direction;//0 for right 1 for left,2 for up,3 for down
	 
	private Lane lane;//the line the car will enter
<<<<<<< Updated upstream
     
=======
    private Matrix matrix=new Matrix();
    private Random random=new Random();
>>>>>>> Stashed changes
   
   //first contractor will be different in the future
   public Car(int direction,Lane lane) {
		super();
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
		this.lane=lane;
		this.direction=direction;

		if(direction==0){
		  this.y = lane.getLineOney()+5;
		  this.x = lane.getLineTwox();
		}else if(direction==1){
			 this.y = lane.getLineOneEndy()+5;
			 this.x = lane.getLineOneEndx();
		}
<<<<<<< Updated upstream
=======
		else if(direction==2){
			 this.y = lane.getLineOney();
			 this.x = lane.getLineOnex()+5;
		}else{
			 this.y = lane.getLineOneEndy();
			 this.x = lane.getLineOneEndx()+5;
		}
>>>>>>> Stashed changes
	}	
   
   //this methos is how the car will decide to move
   //now is taking the direction is going and move one position
   //it is working for strange  roads so if we decide to put round roads it will change
   //if not it will just has to become more clever  when to top and stuff like that
<<<<<<< Updated upstream
	public void move(){
	
		switch (direction) {
     
		case 0: 
        	  x++;
        	
                 break;
        case 1:  
        	 x--;
        	
                 break;
        case 2:  
        	y++;
        	
                 break;
        case 3:  
        	y--;
        	
                 break;                 
=======
   public void move(){
		
		switch (direction) {
    
		case 0: 
			if(!((checkLightDistance(0)) < 25) || checkLightCondition()){
				if(x==lane.getLight().getX1Position()+10){
					this.turn();//need to change lanes the object lane
				}
		    	     x++;
		    	     
			}
			
			
                break;
       case 1: 
    	   if(!((checkLightDistance(1)) < 25) || checkLightCondition())
       	 x--;
       	
                break;
       case 2:
    	   if(!((checkLightDistance(2)) < 25) || checkLightCondition())

       	y++;
       	
                break;
       case 3:  
    	   if(!((checkLightDistance(2)) < 25) || checkLightCondition())

       	y--;
       	
                break;                 
		}
	}
	
	
	
	
	public int checkLightDistance(int directionxv){
		 int value ;
		if(directionxv==0||directionxv==1){
		     value = Math.abs(x - lane.getLight().getX1Position()); 
		}else{
		     value = Math.abs(y - lane.getLight().getY1Position()); 

		}
		
		return value; 	
	}
	
	public boolean checkLightCondition(){
		return lane.getLight().isCondition();
	}
	
	
	//working for direction 0
	//not htat dynamic too static
	public void turn(){
		int randomLane=randomLane=random.nextInt(3);


		if(direction==0){
			 
			 if(randomLane==0){
				 direction =2;
			 }else if(randomLane==1){
				 direction =3;

			 }

		}else if(direction==1){
			 
			 if(randomLane==0){
				 direction =2;
			 }else if(randomLane==1){
				 direction =3;

			 }

		}else if(direction==2){
			 this.y = lane.getLineOney();
			 this.x = lane.getLineOnex()+5;
		}else{
			 this.y = lane.getLineOneEndy();
			 this.x = lane.getLineOneEndx()+5;
>>>>>>> Stashed changes
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
	 
	
<<<<<<< Updated upstream
=======

	
>>>>>>> Stashed changes
	
	 
	
}
