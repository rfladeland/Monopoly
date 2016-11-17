package Monopoly;

import java.io.IOException;

import ConsoleUI.ConsoleUI;

public class monopolyRunner {
	private static monoMenu mm = new monoMenu();
	public static void main(String[] args) throws IOException {
		System.out.println("Monopoly is booted up.");
		
		mm.menu();
//		cards card = new cards();
//		card.getcards();
	}
	
	public void playAgain() throws IOException {
		boolean valid = true;
		String userPlayAgain = null;
		do {
			userPlayAgain = ConsoleUI.promptForInput("Want to play again? Y/N?", false);
			valid = true;
			if (userPlayAgain.equalsIgnoreCase("Y")) {
				mm.menu();
				break;
			}
			if (userPlayAgain.equalsIgnoreCase("N")) {
				System.out.println("Thank you for playing!");
				break;
			} else {
				System.out.println("Invalid. Please enter 'Y' or 'N'");
				valid = false;
			}
		} while (!valid);
	}

}
