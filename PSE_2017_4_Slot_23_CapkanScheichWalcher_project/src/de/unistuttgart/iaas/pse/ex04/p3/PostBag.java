package de.unistuttgart.iaas.pse.ex04.p3;

import java.util.ArrayList;

/**
 * Ein Postsack mit Briefen drin.
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class PostBag {
	private ArrayList<Letter> postsack = new ArrayList<Letter>();
	
	/**
	 * Returns all letters contained in the postbag.
	 * @return all letters contained in the postbag.
	 */
	public ArrayList<Letter> getLetters(Postbag sample) {
		return postsack;
	}

	/**
	 * Adds letters to the postbag.
	 * @param letters - the letters to add.
	 */
	public void addLetter(Letter... letters) {
		for(int i = 0; i < letters.length; i++)
			postsack.add(letters[i]);
	}
	
}
