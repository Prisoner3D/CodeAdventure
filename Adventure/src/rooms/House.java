package rooms;

import items.Item;
import people.Person;

public class House extends Room {
	/*
	 * House - Contains an enemy brute and a clue possibly.
	 * Clue not added currently.
	 * @author Thomas Zhou
	 */

	public House(boolean[] doors, Person[] occupants, Item[] items, int x, int y, boolean explored) {
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
				System.out.print("[ H ]");
			}
        }
        else
        {
            System.out.print("[   ]");
        }
    }
}
