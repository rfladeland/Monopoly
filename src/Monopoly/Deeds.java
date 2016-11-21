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
	private int spaceOnBoard;
	private int house1Rent;
	private int house2Rent;
	private int house3Rent;
	private int house4Rent;
	private int hotelRent;
	private int twoOwnedRent;
	private int threeOwnedRent;
	private int fourOwnedRent;
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
		house2Rent = house2;
		house3Rent = house3;
		house4Rent = house4;
		hotelRent = hotel;
		mortgage = mortgagePrice;

	}

	public Deeds(String title, int loc, int price, int startRent, int twoRent, int threeRent, int fourRent,
			int mortgagePrice) {

		name = title;
		location = loc;
		purchasePrice = price;
		rent = startRent;
		twoOwnedRent = twoRent;
		threeOwnedRent = threeRent;
		fourOwnedRent = fourRent;
		mortgage = mortgagePrice;

	}

	public Deeds(String title, int loc, int price, int startRent, int twoRent, int mortgagePrice) {

		name = title;
		location = loc;
		purchasePrice = price;
		rent = startRent;
		twoOwnedRent = twoRent;
		mortgage = mortgagePrice;

	}

	public void purchaseHouses() throws IOException {

		numOfHouses = ConsoleUI.promptForInt("How many houses would you like to purchase?", 0, 4);

		purchasePrice = houseHotelPurchasePrice * numOfHouses;

		System.out.println(
				"You have purchased " + numOfHouses + " houses, and the total cost was " + purchasePrice + " dollars.");

	}

	public void purchaseHotels() throws IOException {
		numOfHotels = ConsoleUI.promptForInt("How many hotels would you like to purchase?", 0, 1);

		purchasePrice = houseHotelPurchasePrice * numOfHotels;

		System.out.println(
				"You have purchased " + numOfHotels + " hotels, and the total cost was " + purchasePrice + " dollars.");

	}

	public boolean amIOwned() {

		if (owned) {
			return true;
		} else
			return false;

		return isTaken;

	}

	public void takenFlip() {
		isTaken = !isTaken;
	}

	public int rent() {

		return rent;
	}

	public int spaceOnBoard() {

		return spaceOnBoard;
	}

}
