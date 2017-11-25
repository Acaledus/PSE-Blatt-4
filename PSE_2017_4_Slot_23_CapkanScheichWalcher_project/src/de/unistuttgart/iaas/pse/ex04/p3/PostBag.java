package de.unistuttgart.iaas.pse.ex04.p3;

import java.util.ArrayList;

public class PostBag {
	private ArrayList<Letter> postsack = new ArrayList<Letter>();
	
	/**
	 * Returns all letters contained in the postbag.
	 * @return all letters contained in the postbag.
	 */
	public ArrayList<Letter> getLetters() {
		return postsack;
	}

	/**
	 * Adds letters to the postbag.
	 * @param letters - the letters to add.
	 */
	public void addLetter(Letter... letters) {
		for(Letter l : letters)
			postsack.add(l);
	}
	
}