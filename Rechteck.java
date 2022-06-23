package de.buch.uebung05;

import javax.swing.JOptionPane;

public class Rechteck {		//Aufgabe 2
    private double laenge, breite;

    Rechteck() {	//Konstruktor Wert initalisieren
	laenge = 0;
	breite = 0;
    }

    Rechteck(double laenge, double breite) { //Zweiter Konstruktor übergibt initalisierte Werte vom ersten
	this.laenge = laenge;
	this.breite = breite;
    }

    void setLaenge(double laenge) {
	this.laenge = laenge;
    }

    void setBreite(double breite) {
	this.breite = breite;
    }

    void setSeiten(double laenge, double breite) {
	this.laenge = laenge;
	this.breite = breite;
    }

    double getLaenge() {
	return laenge;
    }

    double getBreite() {
	return breite;
    }

    double getLangeSeite() {
	if (laenge > breite)
	    return laenge;
	else
	    return breite;
    }

    double getKurzeSeite() {
	if (laenge > breite)
	    return breite;
	else
	    return laenge;
    }

    double getDiagonale() {
	return Math.sqrt(laenge * laenge + breite * breite);
    }

    double getFlaeche() {
	return laenge * breite;
    }

    double getUmfang() {
	return 2 * laenge + 2 * breite;
    }

    void laengeAusgeben() {	//Aufgabe 3
	double laenge = this.laenge;
	JOptionPane.showMessageDialog(null,"Bei Länge wurde eingegeben: " + laenge);
    }
    void breiteAusgeben() {
	double breite = this.breite;
	JOptionPane.showMessageDialog(null,"Bei Breite wurde eingegeben: " + breite);
    }

    void laengeVergroessern(double laenge) { //Aufgabe 4
	this.laenge += laenge;
	
    }

    void breiteVergroessern(double breite) {
	this.breite += breite;
    }

    void laengeVerkleinern(double laenge) {
	this.laenge -= laenge;
    }

    void breiteVerkleinern(double breite) {
	this.breite -= breite;
    }
}
