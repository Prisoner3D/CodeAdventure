package people;

import rooms.Room;

public class Enemy extends Person{
	private String about;
	
	public Enemy(String firstName, String familyName, int age, Room room, String about) {
		super(firstName, familyName, age, room);
		this.about = about;
	}
	
	public String print() {
		return "[ ! ]";
	}
}
