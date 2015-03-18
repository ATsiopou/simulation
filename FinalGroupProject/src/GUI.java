import java.awt.BorderLayout;

import javax.swing.*;


public class GUI extends JFrame{

	private StartMenu startMenu=new StartMenu();
	
	public GUI(){
		super();
		this.setLayout(new BorderLayout());
		this.add(startMenu, BorderLayout.CENTER);
	}
}
