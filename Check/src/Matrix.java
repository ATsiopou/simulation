
public class Matrix {
	
	private boolean matrixArray [][]=new boolean [1200][800];
	
	public Matrix(){
		for (int i=0;i<1200;i++){
			for(int j=0;j<800;j++){
				matrixArray[i][j]=false;
				
			}
		}	
	}
	
	public void addPosition(int x,int y){
		if(x<1200 && x>0 && y <800 && y >0)
		matrixArray[x][y]=true;

	}

	public void removePosition(int x,int y){
		if(x<1200 && x>0 && y <800 && y >0)
		matrixArray[x][y]=false;
	}
	
	public boolean isCarNear(int x,int y,int direction){
		// workign only for direction 0
		
		
	  if(direction==0){
		if(x<1159){
		  for (int i=x;i<x+40;i++){
			    if(matrixArray[i][y]) return true;
		    }
		  }
	   }else if(direction==1){
	     if(x>40 && x<1200){

		   for (int i=x;i>x-40;i--){
			    if(matrixArray[i][y]) return true;
		     }
		  }
			
	   }else if(direction==2){
		   if(y>40 && y<760){
			   for (int i=y;i<(y+40);i++){
				    if(matrixArray[x][i])  return true;
			     }
			  }
	   }else{
		   if(y>0 && y<800){
			   for (int i=y;i<y-40;i--){
				    if(matrixArray[x][i])  return true;
			     }
			  }
	   }
		
	
	  
		
		return false;
	}
	
    
	
}
