package people;

import rooms.Room;

public abstract class Person {
	
	private String firstName;
	private String familyName;
	private Room room;
	private Room prevRoom;
	private int level;
	private int money;
	
	public Person(String firstName, String familyName, Room room, Room prevRoom, int level, int money)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.prevRoom = room;
		this.room = room;
		this.level = level;
		this.money = money;
	}

	public int getLevel()
	{
		return this.level;
	}
	
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Room getPrevRoom() {
		return this.prevRoom;
	}

	public void setPrevRoom(Room prevRoom) {
		this.prevRoom = prevRoom;
	}

	public String toString()
	{
		return "" + firstName + familyName + level + money + room.toString();
	}

	public String print() {
		return "";
	}
}