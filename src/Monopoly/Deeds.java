package Monopoly;

import java.io.IOException;

import ConsoleUI.ConsoleUI;

public class Deeds {

	private int numOfHouses;
	private int numOfHotels;
	private int purchasePrice;
	private int houseHotelPurchasePrice;
	private int rent;
	private int spaceOnBoard;

	public int purchaseHouses() throws IOException {

		numOfHouses = ConsoleUI.promptForInt("How many houses would you like to purchase?", 0, 4);

		purchasePrice = houseHotelPurchasePrice * numOfHouses;

		System.out.println(
				"You have purchased " + numOfHouses + " houses, and the total cost was " + purchasePrice + " dollars.");

		return purchasePrice;
	}

	public int purchaseHotels() throws IOException {
		numOfHotels = ConsoleUI.promptForInt("How many hotels would you like to purchase?", 0, 1);

		purchasePrice = houseHotelPurchasePrice * numOfHotels;

		System.out.println(
				"You have purchased " + numOfHotels + " hotels, and the total cost was " + purchasePrice + " dollars.");

		return purchasePrice;
	}

	public boolean amIOwned() {

		if (owned) {
			return true;
		} else
			return false;
	}

	public boolean take() {

		return false;
	}

	public int rent() {

		return rent;
	}
	
	public int spaceOnBoard() {
		
		
		return spaceOnBoard;
	}

}
