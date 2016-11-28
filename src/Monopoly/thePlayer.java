package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ConsoleUI.ConsoleUI;

public class thePlayer {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private ArrayList<Deeds> ownedProperties = new ArrayList<Deeds>();
	private ArrayList<cards> ownedCards = new ArrayList<cards>();

	private gamePieces piece;
	private boolean hasRolled = false;
	private boolean playerInJail = false;
	private int jailTurnCounter = 0;
	private int money;
	private int location;

	public thePlayer() {
		money = 1500;
		location = 1;
	}
	
	
	// Thimble, Cannon, Hat, Dog, Battleship, Car, Shoe, Wheelbarrow
	public void setPiece(String playerPiece) {
		switch (playerPiece) {
		case "Thimble":
			piece = gamePieces.Thimble;
			break;
		case "Hat":
			piece = gamePieces.Hat;
			break;
		case "Cannon":
			piece = gamePieces.Cannon;
			break;
		case "Dog":
			piece = gamePieces.Dog;
			break;
		case "Battleship":
			piece = gamePieces.Battleship;
			break;
		case "Car":
			piece = gamePieces.Car;
			break;
		case "Shoe":
			piece = gamePieces.Shoe;
			break;
		case "Wheelbarrow":
			piece = gamePieces.Wheelbarrow;
			break;
		}
	}

	public String getPiece() {
		return piece.toString();
	}

	public void move(int numSpaces) {
		location += numSpaces;
		if (location > 40) {
			location -= 40;
			System.out.println("You have passed go. You collected $200");
			money += 200;
		}
	}

	public void flipRoll() {
		hasRolled = !hasRolled;
	}

	public void goToJail() {
		playerInJail = true;
	}

	public void getOutOfJail() {
		playerInJail = false;
	}

	public int getLocation() {
		return location;
	}

	public boolean getRolled() {
		return hasRolled;
	}

	public void mortgageMenu() throws IOException {
		String[] mortMenu = { "Mortgage", "Pay off mortgage" };
		System.out.println("What would you like to do?");
		int choice = ConsoleUI.promptForMenuSelection(mortMenu, false);
		if (ownedProperties.size() > 0) {
			switch (choice) {
			case 1:
				String[] stringProperties = new String[ownedProperties.size()];
				System.out.println("Which property would you like to mortgage?");
				int i = 0;
				for (Deeds item : ownedProperties) {
					stringProperties[i] = item.getName();
				}
				String property = ownedProperties.get(ConsoleUI.promptForMenuSelection(stringProperties, false))
						.getName();
			case 2:
			}
		}else{
			System.out.println("You don't have anything to mortgage.");
		}
	}

	public int getMoney() {
		return money;
	}

	public void pay(int amount){
		money += amount;
	}
	public void buyPiece(Deeds property) {
		ownedProperties.add(property);
		money -= property.getCurRent();
	}


	public boolean inJail() {
		return playerInJail;
	}


	public int getJailTurn() {
		return jailTurnCounter;
	}


	public void incJailTurn() {
	jailTurnCounter += 1;		
	}


	public void purchaseHouses() throws IOException {
		String[] tempPlayerDeeds = new String[ownedProperties.size()];
		int i =0;
		for(Deeds item : ownedProperties){
			tempPlayerDeeds[i] = item.getName();
			i++;
		}
		System.out.println("Which space would you like to buy a house for?");
		int chosenDeed = ConsoleUI.promptForMenuSelection(tempPlayerDeeds, true);
		if(chosenDeed == 0){
			return;
		}else{
			ownedProperties.get(chosenDeed).purchaseHouses();
		}
	}
	
	public void purchaseHotels() throws IOException {
		String[] tempPlayerDeeds = new String[ownedProperties.size()];
		int i =0;
		for(Deeds item : ownedProperties){
			tempPlayerDeeds[i] = item.getName();
			i++;
		}
		System.out.println("Which space would you like to buy a hotel for?");
		int chosenDeed = ConsoleUI.promptForMenuSelection(tempPlayerDeeds, true);
		if(chosenDeed == 0){
			return;
		}else{
			ownedProperties.get(chosenDeed).purchaseHotels();
		}
	}
}
