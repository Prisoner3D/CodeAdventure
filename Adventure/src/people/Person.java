package people;

import java.util.List;

import items.Item;
import rooms.Room;

public abstract class Person {
	/*
	 * Abstract class for each person.
	 * @author Thomas Zhou
	 */
	
	private String firstName;
	private String familyName;
	private Room room;
	private Room prevRoom;
	private List<Item> items;
	private int money;
	
	public Person(String firstName, String familyName, Room room, Room prevRoom, List<Item> items, int money)
	{
		this.setFirstName(firstName);
		this.setFamilyName(familyName);
		this.prevRoom = room;
		this.room = room;
		this.items = items;
		this.money = money;
	}

	public List<Item> getItems()
	{
		return items;
	}
	
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public Room getPrevRoom() {
		return this.prevRoom;
	}

	public void setPrevRoom(Room prevRoom) {
		this.prevRoom = prevRoom;
	}

	public String toString()
	{
		return "" + getFirstName() + getFamilyName() + items + money + room.toString();
	}

	public String print() {
		return "";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public void addItem(Item item)
	{
		items.add(item);
	}

	public void removeItem(Item item)
	{
		items.remove(item);
	}
}