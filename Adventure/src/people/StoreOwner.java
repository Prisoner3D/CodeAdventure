package people;

import rooms.Room;

public class StoreOwner extends Person{
	private String about;
	
	public StoreOwner(String firstName, String familyName, Room room, String about) {
		super(firstName, familyName, room, null, 0, 0);
		this.about = about;
	}
	
	public String print() {
		return "[ $ ]";
	}
}
