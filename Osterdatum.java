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

public class Osterdatum extends JFrame {

    private JPanel contentPane;
    private JTextField tfJahr;
    private JLabel lblAusgabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Osterdatum frame = new Osterdatum();
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
    public Osterdatum() {
	setTitle("Osterdatum");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 574, 236);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblJahr = new JLabel("Jahr");
	lblJahr.setBounds(25, 18, 61, 16);
	contentPane.add(lblJahr);

	tfJahr = new JTextField();
	tfJahr.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		    berechnen();
	    }
	});
	tfJahr.setBounds(21, 35, 130, 26);
	contentPane.add(tfJahr);
	tfJahr.setColumns(10);

	JButton btnBerechnen = new JButton("Datum für Ostersonntag berechnen");
	btnBerechnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		berechnen();
	    }
	});
	btnBerechnen.setBounds(181, 35, 347, 29);
	contentPane.add(btnBerechnen);

	lblAusgabe = new JLabel("Datum für Ostersonntag:    Berechnung nur für Jahreszahl > 1583");
	lblAusgabe.setBounds(25, 111, 503, 16);
	contentPane.add(lblAusgabe);

	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	btnEnde.setBounds(297, 150, 117, 29);
	contentPane.add(btnEnde);
    }

    private void berechnen() {
	int y = Integer.parseInt(tfJahr.getText());
	if (y > 1583) {
	    int g = y % 19;
	    int c = y / 100;
	    int h = (c - c / 4 - (8 * c + 13) / 25 + 19 * g + 15) % 30;
	    int i = h - (h / 28) * (1 - (29 / (h + 1)) * ((21 - g) / 11));
	    int j = (y + y / 4 + i + 2 - c + c / 4) % 7;
	    int l = i - j;
	    int m = 3 + (l + 40) / 44;
	    int d = l + 28 - 31 * (m / 4);
	    lblAusgabe.setText(d + "." + m + ".");
	} else {
	    lblAusgabe.setText("Datum Falsch!! Bitte geben sie > 1583 ein");
	}

	tfJahr.requestFocus();
	tfJahr.selectAll();
    }
}
