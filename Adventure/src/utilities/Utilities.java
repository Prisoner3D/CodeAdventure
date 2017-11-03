package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import board.Board;
import items.Item;
import people.Adventurer;
import people.EliteEnemy;
import people.Enemy;
import people.Person;
import people.StoreOwner;
import rooms.House;
import rooms.Park;
import rooms.Road;
import rooms.Room;
import rooms.Store;

public class Utilities {
	
	public static Room[][] generateTestMap(Person player, int x, int y)
    {
    	Room[][] definedMap = new Room[5][8];
        for (int j = 0; j < definedMap.length; j++)
        {
        	Room[] row = definedMap[j];
            for (int i = 0; i < row.length;i++)
            {
                Person[] people = {new Enemy("Billy", "Joe", row[i] , row[i], "I'm an enemy!", 0, 10)};
                //System.out.println(people[0].getLevel());
                Item[] items = {};
                boolean explored = false;
                if (i == x && j == y)
                {
                	people = new Person[] {player};
                	player.setRoom(definedMap[i][j]);
                	explored = true;
                	//System.out.println(i + "," + j);
                }
                if (i == 0 && j == 0)
                {
                	people = new Person[] {new StoreOwner("Store", "Owner", row[i], "I own a store.")};
                	player.setRoom(definedMap[i][j]);
                	//System.out.println(i + "," + j);
                }
                row[i] = new Road(people, items, i, j, explored);
                row[i].getOccupants()[0].setRoom(row[i]);
                row[i].getOccupants()[0].setPrevRoom(row[i]);
            }
        }
        definedMap[0][0].getOccupants()[0].setRoom(definedMap[0][0]);
		return definedMap;
    }
	
	public static Room[][] generateDefaultMap(Person player)
    {
		Room[][] definedMap = new Room[3][5];
		Person[] store = {new StoreOwner("Store", "Owner", null, "I own a store.")};
		//Park park = new Park(Constants.ALL_DOORS, null, null, 0, 0, false);
		
		House a1 = genEnemyHouse(0,0);
		a1.getOccupants()[0].setRoom(a1);
		a1.getOccupants()[0].setPrevRoom(a1);
		
		Road a2 = genEnemyRoad(1,0);
		a2.getOccupants()[0].setRoom(a2);
		a2.getOccupants()[0].setPrevRoom(a2);
		
		House a3 = genEnemyHouse(2,0);
		a3.getOccupants()[0].setRoom(a3);
		a3.getOccupants()[0].setPrevRoom(a3);
		
		Store a4 = new Store(Constants.ALL_DOORS, store, null, 3, 0, false);
		a4.getOccupants()[0].setRoom(a4);
		a4.getOccupants()[0].setPrevRoom(a4);
    	
		House a5 = genEnemyHouse(4,0);
		a5.getOccupants()[0].setRoom(a5);
		a5.getOccupants()[0].setPrevRoom(a5);
		
		Room[] row1 = {a1,a2,a3,a4,a5};
		
		definedMap[0] = row1;

		
		Room[] row2 = new Room[5];
    	for (int i = 0; i < row2.length; i++)
    	{
    		if (i == 1)
    		{
    			Person[] people = {player};
    			Road road = new Road(people, null, i, 1, true);
    			row2[i] = road;
    			row2[i].getOccupants()[0].setRoom(row2[i]);
    			row2[i].getOccupants()[0].setPrevRoom(row2[i]);
    			continue;
    		}
    		row2[i] = genEnemyRoad(i,1);
    		row2[i].getOccupants()[0].setRoom(row2[i]);
    		row2[i].getOccupants()[0].setPrevRoom(row2[i]);
    	}
    	
    	definedMap[1] = row2;
    	
    	House c1 = genEnemyHouse(0,2);
    	c1.getOccupants()[0].setRoom(c1);
    	c1.getOccupants()[0].setPrevRoom(c1);
		
    	Road c2 = genEnemyRoad(1,2);
    	c2.getOccupants()[0].setRoom(c2);
    	c2.getOccupants()[0].setPrevRoom(c2);
		
    	House c3 = genEnemyHouse(2,2);
    	c3.getOccupants()[0].setRoom(c3);
    	c3.getOccupants()[0].setPrevRoom(c3);
		
    	House c4 = genEnemyHouse(3,2);
    	c4.getOccupants()[0].setRoom(c4);
    	c4.getOccupants()[0].setPrevRoom(c4);
		
    	House c5 = genEnemyHouse(4,2);
    	c5.getOccupants()[0].setRoom(c5);
    	c5.getOccupants()[0].setPrevRoom(c5);
		
    	Room[] row3 = {c1,c2,c3,c4,c5};
    	
    	definedMap[2] = row3;
    	
		return definedMap;
    }

	private static Road genEnemyRoad(int x, int y) {
		Person[] people = {new Enemy("Billy", "Joe", null, null, "I'm an enemy!", 0, 10 + (int)(Math.random() * 5))};
		Road road = new Road(people, null, x, y, false);
		return road;
	}

	private static House genEnemyHouse(int x, int y)
	{
		Person[] people = {new EliteEnemy("Billy", "Joe", null, null, "I'm an enemy!", 1, (int) (Math.random() * 50))};
		House house = new House(Constants.ALL_DOORS, people, null, x, y, false);
		return house;
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
		map[newY][newX].setExplored(true);
		for (int i = 0; i < map[newY][newX].getOccupants().length;i++)
        {
        	if (map[newY][newX].getOccupants()[i] instanceof Enemy)
        	{
        		//System.out.println("ENEMY");
        		if (fight(player,map[newY][newX].getOccupants()[i]) == player)
        		{
        			break;
        		}
        		newX = x;
        		newY = y;
        		System.out.println("You run back!");
        	}
        	else if (map[newY][newX].getOccupants()[i] instanceof StoreOwner)
        	{
        		System.out.println("You walk expecting an enemy...");
        		startShop(player);
        	}
        }
		player.getRoom().removeLastPerson();
		map[newY][newX].addOccupant(player);
		player.setPrevRoom(map[y][x]);
    	player.setRoom(map[newY][newX]);
    	//System.out.println(newX + "," + newY); 
	}
	
	private static void startShop(Person player) {
		Scanner shop = new Scanner(System.in);
		System.out.println("Welcome to my little shop! I sell all types of wares.");
		System.out.println("I have a hammer for 50 monies and a BB gun for 75 monies.");
		while (true) {
			String x = shop.nextLine();
			if (x.contains("bb") || x.contains("gun")) {
				System.out.println("Sorry, you need more monies.");
			} 
			if (x.contains("hammer")) {
				if (player.getMoney() >= 50)
				{
					System.out.println("Done! Anything else?");
					player.setLevel(1);
					player.setMoney(player.getMoney() - 50);
					System.out.println("You feel more powerful.");
				}
				else
				{
					System.out.println("You need more monies!");
				}
			} 
			if (x.contains("leave") || x.contains("no")) {
				break;
			} 
		}
		System.out.println("You leave the shop.");
	}
	public static void changeToPrev(Person player)
	{
		player.setRoom(player.getPrevRoom());
	}
	
	public static Person fight(Person player1, Person player2) {
		if (player1.getLevel() >= player2.getLevel())
		{
			player1.setMoney(player1.getMoney()+player2.getMoney());
			System.out.println("You encounter an enemy! You are able to attack at an opportune moment!");
			player2.getRoom().removeEnemy();
			return player1; //Player1 wins
			
		}
		else
		{
			System.out.println("You encounter an enemy! However, you are not able to overpower him!");
			return null; //Player1 loses
		}
	}
	
	public static void printLegend(Person player)
	{
		System.out.println("* = YOU ! = ENEMY $ = SHOP X = ROAD H = HOUSE Money: " + player.getMoney());
	}
}
