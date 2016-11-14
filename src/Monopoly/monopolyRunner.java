package Monopoly;

import java.io.IOException;

public class monopolyRunner {

	public static void main(String[] args) throws IOException {
		System.out.println("Monopoly is booted up.");
		monoMenu mm = new monoMenu();
		mm.menu();
	}

}
