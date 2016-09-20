package javaListeProduitMBE;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ListeProduit extends JFrame implements ActionListener, DocumentListener { 
	
	public final static String AJOUTER_PRODUIT = "nouveau produit";
	public final static String SAUVEGARDER = "sauvegarder la liste";
	public final static String RECHARGER = "recharger la liste depuis fichier";
	
	private JButton ajoutProduit;
	private JButton saveList;
	private JButton rechargeList;
	
	private JScrollPane paneauListe;	
	private JList<Produit> listeP;
	private DefaultListModel<Produit> data;
	
	ArrayList<Produit> LP = new ArrayList();
	PrintWriter pw;
	
	public ListeProduit() throws HeadlessException, FileNotFoundException {
		
		super("Liste des produits");

		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		ajoutProduit = new JButton("Ajouter un produit");
		ajoutProduit.setActionCommand(AJOUTER_PRODUIT);
		add(ajoutProduit, BorderLayout.NORTH);
		
		saveList = new JButton("Sauvegarder la liste des produits");
		saveList.setActionCommand(SAUVEGARDER);
		add(saveList, BorderLayout.WEST);
		
		rechargeList = new JButton("Rechager la liste des produits");
		rechargeList.setActionCommand(RECHARGER);
		add(rechargeList, BorderLayout.EAST);
		
		data = new DefaultListModel<>();
		
		listeP = new JList<>(data);
		paneauListe = new JScrollPane(listeP);
		
		add(paneauListe, BorderLayout.CENTER);
		
		
		data.addElement(new Produit("P1", 31, 1));
		data.addElement(new Produit("P2", 21, 5));
		data.addElement(new Produit("P3", 15, 56));
		data.addElement(new Produit("P4", 33, 2));
		data.addElement(new Produit("P5", 55, 6));
		data.addElement(new Produit("P6", 69, 12));
		data.addElement(new Produit("P7", 88, 6));
		
		
		LP.add(new Produit("P1", 31, 1));
		LP.add(new Produit("P2", 21, 5));
		LP.add(new Produit("P3", 15, 56));
		LP.add(new Produit("P4", 33, 2));
		LP.add(new Produit("P5", 55, 6));
		LP.add(new Produit("P6", 69, 12));
		LP.add(new Produit("P7", 88, 6));
		
		ajoutProduit.addActionListener(this);
		saveList.addActionListener(this);
		rechargeList.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case AJOUTER_PRODUIT:
				String nomP = JOptionPane.showInputDialog("Entrez le nom du produit");
				String prixP = JOptionPane.showInputDialog("Entrez le prix du produit");
				String poidsP = JOptionPane.showInputDialog("Entrez le poids du produit");
				
				data.addElement(new Produit(nomP,Double.parseDouble(prixP), Double.parseDouble(poidsP)));
				LP.add(new Produit(nomP,Double.parseDouble(prixP), Double.parseDouble(poidsP)));
				
				Collections.sort(LP);
				data.clear();
				for (Produit p : LP)
					data.addElement(p);
								
				break;
			case SAUVEGARDER:
				try {
					pw = new PrintWriter("produits.csv");
					for (Produit p : LP) {
						pw.println(p.saveToCsv());
					}
					pw.close();
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				data.clear();
				break;
		}

	}
	
	private void validateField(){
		System.out.println("validation");
		
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		validateField();
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		validateField();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		validateField();
		
	}

}
