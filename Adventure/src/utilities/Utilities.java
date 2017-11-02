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
import people.StoreOwner;
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
                if (i == 0 && j == 0)
                {
                	people = new Person[] {new StoreOwner("Store", "Owner", row[i], "I own a store.")};
                	player.setRoom(definedMap[i][j]);
                	//System.out.println(i + "," + j);
                }
                row[i] = new Road(doors, people, items, i, j);
                row[i].getOccupants()[0].setRoom(row[i]);
                row[i].getOccupants()[0].setPrevRoom(row[i]);
            }
        }
        definedMap[0][0].getOccupants()[0].setRoom(definedMap[0][0]);
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
		for (int i = 0; i < map[newY][newX].getOccupants().length;i++)
        {
        	if (map[newY][newX].getOccupants()[i] instanceof Enemy)
        	{
        		System.out.println("hello");
        		if (fight(player,map[newY][newX].getOccupants()[i]) == player)
        		{
        			break;
        		}
        		newX = x;
        		newY = y;
        		//if return is null,  set newX and newY to x and y respectively.
        		System.out.println("AHH You run out as the enemy is too powerful.");
        	}
        	else if (map[newY][newX].getOccupants()[i] instanceof StoreOwner)
        	{
        		System.out.println("hello");
        		//InitiateStore
        	}
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
			player1.setMoney(player1.getMoney()+player2.getMoney());
			System.out.println(player1.getMoney());
			player2.getRoom().removeEnemy();
			return player1; //Player1 wins?
			
		}
		else
		{
			return null;
		}
	}
}
