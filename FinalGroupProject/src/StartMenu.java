import java.awt.*;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f

import javax.swing.*;
import javax.swing.GroupLayout.*;

<<<<<<< HEAD
public class StartMenu extends JPanel {

	public StartMenu() {
		super();
		createLayout();
	}

	private void createLayout() {

		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);

		// Create Labels
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
		

		// Add two more labels, light frequency and average car speed
		GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);
		hGroup.addGroup(gl.createParallelGroup().addComponent(label1).addComponent(label2).addComponent(label3));
		hGroup.addGroup(gl.createParallelGroup().addComponent(carSpinner).addComponent(carFrequencySpinner).addComponent(lightFrequencySpinner));
		hGroup.addGroup(gl.createSequentialGroup().addComponent(startButton).addComponent(endButton));
		gl.setHorizontalGroup(hGroup);

		// For now output the fields to the console, but this should initiate the game with the field values 
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				Integer freq = Integer.getInteger((String)carFrequencySpinner.getValue()); 
				Integer carFrequencyInMilli = freq * 1000;
				System.out.println("Cars: " + carSpinner.getValue());
				System.out.println("Frequency: " + carFrequencyInMilli);
				// start the game here
				// remove this panel
			}
		});
		
		// Action for End button 
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		
		// Create a sequential group for the vertical axis.
		GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label1).addComponent(carSpinner));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label2).addComponent(carFrequencySpinner));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label3).addComponent(lightFrequencySpinner));
		vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(startButton).addComponent(endButton));
		gl.setVerticalGroup(vGroup);
	}
=======
public class StartMenu extends JPanel{
	
	private JSpinner carSpinner= new JSpinner();
	private JSpinner frequencySpinner= new JSpinner();
	private GroupLayout gl = new GroupLayout(this);
    private  JButton startButton = new JButton("Start");
    private JButton endButton = new JButton("End");

	public StartMenu(){
		super();
        this.setLayout(gl);
        JLabel label1 = new JLabel("Cars"); 
        JLabel label2 = new JLabel("Frequency");
        
        GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        hGroup.addGroup(gl.createParallelGroup().addComponent(label1).addComponent(label2));
        hGroup.addGroup(gl.createParallelGroup().addComponent(carSpinner).addComponent(frequencySpinner));
        hGroup.addGroup(gl.createSequentialGroup().addComponent(startButton).addComponent(endButton));
        
        gl.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

        vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label1).addComponent(carSpinner));
        vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label2).addComponent(frequencySpinner));
        vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(startButton).addComponent(endButton));
        gl.setVerticalGroup(vGroup);

	
	}
	
	


	
	
>>>>>>> f1ae67cfb1f2d40327fdcc4d3d73cb16cb25109f

}
