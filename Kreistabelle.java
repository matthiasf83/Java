package de.buch.uebung05;

import javax.swing.JOptionPane;

public class Kreistabelle {

    public static void main(String[] args) {
	double kreisradius = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie den Radius ein:"));
	double r = kreisradius;
	Kreis k = new Kreis(r);
	double erhoehung = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie die Erhöhung an"));
	double e = erhoehung; 
	String ausgabe = "";
	ausgabe +=("Radius\t\tUmfang\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFläche" + "\n");
	for (int i = 0; i < 30; i++) {
	k.setRadius(r+i*e);
	ausgabe +=(k.getRadius()+"\t\t\t\t\t"+k.getUmfang()+"\t\t\t"+k.getFlaeche() + "\n");
	}
	JOptionPane.showMessageDialog(null, ausgabe);
    }

}
