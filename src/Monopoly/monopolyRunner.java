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
	private static ArrayList<cards> Chance = new ArrayList<cards>();
	private static ArrayList<cards> usedChance = new ArrayList<cards>();
	private static ArrayList<cards> CommunityChest = new ArrayList<cards>();
	private static ArrayList<cards> usedCommunityChest = new ArrayList<cards>();
	private static monoMenu mm = new monoMenu();
	private static monoBoard mb = new monoBoard();
	private static Banker bank = new Banker();
	private static thePlayer[] players;
	private static String[] playerMenu = { "Roll", "Buy houses/ hotels", "End Turn", "Quit", "Mortgage / Unmortgage", "Auction A Property" };
	private static String[] listOfPieces = { "Battleship", "Cannon", "Car", "Dog", "Hat", "Shoe", "Thimble",
			"Wheelbarrow" };
	private static int doubles = 0;

	public static void main(String[] args) throws IOException {

		final int MAX_PLAYERS = 8;
		final int MIN_PLAYERS = 2;
		mm.menu();
		addNotBuyable();
		addChanceCards();
		//shuffle(Chance);
		addCommunityChestCards();
		//shuffle(CommunityChest);
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
					if (!(players[turnTracker].inJail()) && players[turnTracker].getRolled()) {
						System.out.println("Sorry, but you cannot roll again this turn.");
						break;
					}
					if (players[turnTracker].inJail() && players[turnTracker].getCanRoll()) {
						if (ConsoleUI.promptForBool("Would you like to pay $50 to get out of jail? (Y/N)", "Y", "N")) {
							players[turnTracker].getOutOfJail();
							players[turnTracker].pay(-50);
						} else {
							jailDoublesRoll(turnTracker);
						}
					}
					if(players[turnTracker].inJail() && !players[turnTracker].getCanRoll() && !players[turnTracker].getRolled()){
						System.out.println("Sorry, but you cannot roll this turn.");
					}
					if (!players[turnTracker].getRolled() && players[turnTracker].getCanRoll()) {
						roll(turnTracker);
					}

					System.out.println("You are now on " + mb.getSpace(players[turnTracker].getLocation() - 1));
					if (!(notBuyableSpaces.contains(mb.getSpace(players[turnTracker].getLocation() - 1)))
							&& players[turnTracker].getMoney() >= bank.sellProperty(players[turnTracker].getLocation())
									.getCurRent()) {
						if (ConsoleUI.promptForBool("Would you like to buy this property?(Y/N)", "Y", "N")) {
							players[turnTracker].buyPiece(bank.sellProperty(players[turnTracker].getLocation()));
							bank.removePiece(players[turnTracker].getLocation());
						} else {
							auction(bank.sellProperty(players[turnTracker].getLocation()), players , players[turnTracker]);
						}
					}else if(mb.getSpace(players[turnTracker].getLocation()-1).equals("Go To Jail")){
						System.out.println("You are now in jail.");
						players[turnTracker].goToJail();
						players[turnTracker].setCanRoll(false);
					}else if (mb.getSpace(players[turnTracker].getLocation()-1).equals("Chance")) {
							cards drawn = drawCard(Chance);
							System.out.println("The card you drew was : " + drawn.getText());
					} else if (mb.getSpace(players[turnTracker].getLocation()-1).equals("Community Chest")) {
							cards drawn = drawCard(CommunityChest);
							System.out.println("The card you drew was : " + drawn.getText());
							
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
					}
					break;
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
				case 9:
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
				case 6:
					Deeds chosenProperty = players[turnTracker].chooseAuctionProperty();
					
					break;
				}
			} while (choice != 3);
			players[turnTracker].flipRoll();
			players[turnTracker].setCanRoll(true);
			turnTracker++;
		} while (!isOver());
	}
	private static cards drawCard(ArrayList<cards> list) {
		int ranSpot = (int)(Math.random() * (list.size()));
		return list.get(ranSpot);
	}
	private static void addChanceCards() {
		 Chance.add(new cards("Advance to Go (Collect $200)"));
		 Chance.add(new cards("Advance to Go (Collect $200)"));
		 Chance.add(new cards("Advance to Illinois Ave. - If you pass Go, collect $200."));
		 Chance.add(new cards("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown."));
		 Chance.add(new cards("Advance to St. Charles Place – If you pass Go, collect $200"));
		 Chance.add(new cards("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank."));
		 Chance.add(new cards("Bank pays you dividend of $50."));
		 Chance.add(new cards("Get out of Jail Free – This card may be kept until needed, or traded/sold."));
		 Chance.add(new cards("Go Back 3 Spaces."));
		 Chance.add(new cards("Go to Jail – Go directly to Jail – Do not pass Go, do not collect $200."));
		 Chance.add(new cards("Make general repairs on all your property – $25 for each house $100 for each hotel"));
		 Chance.add(new cards("Pay poor tax of $15"));
		 Chance.add(new cards("Take a trip to Reading Railroad – If you pass Go, collect $200"));
		 Chance.add(new cards("Take a walk on the Boardwalk – Advance token to Boardwalk"));
		 Chance.add(new cards("You have been elected Chairman of the Board – Pay each player $50"));
		 Chance.add(new cards("Your building loan matures – Collect $150 "));
		 Chance.add(new cards("You have won a crossword competition - Collect $100"));
	}
	
	private static void addCommunityChestCards(){
		CommunityChest.add(new cards("Advance to Go (Collect $200)"));
		CommunityChest.add(new cards("Bank error in your favor – Collect $200"));
		CommunityChest.add(new cards("Doctor's fees– Pay $50"));
		CommunityChest.add(new cards("Get out of jail free – this card may be kept until needed, or traded/sold"));
		CommunityChest.add(new cards("Go to jail – go directly to jail – Do not pass Go, do not collect $200"));
		CommunityChest.add(new cards("It is your birthday Collect $10 from each player"));
		CommunityChest.add(new cards("Grand Opera Night – collect $50 from every player for opening night seats"));
		CommunityChest.add(new cards("Income Tax refund – collect $20"));
		CommunityChest.add(new cards("Life Insurance Matures – collect $100"));
		CommunityChest.add(new cards("Pay Hospital Fees of $100 "));
		CommunityChest.add(new cards("Pay School Fees of $50"));
		CommunityChest.add(new cards("Receive $25 Consultancy Fee"));
		CommunityChest.add(new cards("You are assessed for street repairs – $40 per house, $115 per hotel"));
		CommunityChest.add(new cards("You have won second prize in a beauty contest– collect $10"));
		CommunityChest.add(new cards("You inherit $100"));
		CommunityChest.add(new cards("From sale of stock you get $50"));
		CommunityChest.add(new cards("Holiday Fund matures - Receive $100"));
	}
	private static void jailDoublesRoll(int player) {
		Random genRan = new Random();
		int rollingDice1 = genRan.nextInt(6) + 1;
		int rollingDice2 = genRan.nextInt(6) + 1;
		if (rollingDice1 == rollingDice2) {
			System.out.println("You rolled doubles, you are no longer in jail.");
			players[player].getOutOfJail();
			players[player].setCanRoll(false);
			players[player].flipRoll();
		} else if (players[player].getJailTurn() == 3) {
			System.out.println("You didn't roll doubles and it is your third turn in jail.");
			System.out.println("You get out of jail, but have to pay $50");
			players[player].getOutOfJail();
			players[player].setCanRoll(false);
			players[player].pay(-50);
			players[player].flipRoll();
		} else {
			System.out.println("You didn't roll doubles.");
			players[player].incJailTurn();
			players[player].flipRoll();
			players[player].setCanRoll(false);
		}
	}

	private static void auction(Deeds sellProperty, thePlayer[] participants, thePlayer seller) throws IOException{
		ArrayList<thePlayer> nonParticipants = new ArrayList<thePlayer>();
		nonParticipants.add(seller);
		removeBidder(participants, seller.getPiece());
		String[] participantChoices ={"Bid", "Give Up" , "Look at Stats of Property"};
		String maxBidPlayer = "";
		int choice = -1;
		int maxBid = 0;
		while(maxBid == 0 || participants.length > 1){
			for(thePlayer curBidder : participants){
				System.out.println("What would you like to do?");
				choice = ConsoleUI.promptForMenuSelection(participantChoices, false);
				switch(choice){
				case 1:
					if(curBidder.getMoney() > maxBid){
					maxBid = ConsoleUI.promptForInt("How much would you like to bid?", maxBid + 1, curBidder.getMoney());
					maxBidPlayer = curBidder.getPiece();
					System.out.println(curBidder.getPiece() + " you bid $" + maxBid + ".");
					}else{
						System.out.println(curBidder.getPiece() + ", you are too poor to go on any more. You cannot compete in this auction.");
						nonParticipants.add(curBidder);
						participants = removeBidder(participants, curBidder.getPiece());
					}
				case 2:
					System.out.println(curBidder.getPiece() + ", you have quit this auction.");
					nonParticipants.add(curBidder);
					participants = removeBidder(participants, curBidder.getPiece());
				case 3:
					System.out.println("The Deed name is " + sellProperty.getName());
					System.out.println("The base rent is " + sellProperty.getCurRent());
					System.out.println("Houses and Hotels cost " + sellProperty.getHouseHotelCost());
					System.out.println("Mortgages for " + sellProperty.getMortgage());
				}
			}
			if(participants.length <= 1 && maxBid == 0){
				System.out.println("Someone has to buy the property, even if it's for $1");
				thePlayer[] tempPart = new thePlayer[nonParticipants.size()-1];
				for(int i =0; i<nonParticipants.size() ; i++){
					if(!nonParticipants.get(i).getPiece().equals(seller)){
						tempPart[i] = nonParticipants.get(i);
						nonParticipants.remove(i);
					}
				}
			}
		}
		System.out.println(maxBidPlayer + ", you have won the auction and bought " + sellProperty.getName() + " for " + maxBid);
		for(thePlayer player : participants){
			if(player.getPiece().equals(maxBidPlayer)){
				player.buyPiece(sellProperty);
			}
		}
		thePlayer[] tempArr = new thePlayer[participants.length + nonParticipants.size()];
		int i =0;
		for(thePlayer player : participants){
			tempArr[i] = player;
			i++;
		}for(thePlayer player : nonParticipants){
			tempArr[i] = player;
			i++;
		}
	participants = tempArr;
	}

	private static thePlayer[] removeBidder(thePlayer[] participants, String piece) {
		thePlayer[] tempArr = new thePlayer[participants.length-1];
		int placeTacker =0;
		for(thePlayer player : participants){
			if(!player.getPiece().equals(piece)){
			tempArr[placeTacker] = player;
			placeTacker ++;
			}
		}
		return tempArr;
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
		System.out.println("You rolled " + rollingDice1 + " and " + rollingDice2);

		if (rollingDice1 == rollingDice2) {
			doubles++;
			if (doubles == 3) {
				System.out.println("You rolled doubles three times and are now in jail.");
				players[player].goToJail();
				players[player].setCanRoll(false);
				doubles = 0;
			} else {
				System.out.println("Move " + (rollingDice1 + rollingDice2) + " spaces.");
				System.out.println("You rolled doubles, roll again.");
				players[player].move(sumOfRolls);
			}

		} else {
			doubles = 0;
			System.out.println("Move " + (rollingDice1 + rollingDice2) + " spaces.");
			players[player].move(sumOfRolls);
			players[player].flipRoll();
		}
	}

	public static boolean isOver() {
		return (players.length <= 1);
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
		notBuyableSpaces.add("Go");
		notBuyableSpaces.add("Income Tax");
		notBuyableSpaces.add("Chance");
		notBuyableSpaces.add("Community Chest");
		notBuyableSpaces.add("Luxury Tax");
		notBuyableSpaces.add("Free Parking");
		notBuyableSpaces.add("Go To Jail");
		notBuyableSpaces.add("Just Visiting / In Jail");
		notBuyableSpaces.add("In Jail");
	}
}
