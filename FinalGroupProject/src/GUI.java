import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f

import javax.swing.*;


public class GUI extends JFrame{

	private StartMenu startMenu=new StartMenu();
	private GamePanel gamePanel = new GamePanel();

	public GUI(){
		super();
		this.setLayout(new BorderLayout());
		this.add(startMenu, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
}
