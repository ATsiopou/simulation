import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import java.awt.*;

public class GridPanel extends JPanel {

	private int WIDTH;
	private int HEIGHT; 
	private int TILE; 
	
	public GridPanel(int WIDTH, int HEIGHT, int TILE){
		
		this.WIDTH = WIDTH; 
		this.HEIGHT=HEIGHT;
		this.TILE=TILE; 
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

	protected void paintComponent(Graphics g) {
		showGridLines(g);
	}

	private void showGridLines(Graphics g) {

	    int rowHt = HEIGHT/TILE ;
	    int rowWid = WIDTH/TILE ;
	    
	    // draw the rows
	    for (int i = 0; i < HEIGHT; i++)
	      g.drawLine(0, i * rowHt, WIDTH, i * rowHt);

	    // draw the columns
	    for (int i = 0; i < WIDTH; i++)
	      g.drawLine(i * rowWid, 0, i * rowWid, HEIGHT);	
	    
	   
	    
	}
	
}
