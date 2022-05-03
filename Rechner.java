package de.buch.uebung08;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rechner extends JFrame {

    private JPanel contentPane;
    private JTextField tfOperand1;
    private JTextField tfOperand2;
    private JTextField tfErgebnis;
    private double op1, op2, ergebnis;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Rechner frame = new Rechner();
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
    public Rechner() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 443, 206);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblOperand1 = new JLabel("Operand 1");
	lblOperand1.setBounds(18, 10, 104, 16);
	contentPane.add(lblOperand1);
	
	tfOperand1 = new JTextField();
	tfOperand1.setBounds(14, 26, 120, 26);
	contentPane.add(tfOperand1);
	tfOperand1.setColumns(10);
	
	JLabel lblOperand2 = new JLabel("Operand2");
	lblOperand2.setBounds(308, 10, 61, 16);
	contentPane.add(lblOperand2);
	
	tfOperand2 = new JTextField();
	tfOperand2.setColumns(10);
	tfOperand2.setBounds(303, 26, 120, 26);
	contentPane.add(tfOperand2);
	
	
	
	JButton btnPlus = new JButton("+");
	btnPlus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    op1 = Double.parseDouble(tfOperand1.getText());
		    op2 = Double.parseDouble(tfOperand2.getText());
		    ergebnis = op1 + op2;
		    tfErgebnis.setText(op1 + " + " + op2 + " = " + ergebnis);
		}
	});
	btnPlus.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	btnPlus.setBounds(142, 27, 76, 49);
	contentPane.add(btnPlus);
	
	JButton btnMinus = new JButton("-");
	btnMinus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    op1 = Double.parseDouble(tfOperand1.getText());
		    op2 = Double.parseDouble(tfOperand2.getText());
		    ergebnis = op1 - op2;
		    tfErgebnis.setText(op1 + " - " + op2 + " = " + ergebnis);
		}
	});
	btnMinus.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	btnMinus.setBounds(219, 27, 76, 49);
	contentPane.add(btnMinus);
	
	JButton btnDevide = new JButton("/");
	btnDevide.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    op1 = Double.parseDouble(tfOperand1.getText());
		    op2 = Double.parseDouble(tfOperand2.getText());
		    ergebnis = op1 / op2;
		    tfErgebnis.setText(op1 + " / " + op2 + " = " + ergebnis);
		}
	});
	btnDevide.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	btnDevide.setBounds(219, 79, 76, 49);
	contentPane.add(btnDevide);
	
	JButton btnMultiply = new JButton("*");
	btnMultiply.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    op1 = Double.parseDouble(tfOperand1.getText());
		    op2 = Double.parseDouble(tfOperand2.getText());
		    ergebnis = op1 * op2;
		    tfErgebnis.setText(op1 + " * " + op2 + " = " + ergebnis);
		}
	});
	btnMultiply.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	btnMultiply.setBounds(142, 79, 76, 49);
	contentPane.add(btnMultiply);
	
	JLabel lblErgebnis = new JLabel("Ergebnis");
	lblErgebnis.setBounds(22, 118, 104, 16);
	contentPane.add(lblErgebnis);
	
	tfErgebnis = new JTextField();
	tfErgebnis.setEditable(false);
	tfErgebnis.setBounds(18, 134, 409, 26);
	contentPane.add(tfErgebnis);
	tfErgebnis.setColumns(10);
    }
   
}
