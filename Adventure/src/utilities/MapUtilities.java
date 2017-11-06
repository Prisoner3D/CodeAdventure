package utilities;

import items.Item;
import people.EliteEnemy;
import people.Enemy;
import people.Person;
import people.StoreOwner;
import rooms.House;
import rooms.Road;
import rooms.Room;
import rooms.Store;

public class MapUtilities {
	/*
	 * Utilities and methods meant for map generation.
	 * @author Thomas Zhou
	 */
	public static Room[][] generateTestMap(Person player, int x, int y)
    {
    	Room[][] definedMap = new Room[5][8];
        for (int j = 0; j < definedMap.length; j++)
        {
        	Room[] row = definedMap[j];
            for (int i = 0; i < row.length;i++)
            {
                Person[] people = {new Enemy("Billy", "Joe", row[i] , row[i], "I'm an enemy!", 10)};
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
                	people = new Person[] {new StoreOwner("Store", "Owner", row[i], "I own a store.", Constants.SHOP)};
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
		Person[] store = {new StoreOwner("Store", "Owner", null, "I own a store.", Constants.SHOP)};
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
		
    	House c5 = genEnemyBoss(4,2);
    	c5.getOccupants()[0].setRoom(c5);
    	c5.getOccupants()[0].setPrevRoom(c5);
		
    	Room[] row3 = {c1,c2,c3,c4,c5};
    	
    	definedMap[2] = row3;
    	
		return definedMap;
    }
	
	private static Road genEnemyRoad(int x, int y) {
		Person[] people = {new Enemy("Joe", "Shmoe", null, null)};
		Road road = new Road(people, null, x, y, false);
		return road;
	}

	private static House genEnemyHouse(int x, int y)
	{
		Person[] people = {new Enemy("Joe", "Bigbro", null, null, "I'm a brute.", (int) (Math.random() * 50))};
		House house = new House(Constants.HOUSE_DOORS, people, null, x, y, false);
		return house;
	}
	private static House genEnemyBoss(int x, int y)
	{
		Person[] people = {new EliteEnemy("Fatso", "Matso", null, null, "I'm a boss...", (int) (Math.random() * 500), Constants.DEFAULT_BOSS)};
		House house = new House(Constants.HOUSE_DOORS, people, null, x, y, false);
		return house;
	}
}
