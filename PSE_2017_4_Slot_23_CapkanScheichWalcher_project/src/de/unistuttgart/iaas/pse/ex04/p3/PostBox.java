package de.unistuttgart.iaas.pse.ex04.p3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ein Briefkasten mit vielen Funktionen.
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class PostBox {
	private ArrayList<Letter> briefkasten;

	/**
	 * constructor for the PostBox
	 */
	public PostBox() {
		briefkasten = new ArrayList<Letter>();
	}

	/**
	 * adds letters to the PostBox
	 * 
	 * @param letters
	 *            the letters to add
	 */
	public void addLetters(Letter... letters) {
		for(Letter l : letters)
			briefkasten.add(l);
	}

	/**
	 * prints sender and recipient information for all letters contained in the
	 * post box to the console
	 */
	public void printAll() {
		for(Letter l : briefkasten)
			System.out.println("Absender: " + l.getSender() + "\t\tEmpfänger: " + l.getRecipient());
	}

	/**
	 * Empties the PostBox into the given PostBag, i.e. all letters are moved
	 * from the PostBox to the PostBag.
	 * @param postbag - all letters of the postbox will be moved to this postbag.
	 */
	public void emptyToPostBag(PostBag postBag) {
		for(Letter l : briefkasten) {
			postBag.addLetter(l);
		}
		briefkasten.clear();
	}

	/**
	 * saves all letters in a file
	 */
	public void saveLettersToFile() throws IOException {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream("briefkasten.bin"));
			for(Letter l : briefkasten) {
				os.writeObject(l);
			}
		} finally {
			if(os != null) os.close();
		}
		
	}

	/**
	 * reads letters from a file and adds them to the PostBox
	 */
	public void loadLettersFromFile() throws IOException {
		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(new FileInputStream("briefkasten.bin"));
			while(is.available() > 1) {
				Letter l = (Letter) is.readObject(); //das hier tut irgendwie nicht
				briefkasten.add(l);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(is != null) is.close();
		}
	}

	public static void mainMenu() {
		// initialize the PostBox
		PostBox postBox = new PostBox();

		// initialize all input objects
		int input = -1;
		Scanner scan = new Scanner(System.in);

		while (input != 0) {
			System.out.println("Please choose one of the following options:");
			System.out.println("  1: Add a new letter in postbox");
			System.out.println("  2: Save a postbox to file");
			System.out.println("  3: Read a postbox from file");
			System.out.println("  4: Print all letters in postbox");
			System.out.println("  5: Empty postbox to postbag");
			System.out.println();
			System.out.println("  0: Exit");

			// get user-input
			input = scan.nextInt();

			switch (input) {
			case 1:
				// clear input buffer
				scan.nextLine();

				// input all important info of the letter
				System.out.println("");
				System.out.print("Please input who you are: ");
				String letterFrom = scan.nextLine();
				System.out.print("Please input who receives the letter: ");
				String letterTo = scan.nextLine();

				// make the letter and put it in the PostBox
				postBox.addLetters(new Letter(letterFrom, letterTo));
				break;
			case 2:
				try {
					postBox.saveLettersToFile();
				} catch (IOException e){
					System.err.println(e);
				}
				break;
			case 3:
				try {
					postBox.loadLettersFromFile();
				} catch (IOException e) {
					System.err.println(e);
				}
				break;
			case 4:
				postBox.printAll();
				break;
			case 5:
				postBox.emptyToPostBag(new PostBag());
				break;
			}
		}

		// close the input scanner
		scan.close();
	}

	public static void main(String[] args) {
		mainMenu();
	}

}