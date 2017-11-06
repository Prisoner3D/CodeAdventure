package people;

import java.util.List;

import items.Item;
import rooms.Room;
import utilities.Constants;

public class Enemy extends Person{
	/**
	 * Constructors for each Enemy
	 * @author Thomas Zhou
	 */
	private String about;
	/*
	 * Overloaded constructor for the Brute.
	 */
	public Enemy(String firstName, String familyName, Room room, Room prevRoom, String about, int money) {
		super(firstName, familyName, room, prevRoom, Constants.DEFAULT_BRUTE, money);
		this.about = about;
	}
	/*
	 * Overloaded constructor for a regular enemy.
	 */
	public Enemy(String firstName, String familyName, Room room, Room prevRoom) {
		super(firstName, familyName, room, prevRoom, Constants.DEFAULT_ENEMY, 10 + (int)(Math.random() * 5));
		this.about = "I'm an enemy!";
	}
	/*
	 * Regular constructor - for ex. bosses
	 */
	public Enemy(String firstName, String familyName, Room room, Room prevRoom, String about, int money, List<Item> items) {
		super(firstName, familyName, room, prevRoom, items, money);
		this.about = about;
	}
	public String print() {
		return "[ ! ]";
	}
}
