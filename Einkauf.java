package de.buch.uebung08;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class Einkauf extends JFrame {

    private JPanel contentPane;
    private JTextField textStueckzahl;
    private JTextField textStueckpreis;
    private JTextField textRabatt;
    private JButton btnBerechnen;
    private JButton btnEnde;
    private JLabel lblEingabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Einkauf frame = new Einkauf();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Einkauf() {
	setTitle("Einkaufspreis");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 659, 185);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblStueckzahl = new JLabel("Stückzahl");
	lblStueckzahl.setBounds(21, 16, 61, 16);
	contentPane.add(lblStueckzahl);

	textStueckzahl = new JTextField();
	textStueckzahl.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    textStueckpreis.requestFocus();
	    }
	});
	textStueckzahl.setBounds(17, 34, 130, 26);
	contentPane.add(textStueckzahl);
	textStueckzahl.setColumns(10);

	textStueckpreis = new JTextField();
	textStueckpreis.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    textRabatt.requestFocus();
	    }
	});
	textStueckpreis.setColumns(10);
	textStueckpreis.setBounds(159, 34, 130, 26);
	contentPane.add(textStueckpreis);

	JLabel lblStueckpreis = new JLabel("Stückpreis");
	lblStueckpreis.setBounds(163, 16, 91, 16);
	contentPane.add(lblStueckpreis);

	textRabatt = new JTextField();
	textRabatt.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    berechnen();
	    }
	});
	textRabatt.setColumns(10);
	textRabatt.setBounds(301, 34, 130, 26);
	contentPane.add(textRabatt);

	JLabel lblRabatt = new JLabel("Rabatt (%)");
	lblRabatt.setBounds(305, 16, 61, 16);
	contentPane.add(lblRabatt);

	btnBerechnen = new JButton("Berechnen");
	btnBerechnen.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		berechnen();
	    }
	});
	btnBerechnen.setBounds(476, 34, 158, 29);
	contentPane.add(btnBerechnen);

	btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	btnEnde.setBounds(476, 91, 158, 29);
	contentPane.add(btnEnde);

	lblEingabe = new JLabel("");
	lblEingabe.setBounds(21, 96, 271, 16);
	contentPane.add(lblEingabe);
    }

    private void berechnen() {
	if (textStueckzahl.getText().equals("") || textStueckpreis.getText().equals("")
		|| textRabatt.getText().equals("")) {
	    lblEingabe.setText("Die Eingaben sind unvollständig!!");
	} else {
	    int stueckzahl = Integer.parseInt(textStueckzahl.getText());
	    double stueckpreis = Double.parseDouble(textStueckpreis.getText());
	    double rabattwert = Double.parseDouble(textRabatt.getText());
	    double brutto = stueckzahl * stueckpreis;
	    double rabatt = brutto * rabattwert / 100;
	    double einkaufspreis = brutto - rabatt;
	    DecimalFormat df = new DecimalFormat("#0.00");
	    lblEingabe.setText("Der Einkaufspreis beträgt: " + df.format(einkaufspreis) + " €");
	    textStueckzahl.requestFocus();
	    textStueckzahl.selectAll();

	}

    }
}
