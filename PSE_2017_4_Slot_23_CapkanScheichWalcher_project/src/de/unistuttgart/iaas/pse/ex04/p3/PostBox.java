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
		for(int i = 0; i < letters.length; i++)
			briefkasten.add(letters[i]);
	}

	/**
	 * prints sender and recipient information for all letters contained in the
	 * post box to the console
	 */
	public void printAll() {
		for(int i = 0; i < box.size(); i++)
			System.out.println("Absender: " + briefkasten.get(i).getSender() + "\t\tEmpfänger: " + briefkasten.get(i).getRecipient());
	}

	/**
	 * Empties the PostBox into the given PostBag, i.e. all letters are moved
	 * from the PostBox to the PostBag.
	 * @param postbag - all letters of the postbox will be moved to this postbag.
	 */
	public void emptyToPostBag(PostBag postBag) {
		for(int i = 0; i < briefkasten.size(); i++) {
			postBag.addLetter(briefkasten.get(i));
		}
		briefkasten.clear();
	}

	/**
	 * saves all letters in a file
	 */
	public void saveLettersToFile() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream("letters.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(box);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * reads letters from a file and adds them to the PostBox
	 */
	public void loadLettersFromFile() throws IOException {
		try {
			FileInputStream fin = new FileInputStream("letters.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);
			box = (ArrayList<Letter>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
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
