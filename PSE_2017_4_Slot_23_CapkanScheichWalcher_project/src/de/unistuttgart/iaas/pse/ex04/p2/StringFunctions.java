package de.unistuttgart.iaas.pse.ex04.p2;

import java.util.Scanner;

/**
 * Eine Klasse mit verschiedenen Methoden zur Untersuchung von Strings.
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class StringFunctions {
	/**
	 * Eine Methode, die die Anzahl der Diphthonge in einem String z‰hlt.
	 * @param testString - der zu untersuchende String.
	 * @return - die Anzahl der Diphthonge.
	 */
	public static int numberOfDiphthongs(String testString) {
		testString = testString.toLowerCase(); //Damit Diphthonge mit Groﬂbuchstaben, zum Beispiel bei "Auenland" auch erkannt werden.
		String[] buchstabenpaar = new String[testString.length() - 1];
		for(int i = 0; i < testString.length() - 1; i++) {
			buchstabenpaar[i] = testString.substring(i, i + 2);
		}
		int anzahl = 0;
		for (String s : buchstabenpaar) {
			if(s.equals("ai")||s.equals("eu")||s.equals("au")||s.equals("‰u")||s.equals("ei")||s.equals("ui")) {
				anzahl++;
			}
		}
		return anzahl;
	}
	
	/**
	 * ‹berpr¸ft, ob ein String ein Palindrom ist.
	 * @param testString - der zu ¸berpr¸fende String.
	 * @return true, wenn der String ein Palindrom ist und false, wenn er es nicht ist.
	 */
	public static boolean isPalindrome(String testString) {
		testString = testString.toLowerCase(); //Damit groﬂ geschriebene Wˆrter wie "Rentner" als Palindrome erkannt werden.
		return testString.contains(new StringBuilder(testString).reverse().toString());
	}

	/**
	 * Ein Spiel, bei dem der Spieler zwei Mal einen String eingibt. 
	 * Wenn der erste ein Palindrom ist und der zweite
	 * mehr als drei Diphthonge enth‰lt, hat der Spieler gewonnen. 
	 * @param args - nicht genutzt.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Gib einen String ein. Wenn er ein Palindrom ist, kommst du weiter.");
		if (isPalindrome(sc.next())) {
			System.out.println("Gib einen String ein. Wenn er mehr als drei Diphthonge enth‰lt, hast du gewonnen.");
			if (numberOfDiphthongs(sc.next()) > 3) {
				System.out.println("Du hast gewonnen!");
			} else {
				System.out.println("Leider zu wenige Diphthonge.");
			}
		} else {
			System.out.println("Das ist kein Palindrom.");
		}
		sc.close();
	}

}