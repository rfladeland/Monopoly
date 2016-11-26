package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import ConsoleUI.ConsoleUI;

public class monopolyRunner {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static int numPlayers;
	private static monoMenu mm = new monoMenu();
	private static monoBoard mb = new monoBoard();
	private static thePlayer[] players;
	private static String[] playerMenu = { "Roll","Buy", "End Turn" };
	private static String[] listOfPieces = { "Battleship", "Cannon", "Car", "Dog", "Hat", "Shoe", "Thimble",
			"Wheelbarrow" };

	public static void main(String[] args) throws IOException {

		final int MAX_PLAYERS = 8;
		final int MIN_PLAYERS = 2;
		mm.menu();
		System.out.println("Monopoly is booted up.");
		int numPlayers = ConsoleUI.promptForInt("How many people will be playing?", MIN_PLAYERS, MAX_PLAYERS);
		System.out.println("There are " + numPlayers + " players for this game.");
		players = new thePlayer[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
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
		int turnTracker = 0;
		int choice = -1;
		// loop for the entire game
		do {
			//mortgage//
			//sell//
			//Auction//
			//Jail//
			//trade//
			//Doubles//
			//Buy houses//
			
			// loop for the individual turns
			do {
				turnTracker %= numPlayers;
				System.out.println(players[turnTracker].getPiece() + " it is your turn. What would you like to do?");
				choice = ConsoleUI.promptForMenuSelection(playerMenu, false);
				switch (choice) {
				// rolls the dice
				case 1:
					if (players[turnTracker].getRolled()) {
						System.out.println("Sorry, but you cannot roll again this turn.");
					}else{
						roll(turnTracker);
						players[turnTracker].flipRoll();
						System.out.println("You are now on " + mb.getSpace(players[turnTracker].getLocation()));
					}
				// buys a property
				case 2:
					System.out.println("This space costs " + 1);
				// ends the turn
				case 3:
					if(!players[turnTracker].getRolled()){
						System.out.println("Sorry, but you have to roll first.");
						choice = -1;
					}else{
						break;
						}
				}
			} while (choice != 3);
			players[turnTracker].flipRoll();
			turnTracker ++;
		} while (!isOver());

	}

	public static int pickingGamePiece() throws IOException {

		// player picks their game piece and will be referred to that game piece
		// each turn
		return ConsoleUI.promptForMenuSelection(listOfPieces, false);

	}

	// pretty sure this works
	public static void roll(int player) {
		Random genRan = new Random();
		int rollingDice1 = genRan.nextInt(6) + 1;
		int rollingDice2 = genRan.nextInt(6) + 1;
		int sumOfRolls = rollingDice1 + rollingDice2;
		System.out.println("You rolled " + rollingDice1 + " and " + rollingDice2 + ". Move " + sumOfRolls + " spaces.");
		players[player].move(sumOfRolls);
	}

	public static boolean isOver() {
		return false;
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
}
