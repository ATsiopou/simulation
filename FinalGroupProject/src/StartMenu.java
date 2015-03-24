import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.*;

public class StartMenu extends JFrame {

	private GamePanel game;
	public StartMenu() {
		super();

		
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createLayout();	
		
	}

	private void createLayout() {
		
		//this.setLayout(new BorderLayout());
		Container container = getContentPane();

		GroupLayout gl = new GroupLayout(container);
		container.setLayout(gl);

		// Create Labels
		 ImageIcon img = new ImageIcon("/tmp/image.jpg");
	     JLabel image = new JLabel(img);
		JLabel label1 = new JLabel("Total Cars");
		JLabel label2 = new JLabel("Car Frequency");
		JLabel label3 = new JLabel("Light Frequency");
		//JLabel label4 = new JLabel("Average Car Speed");

		// Create Buttons
		JButton startButton = new JButton("Start");
		JButton endButton = new JButton("End");

		// Create Spinner Models with default/max/min/step values
		SpinnerModel carSpinnerModel = new SpinnerNumberModel(10, 1, 50, 1);
		SpinnerModel carFrequencySpinnerModel = new SpinnerNumberModel(2, 1, 5,1);
		SpinnerModel lightFrequencySpinnerModel = new SpinnerNumberModel(5, 5,30, 1);
		// SpinnerModel averageCarSpeedSpinnerModel = new SpinnerNumberModel();

		// Add the set values for each SpinnerModel
		JSpinner carSpinner = new JSpinner(carSpinnerModel);
		JSpinner carFrequencySpinner = new JSpinner(carFrequencySpinnerModel);
		JSpinner lightFrequencySpinner = new JSpinner(lightFrequencySpinnerModel);
		

		JPanel gameContainer = new JPanel();


		// For now output the fields to the console, but this should initiate the game with the field values 
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				Integer freq = (Integer) carFrequencySpinner.getValue(); 
				Integer carFrequencyInMilli = freq * 1000;
				System.out.println("Cars: " + carSpinner.getValue());
				System.out.println("Frequency: " + carFrequencyInMilli);
				image.setVisible(false);
				// start the game here
				// remove this panel
				game  = new GamePanel();
				gameContainer.add(game);
				
			}
		});
		
		// Action for End button 
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		// Add two more labels, light frequency and average car speed
		GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		hGroup.addGroup(gl.createParallelGroup().addComponent(image).addComponent(label1).addComponent(label2).addComponent(label3).addComponent(gameContainer));
		hGroup.addGroup(gl.createParallelGroup().addComponent(carSpinner).addComponent(carFrequencySpinner).addComponent(lightFrequencySpinner));
		hGroup.addGroup(gl.createSequentialGroup().addComponent(startButton).addComponent(endButton));
		gl.setHorizontalGroup(hGroup);
		
		// Create a sequential group for the vertical axis.
		GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();
		 vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(image));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label1).addComponent(carSpinner));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label2).addComponent(carFrequencySpinner));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label3).addComponent(lightFrequencySpinner));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(startButton).addComponent(endButton));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(gameContainer));
		gl.setVerticalGroup(vGroup);
	}

}
