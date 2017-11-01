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
	
	public static Room[][] generateDefaultMap(Person player, int x, int y)
    {
    	Room[][] definedMap = new Room[5][8];
        for (int j = 0; j < definedMap.length; j++)
        {
        	Room[] row = definedMap[j];
            for (int i = 0; i < row.length;i++)
            {
                boolean[] doors = {true,true,true,true};
                Person[] people = {new Enemy("Billy", "Joe", row[i] , row[i], "I'm an enemy!", 0, 10)};
                //System.out.println(people[0].getLevel());
                Item[] items = {};

                if (i == x && j == y)
                {
                	people = new Person[] {player};
                	player.setRoom(definedMap[i][j]);
                	//System.out.println(i + "," + j);
                }
                row[i] = new Road(doors, people, items, i, j);
            }
        }
		return definedMap;
    }
	public static void changeRoom(Person player, int direction, Room[][] map) //Change so it calls check combat, if so then move.
	{
		Room current = player.getRoom();
		int x = current.getX();
		int y = current.getY();
		int newX = x;
		int newY = y;
		if (direction == Constants.UP)
		{
			newX = x;
			newY = y - 1;
		}
		else if (direction == Constants.DOWN)
		{
			newX = x;
			newY = y + 1;
		}
		else if (direction == Constants.LEFT)
		{
			newX = x - 1;
			newY = y;
			for (int i = 0; i < player.getRoom().getOccupants().length;i++)
            {
            	if (player.getRoom().getOccupants()[i] instanceof Enemy)
            	{
            		if (fight(player,player.getRoom().getOccupants()[i]) == null)
            		{
            			break;
            		}
            		newX = x;
            		newY = y;
            		//if return is null,  set newX and newY to x and y respectively.
            		System.out.println("Oops room is locked");
            	}
            }
		}
		else if (direction == Constants.RIGHT)
		{
			newX = x + 1;
			newY = y;
		}
		if (newX > map[0].length - 1|| newX < 0)
		{
			newX = x;
		}
		if (newY > map.length - 1 || newY < 0)
		{
			newY = y;
		}
		player.getRoom().removeLastPerson();
		map[newY][newX].addOccupant(player);
		player.setPrevRoom(map[y][x]);
    	player.setRoom(map[newY][newX]);
    	System.out.println(newX + "," + newY);
    	
    	
	}
	
	public static void changeToPrev(Person player)
	{
		player.setRoom(player.getPrevRoom());
	}
	
	public static Person fight(Person player1, Person player2) {
		if (player1.getLevel() >= player2.getLevel())
		{
			return player1;
		}
		else
		{
			//should delete player2 player2
			player2.delete();
			return null;
		}
	}
}
