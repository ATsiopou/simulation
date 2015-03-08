import java.awt.*;

import javax.swing.JFrame;

class Main {

	
	//create the frame and make the illusion of cars mobing
	public static void main(String[] args) throws InterruptedException {
		
		//this 6 lines just create a jframe and a systemengine object
		JFrame frame = new JFrame("");
		SystemEngine game = new SystemEngine();
     	frame.add(game);
		frame.setSize(1200, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		// this for loop moves every car by calling the car method and the repaint the frame
		//every 25 miliseconds
		int rea=0;
		
		while (true) {

			game.repaint();

			game.moveCar();

			Thread.sleep(25);
			
			if(rea%230==0){
				game.lightsEngine();//every 230 interaction  2-3 seconds chnage the lights color (red- color)
			}
			rea++;
		}
	}
	
	
}