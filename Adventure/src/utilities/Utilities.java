package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import board.Board;
import items.Item;
import people.Adventurer;
import people.Enemy;
import people.Person;
import rooms.House;
import rooms.Park;
import rooms.Road;
import rooms.Room;

public class Utilities {
	
	public static Room[][] generateDefaultMap(Person player)
    {
    	Room[][] definedMap = new Room[5][5];
        for (int j = 0; j < definedMap.length; j++)
        {
        	Room[] row = definedMap[j];
            for (int i = 0; i<row.length;i++)
            {
                boolean[] doors = {true,true,true,true};
                Person[] people = {new Enemy("Billy", "Joe", 20, row[i], "I'm an enemy!")};
                Item[] items = {};

                if (i == 1 && j == 2)
                {
                	people = new Person[] {player};
                }
                row[i] = new Road(doors, people, items, i, j);
            }
        }
		return definedMap;
    }
	public static void changeRoom(Person player, int direction, Room[][] map)
	{
		Room current = player.getRoom();
		int x = current.getX();
		int y = current.getY();
		int newX;
		int newY;
		switch(direction)
		{
			case(Constants.UP):
				newX = x;
				newY = y-1;
				removeLastPerson(current.getOccupants());
				for (int j = 0; j < map.length; j++)
		        {
		        	Room[] row = map[j];
		            for (int i = 0; i < row.length;i++)
		            {
		                if (j == newY && i == newX)
		                {
		                	addPerson(player, row[i].getOccupants());
		                }
		            }
		        }
			case(Constants.DOWN):
				newX = x;
				newY = y+1;
				removeLastPerson(current.getOccupants());
				for (int j = 0; j < map.length; j++)
		        {
		        	Room[] row = map[j];
		            for (int i = 0; i < row.length;i++)
		            {
		                if (j == newY && i == newX)
		                {
		                	addPerson(player, row[i].getOccupants());
		                }
		            }
		        }
			case(Constants.LEFT):
				newX = x - 1;
				newY = y;
				removeLastPerson(current.getOccupants());
				for (int j = 0; j < map.length; j++)
		        {
		        	Room[] row = map[j];
		            for (int i = 0; i < row.length;i++)
		            {
		                if (j == newY && i == newX)
		                {
		                	addPerson(player, row[i].getOccupants());
		                }
		            }
		        }
			case(Constants.RIGHT):
				newX = x + 1;
				newY = y;
				removeLastPerson(current.getOccupants());
				for (int j = 0; j < map.length; j++)
		        {
		        	Room[] row = map[j];
		            for (int i = 0; i < row.length;i++)
		            {
		                if (j == newY && i == newX)
		                {
		                	addPerson(player, row[i].getOccupants());
		                }
		            }
		        }
		}
		
	}
	public static void removeLastPerson(Person[] room)
	{
		Person[] replace = new Person[room.length - 1];
		for (int i = 0; i < replace.length; i++)
		{
			replace[i] = room[i];
		}
		room = replace;
	}
	public static void addPerson(Person addition, Person[] room)
	{
		Person[] replace = new Person[room.length + 1];
		for (int i = 0; i < replace.length; i++)
		{
			replace[i] = room[i];
		}
		replace[replace.length - 1] = addition;
		room = replace;
	}
}
