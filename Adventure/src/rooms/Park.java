package rooms;

import items.Item;
import people.Person;

//MIGHT SCRAP
public class Park extends Room{

	public Park(boolean[] doors, Person[] occupants, Item[] items, int x, int y, boolean explored) {
		super(doors, occupants, items, x, y, explored);
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
				System.out.print("[ P ]");
			}
        }
        else
        {
            System.out.print("[   ]");
        }
    }
}
