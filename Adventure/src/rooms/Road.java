package rooms;

import people.Person;
import utilities.Constants;
import items.Item;

public class Road extends Room {
	/*
	 * Regular street
	 * Contains regular enemy
	 * @author Thomas Zhou
	 */

    public Road(Person[] people, Item[] items, int x, int y, boolean explored)
    {
        super(Constants.ALL_DOORS, people, items, x, y, explored);
    }

	@Override
	public void print()
    {
		if (this.explored)
        {
			if (getOccupants().length != 0)
	        {
	            System.out.print(getOccupants()[0].print());
	        } 
			else
			{
				System.out.print("[ X ]");
			}
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
