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
	private static ArrayList<String> notBuyableSpaces = new ArrayList<String>();
	private static monoMenu mm = new monoMenu();
	private static monoBoard mb = new monoBoard();
	private static Banker bank = new Banker();
	private static thePlayer[] players;
	private static String[] playerMenu = { "Roll", "Buy houses/ hotels", "End Turn", "Quit", "Mortgage / Unmortgage" };
	private static String[] listOfPieces = { "Battleship", "Cannon", "Car", "Dog", "Hat", "Shoe", "Thimble",
			"Wheelbarrow" };
	private static int doubles = 0;

	public static void main(String[] args) throws IOException {

		final int MAX_PLAYERS = 8;
		final int MIN_PLAYERS = 2;
		mm.menu();
		addNotBuyable();
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
			// Jail//
			// Doubles//

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
					} else if (players[turnTracker].inJail()) {
						if (ConsoleUI.promptForBool("Would you like to pay $50 to get out of jail? (Y/N)", "Y", "N")) {
							players[turnTracker].getOutOfJail();
							players[turnTracker].pay(-50);
						} else {
							jailDoublesRoll(turnTracker);
						}
					} else {
					}
					roll(turnTracker);
					System.out.println("You are now on " + mb.getSpace(players[turnTracker].getLocation() - 1));
					if (!(notBuyableSpaces.contains(mb.getSpace(players[turnTracker].getLocation() - 1)))
							&& players[turnTracker].getMoney() >= bank.sellProperty(players[turnTracker].getLocation())
									.getCurRent()) {
						if (ConsoleUI.promptForBool("Would you like to buy this property?(Y/N)", "Y", "N")) {
							players[turnTracker].buyPiece(bank.sellProperty(players[turnTracker].getLocation()));
							bank.removePiece(players[turnTracker].getLocation());
						} else {
							auction(bank.sellProperty(players[turnTracker].getLocation()));
						}
					}
					break;
					
					// buys houses / hotels
				case 2:
					String[] purchaseList = { "Purchase a house", "Purchase a Hotel" };
					System.out.println("Which would you like to do?");
					int purchChoice = ConsoleUI.promptForMenuSelection(purchaseList, true);
					if (purchChoice == 0) {
						break;
					} else if (purchChoice == 1) {
						players[turnTracker].purchaseHouses();
					} else {
						players[turnTracker].purchaseHotels();
					}
					break;
					// ends the turn
				case 3:
					if (!players[turnTracker].getRolled()) {
						System.out.println("Sorry, but you have to roll first.");
						choice = -1;
					} else {
						break;
					}

					// "Quit game"
					// auctions off everything
					// removes player from game
				case 4:
					break;
					// mortgage / unmortgage
				case 5:
					players[turnTracker].mortgageMenu();
					break;
					
					// trade
				case 6:
					// trade(players[turnTracker]);
					break;
					// sell houses and hotels
				case 7:
					// players[turnTracker].sell();
					break;
					
					// show player money as well
					// as owned properties
					// goes into a different method with a different menu
				case 8:
					break;
					
					// Auction off specific deeds that you own
					// No buildings are allowed
				case 9:
					break;
				}
			} while (choice != 3);
			players[turnTracker].flipRoll();
			turnTracker++;
		} while (!isOver());
	}

	private static void jailDoublesRoll(int player) {
		Random genRan = new Random();
		int rollingDice1 = genRan.nextInt(6) + 1;
		int rollingDice2 = genRan.nextInt(6) + 1;
		if (rollingDice1 == rollingDice2) {
			System.out.println("You rolled doubles, you are no longer in jail.");
			players[player].getOutOfJail();
			players[player].flipRoll();
		} else if (players[player].getJailTurn() == 3) {
			System.out.println("You didn't roll doubles and it is your third turn in jail.");
			System.out.println("You get out of jail, but have to pay $50");
			players[player].getOutOfJail();
			players[player].pay(-50);
			players[player].flipRoll();
		} else {
			System.out.println("You didn't roll doubles.");
			players[player].incJailTurn();
		}
	}

	private static void auction(Deeds sellProperty) {

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
		if (rollingDice1 == rollingDice2) {
			doubles++;
			if (doubles == 3) {
				players[player].goToJail();
				doubles = 0;
			} else {
				players[player].flipRoll();
			}
		}else{
			players[player].flipRoll();
		}
	}

	public static boolean isOver() {
		return (players.length > 1);
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

	public static void addNotBuyable() {
		notBuyableSpaces.add("1");
		notBuyableSpaces.add("3");
		notBuyableSpaces.add("5");
		notBuyableSpaces.add("8");
		notBuyableSpaces.add("11");
		notBuyableSpaces.add("18");
		notBuyableSpaces.add("21");
		notBuyableSpaces.add("23");
		notBuyableSpaces.add("31");
		notBuyableSpaces.add("34");
		notBuyableSpaces.add("37");
		notBuyableSpaces.add("39");
	}
}
