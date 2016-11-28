package ConsoleUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Generates a console-based menu using the Strings in options as the menu
	 * items. Reserves the number 0 for the "quit" option when withQuit is true.
	 * 
	 * @param options
	 *            - Strings representing the menu options
	 * @param withQuit
	 *            - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 */
	public static int promptForMenuSelection(String[] options, boolean withQuit) throws IOException {
		if (options == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		int minimum = 1;
		for (int i = 0; i < options.length; i++) {
			System.out.println(i + 1 + " " + options[i]);
		}
		if (withQuit == true) {
			minimum = 0;
			System.out.println("0 Quit");
		}
		return promptForInt("", minimum, options.length);
	}

	/**
	 * Generates a prompt that expects the user to enter one of two responses
	 * that will equate to a boolean value. The trueString represents the case
	 * insensitive response that will equate to true. The falseString acts
	 * similarly, but for a false boolean value. Example: Assume this method is
	 * called with a trueString argument of "yes" and a falseString argument of
	 * "no". If the enters "YES", the method returns true. If the user enters
	 * "no", the method returns false. All other inputs are considered invalid,
	 * the user will be informed, and the prompt will repeat.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param trueString
	 *            - the case insensitive value that will evaluate to true
	 * @param falseString
	 *            - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 */
	public static boolean promptForBool(String prompt, String trueString, String falseString) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		System.out.println(prompt);
		String yboolean;
		boolean nboolean = false;
		boolean isInputValid;
		do {
			isInputValid = true;
			yboolean = in.readLine();
			try {
			}
			catch (NumberFormatException ex) {
				System.out.println("Invalid input");
			}
			if (yboolean.equalsIgnoreCase(trueString)) {
				nboolean = true;
			} else if (yboolean.equalsIgnoreCase(falseString)) {
				nboolean = false;
			} else {
				System.out.println("Input is invalid");
				isInputValid = false;
			}
		} while (!isInputValid);
		return nboolean;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a byte
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the byte value
	 */
	public static byte promptForByte(String prompt, byte min, byte max) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		System.out.println(prompt);
		String input = null;
		byte value = 0;
		boolean isInputValid = true;
		do {
			isInputValid = true;
			input = in.readLine();
			try {
				value = Byte.parseByte(input);
			}
			catch (NumberFormatException ex) {
				value = (byte) (min-1);
			}
			if (value < min || value > max) {
				isInputValid = false;
				System.out.println("Invalid. Pick a number between " + min + " and " + max + ".");
				System.out.println(prompt);
			}
		} while (!isInputValid);
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a short
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the short value
	 */

	public static short promptForShort(String prompt, short min, short max) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		System.out.println(prompt);
		String input = null;
		short value = 0;
		boolean isInputValid = true;
		do {
			isInputValid = true;
			input = in.readLine();
			try {
				value = Short.parseShort(input);
			}
			catch (NumberFormatException ex) {
				value = (short) (min-1);
			}
			if (value < min || value > max) {
				isInputValid = false;
				System.out.println("Invalid. Pick a number between " + min + " and " + max + ".");
				System.out.println(prompt);
			}else {
				isInputValid = true;
				System.out.println("Your input was " + input);
			}
		} while (!isInputValid);
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing an int
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the int value
	 */
	public static int promptForInt(String prompt, int min, int max) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		System.out.println(prompt);
		String input = null;
		int value = 0;
		boolean isInputValid = true;
		do {
			isInputValid = true;
			input = in.readLine();
			try {
				value = Integer.parseInt(input);
			}
			catch (NumberFormatException ex) {
				value = min - 1;
			}
			if (value < min || value > max) {
				isInputValid = false;
				System.out.println("Invalid. Pick a number between " + min + " and " + max + ".");
				System.out.println(prompt);
			}
		} while (!isInputValid);
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a long
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the long value
	 */
	static long promptForLong(String prompt, long min, long max) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		System.out.println(prompt);
		String input = null;
		long value = 0;
		boolean isInputValid = true;
		do {
			isInputValid = true;
			input = in.readLine();
			try {
				value = Long.parseLong(input);
			}
			catch (NumberFormatException ex) {
				value = min - 1;
			}
			if (value < min || value > max) {
				isInputValid = false;
				System.out.println("Invalid. Pick a number between " + min + " and " + max + ".");
				System.out.println(prompt);
			}
		} while (!isInputValid);
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a float
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the float value
	 */
	public static float promptForFloat(String prompt, float min, float max) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		System.out.println(prompt);
		String input = null;
		float value = 0;
		boolean isInputValid = true;
		do {
			isInputValid = true;
			input = in.readLine();
			try {
				value = Float.parseFloat(input);
			}
			catch (NumberFormatException ex) {
				value = min - 1;
			}
			if (value < min || value > max) {
				isInputValid = false;
				System.out.println("Invalid. Pick a number between " + min + " and " + max + ".");
				System.out.println(prompt);
			}
		} while (!isInputValid);
		return value;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a double
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the double value
	 */
	public static double promptForDouble(String prompt, double min, double max) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(prompt);
		String input = null;
		double value = 0;
		boolean isInputValid = true;
		do {
			isInputValid = true;
			input = in.readLine();
			try {
				value = Double.parseDouble(input);
			}
			catch (NumberFormatException ex) {
				value = min - 1;
			}
			if (value < min || value > max) {
				isInputValid = false;
				System.out.println("Have to enter a number between " + min + " and " + max + " to be valid");
				System.out.println(prompt);
			}
		} while (!isInputValid);
		return value;
	}

	/**
	 * Generates a prompt that allows the user to enter any response and returns
	 * the String. When allowEmpty is true, empty responses are valid. When
	 * false, responses must contain at least one character (including
	 * whitespace).
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user.
	 * @param allowEmpty
	 *            - when true, makes empty responses valid
	 * @return the input from the user as a String
	 */
	public static String promptForInput(String prompt, boolean allowEmpty) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(prompt);
		String value = null;
		boolean isInputValid = true;
		do {
			isInputValid = true;
			value = in.readLine();
			if (allowEmpty == false) {
				if (value.equals("")) {
					System.out.println("Invalid. Must enter at least a word.");
					isInputValid = false;
				}
				else {
					isInputValid = true;
				}
			}
		} while (!isInputValid);
		return value;
	}
	/**
	 * Generates a prompt that expects a single character input representing a
	 * char value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the char value
	 */
	public static char promptForChar(String prompt, char min, char max) throws IOException {
		if (prompt == null) {
			IllegalArgumentException myException = new IllegalArgumentException("prompt cannot be null");
			throw myException;
		}
		System.out.println(prompt);
		char value = 0;
		String input;
		boolean isInputValid = true;
		do {
			input = in.readLine();
			isInputValid = true;
			try {
				value = input.charAt(0);
			}
			catch (NumberFormatException ex) {
				value = (char) (min-1);
			}
			if (value < min || value > max) {
				isInputValid = false;
				System.out.println("Invalid. Pick a character between " + min + " and " + max + ".");
				System.out.println(prompt);
			}
		} while (!isInputValid);
		return value;
	}
}
