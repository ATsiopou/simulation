import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.GroupLayout.*;

public class StartMenu extends JFrame {

	private GamePanel defaultGame; // simulation with default parameters  
	private GamePanel userGame;    // simulation with user specified values
	
	

	private JPanel fLayout=new JPanel();
	private JPanel sLayout=new JPanel();
	private JPanel northPanel=new JPanel();
	private JButton startButton = new JButton("Start");
	private JButton endButton = new JButton("End");
	private JComboBox mapBox=new JComboBox();
	private JSlider speedSlider=new JSlider(1,40);
	private String maps[];
	
	public StartMenu() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createLayout();	
	}

	private void createLayout() {
		this.setLayout(new BorderLayout());
	
		// Create Labels
		ImageIcon img = new ImageIcon("res/LOGO.PNG");
	    final JLabel image = new JLabel(img);
		

		// Create Spinner Models with default/min/max/step values
		SpinnerModel carSpinnerModel = new SpinnerNumberModel(10,10, 300, 1);
		SpinnerModel carFrequencySpinnerModel = new SpinnerNumberModel(1, 1, 5,1);
		SpinnerModel lightFrequencySpinnerModel = new SpinnerNumberModel(2, 2,6, 1);
		// SpinnerModel averageCarSpeedSpinnerModel = new SpinnerNumberModel();

		// Add the set values for each SpinnerModel
		final JSpinner carSpinner = new JSpinner(carSpinnerModel);
		final JSpinner carFrequencySpinner = new JSpinner(carFrequencySpinnerModel);
		final JSpinner lightFrequencySpinner = new JSpinner(lightFrequencySpinnerModel);
//			carSpinner.setBounds(x, y, width, height);



		/**
		 * carFrequencyinMilli = the rate the cars enter into the map 
		 * totalNumberOfCars   = the total number of cars in the map 
		 * lightFrequnecy      = the rate at which the lights change
		 * 
		 * 
		 */
		// For now output the fields to the console, but this should initiate the game with the field values 
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				Integer carEntryFrequency = (Integer) carFrequencySpinner.getValue() * 10;
				Integer lightFrequency = (Integer) lightFrequencySpinner.getValue() * 50; 
				Integer totalNumberOfCars = (Integer) carSpinner.getValue(); 
				double speed=(double)speedSlider.getValue()/1000;
				
				/*
				System.out.println("totalNumberOfCars: " + totalNumberOfCars);
				System.out.println("carEntryFrequency: " + carEntryFrequency);
				System.out.println("lightFrequency: " + lightFrequency );
				*/

				//Set the start screen image as false and begin the simulation 
				// remove this panel
				image.setVisible(false);
				// start the game here
				if(userGame!=null){
				    remove(userGame);
				 }
				
				userGame = new GamePanel(totalNumberOfCars, carEntryFrequency, lightFrequency,maps,mapBox.getSelectedIndex(),speed);
				add(userGame);
				invalidate();
			    validate();
					
			}
		});
		
		// Action for End button 
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		
		fLayout.add(new JLabel("Total Cars"));
		fLayout.add(carSpinner);
		fLayout.add(new JLabel("Avarage Speed"));
		fLayout.add(speedSlider);
		fLayout.add(startButton);

		sLayout.add(new JLabel("Car Frequency"));
		sLayout.add(carFrequencySpinner);
		
		sLayout.add(new JLabel("Light Frequency"));
		sLayout.add(lightFrequencySpinner);
		sLayout.add(mapBox);
		sLayout.add(endButton);

		northPanel.setLayout(new BorderLayout());
		northPanel.add(fLayout,BorderLayout.NORTH);
		northPanel.add(sLayout,BorderLayout.CENTER);
		
		this.add(northPanel,BorderLayout.NORTH);
		add(image,BorderLayout.CENTER);
		try {
				this.readFiles();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void readFiles() throws IOException{
			Scanner scanner=new Scanner(new FileReader("res/maps.txt"));
			    try {
			         maps=scanner.nextLine().split(",");
			        for(int i=0;i<maps.length;i++){
			    		mapBox.addItem(maps[i]);
			        }
			    } finally {
			    	scanner.close();
			    }
		}

}