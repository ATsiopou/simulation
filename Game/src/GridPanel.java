import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import java.awt.*;

public class GridPanel extends JPanel {


	private static final long serialVersionUID = 7933994053959437894L;
	private int WIDTH;
	private int HEIGHT; 
	private int TILE; 
	
	public GridPanel(int WIDTH, int HEIGHT, int TILE){
		
		//this.WIDTH = WIDTH/TILE; 
		//this.HEIGHT=HEIGHT/TILE;
		this.WIDTH=WIDTH; 
		this.HEIGHT=HEIGHT; 
		this.TILE=TILE; 
		setOpaque(false);

	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

	protected void paintComponent(Graphics2D g) {
		showGridLines(g);
	}

	private void showGridLines(Graphics g) {
		
	    // draw the rows
		//Cast the Grphics to graphics2d
		
		Graphics2D g2d = (Graphics2D) g; 
		
	    for (int i = 0; i < HEIGHT; i++){
	      	g2d.drawLine(i*TILE, 0, i*TILE, TILE*HEIGHT);
	        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
	                i * 0.1f));
	    }
	    
	    // draw the columns
	    for (int i = 0; i < WIDTH; i++){
	        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
	                i * 0.1f));
	    	g2d.drawLine(0, i*TILE, TILE*WIDTH, i*TILE);	   
	    	
	    }
	    
//	    	g.setColor(Color.GRAY);
	    	
	}
	
}
