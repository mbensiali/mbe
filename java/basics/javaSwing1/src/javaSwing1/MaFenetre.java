package javaSwing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MaFenetre extends JFrame implements ActionListener {
	
	private JButton bouton1;
	JTextField saisie1;
	
	public MaFenetre(){
		super ("ma super fenetre");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout (new FlowLayout());
		
		bouton1 = new JButton("cliquez moi!");
		add(bouton1);
		
		
		
		bouton1.addActionListener(this);
		
		for(int i = 1; i<=15;i++)
			add(new JButton ("bouton test" + i));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action déclenchée");
		
	}
}
