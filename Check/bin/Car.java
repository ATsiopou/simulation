public class Car {

	private int x;//the x position of the car
	private int y;//the y position of the car
	 
	private int direction;//0 for right 1 for left,2 for up,3 for down
	 
	private Lane lane;//the line the car will enter
     
   
   //first contractor will be different in the future
   public Car(int direction,Lane lane) {
		super();
		this.lane=lane;
		this.direction=direction;

		if(direction==0){
		  this.y = lane.getLineOney()+5;
		  this.x = lane.getLineTwox();
		}else if(direction==1){
			 this.y = lane.getLineOneEndy()+5;
			 this.x = lane.getLineOneEndx();
		}
	}	
   
   //this methos is how the car will decide to move
   //now is taking the direction is going and move one position
   //it is working for strange  roads so if we decide to put round roads it will change
   //if not it will just has to become more clever  when to top and stuff like that
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
