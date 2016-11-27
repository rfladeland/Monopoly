package Monopoly;

import java.util.ArrayList;

public class monoBoard {
	private ArrayList<String> board = new ArrayList<String>();
//	[go][02][03][04][05][06][07][08][09][10][11](jail / passing jail)
//	[40]                              		[12]
//	[39]				      				[13]
//	[38]	   			      				[14]
//	[37]				      				[15]
//	[36]	   [Jail]  	      				[16]
//	[35]		   		   		 			[17]
//	[34]				   		  			[18]
//	[33]				     				[19]
//	[32]				     				[20]
//	[31][30][29][28][27][26][25][24][23][22][21]
//	go to				  					free
//	jail				  					parking
	
	public monoBoard(){
		board.add("Go");
		board.add("Mediteranean Avenue");
		board.add("Community Chest");
		board.add("Baltic Avenue");
		board.add("Income Tax");
		board.add("Reading Railroad");
		board.add("Oriental Avenue");
		board.add("Chance");
		board.add("Vermont Avenue");
		board.add("Connecticut Avenue");
		board.add("Just Visiting / In Jail");
		board.add("St. Charles Place");
		board.add("Electric Company");
		board.add("States Avenue");
		board.add("Virginia Avenue");
		board.add("Pennsylvania Railroad");
		board.add("St. James Place");
		board.add("Community Chest");
		board.add("Tennessee Avenue");
		board.add("New York Avenue");
		board.add("Free Parking");
		board.add("Kentucky Avenue");
		board.add("Chance");
		board.add("Indiana Avenue");
		board.add("Illinois Avenue");
		board.add("B & Q Railroad");
		board.add("Atlantic Avenue");
		board.add("Ventor Avenue");
		board.add("Water Works");
		board.add("Marvin Gardens");
		board.add("Go To Jail");
		board.add("Pacific Avenue");
		board.add("North Carolina Avenue");
		board.add("Community Chest");
		board.add("Pennsylvania Avenue");
		board.add("Short Line");
		board.add("Chance");
		board.add("Park Place");
		board.add("Luxury Tax");
		board.add("Boardwalk");
	}
	public String getSpace(int space){
		return board.get(space);
	}
}
