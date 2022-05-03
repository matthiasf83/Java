package de.buch.uebung08;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ZollZentimeter extends JFrame {

    private JPanel contentPane;
    private JTextField textZoll;
    private JLabel lblAusgabe; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ZollZentimeter frame = new ZollZentimeter();
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
    public ZollZentimeter() {
    	setTitle("Umrechnung von Zoll in Zentimeter");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblZoll = new JLabel("Zoll");
	lblZoll.setBounds(32, 26, 61, 16);
	contentPane.add(lblZoll);
	
	textZoll = new JTextField();
	textZoll.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			umrechnen();
		    }
		}
	});
	textZoll.setBounds(29, 43, 130, 26);
	contentPane.add(textZoll);
	textZoll.setColumns(10);
	
	JButton btnUmrechnen = new JButton("Umrechnen");
	btnUmrechnen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    umrechnen();
		} 
	});
	btnUmrechnen.setBounds(25, 81, 130, 29);
	contentPane.add(btnUmrechnen);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(230, 81, 130, 29);
	contentPane.add(btnEnde);
	
	lblAusgabe = new JLabel();
	lblAusgabe.setBounds(240, 48, 112, 16);
	contentPane.add(lblAusgabe);
    }
	
	private void umrechnen() {
	  double zoll = Double.parseDouble(textZoll.getText());
	   double cm = zoll * 2.54;
	   DecimalFormat df = new DecimalFormat("#0.00");
	    lblAusgabe.setText(df.format(cm) + " cm");
	    textZoll.requestFocus();
	    textZoll.selectAll();
    }
}
