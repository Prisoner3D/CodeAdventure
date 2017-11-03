package rooms;

import items.Item;
import people.Person;

//MIGHT SCRAP
//For 3D Map
public class Floor extends Room {
	
	public Floor(boolean[] doors, Person[] occupants, Item[] items, int x, int y, boolean explored) {
		super(doors, occupants, items, x, y, explored);
	}

	@Override
	public void print()
    { 
        if (getOccupants().length != 0)
        {
            System.out.print(getOccupants()[0].print());
        } 
        if (this.explored)
        {
            System.out.print("[ X ]");
        }
        else
        {
            System.out.print("[   ]");
        }

    }
}
