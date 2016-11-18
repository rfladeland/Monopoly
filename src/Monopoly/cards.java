package Monopoly;

import java.util.ArrayList;

public class cards {
	// Text on card
	private String text = "";
	private int type = -1;
	// 1 = move 
	// 2 = collect
	// 3 = pay
	// 4 = Get out of Jail
	// 5 = repairs 
	private String action = "";
	//depending on what the card is saying will determine what the action is eg. a card that wants you to pay an amount is set to "pay".
	
	// private ArrayList<String> CommunityChest = new ArrayList<>();
	// private ArrayList<String> Chance = new ArrayList<>();

	public cards(String words) {
		text = words;
		setAction();
		setType();
	}
//sets the action depending on what the text is. eg. every instance you get money is set to collect.
	private void setAction() {
		if (text.contains("Advance") || text.contains("Go") || text.contains("Take a trip")||text.contains("Go to Jail")||text.contains("3 spaces")) {
			action = "Move";
		}
		if (text.contains("Collect") && !action.equals("Move") || text.contains("dividend") || text.contains("Recieve")
				|| text.contains("inherit") || text.contains("sale")) {
			action = "Collect";
		}
		if (text.contains("Pay") && !action.equals("Collect") && !action.equals("Move")) {
			action = "Pay";
		}
		if (text.contains("Get out of jail")) {
			action = "Get out of jail";
		}
		if (text.contains("repairs")) {
			action = "General repairs";
		}
	}
//sets the type depending on what the action is. eg. the action move is set to type one.
	private void setType() {
		if (action.equalsIgnoreCase("Move")) {
			type = 1;
		} else if (action.equalsIgnoreCase("Collect")) {
			type = 2;
		} else if (action.equalsIgnoreCase("Pay")) {
			type = 3;
		} else if (action.equalsIgnoreCase("Get out of jail")) {
			type = 4;
		} else if (action.equalsIgnoreCase(" Repairs")) {
			type = 5;
		}
	}
	// Chance.add(new cards("Advance to Go (Collect $200)"));
	// Chance.add("Advance to Go (Collect $200)");
	// Chance.add("Advance to Illinois Ave. - If you pass Go, collect $200.");
	// Chance.add("Advance token to nearest Utility. If unowned, you may buy it
	// from the Bank. If owned, throw dice and pay owner a total ten times the
	// amount thrown.");
	// Chance.add("Advance to St. Charles Place – If you pass Go, collect
	// $200");
	// Chance.add("Advance token to the nearest Railroad and pay owner twice the
	// rental to which he/she is otherwise entitled. If Railroad is unowned, you
	// may buy it from the Bank.");
	// Chance.add("Bank pays you dividend of $50.");
	// Chance.add("Get out of Jail Free – This card may be kept until needed, or
	// traded/sold.");
	// Chance.add("Go Back 3 Spaces.");
	// Chance.add("Go to Jail – Go directly to Jail – Do not pass Go, do not
	// collect $200.");
	// Chance.add("Make general repairs on all your property – $25 for each house
	//  $100 for each hotel");
	// Chance.add("Pay poor tax of $15");
	// Chance.add("Take a trip to Reading Railroad – If you pass Go, collect
	// $200");
	// Chance.add("Take a walk on the Boardwalk – Advance token to Boardwalk");
	// Chance.add("You have been elected Chairman of the Board – Pay each player
	// $50");
	// Chance.add("Your building loan matures – Collect $150 ");
	// Chance.add("You have won a crossword competition - Collect $100");
	//
	//
	// CommunityChest.add("Advance to Go (Collect $200)");
	// CommunityChest.add("Bank error in your favor – Collect $200");
	// CommunityChest.add("Doctor's fees– Pay $50");
	// CommunityChest.add("Get out of jail free – this card may be kept until
	// needed, or traded/sold");
	// CommunityChest.add("Go to jail – go directly to jail – Do not pass Go, do
	// not collect $200");
	// CommunityChest.add("It is your birthday Collect $10 from each player");
	// CommunityChest.add("Grand Opera Night – collect $50 from every player for
	// opening night seats");
	// CommunityChest.add("Income Tax refund – collect $20");
	// CommunityChest.add("Life Insurance Matures – collect $100");
	// CommunityChest.add("Pay Hospital Fees of $100 ");
	// CommunityChest.add("Pay School Fees of $50");
	// CommunityChest.add("Receive $25 Consultancy Fee");
	// CommunityChest.add("You are assessed for street repairs – $40 per house,
	// $115 per hotel");
	// CommunityChest.add("You have won second prize in a beauty contest–
	// collect $10");
	// CommunityChest.add("You inherit $100");
	// CommunityChest.add("From sale of stock you get $50");
	// CommunityChest.add("Holiday Fund matures - Receive $100");

	// @return text on card
	public String getText() {
		return text;
	}

	// @return simple action of card
	// used by setType
	// "move" , "add/subtract amount money" .. etc
	public String getAction() {
		return action;
	}

	//
	public int getType() {
		return type;
	}

}