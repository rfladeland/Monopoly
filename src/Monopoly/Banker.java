package Monopoly;

import java.util.ArrayList;

public class Banker {
	private ArrayList<Deeds> properties = new ArrayList<Deeds>();

	// [go][02][03][04][05][06][07][08][09][10][11](jail / passing jail)
	// [40] 								   [12]
	// [39] 							       [13]
	// [38] 								   [14]
	// [37] 								   [15]
	// [36] [Jail] 							   [16]
	// [35] 								   [17]
	// [34] 								   [18]
	// [33] 								   [19]
	// [32] 								   [20]
	// [31][30][29][28][27][26][25][24][23][22][21]
	// go to 									free
	// jail 									parking

	public Banker() {
		// Makes new deed
		// call with new Deeds(String title, int loc, int price, int startRent,
		// int costPerHouse,
		// int house1, int house2, int house3, int house4, int hotel, int
		// mortgagePrice
		
		//Brown
		properties.add(new Deeds("Mediteranean Avenue","Brown", 2, 60, 2, 50, 10, 30, 90, 160, 250, 30, false));
		properties.add(new Deeds("Baltic Avenue", "Brown", 4, 60, 4, 50, 20, 60, 180, 320, 450, 30, false));
		
		//Light Blue
		properties.add(new Deeds("Oriental Avenue", "Light Blue", 7, 100, 6, 50, 30, 90, 270, 400, 550, 50, false));
		properties.add(new Deeds("Vermont Avenue", "Light Blue", 9, 100, 6, 50, 30, 90, 270, 400, 550, 50, false));
		properties.add(new Deeds("Connecticut Avenue", "Light Blue", 10, 120, 8, 50, 40, 100, 300, 450, 600, 60, false));
		
		//Violet
		properties.add(new Deeds("St. Charles Place", "Violet", 12, 140, 10, 100, 50, 150, 450, 625, 750, 70, false));
		properties.add(new Deeds("States Avenue", "Violet", 14, 140, 10, 100, 50, 150, 450, 625, 750, 70, false));
		properties.add(new Deeds("Virginia Avenue", "Violet", 15, 160, 12, 100, 60, 180, 500, 700, 900, 80, false));
		
		//Orange
		properties.add(new Deeds("St. James Place", "Orange", 17, 180, 14, 100, 70, 200, 550, 750, 950, 90, false));
		properties.add(new Deeds("Tennessee Avenue", "Orange", 19, 180, 14, 100, 70, 200, 550, 750, 950, 90, false));
		properties.add(new Deeds("New York Avenue", "Orange", 20, 200, 16, 100, 80, 220, 600, 800, 1000, 100, false));
	
		//Red
		properties.add(new Deeds("Kentucky Avenue", "Red", 22, 220, 18, 150, 90, 250, 700, 875, 1050, 110, false));
		properties.add(new Deeds("Indiana Avenue", "Red", 24, 220, 18, 150, 90, 250, 700, 875, 1050, 110, false));
		properties.add(new Deeds("Illinois Avenue", "Red", 25, 240, 20, 150, 100, 300, 750, 925, 1100, 120, false));
		
		//Yellow
		properties.add(new Deeds("Atlantic Avenue", "Yellow", 27, 260, 22, 150, 110, 330, 800, 975, 1150, 130, false));
		properties.add(new Deeds("Ventnor Avenue", "Yellow", 29, 260, 22, 150, 110, 330, 800, 975, 1150, 130, false));
		properties.add(new Deeds("Marvin Gardens", "Yellow", 30, 280, 24, 150, 120, 360, 850, 1025, 1200, 140, false));
	
		//Green
		properties.add(new Deeds("Pacific Avenue", "Green", 32, 300, 26, 200, 130, 390, 900, 1100, 1275, 150, false));
		properties.add(new Deeds("North Caroline Avenue", "Green", 34, 300, 26, 200, 130, 390, 900, 1100, 1275, 150, false));
		properties.add(new Deeds("Pennsylvania Avenue", "Green", 35, 320, 28, 200, 150, 450, 1000, 1200, 1400, 160, false));
		
		//Dark Blue
		properties.add(new Deeds("Park Place", "Dark Blue", 38, 350, 35, 200, 175, 500, 1100, 1300, 1700, 175, false));
		properties.add(new Deeds("Boardswalk", "Dark Blue", 40, 400, 50, 200, 200, 600, 1400, 1700, 200, 200, false));
		
		//Railroads
		properties.add(new Deeds("Reading Railroad", "White", 6, 200, 25, 50, 100, 200, 100, false));
		properties.add(new Deeds("Pennsylvania Railroad", "White", 16, 200, 25, 50, 100, 200, 100, false));
		properties.add(new Deeds("B. & O. Railroad", "White", 26, 200, 25, 50, 100, 200, 100, false));
		properties.add(new Deeds("Short Line", "White", 36, 200, 25, 50, 100, 200, 100, false));

		//Utilities
		properties.add(new Deeds("Electric Company", "Black", 13, 150, 1, 10, 75, false));
		properties.add(new Deeds("Water Works", "Black", 29, 150, 1, 10, 75, false));

	}
	
	public Deeds sellProperty(int location){
		for(int i =0; i<properties.size(); i++){
			if(properties.get(i).getLocation() == location){
			return properties.get(i);	
			}
		}
		return null;
	}

	public void removePiece(int location) {
		for(int i =0; i<properties.size(); i++){
			if(properties.get(i).getLocation() == location){
			properties.get(i).takenFlip();	
			}
		}
	}
}
