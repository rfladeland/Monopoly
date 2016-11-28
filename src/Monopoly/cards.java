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