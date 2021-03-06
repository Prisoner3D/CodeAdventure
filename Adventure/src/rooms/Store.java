package rooms;

import items.Item;
import people.Person;

public class Store extends Room{
	/*
	 * Room that houses a store owner and allows store transactions.
	 * @author Thomas Zhou
	 */

	public Store(boolean[] doors, Person[] occupants, Item[] items, int x, int y, boolean explored) {
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
				System.out.print("[ S ]");
			}
        }
        else
        {
            System.out.print("[   ]");
        }
    }

}
