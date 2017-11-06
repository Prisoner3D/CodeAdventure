package people;

import java.util.List;

import items.Item;
import rooms.Room;

public class Adventurer extends Person {
	/**
	 * Adventurer - The player
	 * @author Thomas Zhou
	 */
	public Adventurer(String firstName, String familyName, Room room, Room prevRoom, List<Item> items, int money) {
		super(firstName, familyName, room, prevRoom, items, money);
	}
	
	public String print() {
		return "[ * ]";
	}
}
