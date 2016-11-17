package Monopoly;

import java.io.IOException;

import ConsoleUI.ConsoleUI;

public class Deeds {

	private String name = "";
	private int location;
	private int numOfHouses;
	private int numOfHotels;
	private int purchasePrice;
	private int houseHotelPurchasePrice;
	private int rent;
	private int house1Rent;
	private int house2Rent;
	private int mortgage;
	private boolean isTaken = false;

	public Deeds(String title, int loc, int price, int startRent, int costPerHouse, int house1, int house2, int house3,
			int house4, int hotel, int mortgagePrice) {
		name = title;
		location = loc;
		purchasePrice = price;
		rent = startRent;
		houseHotelPurchasePrice = costPerHouse;
		house1Rent = house1;

	}

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

	public boolean amITaken() {

		return isTaken;
	}

	public void takenFlip() {
		isTaken = !isTaken;
	}

}
