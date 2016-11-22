package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ConsoleUI.ConsoleUI;
public class monoMenu {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// menu to start Monopoly
	public void menu() throws IOException {
		final int MAX_PLAYERS = 8;
		final int MIN_PLAYERS = 2;
		String[] options = { "Rules", "Start", "Credits" };
		boolean quit = false;
		while (!quit) {
			int menu = (ConsoleUI.promptForMenuSelection(options, true));
			if (menu == 1) {
				theRules();
			} else if (menu == 2) {
				int inputNumberOfPlayers = ConsoleUI.promptForInt("How many people will be playing?", MIN_PLAYERS, MAX_PLAYERS);
				System.out.println("There are " + inputNumberOfPlayers + " players for this game.");
				monopolyRunner mR = new monopolyRunner();
				mR.pickingGamePiece(inputNumberOfPlayers);
			} else if (menu == 3) {
				System.out.println("Christain Griffus");
				System.out.println("Jeremy Currie");
				System.out.println("Russell Fladeland");
				System.out.println("Tien Cu");
				System.out.println("Press enter to go Back to Menu");
				in.readLine();
				quit = false;
			} else if (menu == 0) {
				System.out.println("You quit Monopoly");
				quit = true;
			}
		}	
	}

	public void theRules() throws IOException {
		System.out.println("What do you need to know?");
		boolean ruleQuit = false;
		while(!ruleQuit){
			String[] rules = { "Object", "Preparation", "Banker", "The Bank", "The Play", "'Go'", "Buying Properties",
				"Paying Rent", "'Chance' and 'Community Chest' Cards", "Income Tax", "Jail", "'Free Parking'", "Houses",
				"Hotels", "Selling Properties", "Mortgages", "Bankruptcy", "Miscellaneous", "Back to Menu" };
			int ruleSelect = ConsoleUI.promptForMenuSelection(rules, ruleQuit);
			if (ruleSelect == 1) {
				// explains object
				System.out.println(" The object of the game is to become the wealthiest player through "
						+ "buying, renting and selling property.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 2) {
				// explains preparation
				System.out.println(" Place the board on a table and put the Chance "
						+ "and Community Chest cards facedown on their allotted " + "spaces on the\n board. "
								+ "Each player chooses one token to represent him/her while traveling around " + "the board.");
				System.out.println("");
				System.out.println(" Each player is given $1,500");
				System.out.println("");
				System.out.println(" All remaining money and other equipment go to the Bank.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 3) {
				// explains banker
				System.out.println(" Select as Banker a player who will also make a good Auctioneer. \n A Banker "
						+ "who plays in the game must keep his/her personal funds separate from those of the Bank. "
						+ "\n When more than five persons play, the Banker may elect to act only as Banker and "
						+ "Auctioneer. \n In this case the computer will automatically be the Banker.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 4) {
				// explains the bank
				System.out.println(" Besides the Bank's money, the Bank holds the Title Deed cards and houses and "
						+ "hotels prior to purchase and use by the \n players. \n The Bank pays salaries and bonuses. "
						+ "\n It sells and auctions properties and hands out their proper Title Deed cards; \n it sells "
						+ "houses and hotels to the players and loans money when required on mortgages.");
				System.out.println("");
				System.out.println(" The Bank collects all taxes, fines, loans and interest, and the price of all "
						+ "properies which it sells and auctions.");
				System.out.println("");
				System.out.println(" The Bank never 'goes broke'. If the Bank runs out of money, the Banker may "
						+ "issue as much more as needed by writing on\n any ordinary paper.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 5) {
				// explains the play
				System.out.println(" Starting with the Banker, each player in turn throws the dice. \n The player with "
						+ "the highest total starts the play: Place your token on the corner marked 'GO', \n throw the "
						+ "dice and move your token in the direction of the arrow the number of spaces indicated by "
						+ "the dice. \n After you have completed your play, the turn passes to the left.\n The tokens "
						+ "remain on the spaces occupied and proceed from that point on the player's next turn. "
						+ "\n Two or more tokens may rest on the same space at the same time.");
				System.out.println("");
				System.out.println(" According to the space your token reaches, you may be entitled to buy real "
						+ "estate or other properties -- or obliged to\n pay rent, pay taxes, draw a Chance or "
						+ "Community Chest card, 'Go to Jail', etc.");
				System.out.println("");
				System.out.println(" If you throw doubles, you move your token as usual, the sum of the two dice, "
						+ "and are subject to any privileges or\n penalties pertaining to the space on which you land. "
						+ "Retaining the dice, throw again and move your token as before.\n If you throw doubles "
						+ "three times in succession, move your token immediately to the space marked 'In Jail' (See Jail).");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 6) {
				// explains go
				System.out.println(" Each time a player's token lands on or passes over GO, whether by throwing "
						+ "the dice or drawing a card, the Banker pays\n him/her a $200 salary.");
				System.out.println("");
				System.out.println(" The $200 is paid only once each time around the board.\n However, if a player "
						+ "passing GO on the throw of the dice lands 2 spaces beyond it on Community Chest, or 7 "
						+ "spaces\n beyond it on Chance, and draws the 'Advance to GO' card, he/she collects $200 for "
						+ "passing GO the first time and\n another $200 for reaching it the second time by instructions "
						+ "on the card.");
				System.out.println("");
				System.out.println("Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 7) {
				// explains buying properties
				System.out.println(" Whenever you land on an unowned property you may buy that property from the "
						+ "Bank at its printed price.\n You receive the Title Deed card showing ownership;\n place it "
						+ "face-up in front of you.");
				System.out.println("");
				System.out.println(" If you do not wish to buy the property, the Banker sells it at auction to the "
						+ "highest bidder.\n They buyer pays the Bank the amount of the bid in cash and receives the "
						+ "Title Deed card for that property.\n Any player, including the one who declined the option to "
						+ "buy it at the printed price, may bid.\n Bidding may start at any price.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 8) {
				// explains paying rent
				System.out.println(" When you land on property owned by another player, the owner collects rent "
						+ "from you in accordance with the list\n printed on its Title Deed card.");
				System.out.println("");
				System.out.println(" If the property is mortgaged, no rent can be collected.\n When a property is mortgaged, "
						+ "its Title Deed card is placed face-down in front of the owner.");
				System.out.println("");
				System.out.println(" It is an advantage to hold all the Title Deed cards in a color-group (e.g., "
						+ "Boardwalk and Park Place; or Connecticut,\n Vermont and Oriental Avenue) because the owner may then charge "
						+ "double rent for unimproved properties even if another\n property in that color-group is mortgaged.");
				System.out.println("");
				System.out.println(" It is even more advantageous to have houses or hotels on properties because "
						+ "rents are much higher than for unimproved\n properties.");
				System.out.println("");
				System.out.println(" The owner may not collect the rent if he/she fails to ask for it before the "
						+ "second player following throws the dice.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 9) {
				// explains Chance and Community Chest
				System.out.println(" When you land on either of these spaces, take the top card from the deck "
						+ "indicated, follow the instructions and return\n the card facedown to the bottom of the "
						+ "deck.");
				System.out.println("");
				System.out.println(" The 'Get Out of Jail Fee' card is held until used and then returned to the "
						+ "bottom of the deck.\n If the player who draws it does not wish to use it, he/she may sell "
						+ "it, at any time, to another player at a price\n agreeable to both.");
				System.out.println("");
				System.out.println("Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 10) {
				// explains Income Tax
				System.out.println(" If you land here you have two options:\n You may estimate your tax at $200 and "
						+ "pay the Bank, or you may pay 10% of your total worth to the Bank.\n Your total worth is "
						+ "all your cash on hand, printed prices of mortgaged and unmortgaged properties and cost "
						+ "price of\n all buildings you own.");
				System.out.println("");
				System.out.println(" You must decide which option you will take before you add up your total worth.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 11) {
				// explains jail
				System.out.println(" You land in Jail when... \n (1) your token lands on the space marked 'Go to "
						+ "Jail'; \n (2) you draw a card marked 'Go to Jail'; or \n (3) you thow doubles three times in succession");
				System.out.println("");
				System.out.println(" When you are sent to Jail you cannot collect your $200 salary in that move "
						+ "since, regardless of where your token is on\n the board, you must move it directly into " + "Jail. Your turn ends when you are sent to Jail.");
				System.out.println("");
				System.out.println(" If you are not 'sent' to Jail but in the ordinary course of play land on that "
						+ "space, you are 'Just Visiting',\n you incur no penalty, and you move ahead in the usual "
						+ "manner on your next turn.");
				System.out.println("");
				System.out.println(" You get out of Jail by... \n (1) throwing doubles on any of your next three turns; "
						+ "if you succeed in doing this you immediately move forward the\n     number of spaces shown by your "
						+ "doubles throw; even though you had thrown doubles, you do not take another turn; \n (2) using "
						+ "the 'Get Out of Jail Free' card if you have it; \n (3) purchasing the 'Get Out of Jail Free' card "
						+ "from another player and playing it; \n (4) paying a fine of $50 before you roll the dice on either "
						+ "of your next two turns.");
				System.out.println("");
				System.out.println(" If you do not throw doubles by your third turn, you must pay the $50 fine. "
						+ "\n You then get out of Jail and immediately move forward the number of spaces shown by your "
						+ "throw.");
				System.out.println("");
				System.out.println(" Even though you are in Jail, you may buy and sell property, buy and sell houses "
						+ "and hotels and collect rents.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 12) {
				// explains free parking
				System.out.println(" A player landing on this place does not receive any money, property or reward of any "
						+ "kind.\n This is just a 'free' resting place.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 13) {
				// explains houses
				System.out.println(" When you own all the properties in a color-group you may buy houses from the Bank "
						+ "and erect them on those properties.");
				System.out.println("");
				System.out.println(" If you buy one house, you may put it on any one of those properties.\n The next "
						+ "house you buy must be erected on one of the unimproved properties of this or any other "
						+ "complete color-group\n you may own.");
				System.out.println("");
				System.out.println(" The price you must pay the Bank for each house is shown on your Title Deed card "
						+ "for the property on which you erect\n the house.");
				System.out.println("");
				System.out.println(" The owner still collects double rent from an opponent who lands on the unimproved "
						+ "properties of his/her complete\n color-group.");
				System.out.println("");
				System.out.println(" Following the above rules, you may buy and erect at any time as many houses as "
						+ "your judgement and financial standing\n will allow. But you must build evenly, i.e., you cannot "
						+ "erect more than one house on any one property of any\n color-group until you have built one house "
						+ "on every property of that group.\n You may then begin on the second row of houses, and so on, up "
						+ "to a limit of four houses to a property.\n For example, you cannot build three houses on one "
						+ "property if you have only one house on another property of that\n group.");
				System.out.println("");
				System.out.println(" As you build evenly, you must also break down evenly if you sell houses back "
						+ "to the Bank (see Selling Property).");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 14) {
				// explains hotels
				System.out.println(" When a player has four houses on each property of a complete color-group, he/she "
						+ "may buy a hotel from the Bank and\n erect it on any property of the color-group.\n He/she "
						+ "returns the four houses from that property to the Bank and pays the price for the hotel as "
						+ "shown on the Title\n Deed card. Only one hotel may be erected on any one property.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 15) {
				// explains selling property
				System.out.println(" Unimproved properties, railroads and utilities (but not buildings) may "
						+ "be sold to any player as a private transaction\n for any amount the owner can get; "
						+ "\n however, no property can be sold to another player if buildings are standing on any "
						+ "properties of that color-group.\n Any buildings so located must be sold back to the Bank "
						+ "before the owner can sell any property of that color-group.");
				System.out.println("");
				System.out.println(" Houses and hotels may be sold back to the Bank at any time for one-half the price "
						+ "paid for them.");
				System.out.println("");
				System.out.println(" All houses on one color-group must be sold one by one, evenly, in reverse of the "
						+ "manner in which they were erected.");
				System.out.println("");
				System.out.println(" All hotels on one color-group may be sold at once, or they may be sold one "
						+ "house at a time (one hotel equals five\n houses), evenly, in reverse of the manner in "
						+ "which they were erected.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 16) {
				System.out.println(" Unimproved properties can be mortgaged through the Bank at any time.\n Before an "
						+ "improved property can be mortgaged, all the buildings on all the properties of its color-"
						+ "group must be sold\n back to the Bank at half price.\n The mortgage value is printed on each Title "
						+ "Deed card.");
				System.out.println("");
				System.out.println(" No rent can be collected on mortgaged properties\n or utilities, but rent can "
						+ "be collected on mortgaged properties in the same group.");
				System.out.println("");
				System.out.println(" In order to lift the mortgage plus 10% interest. When all the properties of a "
						+ "color-group are no longer mortgaged,\n the owner may begin to buy back houses at full price.");
				System.out.println("");
				System.out.println(" The player who mortgages property retains possession of it and no other player "
						+ "may secure it by lifting the mortgage\n from the Bank.\n However, the owner may sell this "
						+ "mortgaged property to another player at any agreed price.\n If you are the new owner, you "
						+ "may lift the mortgage at once if you wish by paying off the mortgage plus 10% interest\n to"
						+ " the Bank.\n If the mortgage is not lifted at once, you must pay the Bank 10% interest when "
						+ "you buy the property and if you lift\n the mortgage later you must pay the Bank an additional 10% "
						+ "interest as well as the amount of the mortgage.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 17) {
				// explains Bankruptcy
				System.out.println(" You are declared bankrupt if you owe more than you can pay either to another "
						+ "player or to the Bank.\n If your debt is to another player, you must turn over to that player "
						+ "all that you have oof value and retire from the\n game. In making this settlement, if you own "
						+ "houses or hotels, you must return these to\n the Bank in exchange for money to the extent of one-half "
						+ "the amount paid for them;\n this cash is given to the creditor but the new owner must at once pay "
						+ "the Bank the amount of interest on the loan,\n which is 10% of the value of the property.\n The new"
						+ " owner who does this may then, at his/her option, pay the principal or hold the property in this "
						+ "way until\n a later turn, he/she must pay the interest again upon lifting the mortgage.");
				System.out.println("");
				System.out.println(
						" Should you owe the Bank, instead of another player, more than you can pay (because of taxes "
								+ "or penalties) even by\n selling off buildings and mortgaging property, you must turn over all assets to the Bank. "
								+ "\n In this case, the Bank immediately sells by auction all property so taken, except "
								+ "buildings.\n A bankrupt player must immediately retire from the game.\n The last player left in the game wins.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else if (ruleSelect == 18) {
				// explains miscellaneous
				System.out.println(
						" Money can be loaned to a player only by the Bank and then only by mortgaging property.\n No player may "
								+ "borrow from or lend money to another player.");
				System.out.println("");
				System.out.println(" Press enter to go back to rule menu.");
				in.readLine();
				ruleQuit = false;
			} else{
				// Back to Menu
				ruleQuit = true;
			}
		}
	}
}
