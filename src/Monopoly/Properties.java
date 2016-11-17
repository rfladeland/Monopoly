package Monopoly;

import java.util.ArrayList;

public class Properties {

	private int houseHotelPurchasePrice;
	private String color = "";
	private Deeds deed = null;

	public void listOfProperties() {

		ArrayList<String> brown = new ArrayList<String>();
		ArrayList<String> lightBlue = new ArrayList<String>();
		ArrayList<String> pink = new ArrayList<String>();
		ArrayList<String> orange = new ArrayList<String>();
		ArrayList<String> red = new ArrayList<String>();
		ArrayList<String> yellow = new ArrayList<String>();
		ArrayList<String> green = new ArrayList<String>();
		ArrayList<String> darkBlue = new ArrayList<String>();
		ArrayList<String> railroad = new ArrayList<String>();
		ArrayList<String> utilities = new ArrayList<String>();

		brown.add("Mediterranean Avenue");
		brown.add("Baltic Avenue");

		lightBlue.add("Oriental Avenue");
		lightBlue.add("Vermont Avenue");
		lightBlue.add("Connecticut Avenue");

		pink.add("St. Charles Place");
		pink.add("States Avenue");
		pink.add("Virginia Avenue");

		orange.add("St. James Place");
		orange.add("Tennessee Avenue");
		orange.add("New York Avenue");

		red.add("Kentucky Avenue");
		red.add("Indiana Avenue");
		red.add("Illinios Avenue");

		yellow.add("Atlantic Avenue");
		yellow.add("Ventnor Avenue");
		yellow.add("Marvin Gardens");

		green.add("Pacific Avenue");
		green.add("North Carolina Avenue");
		green.add("Pennsylvania Avenue");

		darkBlue.add("Park Place");
		darkBlue.add("Boardwalk");

		railroad.add("Reading Railroad");
		railroad.add("Pennsylvania Railroad");
		railroad.add("B.& O. Railroad");
		railroad.add("Short Line");

		utilities.add("Electric Company");
		utilities.add("Water Works");
	}

	public int brownAndLightBlueHousePrice() {

		houseHotelPurchasePrice = 50;

		return houseHotelPurchasePrice;
	}

	public int orangeAndPinkHousePrice() {

		houseHotelPurchasePrice = 100;

		return houseHotelPurchasePrice;
	}

	public int redAndYellowHousePrice() {

		houseHotelPurchasePrice = 150;

		return houseHotelPurchasePrice;
	}

	public int greenAndDarkBlueHousePrice() {

		houseHotelPurchasePrice = 200;

		return houseHotelPurchasePrice;
	}

	public int getHouseHotelPurchasePrice() {
		return houseHotelPurchasePrice;
	}

	public void setHouseHotelPurchasePrice(int housePurchasePrice) {
		this.houseHotelPurchasePrice = housePurchasePrice;
	}

}
