package Monopoly;

import java.util.ArrayList;

public class Banker {
private ArrayList<Deeds> properties = new ArrayList<Deeds>();	

//[go][02][03][04][05][06][07][08][09][10][11](jail / passing jail)
//[40]                             		  [12]
//[39]			    				 	  [13]
//[38]	   		      				 	  [14]
//[37]				      				  [15]
//[36]	   [Jail]  	      				  [16]
//[35]		   		   		 			  [17]
//[34]				   		  			  [18]
//[33]				     				  [19]
//[32]				     				  [20]
//[31][30][29][28][27][26][25][24][23][22][21]
//go to				  					free
//jail				  					parking


public Banker(){
	// Makes new deed
	// call with new Deeds(String title, int loc, int price, int startRent, int costPerHouse,
	//int house1, int house2, int house3, int house4, int hotel, int mortgagePrice
	properties.add(new Deeds( "Mediteranean Avenue" , 2, 60, 2, 50, 10, 30, 90, 160, 250, 30));
}
}
