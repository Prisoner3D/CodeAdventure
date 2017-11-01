package people;

import rooms.Room;

public class Enemy extends Person{
	private String about;
	private int level;
	
	public Enemy(String firstName, String familyName, int age, Room room, String about, int level) {
		super(firstName, familyName, age, room);
		this.about = about;
		this.level = level;
	}
	
	public String print() {
		return "[ ! ]";
	}
}
