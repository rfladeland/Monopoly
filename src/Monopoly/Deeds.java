package Monopoly;

import java.io.IOException;

import ConsoleUI.ConsoleUI;

public class Deeds {
	private String color = "";
	private String name = "";
	private int location;
	private int numOfHouses;
	private int numOfHotels;
	private int purchasePrice;
	private int houseHotelPurchasePrice;
	private int curRent;
	private int rent;
	private int house1Rent;
	private int house2Rent;
	private int house3Rent;
	private int house4Rent;
	private int hotelRent;
	private int twoOwnedRent;
	private int threeOwnedRent;
	private int fourOwnedRent;
	private int mortgage;
	private boolean isMortgaged = false;
	private boolean isTaken = false;

	// Constructor for regular properties
	public Deeds(String title, String deedColor, int loc, int price, int startRent, int costPerHouse, int house1,
			int house2, int house3, int house4, int hotel, int mortgagePrice, boolean owned) {

		name = title;
		color = deedColor;
		location = loc;
		purchasePrice = price;
		curRent = startRent;
		rent = startRent;
		houseHotelPurchasePrice = costPerHouse;
		house1Rent = house1;
		house2Rent = house2;
		house3Rent = house3;
		house4Rent = house4;
		hotelRent = hotel;
		mortgage = mortgagePrice;
		isTaken = owned;

	}

	// Constructor for railroads
	public Deeds(String title, String deedColor, int loc, int price, int startRent, int twoRent, int threeRent,
			int fourRent, int mortgagePrice, boolean owned) {

		name = title;
		color = deedColor;
		location = loc;
		purchasePrice = price;
		rent = startRent;
		twoOwnedRent = twoRent;
		threeOwnedRent = threeRent;
		fourOwnedRent = fourRent;
		mortgage = mortgagePrice;
		curRent = startRent;
		isTaken = owned;
	}

	// Constructor for utilities
	public Deeds(String title, String deedColor, int loc, int price, int startRent, int twoRent, int mortgagePrice, boolean owned) {

		name = title;
		color = deedColor;
		location = loc;
		purchasePrice = price;
		curRent = startRent;
		rent = startRent;
		twoOwnedRent = twoRent;
		mortgage = mortgagePrice;
		isTaken = owned;
	}

	// Method for purchasing houses, may need more work
	public void purchaseHouses() throws IOException {

		numOfHouses = ConsoleUI.promptForInt("How many houses would you like to purchase?", 0, 4);

		purchasePrice = houseHotelPurchasePrice * numOfHouses;

		System.out.println(
				"You have purchased " + numOfHouses + " houses, and the total cost was " + purchasePrice + " dollars.");

	}

	// Method for purchasing hotels, may need more work
	public void purchaseHotels() throws IOException {
		numOfHotels = ConsoleUI.promptForInt("How many hotels would you like to purchase?", 0, 1);
		if (numOfHotels == 1) {
			purchasePrice = houseHotelPurchasePrice * numOfHotels;
			System.out.println("You have purchased one hotel for " + purchasePrice + " dollars.");
		} else {
			System.out.println("You didn't buy a hotel.");
		}
	}

	public void setRent(int house, int hotel) {
		if (hotel == 0) {
			switch (house) {
			case 1:
				curRent = house1Rent;
				break;
			case 2:
				curRent = house2Rent;
				break;
			case 3:
				curRent = house3Rent;
				break;
			case 4:
				curRent = house4Rent;
				break;
			}
		} else {
			curRent = hotelRent;
		}
	}

	// Determines if the property is owned or not
	public boolean amIOwned() {
		return isTaken;

	}
	
	public int getPrice(){
		return purchasePrice;
	}

	// Flips the property from owned to not owned and vice-versa when called
	public void takenFlip() {

		isTaken = !isTaken;
	}

	public String getName() {
		return name;
	}

	// Finds what space on the board the player lands on
	public int getLocation() {
		return location;
	}

	// gets rent
	public int getCurRent() {
		return curRent;
	}

	public String getColor() {
		return color;
	}

	public int getMortgage() {
		return mortgage;
	}

	public void unMortgage() {
		isMortgaged = false;
	}

	public void mortgage() {
		isMortgaged = true;
	}
}
