package javaSwing2;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MicroOnde extends JFrame {

	public MicroOnde(String title) throws HeadlessException {
		super("micro onde");
		
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		// TODO Auto-generated constructor stub
	}

}
