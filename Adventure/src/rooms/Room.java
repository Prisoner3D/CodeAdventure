package rooms;

import people.Enemy;
import people.Person;
import items.Item;

import java.util.Arrays;

public abstract class Room {

    private boolean[] doors;
    private Person[] occupants;
    private Item[] items;
    public boolean explored;
    private int x, y;

    public Room (boolean[] doors, Person[] occupants, Item[] items, int x, int y)
    {
    	this.x = x;
    	this.y = y;
        this.doors = doors;
        this.occupants = occupants;
        this.items = items;
        this.explored = true;
    }

    public Person[] getOccupants() 
    {
        return occupants;
    }

    public void setOccupants(Person[] occupants) 
    {
        this.occupants = occupants;
    }
    
    public void addOccupant(Person p)
    {
        this.occupants = Arrays.copyOf(this.occupants,this.occupants.length+1);
        this.occupants[this.occupants.length-1] = p;
        p.setRoom(this);
    }
    
    public boolean[] getDoors()
    {
    	return doors;
    }
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    
    public void removeEnemy()
	{
		Person[] replace = new Person[this.occupants.length - 1];
		for (int i = 0; i < replace.length; i++)
		{
			if (this.getOccupants()[i] instanceof Enemy)
			{
				continue;
			}
			replace[i] = this.getOccupants()[i];
		}
		this.occupants = replace;
	}
    
    public void removeLastPerson()
	{
		Person[] replace = new Person[this.occupants.length - 1];
		for (int i = 0; i < replace.length; i++)
		{
			replace[i] = this.getOccupants()[i];
		}
		this.occupants = replace;
	}
	public void addPerson(Person addition)
	{
		Person[] replace = new Person[this.occupants.length + 1];
		for (int i = 0; i < replace.length; i++)
		{
			replace[i] = this.occupants[i];
		}
		replace[replace.length - 1] = addition;
		this.occupants = replace;
	}
    
    public abstract void print();
}
