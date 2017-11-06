package people;

import java.util.List;

import items.Item;
import rooms.Room;

public class EliteEnemy extends Enemy{
	/**
	 * The enemy boss.
	 * @author Thomas Zhou
	 */
	public EliteEnemy(String firstName, String familyName, Room room, Room prevRoom, String about,
			int money, List<Item> items) {
		super(firstName, familyName, room, prevRoom, about, money, items);
		// TODO Auto-generated constructor stub
	}

}
