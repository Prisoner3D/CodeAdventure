package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import board.Board;
import items.BB;
import items.Hammer;
import items.Item;
import items.Weapon;
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
	/*
	 * Utilities used throughout the program.
	 * @author Thomas Zhou
	 */
	
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
			System.out.println("You walk into an invisible barrier.");
		}
		if (newY > map.length - 1 || newY < 0)
		{
			newY = y;
			System.out.println("You walk into an invisible barrier.");
		}
		if (map[newY][newX].getDoors()[direction] == false)
		{
			newX = x;
			newY = y;
			System.out.println("You can't find an entrance.");
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
        		startShop(player, (StoreOwner) map[newY][newX].getOccupants()[i]);
        	}
        }
		player.getRoom().removeLastPerson();
		map[newY][newX].addOccupant(player);
		player.setPrevRoom(map[y][x]);
    	player.setRoom(map[newY][newX]);
    	//System.out.println(newX + "," + newY); 
	}
	
	private static void startShop(Person player, StoreOwner store) {
		Scanner shop = new Scanner(System.in);
		System.out.println("Welcome to my little shop " + player.getFirstName() + "! I sell all types of wares.");
		System.out.println("I have a hammer for 50 monies and a BB gun for 100 monies.");
		boolean bb = false;
		boolean hammer = false;
		for (Item item : store.getItems())
		{
			if (item instanceof BB)
			{
				bb = true;
			}
			if (item instanceof Hammer)
			{
				hammer = true;
			}
		}
		while (true) {
			String x = shop.nextLine();
			if (x.contains("bb") || x.contains("gun")) {
				if (bb)
				{
					if (player.getMoney() >= 100)
					{
						Item bbitem = null;
						System.out.println("Done! Anything else?");
						for (Item item : store.getItems())
						{
							if (item instanceof BB)
							{
								player.addItem(item);
								bbitem = item;
							}
							
						}
						store.removeItem(bbitem); //Workaround as adding this into the loop raises ConcurrentModificationException
						player.setMoney(player.getMoney() - 100);
						System.out.println("You feel more powerful.");
					}
					else
					{
						System.out.println("You need more monies!");
					}
				}
				else
				{
					System.out.println("Out of stock! Sorry.");
				}
			} 
			if (x.contains("hammer")) {
				if (hammer)
				{
					if (player.getMoney() >= 50)
					{
						System.out.println("Done! Anything else?");
						for (Item item : store.getItems())
						{
							if (item instanceof Hammer)
							{
								player.addItem(item);
								store.removeItem(item);
							}
						}
						player.setMoney(player.getMoney() - 50);
						System.out.println("You feel more powerful.");
					}
					else
					{
						System.out.println("You need more monies!");
					}
				}
				else
				{
					System.out.println("Out of stock! Sorry.");
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
		int p1max = 0;
		int p2max = 0;
		for (Item item : player1.getItems())
		{
			if (item instanceof Weapon)
			{
				if (((Weapon) item).getPower() > p1max)
				{
					p1max = ((Weapon) item).getPower();
				}
			}
		}
		for (Item item : player2.getItems())
		{
			if (item instanceof Weapon)
			{
				if (((Weapon) item).getPower() > p2max)
				{
					p2max = ((Weapon) item).getPower();
				}
			}
		}
		if (p1max >= p2max)
		{
			player1.setMoney(player1.getMoney()+player2.getMoney());
			System.out.println("You encounter an enemy! You are able to attack at an opportune moment!");
			player2.getRoom().removeEnemy();
			return player1; //Player1 wins
			
		}
		else
		{
			System.out.println("You encounter an enemy! However, you are not able to overpower him! If you had a better weapon...");
			return null; //Player1 loses
		}
	}
	
	public static void printLegend(Person player)
	{
		System.out.println("* = YOU ! = ENEMY $ = SHOP X = ROAD H = HOUSE Money: " + player.getMoney());
	}
}
