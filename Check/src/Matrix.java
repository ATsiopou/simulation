
public class Matrix {
	
	private boolean arrayOfPosition[][]=new boolean [1201][801];
	
	public Matrix(){
		
		for(int i=0;i<1201;i++){
			for(int j=0;j<801;j++){
				arrayOfPosition[i][j]=false;
			}
		}
		
	}
	
	public void remove(int x, int y){
		//30 is the size of the car
		for (int i=x;i<(x+30);i++){
			for(int j=y;j<(y+30);j++){
				arrayOfPosition[i][j]=false;
			}
		}
	}
	
	public void add(int x, int y){
		//30 is the size of the car
				for (int i=x;i<(x+30);i++){
					for(int j=y;j<(y+30);j++){
						System.out.println(arrayOfPosition[i][j]);

					}
				}
	}

	
	public boolean isACarInfront(int x,int y){
		if(x<1100 && y<700){//testing
		
		int xx=x+31;
		int yy=y+31;
		
		 for(int i=xx;i<xx+10;i++){
			 for(int j=xx;j<xx+10;j++){
				 if(arrayOfPosition[i][j]){
					
					 return true;
				 }
			 }
		 }
		
		}
		return false;
	}
	
	

	
	
}
