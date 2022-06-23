package de.buch.uebung05;

import javax.swing.JOptionPane;

//Aufgabe 1
public class Kreistest {
    public static void main(String[] args) {
	double kreisradius = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie einen Kreisradius ein:"));
	String einheit = JOptionPane.showInputDialog("Geben Sie die Maßeinheit ein:");
	double r = (kreisradius); //übergibt Kommazahl an Konstruktor Kreis (double r)
	Kreis k = new Kreis(r); // Neues Objekt von Typ Kreis mit Referenz k
	System.out.println("Radius: " + k.getRadius() + " " + einheit);
	System.out.println("Umfang: " + k.getUmfang() + " " + einheit);
	System.out.println("Fl�che: " + k.getFlaeche() + " " + einheit + '\u00b2');
    }

}

