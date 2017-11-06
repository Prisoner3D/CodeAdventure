package people;

import java.util.List;

import items.Item;
import rooms.Room;

public class StoreOwner extends Person{
	/*
	 * Store Owner - Sells weapons to you.
	 * @author Thomas Zhou
	 */
	private String about;
	
	public StoreOwner(String firstName, String familyName, Room room, String about, List<Item> items) {
		super(firstName, familyName, room, null, items, 0);
		this.about = about;
	}
	
	public String print() {
		return "[ $ ]";
	}
}
