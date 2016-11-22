package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import ConsoleUI.ConsoleUI;

public class monopolyRunner {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static monoMenu mm = new monoMenu();

	public static void main(String[] args) throws IOException {
		System.out.println("Monopoly is booted up.");

		int location = 1;
		int playerMoney = 1300;
		int playerMoneyOwed = 0;
		
		mm.menu();
		// cards card = new cards();
		// card.getcards();
	}

	public void pickingGamePiece(int numPlayer) throws IOException {

		// player picks their game piece and will be referred to that game piece
		// each turn, but as of now it doesn't separate each player from the
		// other
		int i = 0;
		gamePieces playerPiece = null;
		for (i = 1; i < numPlayer + 1; i++) {
			String[] thePlayers = new String[i];
			System.out.println("Player " + i + ", What game piece do you want to play?");
			System.out.println(
					"Tokens you can play as: Thimble, Cannon, Hat, Dog, " + "Battleship, Car, Shoe, Wheelbarrow");
			String pieceChoice = in.readLine();
			if (pieceChoice.equalsIgnoreCase("Thimble")) {
				playerPiece = gamePieces.Thimble;
			} else if (pieceChoice.equalsIgnoreCase("Cannon")) {
				playerPiece = gamePieces.Cannon;
			} else if (pieceChoice.equalsIgnoreCase("Hat")) {
				playerPiece = gamePieces.Hat;
			} else if (pieceChoice.equalsIgnoreCase("Dog")) {
				playerPiece = gamePieces.Dog;
			} else if (pieceChoice.equalsIgnoreCase("Battleship")) {
				playerPiece = gamePieces.Battleship;
			} else if (pieceChoice.equalsIgnoreCase("Car")) {
				playerPiece = gamePieces.Car;
			} else if (pieceChoice.equalsIgnoreCase("Shoe")) {
				playerPiece = gamePieces.Shoe;
			}
			System.out.println("Player " + i + " chose " + playerPiece + ".");
		}
		System.out.println("Time to start!! ");

		// prints player stats (a general code for one player, doesn't differ
		// which player has what stats)
		String[] playerStartMenu = { "Roll Dice", "View Stats" };
		System.out.println("It is " + playerPiece + "'s turn. What do you want to do?");
		int startMenu = ConsoleUI.promptForMenuSelection(playerStartMenu, true);
		if (startMenu == 1) {
			// rolls the dice
			roll();
		} else if (startMenu == 2) {
			// shows player their stats of the game so far
			System.out.println("You have: " + playerMoney);
			System.out.println("You owe: " + playerMoneyOwed);
		} else {
			System.out.println(playerPiece.toString() + " has quit. All your properties will be auctioned.");
		}

		// // moves player to jail if landed on 'go to jail' spot
		// if (location == 31) {
		// System.out.println("Looks like you're going to jail.");
		// playerInJail = true;
		// location = 11;
		// }
		//
		// // moves player to jail picks 'go to jail' card
		// if (card.equals("Go to Jail")) { // card is a placeholder variable
		// for
		// location = 11;
		// playerInJail = true;
		// }
		//
		// // gets player out of jail
		// if (playerInJail = true) {
		// for (jailTurnCounter = 0; jailTurnCounter < 4; jailTurnCounter++) {
		// if (diceRoll1 == diceRoll2) { // diceRoll1 and diceRoll2 are
		// // placeholder variables
		// playerInJail = false;
		// break;
		// } else if (card.equals("Get out of Jail")) {
		// playerInJail = false;
		// break;
		// } else {
		// playerInJail = true;
		// }
		// }
		// if (jailTurnCounter == 3) {
		// playerMoney -= 50;
		// playerInJail = false;
		// break;
		// }
		// }

		// resets location number
		if (location >= 41) {
			location -= 40;
		}
	}

	//pretty sure this works
	public void roll() {
		Random genRan = new Random();
		int rollingDice1 = genRan.nextInt(6) + 1;
		int rollingDice2 = genRan.nextInt(6) + 1;
		int sumOfRolls = rollingDice1 + rollingDice2;
		System.out.println("You rolled " + rollingDice1 + " and " + rollingDice2 + ". Move " + sumOfRolls + " spaces.");
		location += sumOfRolls; //idk if that'll be useful
		return;
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
