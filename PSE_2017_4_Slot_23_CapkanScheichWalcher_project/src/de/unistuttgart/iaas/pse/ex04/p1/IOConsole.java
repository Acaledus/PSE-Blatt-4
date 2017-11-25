package de.unistuttgart.iaas.pse.ex04.p1;

/**
 * Klasse zur Berechnung von Flächen.
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class IOConsole {
	
	/**
	 * Berechnet den Flächeninhalt eines Kreises mit gegebenem Radius.
	 * @param radius der Radius des Kreises.
	 * @return - den Flächeninhalt.
	 * @throws IllegalArgumentException
	 */
	public static double computeCircleArea(double radius) throws IllegalArgumentException {
		if (radius < 0) {
			throw new IllegalArgumentException("Kein Kreis hat einen negativen Radius.");
		}
		return Math.pow(radius, 2) * Math.PI;
	}

	/**
	 * Berechnet den Umfang eines Kreises mit gegebenem Radius.
	 * @param radius - der Radius des Kreises.
	 * @return - den Umfang.
	 * @throws IllegalArgumentException
	 */
	public static double computeCircleCircumference(double radius) throws IllegalArgumentException {
		if (radius < 0) {
			throw new IllegalArgumentException("Kein Kreis hat einen negativen Radius.");
		}
		return 2 * radius * Math.PI;
	}

	/**
	 * Berechnet den Flächeninhalt eines Rechtecks mit gegebenen Seitenlängen.
	 * @param a - erste Seite.
	 * @param b - zweite Seite.
	 * @return - den Flächeninhalt des Rechtecks.
	 * @throws IllegalArgumentException
	 */
	public static double computeRectangleArea(double a, double b) throws IllegalArgumentException {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Kein Rechteck hat eine negative Seitenlänge.");
		}
		return a * b;
	}
	
	/**
	 * Berechnet den Umfang eines Rechtecks mit gegebenen Seitenlängen.
	 * @param a - erste Seite.
	 * @param b - zweite Seite.
	 * @return - den Umfang des Rechtecks.
	 * @throws IllegalArgumentException
	 */
	public static double computeRectangleCircumference(double a, double b) throws IllegalArgumentException {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Kein Rechteck hat eine negative Seitenlänge.");
		}
		return 2 * (a + b);
	}

	/**
	 * Berechnet den Flächeinhalt eines rechtwinkligen Dreiecks mit gegebener Kathete und Ankathete.
	 * @param a - erste Seite.
	 * @param b - zweite Seite.
	 * @return - den Flächeninhalt
	 * @throws IllegalArgumentException
	 */
	public static double computeTriangleArea(double a, double b) throws IllegalArgumentException {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Kein Dreieck hat eine negative Seitenlänge.");
		}
		return a * b / 2;
	}

	/**
	 * Berechnet den Umfang eines rechtwinkligen Dreiecks mit gegebener Kathete und Ankathete.
	 * @param a - erste Seite.
	 * @param b - zweite Seite.
	 * @return - den Umfang.
	 * @throws IllegalArgumentException
	 */
	public static double computeTriangleCircumference(double a, double b) throws IllegalArgumentException {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Kein Dreieck hat eine negative Seitenlänge.");
		}
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) + a + b; //Hier ist keine Exception nötig, da a und b an dieser Stelle gar nicht mehr negativ sein können.
	}

	public static void printMenu() {
		//Noch zu erledigen
	}

	public static void main(String[] args) {
		printMenu();
	}

}