package people;

import rooms.Room;

public class Enemy extends Person{
	private String about;
	
	public Enemy(String firstName, String familyName, Room room, Room prevRoom ,String about, int level, int money) {
		super(firstName, familyName, room, prevRoom, level, money);
		this.about = about;
	}
	
	public void delete()
	{
		for(int x = 0; x < this.getRoom().getOccupants().length; i++)
		{
			if (this.getRoom().getOccupants()[i] == (Person)this)
			{
				x = 
			}
		}
			
	}
	
	public String print() {
		return "[ ! ]";
	}
}
