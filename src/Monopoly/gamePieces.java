package Monopoly;

public enum gamePieces {
	Thimble, Cannon, Hat, Dog, Battleship, Car, Shoe, Wheelbarrow;


	@Override
	public String toString() {
		switch (this) {
		case Thimble:
			return "Thimble";
		case Cannon:
			return "Cannon";
		case Hat:
			return "Hat";
		case Dog:
			return "Dog";
		case Battleship:
			return "Battleship";
		case Car:
			return "Car";
		case Shoe:
			return "Shoe";
		case Wheelbarrow:
			return "Wheelbarrow";
		default:
		return "";
		}
	}
}