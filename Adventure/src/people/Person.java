package people;

import rooms.Room;

public abstract class Person {
	
	private String firstName;
	private String familyName;
	private int age;
	private Room room;
	
	public Person(String firstName, String familyName, int age, Room room)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.age = age;
		this.room = room;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String toString()
	{
		return "" + firstName + familyName + age + room.toString();
	}

	public String print() {
		return "";
	}
}