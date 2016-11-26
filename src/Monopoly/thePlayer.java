package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ConsoleUI.ConsoleUI;

public class thePlayer {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private ArrayList<Deeds> ownedProperties = new ArrayList<Deeds>();
	private ArrayList<cards> ownedCards = new ArrayList<cards>();
	
	private gamePieces piece;
	private boolean hasRolled = false;
	private boolean playerInJail = false;
	private int jailTurnCounter = 0;
	private int money;
	private int location;
	
	public thePlayer(){
		money = 1500;
		location = 1;
		
	}
	
	//Thimble, Cannon, Hat, Dog, Battleship, Car, Shoe, Wheelbarrow
	public void setPiece(String playerPiece){
		switch(playerPiece){
		case "Thimble":
			piece = gamePieces.Thimble;
			break;
		case "Hat":
			piece = gamePieces.Hat;
			break;
		case "Cannon":
			piece = gamePieces.Cannon;
			break;
		case "Dog":
			piece = gamePieces.Dog;
			break;
		case "Battleship":
			piece = gamePieces.Battleship;
			break;
		case "Car":
			piece = gamePieces.Car;
			break;
		case "Shoe":
			piece = gamePieces.Shoe;
			break;
		case "Wheelbarrow":
			piece = gamePieces.Wheelbarrow;
			break;
		}
	}
	
	public String getPiece(){
		return piece.toString();
	}
	
	public void move(int numSpaces){
		location += numSpaces;
		if(location > 40){
			location -= 40;
			System.out.println("You have passed go. You collected $200");
			money += 200;
		}
	}
	
	public void flipRoll(){
		hasRolled = !hasRolled;
	}
	
	public int getLocation(){
		return location;
	}
	
	public boolean getRolled(){
		return hasRolled;
	}
}
