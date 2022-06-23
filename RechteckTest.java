package de.buch.uebung05;

import javax.swing.JOptionPane;


public class RechteckTest {
    public static void main(String[] args) {
	try {
	String eingabe = JOptionPane.showInputDialog("Geben Sie die Rechtecklänge ein:");
	double laenge = Double.parseDouble(eingabe);
	eingabe = JOptionPane.showInputDialog("Geben Sie die Rechteckbreite ein:");
	double breite = Double.parseDouble(eingabe);
	String einheit = JOptionPane.showInputDialog("Geben Sie die Maßeinheit ein:");
	Rechteck r = new Rechteck(laenge,breite);
	System.out.println("Lange Seite: " + r.getLangeSeite() + " " + einheit);
	//r.laengeVergroessern(laenge);
	//r.breiteVergroessern(breite);
	JOptionPane.showMessageDialog(null,"Kurze Seite: " + r.getKurzeSeite() + " " + einheit + 
	"\n" + "Diagonale: " + r.getDiagonale() + " " + einheit +
	"\n" + "Fläche: " + r.getFlaeche() + " " + einheit + '\u00b2' +
	"\n" + "Umfang: " + r.getUmfang() + " " + einheit);
	r.laengeAusgeben(); 
	r.breiteAusgeben();
	
	
	}
	catch (Exception e) {
	    JOptionPane.showMessageDialog(null,"Falsche Eingabe");
	}
    }

}
