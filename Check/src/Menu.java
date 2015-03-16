import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Menu {

	

	public void render(Graphics g){
		
		Font f1 = new Font("arial",Font.BOLD,20); 
		g.setFont(f1);
		g.setColor(Color.WHITE);
		g.drawString("Traffic Simulation", 600, 200);
		
	
	}
	
	
}
