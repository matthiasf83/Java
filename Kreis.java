package de.buch.uebung05;

public class Kreis { // Aufgabe 1
    double radius;

    Kreis() {
	radius = 0; // Konstruktor mit leerer Parameterliste initalisiert Wert 0
    }

    Kreis(double r) { // Konstruktor bekommt als Parameter eine Kommazahl zur initalisierung des Radius
	radius = r;
    }

    double getRadius() {
	return radius;
    }

    void setRadius(double r) { // Void keine Rückgabe
	radius = r;
    }

    double getUmfang() {
	return 2 * Math.PI * radius;
    }

    double getFlaeche() {
	return Math.PI * radius * radius; 
    }

    void setUmfang(double u) {	//Aufgabe 5
	radius = u / (2 * Math.PI);
    }

    void setFlaeche(double f) {
	radius = Math.sqrt(f / Math.PI);
    }
}


    
    

