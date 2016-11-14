package Monopoly;

import java.io.IOException;
import ConsoleUI.ConsoleUI;

public class monoMenu {
	//menu to start Monopoly
		public void menu() throws IOException{
			final int MAX_PLAYERS = 8;
			final int MIN_PLAYERS = 2;
			String[] options = {"Rules", "Start"};
			boolean quit = true;
			int menu = (ConsoleUI.promptForMenuSelection(options, quit));
			if(menu == 1){
				//put rules?
			}else if(menu == 2){
				//input players amount
				int players = ConsoleUI.promptForInt("How many people will be playing?", MIN_PLAYERS, MAX_PLAYERS);
				System.out.println("There are " + players + " players for this game.");
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
}
