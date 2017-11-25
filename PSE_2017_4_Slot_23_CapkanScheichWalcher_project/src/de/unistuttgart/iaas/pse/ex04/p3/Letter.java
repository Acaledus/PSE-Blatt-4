package de.unistuttgart.iaas.pse.ex04.p3;

import java.io.Serializable;

/**
 * Ein serialisierbarer Brief.
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
@SuppressWarnings("serial")
public class Letter implements Serializable {
	private String sender;
	private String recipient; 

	/**
	 * Creates a new letter.
	 * @param sender - the sender of the letter.
	 * @param recipient - the recipient of the letter.
	 */
	public Letter(String sender, String recipient) {
		this.sender = sender;
		this.recipient = recipient;
	}

	/**
	 * Returns the sender of the letter.
	 * @return - the sender of the letter.
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Returns the recipient of the letter.
	 * @return - the recipient of the letter.
	 */
	public String getRecipient() {
		return recipient;
	}

}