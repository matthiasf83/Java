package de.buch.uebung10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class Notenbilanz2 extends JFrame {

    private JPanel contentPane;
    private JTextField tfAnzahlNoten;
    private int notenzahl, i;
    private double summe, besteNote, schlechtesteNote, notenschnitt;
    double [] noten;
    private JButton btnAnzahlUebernehmen;
    private JLabel lblNote;
    private JTextField tfNote;
    private JButton btnNoteUebernehmen;
    private JLabel lblNotenzahl;
    private JLabel lblNotenschnitt;
    private JLabel lblBesteNote;
    private JLabel lblSchlechtesteNote;
    private JButton btnNeu;
    private DecimalFormat fzahl;
    private JLabel lblNoten;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Notenbilanz2 frame = new Notenbilanz2();
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
    public Notenbilanz2() {
	setTitle("Notenbilanz");
	fzahl = new DecimalFormat("###,##0.00");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 293);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblAnzahlNoten = new JLabel("Anzahl Noten");
	lblAnzahlNoten.setBounds(10, 11, 112, 14);
	contentPane.add(lblAnzahlNoten);

	tfAnzahlNoten = new JTextField();
	tfAnzahlNoten.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    anzahluebernehmen();
	    }
	});
	tfAnzahlNoten.setBounds(5, 26, 95, 20);
	contentPane.add(tfAnzahlNoten);
	tfAnzahlNoten.setColumns(10);

	btnAnzahlUebernehmen = new JButton("Übernehmen");
	btnAnzahlUebernehmen.addActionListener(e -> anzahluebernehmen());
	btnAnzahlUebernehmen.setBounds(112, 25, 134, 23);
	contentPane.add(btnAnzahlUebernehmen);

	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(e -> System.exit(0));
	btnEnde.setBounds(335, 195, 89, 23);
	contentPane.add(btnEnde);

	lblNote = new JLabel("1.Note");
	lblNote.setVisible(false);
	lblNote.setBounds(10, 69, 81, 14);
	contentPane.add(lblNote);

	tfNote = new JTextField();
	tfNote.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    noteuebernehmen();
		btnNeu.requestFocus();
	    }
	});
	tfNote.setVisible(false);
	tfNote.setBounds(5, 84, 86, 20);
	contentPane.add(tfNote);
	tfNote.setColumns(10);

	btnNoteUebernehmen = new JButton("Übernehmen");
	btnNoteUebernehmen.addActionListener(e -> noteuebernehmen());
	btnNoteUebernehmen.setVisible(false);
	btnNoteUebernehmen.setBounds(112, 84, 134, 23);
	contentPane.add(btnNoteUebernehmen);

	lblNotenzahl = new JLabel("");
	lblNotenzahl.setBounds(10, 120, 236, 20);
	contentPane.add(lblNotenzahl);

	lblNotenschnitt = new JLabel("");
	lblNotenschnitt.setBounds(10, 145, 236, 20);
	contentPane.add(lblNotenschnitt);

	lblBesteNote = new JLabel("");
	lblBesteNote.setBounds(10, 170, 236, 20);
	contentPane.add(lblBesteNote);

	lblSchlechtesteNote = new JLabel("");
	lblSchlechtesteNote.setBounds(10, 198, 236, 20);
	contentPane.add(lblSchlechtesteNote);

	btnNeu = new JButton("Neue Berechnung");
	btnNeu.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    neueBerechnung();

	    }
	});
	btnNeu.setVisible(false);
	btnNeu.setBounds(256, 25, 168, 23);
	contentPane.add(btnNeu);
	
	lblNoten = new JLabel("");
	lblNoten.setBounds(10, 231, 414, 14);
	contentPane.add(lblNoten);
	
    }

    private void anzahluebernehmen() {
	try {
	    if (!tfAnzahlNoten.getText().equals("") && Integer.parseInt(tfAnzahlNoten.getText()) > 0) {
		notenzahl = Integer.parseInt(tfAnzahlNoten.getText());
		noten = new double [notenzahl];
		i = 1;
		summe = 0;
		besteNote = 6;
		schlechtesteNote = 0;
		btnAnzahlUebernehmen.setVisible(false);
		tfAnzahlNoten.setEditable(false);
		lblNote.setVisible(true);
		tfNote.setVisible(true);
		btnNoteUebernehmen.setVisible(true);
		tfNote.requestFocus();
	    } else {
		JOptionPane.showMessageDialog(null, "Anzahl der Noten eingeben!");
		tfAnzahlNoten.requestFocus();
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
	}
    }
    private void noteuebernehmen() {
	try {
	    if (Double.parseDouble(tfNote.getText()) < 1 || Double.parseDouble(tfNote.getText()) > 6) {
		JOptionPane.showMessageDialog(null, "Bitte Note 1-6 eingeben");

	    } else {
		Double.parseDouble(tfNote.getText());
		summe = summe + Double.parseDouble(tfNote.getText());
		noten[i-1] = Double.parseDouble(tfNote.getText());
		notenschnitt = summe / i;
		lblNotenschnitt.setText("Notenschnitt: " + fzahl.format(notenschnitt));
		lblNotenzahl.setText("Anzahl eingegebene Noten: " + Integer.toString(i));

		if (Double.parseDouble(tfNote.getText()) > schlechtesteNote) {
		    schlechtesteNote = Double.parseDouble(tfNote.getText());
		    lblSchlechtesteNote.setText("schlechteste Note: " + Double.toString(schlechtesteNote));
		}
		if (Double.parseDouble(tfNote.getText()) < besteNote) {
		    besteNote = Double.parseDouble(tfNote.getText());
		    lblBesteNote.setText("beste Note: " + Double.toString(besteNote));
		}
		if (i == notenzahl) {
		    notenschnitt = summe / notenzahl;
		    btnNoteUebernehmen.setVisible(false);
		    btnNeu.setVisible(true);
		    lblNoten.setVisible(true);
		    lblNoten.setText("Noten: ");
		    for (double n: noten) { 
			lblNoten.setText(lblNoten.getText() + " " + "["+ n +"]");
		    }
		} else {
		    i++;
		    lblNote.setText(Integer.toString(i) + ".Note");
		    tfNote.setText("");
		    tfNote.requestFocus();
		}
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Bitte Note eingeben!");
	    tfNote.requestFocus();
	}
    }
    private void neueBerechnung() {
	i = 1;
	lblNote.setText(Integer.toString(i) + ".Note");
	summe = 0;
	besteNote = 6;
	schlechtesteNote = 0;
	btnAnzahlUebernehmen.setVisible(true);
	tfAnzahlNoten.setEditable(true);
	lblNote.setVisible(false);
	tfNote.setVisible(false);
	tfNote.setText("");
	btnNoteUebernehmen.setVisible(false);
	tfAnzahlNoten.setText("");
	tfAnzahlNoten.requestFocus();
	lblNotenschnitt.setText("");
	lblBesteNote.setText("");
	lblSchlechtesteNote.setText("");
	lblNotenzahl.setText("");
	btnNeu.setVisible(false);
	lblNoten.setVisible(false);
    }
}