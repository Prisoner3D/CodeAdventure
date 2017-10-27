package utilities;

import items.Item;
import people.Person;
import rooms.House;
import rooms.Park;
import rooms.Road;
import rooms.Room;

public class Utilities {
	public static Room[][] generateDefaultMap()
    {
    	Room[][] definedMap = new Room[5][5];
        for (int j = 0; j < definedMap.length; j++)
        {
        	Room[] row = definedMap[j];
            for (int i = 0; i<row.length;i++)
            {
                boolean[] doors = {true,true,true,true};
                Person[] people = {};
                Item[] items = {};

                row[i] = new Road(doors, people, items, i, j);
            }

        }
        
        
		return definedMap;
    }
}
