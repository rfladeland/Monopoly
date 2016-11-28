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
		location = 41;
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
		} else {
			System.out.println("You don't have anything to mortgage.");
		}
	}

	public int getMoney() {
		return money;
	}

	public void pay(int amount) {
		money += amount;
	}

	public void buyPiece(Deeds property) {
		System.out.println("You paid " + property.getPrice() + " for " + property.getName());
		ownedProperties.add(property);
		money -= property.getPrice();
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
		int i = 0;
		for (Deeds item : ownedProperties) {
			tempPlayerDeeds[i] = item.getName();
			i++;
		}
		System.out.println("Which space would you like to buy a house for?");
		int chosenDeed = ConsoleUI.promptForMenuSelection(tempPlayerDeeds, true);
		if (chosenDeed == 0) {
			return;
		}
		if (ownedProperties.get(chosenDeed).getHouse() < 4) {
			if (money >= ownedProperties.get(chosenDeed).getHouseHotelCost()) {
				if (ownedProperties.get(chosenDeed).getColor().equals("Black")
						|| ownedProperties.get(chosenDeed).getColor().equals("White")) {
					System.out.println("Sorry, but you cannot build a hpuse on this space.");
				} else if (ownedProperties.get(chosenDeed).getColor().equals("Brown")) {
					for (Deeds item : ownedProperties) {
						if (item.getColor().equals("Brown")
								&& !(item.getName().equals(ownedProperties.get(chosenDeed).getName()))
								&& item.getHouse() <= ownedProperties.get(chosenDeed).getHouse()) {
							if (ownedProperties.get(chosenDeed).getHouse() < 4) {
								money -= ownedProperties.get(chosenDeed).getHouseHotelCost();
								ownedProperties.get(chosenDeed).purchaseHouses();
							} else {
								System.out.println("You already have 4 houses here and cannot build any more.");
							}
						}
						System.out.println("You cannot build a house here.");
					}
				} else if (ownedProperties.get(chosenDeed).getColor().equals("Dark Blue")) {
					for (Deeds item : ownedProperties) {
						if (item.getColor().equals("Dark Blue")
								&& !(item.getName().equals(ownedProperties.get(chosenDeed).getName()))
								&& item.getHouse() <= ownedProperties.get(chosenDeed).getHouse()) {
							if (ownedProperties.get(chosenDeed).getHouse() < 4) {
								money -= ownedProperties.get(chosenDeed).getHouseHotelCost();
								ownedProperties.get(chosenDeed).purchaseHouses();
							} else {
								System.out.println("You already have 4 houses here and cannot build any more.");
							}
						}
						System.out.println("You cannot build a house here.");

					}
				} else {
					int propTracker = 1;
					for (Deeds item : ownedProperties) {
						if (item.getColor().equals(ownedProperties.get(chosenDeed).getColor())
								&& !(item.getName().equals(ownedProperties.get(chosenDeed).getName()))) {
							propTracker += 1;
						}
					}
					if (propTracker == 3) {
						int minHousesIndex = chosenDeed;
						for (i = 0; i < ownedProperties.size(); i++) {
							if (ownedProperties.get(i).getColor().equals(ownedProperties.get(chosenDeed).getColor())
									&& !(ownedProperties.get(i).getName()
											.equals(ownedProperties.get(chosenDeed).getName()))
									&& ownedProperties.get(i).getHouse() < ownedProperties.get(chosenDeed).getHouse()) {
								minHousesIndex = i;
							}

						}
						if (minHousesIndex == chosenDeed) {
							System.out.println(
									"You bought a house for $" + ownedProperties.get(chosenDeed).getHouseHotelCost());
							money -= ownedProperties.get(chosenDeed).getHouseHotelCost();
							ownedProperties.get(chosenDeed).purchaseHouses();
						} else {
							System.out.println(
									"You cannot build a house here because you have to build houses evenly across all same colored spaces.");
						}
					} else {
						System.out.println("You cannot build a house here because you do not own all three "
								+ ownedProperties.get(chosenDeed).getColor().toLowerCase() + " spaces.");
					}
				}
			}
		} else {
			System.out.println("You cannot build a house here because there are already 4 houses here.");
		}
	}

	public void purchaseHotels() throws IOException {
		String[] tempPlayerDeeds = new String[ownedProperties.size()];
		int i = 0;
		for (Deeds item : ownedProperties) {
			tempPlayerDeeds[i] = item.getName();
			i++;
		}
		System.out.println("Which space would you like to buy a hotel for?");
		int chosenDeed = ConsoleUI.promptForMenuSelection(tempPlayerDeeds, true);
		if (chosenDeed == 0) {
			return;
		} else {
			if (money >= ownedProperties.get(chosenDeed).getHouseHotelCost()) {
				if (ownedProperties.get(chosenDeed).getHotel() == 0) {
					if (ownedProperties.get(chosenDeed).getColor().equals("Black")
							|| ownedProperties.get(chosenDeed).getColor().equals("White")) {
						System.out.println("Sorry, but you cannot build a hotel on this space.");
					} else if (ownedProperties.get(chosenDeed).getColor().equals("Brown")) {
						for (Deeds item : ownedProperties) {
							if (item.getColor().equals("Brown")
									&& !(item.getName().equals(ownedProperties.get(chosenDeed).getName()))
									&& item.getHouse() == 4) {
								money -= ownedProperties.get(chosenDeed).getHouseHotelCost();
								ownedProperties.get(chosenDeed).purchaseHotels();
							}
							System.out.println("You cannot build a hotel here.");
						}
					} else if (ownedProperties.get(chosenDeed).getColor().equals("Dark Blue")) {
						for (Deeds item : ownedProperties) {
							if (item.getColor().equals("Dark Blue")
									&& !(item.getName().equals(ownedProperties.get(chosenDeed).getName()))
									&& item.getHouse() == 4) {
								money -= ownedProperties.get(chosenDeed).getHouseHotelCost();
								ownedProperties.get(chosenDeed).purchaseHotels();
							}
							System.out.println("You cannot build a hotel here.");

						}
					} else {
						int propTracker = 1;
						for (Deeds item : ownedProperties) {
							if (item.getColor().equals(ownedProperties.get(chosenDeed).getColor())
									&& !(item.getName().equals(ownedProperties.get(chosenDeed).getName()))
									&& item.getHouse() == 4) {
								propTracker += 1;
							}
						}
						if (propTracker == 3) {
							money -= ownedProperties.get(chosenDeed).getHouseHotelCost();
							ownedProperties.get(chosenDeed).purchaseHotels();
						} else {
							System.out.println("You cannot build a hotel here.");
						}
					}
				} else {
					System.out.println("You already have a hotel here, you cannot build another one.");
				}
			} else {
				System.out.println("You are too poor to afford a hotel.");
			}
		}
	}
}