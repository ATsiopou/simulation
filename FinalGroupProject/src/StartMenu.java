import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.*;

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
	
	


	
	

}
