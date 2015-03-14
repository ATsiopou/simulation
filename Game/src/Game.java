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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class Game {

	public Game() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				JFrame window = new JFrame("Traffic Simulation");
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setLayout(new BorderLayout());
				window.add(new GamePanel());
				window.pack();
				window.setResizable(true);
				window.setLocationRelativeTo(null);
				window.setVisible(true);

			}
		});
	}

	public static void main(String[] args) {
		new Game();
	}

}
