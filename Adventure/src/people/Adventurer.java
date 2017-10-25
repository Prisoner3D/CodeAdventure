package people;

import rooms.Room;

public class Adventurer extends Person {

	private String firstName;
	private String familyName;
	private int age;
	private Room room;
	public Adventurer(String firstName, String familyName, int age, Room room) {
		super(firstName, familyName, age, room);
	}

}
