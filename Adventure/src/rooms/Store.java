package rooms;

import items.Item;
import people.Person;

public class Store extends Room{

	public Store(boolean[] doors, Person[] occupants, Item[] items, int x, int y) {
		super(doors, occupants, items, x, y);
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
            System.out.print("[ S ]");
        }
        else
        {
            System.out.print("[   ]");
        }

    }

}
