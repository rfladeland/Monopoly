package Monopoly;

import java.util.ArrayList;

public class cards {
	// Text on card
	private String text = "";
	// 1 = move to go
	// 2 =
	private int type = -1;
	private String action = "";
	// private ArrayList<String> CommunityChest = new ArrayList<>();
	// private ArrayList<String> Chance = new ArrayList<>();

	public cards(String words) {
		text = words;
		setAction();
		setType();
	}

	private void setAction() {
		if (text.contains("Advance") || text.contains("Go")) {
			action = "Move";
		}
		if (text.contains("Illinois")) {
			action = "Advance to Illinois";
		}
		if (text.contains("Collect") && !action.equals("Move") || text.contains("pays") || text.contains("Recieve")
				|| text.contains("inherit") || text.contains("sale")) {
			action = "Collect";
		}
		if (text.contains("Pay") && !action.equals("Collect") && !action.equals("Move")) {
			action = "Pay";
		}
		if (text.contains("Utility")) {
			action = "Utility";
		}
		if (text.contains("St. Charles")) {
			action = "St. Charles";
		}
		if (text.contains("nearest railroad")) {
			action = "nearest railroad";
		}
		if (text.contains("Get out of jail")) {
			action = "Get out of jail";
		}
		if (text.contains("3 Spaces")) {
			action = "Back 3";
		}
		if (text.contains("Go to Jail")) {
			action = "Go to Jail";
		}
		if (text.contains("General repairs")) {
			action = "General repairs";
		}
		if (text.contains("street repairs")) {
			action = "street repairs";
		}
		if (text.contains("Reading railroad")) {
			action = "Take a trip";
		}
		if (text.contains("Boardwalk")) {
			action = "take a walk";
		}
	}

	private void setType() {
		if (action.equalsIgnoreCase("Move") && text.contains("to Go")) {
			type = 1;
		} else if (action.equalsIgnoreCase("Move") && text.contains("Illinois")) {
			type = 2;
		} else if (action.equalsIgnoreCase("Collect")) {
			type = 3;
		} else if (action.equalsIgnoreCase("Pay")) {
			type = 4;
		} else if (action.equalsIgnoreCase("Utility")) {
			type = 5;
		} else if (action.equalsIgnoreCase("St. Charles.")) {
			type = 6;
		} else if (action.equalsIgnoreCase("nearest railroad")) {
			type = 7;
		} else if (action.equalsIgnoreCase("Get out of jail")) {
			type = 8;
		} else if (action.equalsIgnoreCase("Back 3")) {
			type = 8;
		} else if (action.equalsIgnoreCase("Go to Jail")) {
			type = 9;
		} else if (action.equalsIgnoreCase("General Repairs")) {
			type = 10;
		} else if (action.equalsIgnoreCase("street repairs")) {
			type = 10;
		} else if (action.equalsIgnoreCase("Take a trip")) {
			type = 11;
		} else if (action.equalsIgnoreCase("Take a walk")) {
			type = 12;
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
	// Chance.add("Make general repairs on all your property – For each house
	// pay $25 – For each hotel $100");
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