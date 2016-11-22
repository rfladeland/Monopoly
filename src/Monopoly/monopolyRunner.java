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
		
		mm.menu();
//		cards card = new cards();
//		card.getcards();
	}
	
	public void pickingGamePiece() throws IOException {

		// player picks their game piece and will be referred to that game piece
		// each turn
		gamePieces playerPiece = null;
		for (i = 1; i < numberOfPlayers + 1; i++) {
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
		System.out.println("It is " + playerPiece + "'s turn. What do you want to do?");
		int startMenu = ConsoleUI.promptForMenuSelection(playerStartMenu, true);
		if (startMenu == 1) {
			// rolls the dice

		} else if (startMenu == 2) {
			// shows player their stats of the game so far
			System.out.println("You have: " + playerMoney);
			System.out.println("You owe: " + playerMoneyOwed);
		} else {
			System.out.println(playerPiece.toString() + " has quit. All your properties will be auctioned.");
		}

		// moves player to jail if landed on 'go to jail' spot
		if (location == 31) {
			playerInJail = true;
			location = 11;
		}

		// moves player to jail picks 'go to jail' card
		if (card.equals("Go to Jail")) { // card is a placeholder variable for 
			location = 11;
			playerInJail = true;
		}

		// gets player out of jail
		if (playerInJail = true) {
			for (jailTurnCounter = 0; jailTurnCounter < 4; jailTurnCounter++) {
				if (diceRoll1 == diceRoll2) { // diceRoll1 and diceRoll2 are
												// placeholder variables
					playerInJail = false;
					break;
				} else if (card.equals("Get out of Jail")) {
					playerInJail = false;
					break;
				} else {
					playerInJail = true;
				}
			}
			if (jailTurnCounter == 3) {
				playerMoney -= 50;
				playerInJail = false;
				break;
			}
		}

		// resets location number
		if (location >= 41) {
			location -= 40;
		}
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
