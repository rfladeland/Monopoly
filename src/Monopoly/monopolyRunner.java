package Monopoly;

import java.io.IOException;

import ConsoleUI.ConsoleUI;

public class monopolyRunner {
	private static monoMenu mm = new monoMenu();
	public static void main(String[] args) throws IOException {
		System.out.println("Monopoly is booted up.");
		final int MAX_PLAYERS = 8;
		final int MIN_PLAYERS = 2;
		boolean playerInJail = false;
		int jailTurnCounter = 0;
		int location = 1;
		int playerMoney = 1300;
		int playerMoneyOwed = 0;
		String[] playerStartMenu = { "Roll Dice", "View Stats" };
		// input players amount
		int numberOfPlayers = ConsoleUI.promptForInt("How many people will be playing?", MIN_PLAYERS, MAX_PLAYERS);
		// ask each players entered what game piece they want
		System.out.println("There are " + numberOfPlayers + " players for this game.");
		int i = 0;
		gamePieces playerPiece = null;
		
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
