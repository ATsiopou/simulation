/*Authors : Iordanis Paschalidis 
 * 			Anthony Tsiopoulos 
 * 
 * Class  : Game
 * 			This is the entry point for the simulation. Within this class, the JFrame is created and
 * 			it's contenPane is set to hold a newly created GamePanel Object. 
 * 			
 * Moded  : 03/02/15
 * 
 */
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {

		JFrame window = new JFrame("SortaSim");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GamePanel());
		
		/*
		if(showGrid) {
			//check if this works and both are showing.
			//make sure that the background of this gridPanel is transparent
			window.setContentPane(new GridPane());
		}
		//Second Approach
		ContentPanel (JPanel) >> Add this to contentPane()
			- GamePanel
			- Conidtionally - GridPanel
			
			*/
		window.setResizable(true);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
