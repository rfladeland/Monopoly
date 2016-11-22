package Monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ConsoleUI.ConsoleUI;

public class thePlayer {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private ArrayList<Deeds> ownedProperties = new ArrayList<Deeds>();

	boolean playerInJail = false;
	int jailTurnCounter = 0;
}
