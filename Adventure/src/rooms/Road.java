package rooms;

import people.Person;
import items.Item;

public class Road extends Room {

    public Road(boolean[] doors, Person[] people, Item[] items, int x, int y)
    {
        super(doors, people, items, x, y);
    }

	@Override
    public void print()
    { /*
        if (getOccupants().length != 0)
        {
            System.out.print(getOccupants()[0].print());
        } */
        if (this.explored)
        {
            System.out.print("[ X ]");
        }
        else
        {
            System.out.print("[   ]");
        }

    }
    
    public String toString()
    {
    	boolean[] doors = this.getDoors();
    	String response = "This is the street, you can go ";
    	if (doors[0])
    	{
    		response += "N";
    	}
    	
    	if(doors[1]) {
    		response += " and E";
    	}
    	
    	if (doors[2]) {
    		response += " and S";
    	}
    	
    	if (doors[3]) {
    		response += " and W";
    	}
    	
    	return response;
    }
}
