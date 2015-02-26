import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Main {

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("");
		SystemEngine game = new SystemEngine();
     	frame.add(game);
		frame.setSize(1200, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		
		int rea=0;
		
		while (true) {

			game.repaint();

			game.moveCar();

			Thread.sleep(25);
			
			if(rea%230==0){
				game.lightsEngine();
			}
			rea++;
		}
	}
	
	
}