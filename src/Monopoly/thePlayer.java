package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ConsoleUI.ConsoleUI;

public class thePlayer {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	private ArrayList<Deeds> ownedProperties = new ArrayList<Deeds>();
	
	public void pickingGamePiece() throws IOException{
		final int MAX_PLAYERS = 8;
		final int MIN_PLAYERS = 2;
		boolean playerInJail = false;
		int jailTurnCounter = 0;
		int location = 1;
		int playerMoney = 1500;
		// input players amount
		int numberOfPlayers = ConsoleUI.promptForInt("How many people will be playing?", MIN_PLAYERS, MAX_PLAYERS);
		//ask each players entered what game piece they want
		System.out.println("There are " + numberOfPlayers + " players for this game.");
		int i = 0;
		gamePieces playerPiece = null;
		
		//this is used for future jail things
		//moves player to jail if landed on 'go to jail' spot
		if(location == 31){ //location is a placeholder variable
			playerInJail = true;
			location = 11;
		}
		
		//moves player to jail picks 'go to jail' card
		if(card.equals("Go to Jail")){ //card is a placeholder variable to test
			location = 11;
			playerInJail = true;
		}
		
		//gets player out of jail
		if(playerInJail = true){
			for(jailTurnCounter = 0; jailTurnCounter < 4; jailTurnCounter++){
				if(diceRoll1 == diceRoll2){
					playerInJail = false;
					break;
				}else if(card.equals("Get out of Jail")){
					playerInJail = false;
					break;
				}else{
					playerInJail = true;
				}
			}
			if(jailTurnCounter == 3){
				playerMoney -= 50;
				playerInJail = false;
				 break;
			}
		}
		
		//adds 200 money when they pass go (not sure how to do it so that it won't count it the first play)
		if(location == 2){
			playerMoney += 200;
		}
		//just a giant mess with the enums :'D I need help here
//		for(i = 1; i < numberOfPlayers+1; i++){
//			String thePlayers[];
//			System.out.println("Player " + i + ", What game piece do you want to play?");
//			System.out.println("Tokens you can play as: Thimble, Cannon, Hat, Dog, "
//					+ "Battleship, Car, Shoe, Wheelbarrow");
//			String pieceChoice = in.readLine();
//			if(pieceChoice.equalsIgnoreCase("Thimble")){
//				playerPiece = gamePieces.Thimble;
//			}else if(pieceChoice.equalsIgnoreCase("Cannon")){
//				playerPiece = gamePieces.Cannon;
//			}else if(pieceChoice.equalsIgnoreCase("Hat")){
//				playerPiece = gamePieces.Hat;
//			}else if(pieceChoice.equalsIgnoreCase("Dog")){
//				playerPiece = gamePieces.Dog;
//			}else if(pieceChoice.equalsIgnoreCase("Battleship")){
//				playerPiece = gamePieces.Battleship;
//			}else if(pieceChoice.equalsIgnoreCase("Car")){
//				playerPiece = gamePieces.Car;
//			}else if(pieceChoice.equalsIgnoreCase("Shoe")){
//				playerPiece = gamePieces.Shoe;
//			}
//		}
//			System.out.println("Player " + thePlayers[1] + " chose " + playerPiece + ".");
//			System.out.println("Time to start!! " + playerPiece + " rolled the dice...");
		// if players accepted ask what piece they want
	}
}
