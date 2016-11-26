package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import ConsoleUI.ConsoleUI;

public class monopolyRunner {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static monoMenu mm = new monoMenu();
	private static monoBoard mb = new monoBoard();
	private static thePlayer[] players;
	private static String[] listOfPieces = { "Battleship", "Cannon", "Car", "Dog", "Hat", "Shoe", "Thimble",
			"Wheelbarrow" };

	
	
	public static void main(String[] args) throws IOException {
		
		final int MAX_PLAYERS = 8;
		final int MIN_PLAYERS = 2;
		mm.menu();
		System.out.println("Monopoly is booted up.");
		int inputNumberOfPlayers = ConsoleUI.promptForInt("How many people will be playing?", MIN_PLAYERS, MAX_PLAYERS);
		System.out.println("There are " + inputNumberOfPlayers + " players for this game.");
		players = new thePlayer[inputNumberOfPlayers];
		for (int i = 0; i < inputNumberOfPlayers; i++) {
			players[i] = new thePlayer();
			System.out.println();
			System.out.println();
			System.out.println("Player " + (i + 1) + " please choose your piece.");

			int playerPiece = pickingGamePiece() - 1;

			System.out.println("You chose " + listOfPieces[playerPiece] + ".");
			players[i].setPiece(listOfPieces[playerPiece]);
			removePiece(playerPiece);
		}
		System.out.println("Time to start!! ");
		System.out.println();
		System.out.println();
		System.out.println();
		for (thePlayer player : players) {
			System.out.println(player.getPiece());
		}

	}

	public static int pickingGamePiece() throws IOException {

		// player picks their game piece and will be referred to that game piece
		// each turn
		return ConsoleUI.promptForMenuSelection(listOfPieces, false);

	}

	// // prints player stats (a general code for one player, doesn't differ
	// // which player has what stats)
	// String[] playerStartMenu = { "Roll Dice", "View Stats" };
	// System.out.println("It is " + playerPiece + "'s turn. What do you want to
	// do?");
	// int startMenu = ConsoleUI.promptForMenuSelection(playerStartMenu, true);
	// if (startMenu == 1) {
	// // rolls the dice
	// roll();
	// } else if (startMenu == 2) {
	// // shows player their stats of the game so far
	// System.out.println("You have: " + playerMoney);
	// System.out.println("You owe: " + playerMoneyOwed);
	// } else {
	// System.out.println(playerPiece.toString() + " has quit. All your
	// properties will be auctioned.");
	// }
	//
	// // // moves player to jail if landed on 'go to jail' spot
	// // if (location == 31) {
	// // System.out.println("Looks like you're going to jail.");
	// // playerInJail = true;
	// // location = 11;
	// // }
	// //
	// // // moves player to jail picks 'go to jail' card
	// // if (card.equals("Go to Jail")) { // card is a placeholder variable
	// // for
	// // location = 11;
	// // playerInJail = true;
	// // }
	// //
	// // // gets player out of jail
	// // if (playerInJail = true) {
	// // for (jailTurnCounter = 0; jailTurnCounter < 4; jailTurnCounter++) {
	// // if (diceRoll1 == diceRoll2) { // diceRoll1 and diceRoll2 are
	// // // placeholder variables
	// // playerInJail = false;
	// // break;
	// // } else if (card.equals("Get out of Jail")) {
	// // playerInJail = false;
	// // break;
	// // } else {
	// // playerInJail = true;
	// // }
	// // }
	// // if (jailTurnCounter == 3) {
	// // playerMoney -= 50;
	// // playerInJail = false;
	// // break;
	// // }
	// // }
	//
	// // resets location number
	// if (location >= 41) {
	// location -= 40;
	// }
	// }

	public static void removePiece(int removedSpace) {
		String[] temp = new String[listOfPieces.length - 1];
		int j = 0;
		for (int i = 0; i < listOfPieces.length; i++) {
			if (i == removedSpace) {
			} else {
				temp[j] = listOfPieces[i];
				j++;
			}
		}
		listOfPieces = temp;
	}

	// pretty sure this works
	public void roll(int player) {
		Random genRan = new Random();
		int rollingDice1 = genRan.nextInt(6) + 1;
		int rollingDice2 = genRan.nextInt(6) + 1;
		int sumOfRolls = rollingDice1 + rollingDice2;
		System.out.println("You rolled " + rollingDice1 + " and " + rollingDice2 + ". Move " + sumOfRolls + " spaces.");
		players[player].move(sumOfRolls);
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
