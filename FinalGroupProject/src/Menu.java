import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	public Menu() {
		initMenu();
	}

	private void initMenu() {
		setTitle("Traffic Simulation");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createLayout() {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        
        //Create the labels here 
        JLabel label1 = new JLabel("Cars"); 
        JLabel label2 = new JLabel("Frequency");
        
        final JTextField carsTextField = new JTextField();
        final JTextField frequencyTextField = new JTextField();
        
        JButton startButton = new JButton("Start");
        JButton endButton = new JButton("End");

  
        //For now output the fields to the consol 
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
             System.out.println("Cars: " + carsTextField.getText());
             System.out.println("Frequency: " + frequencyTextField.getText());
             //start the game here
             //remove this panel
            }
        });
        endButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
          System.exit(0);
         }
        });
        
        // Create a sequential group for the horizontal axis.
        GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();

        hGroup.addGroup(gl.createParallelGroup().addComponent(label1).addComponent(label2));
        hGroup.addGroup(gl.createParallelGroup().addComponent(carsTextField).addComponent(frequencyTextField));
        hGroup.addGroup(gl.createSequentialGroup().addComponent(startButton).addComponent(endButton));
        
        gl.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

        vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label1).addComponent(carsTextField));
        vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(label2).addComponent(frequencyTextField));
        vGroup.addGroup(gl.createParallelGroup(Alignment.BASELINE).addComponent(startButton).addComponent(endButton));
        gl.setVerticalGroup(vGroup);
    }

}
