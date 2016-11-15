package Monopoly;

import java.io.IOException;
import ConsoleUI.ConsoleUI;

public class monoMenu {
	//menu to start Monopoly
		public void menu() throws IOException{
			final int MAX_PLAYERS = 8;
			final int MIN_PLAYERS = 2;
//			String[] gamePieces = {"Thimble", "Dog", "Man On Horse", "Battleship", "Hat", "Cannon"};
			String[] options = {"Rules", "Start"};
			boolean quit = true;
			int menu = (ConsoleUI.promptForMenuSelection(options, quit));
			if(menu == 1){
				//put rules? I guess?
				theRules();
			}else if(menu == 2){
				//input players amount
				int players = ConsoleUI.promptForInt("How many people will be playing?", MIN_PLAYERS, MAX_PLAYERS);
				System.out.println("There are " + players + " players for this game.");
				
				//if players accepted ask what piece they want
			}else if(menu == 0){
				System.out.println("You quit Monopoly");
			}
			playAgain();
		}

		public void playAgain() throws IOException{
			boolean valid = true;
			String userPlayAgain = null;
			do {
				userPlayAgain = ConsoleUI.promptForInput("Want to play again? Y/N?", false);
				valid = true;
				if (userPlayAgain.equalsIgnoreCase("Y")) {
					menu();
					break;
				}
				if (userPlayAgain.equalsIgnoreCase("N")) {
					System.out.println("Thank you for playing!");
					break;
				} else {
					System.out.println("Invalid. Please enter 'Y' or 'N'");
					valid = false;
				}
			} while (!valid);
		}
		
		public void theRules() throws IOException{
			System.out.println("What do you need to know?");
			boolean ruleQuit = false;
			String[] rules = {"Object", "Preparation", "Banker", "The Bank", "The Play", "'Go'", 
					"Buying Properties", "Paying Rent", "'Chance' and 'Community Chest' Cards", 
					"Income Tax", "Jail", "'Free Parking'", "Houses", "Hotels", 
					"Selling Properties", "Mortgages", "Bankruptcy", "Miscellaneous", "Back to Menu"};
			int ruleSelect = ConsoleUI.promptForMenuSelection(rules, ruleQuit);
			if(ruleSelect == 1){
				//explains object
				System.out.println("The object of the game is to become the wealthiest player through "
						+ "buying, renting and selling property.");
			}else if(ruleSelect == 2){
				//explains preparation
				System.out.println("Place the board on a table and put the Chance "
						+ "and Community Chest cards facedown on their allotted "
						+ "spaces on the board. Each player chooses one token to "
						+ "represent him/her while traveling around the board.");
				System.out.println("Each player is given $1,500");
				System.out.println("All remaining money and other equipment go to the Bank.");
			}else if(ruleSelect == 3){
				//explains banker
				System.out.println("Select as Banker a player who will also make a good Auctioneer. A Banker "
						+ "who plays in the game must keep his/her personal funds separate from those of the Bank. "
						+ "When more than five persons play, the Banker may elect to act only as Banker and "
						+ "Auctioneer. Which is the computer.");
			}else if(ruleSelect == 4){
				//explains the bank
				System.out.println("Besides the Bank's money, the Bank holds the Title Deed cards and houses and "
						+ "hotels prior to purchase and use by the players. The Bank pays salaries and bonuses. "
						+ "It sells and auctions properties and hands out their proper Title Deed cards; it sells "
						+ "houses and hotels to the players and loans money when required on mortgages.");
				System.out.println("The Bank collects all taxes, fines, loans and interest, and the price of all "
						+ "properies which it sells and auctions.");
				System.out.println("The Bank never 'goes broke'. If the Bank runs out of money, the Banker may "
						+ "issue as much more as needed by writing on any ordinary paper.");
			}else if(ruleSelect == 5){
				//explains the play
				System.out.println("Starting with the Banker, each player in turn throws the dice. The player with "
						+ "the highest total starts the play: Place your token on the corner marked 'GO', throw the "
						+ "dice and move your token in the direction of the arrow the number of spaces indicated by "
						+ "the dice. After you have completed your play, the turn passes to the left. The tokens "
						+ "remain on the spaces occupied and proceed from that point on the player's next turn. "
						+ "Two or more tokens may rest on the same space at the same time.");
				System.out.println("According to the space your token reaches, you may be entitled to buy real "
						+ "estate or other properties -- or obliged to pay rent, pay taxes, draw a Chance or "
						+ "Community Chest card, 'Go to Jail', etc.");
				System.out.println("If you throw doubles, you move your token as usual, the sum of the two dice, "
						+ "and are subject to any privileges or penalties pertaining to the space on which you land. "
						+ "Retaining the dice, throw again and move your token as before. If you throw doubles "
						+ "three times in succession, move your token immediately to the space marked 'In Jail' (See Jail).");
			}else if(ruleSelect == 6){
				//explains go
				System.out.println("Each time a player's token lands on or passes over GO, whether by throwing "
						+ "the dice or drawing a card, the Banker pays him/her a $200 salary.");
				System.out.println("The $200 is paid only once each time around the board. However, if a player "
						+ "passing GO on the throw of the dice lands 2 spaces beyond it on Community Chest, or 7 "
						+ "spaces beyond it on Chance, and draws the 'Advance to GO' card, he/she collects $200 for "
						+ "passing GO the first time and another $200 for reaching it the second time by instructions "
						+ "on the card.");
			}else if(ruleSelect == 7){
				//explains buying properties
				System.out.println("Whenever you land on an unowed property you may buy that property from the "
						+ "Bank at its printed price. You receive the Title Deed card showing ownership; place it "
						+ "faceup in front of you.");
				System.out.println("If you do not wish to buy the property, the Banker sells it at auction to the "
						+ "highest bidder. They buyer pays the Bank the amount of the bid in cash and receives the "
						+ "Title Deed card for that property. Any player, including the one who declined the option to "
						+ "buy it at the printed price, may bid. Bidding may start at any price.");
			}else if(ruleSelect == 8){
				//explains paying rent
				System.out.println("When you land on property owned by another player, the owner collects rent "
						+ "from you in accordance with the list printed on its Title Deed card.");
				System.out.println("If the property is mortgaged, no rent can be collected. When a property is mortgaged, "
						+ "its Title Deed card is placed facedown in front of the owner.");
				System.out.println("It is an advantage to hold all the Title Deed cards in a color-group (e.g., "
						+ "Boardwalk and Park Place; or Connecticut, Vermont and Oriental Avenue) because the owner may then charge "
						+ "double rent for unimproved properties even if another property in that color-group is mortgaged.");
				System.out.println("It is even more advantageous to have houses or hotels on properties because "
						+ "rents are much higher than for unimproved properties.");
				System.out.println("The owner may not collect the rent if he/she fails to ask for it before the "
						+ "second player following throws the dice.");
			}else if(ruleSelect == 9){
				//explains Chance and Community Chest
				System.out.println("When you land on either of these spaces, take the top card from the deck "
						+ "indicated, follow the instructions and return the card facedown to the bottom of the "
						+ "deck.");
				System.out.println("The 'Get Out of Jail Fee' card is held until used and then returned to the "
						+ "bottom of the deck. If the player who draws it does not wish to use it, he/she may sell "
						+ "it, at any time, to another player at a price agreeable to both.");
			}else if(ruleSelect == 10){
				//explains Income Tax
				System.out.println("If you land here you have two options: You may estimate your tax at $200 and "
						+ "pay the Bank, or you may pay 10% of your total worth to the Bank. Your total worth is "
						+ "all your cash on hand, printed prices of mortgaged and unmortgaged properties and cost "
						+ "price of all buildings you own.");
				System.out.println("You must decide which option you will take before you add up your total worth.");
			}else if(ruleSelect == 11){
				//explains jail
				System.out.println("You land in Jail when... (1) your token lands on the space marked 'Go to "
						+ "Jail'; (2) you draw a card marked 'Go to Jail'; or (3) you thow doubles three times "
						+ "in seccossion");
				System.out.println("When you are sent to Jail you cannot collect your $200 salary in that move "
						+ "since, regardless of where your token is on the board, you must move it directly into "
						+ "Jail. Your turn ends when you are sent to Jail.");
				System.out.println("If you are not 'sent' to Jail but in the ordinary course of play land on that "
						+ "space, you are 'Jest Visiting', you incur no penalty, and you move ahead in the usual "
						+ "manner on your next turn.");
				System.out.println("You get out of Jail by... (1) throwing doubles on any of your next three turns; "
						+ "if you succeed in doing this you immediately move forward the number of spaces shown by your "
						+ "doubles throw; even though you had thrown doubles, you do not take another turn; (2) using "
						+ "the 'Get Out of Jail Free' card if you have it; (3) purchasing the 'Get Out of Jail Free' card "
						+ "from another player and playing it; (4) paying a fine of $50 before you roll the dice on either "
						+ "of your next two turns.");
				System.out.println("If you do not throw doubles by your third turn, you must pay the $50 fine. "
						+ "You then get out of Jail and immediately move forward the number of spaces shown by your "
						+ "throw.");
				System.out.println("Even though you are in Jail, you may buy and sell property, buy and sell houses "
						+ "and hotels and collect rents.");
			}else if(ruleSelect == 12){
				//explains free parking
				System.out.println("A player landing on this place does not receive any money, property or reward of any "
						+ "kind. This is just a 'free' resting place.");
			}else if(ruleSelect == 13){
				//explains houses
				System.out.println("When you own all the properties in a color-group you may buy houses from the Bank "
						+ "and erect them on those properties.");
				System.out.println("If you buy one house, you may put it on any one of those properties. The next "
						+ "house you buy must be erected on one of the unimproved properties of this or any other "
						+ "complete color-group you may own.");
				System.out.println("The price you must pay the Bank for each house is shown on your Titel Deed card "
						+ "for the property on which you erect the house.");
				System.out.println("The owner still collects double rent from an opponent who lands on the unimproved "
						+ "properties of his/her complete color-group.");
				System.out.println("Following the above rules, you may buy and erect at any time as many houses as "
						+ "your judgement and financial standing will allow. But you must build evenly, i.e., you cannot "
						+ "erect more than one house on any one property of any color-group until you have built one house "
						+ "on every property of that group. You may then begin on the second row of houses, and so on, up "
						+ "to a limit of four houses to a property. For example, you cannot build three houses on one "
						+ "property if you have only one house on another property of that group.");
			}else if(ruleSelect == 20){
				//Back to Menu
			}
		}
}
