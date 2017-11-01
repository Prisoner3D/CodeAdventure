package people;

import rooms.Room;

public class Adventurer extends Person {

	private String firstName;
	private String familyName;
	private int age;
	private Room room;
	private int level;
	
	public Adventurer(String firstName, String familyName, int age, Room room, int level) {
		super(firstName, familyName, age, room);
		this.level = level;
	}

	public String print() {
		return "[ * ]";
	}
}
