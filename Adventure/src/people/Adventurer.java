package people;

import rooms.Room;

public class Adventurer extends Person {

	private String firstName;
	private String familyName;
	private int age;
	private Room room;
	private int level;
	
	public Adventurer(String firstName, String familyName, Room room, Room prevRoom, int level, int money) {
		super(firstName, familyName, room, prevRoom, level, money);
		this.level = level;
	}

	public String print() {
		return "[ * ]";
	}
}
