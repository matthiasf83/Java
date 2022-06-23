package de.buch.uebung09;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FahrenheitCelsius extends JFrame {

    private JPanel contentPane;
    private JTextField textFahrenheit;
    private JTextField textCelsius;
    private JButton btnUmrechnen;
    private JButton btnEnde;
    private JLabel textFehler;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    FahrenheitCelsius frame = new FahrenheitCelsius();
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
    public FahrenheitCelsius() {
	setTitle("Umrechnung Fahrenheit in Celsius");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	
	JLabel labelFahrenheit = new JLabel("Grad Fahrenheit");
	labelFahrenheit.setBounds(25, 22, 106, 16);
	contentPane.add(labelFahrenheit);
	
	textFahrenheit = new JTextField();
	textFahrenheit.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode()== KeyEvent.VK_ENTER) {
			umrechnen();
		    }
		}
	});
	textFahrenheit.setBounds(22, 38, 130, 26);
	contentPane.add(textFahrenheit);
	textFahrenheit.setColumns(10);
	
	
	JLabel labelCelsius = new JLabel("Grad Celsius");
	labelCelsius.setBounds(25, 84, 85, 16);
	contentPane.add(labelCelsius);

	textCelsius = new JTextField();
	textCelsius.setEditable(false);
	textCelsius.setBounds(22, 100, 130, 26);
	contentPane.add(textCelsius);
	textCelsius.setColumns(10);

	
	btnUmrechnen = new JButton("Umrechnen");
	btnUmrechnen.addActionListener(e -> umrechnen());
	btnUmrechnen.setBounds(215, 35, 117, 29);
	contentPane.add(btnUmrechnen);

	btnEnde = new JButton("Ende");
	btnEnde.addActionListener(e -> System.exit(0));
	btnEnde.setBounds(215, 98, 117, 29);
	contentPane.add(btnEnde);
	
	textFehler = new JLabel("");
	textFehler.setBounds(25, 149, 307, 16);
	contentPane.add(textFehler);
    }

    	private void umrechnen() {
    	try {
	double fahrenheit = Double.parseDouble(textFahrenheit.getText());
	double celsius = (fahrenheit - 32) * 5 / 9;
	DecimalFormat df = new DecimalFormat("#0.00");
	textCelsius.setText(df.format(celsius));
	textFahrenheit.requestFocus();
	textFahrenheit.selectAll();
    	}
	catch (NumberFormatException e) {
	    textFehler.setText("Keine korrekte Fahrenheit-Temperatur");
	}
    }
}
