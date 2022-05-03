package de.buch.uebung08;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AlteZaehlweise extends JFrame {

    private JPanel contentPane;
    private JTextField textStueckzahl;
    private JLabel lblStueck;
    private JLabel lblDutzend;
    private JLabel lblSchock;
    private JLabel lblGros;
    private JButton btnEnde;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AlteZaehlweise frame = new AlteZaehlweise();
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
    public AlteZaehlweise() {
	setTitle("Alte Zählweise");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 253);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblStueckzahl = new JLabel("Geben Sie eine Stückzahl an:");
	lblStueckzahl.setBounds(23, 17, 189, 16);
	contentPane.add(lblStueckzahl);

	textStueckzahl = new JTextField();
	textStueckzahl.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    umrechnen();

	    }
	});
	textStueckzahl.setBounds(21, 36, 130, 26);
	contentPane.add(textStueckzahl);
	textStueckzahl.setColumns(10);

	
	JButton btnUmrechnen = new JButton("In alte Zählmaße umrechnen");
	btnUmrechnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		umrechnen();
	    }
	});
	btnUmrechnen.setBounds(204, 36, 229, 29);
	contentPane.add(btnUmrechnen);

	
	
	lblStueck = new JLabel("Stück");
	lblStueck.setBounds(23, 182, 128, 16);
	contentPane.add(lblStueck);

	lblDutzend = new JLabel("Dutzend");
	lblDutzend.setBounds(23, 154, 128, 16);
	contentPane.add(lblDutzend);

	lblSchock = new JLabel("Schock");
	lblSchock.setBounds(23, 126, 128, 16);
	contentPane.add(lblSchock);

	lblGros = new JLabel("Gros");
	lblGros.setBounds(23, 98, 128, 16);
	contentPane.add(lblGros);

	btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	btnEnde.setBounds(265, 141, 117, 29);
	contentPane.add(btnEnde);
    }

    private void umrechnen() {
	int stueck = Integer.parseInt(textStueckzahl.getText());
	int gros = stueck / 144;
	stueck = stueck % 144;
	int schock = stueck / 60;
	stueck = stueck % 60;
	int dutzend = stueck / 12;
	stueck = stueck % 12;
	lblGros.setText(gros + " Groß");
	lblSchock.setText(schock + " Schock");
	lblDutzend.setText(dutzend + " Dutzend");
	lblStueck.setText(stueck + " Stück");
	textStueckzahl.requestFocus();
	textStueckzahl.selectAll();

    }
}
