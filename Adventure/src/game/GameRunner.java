package game;

import items.Item;
import rooms.*;
import utilities.Constants;
import utilities.Utilities;
import people.Adventurer;
import people.Enemy;
import people.Person;

import java.util.Scanner;

import board.Board;

public class GameRunner {

	//To Do
	// ITEMS: Weapons, Clues
	// Shop upgrade
	//Storyline
	//Board constructor - combine
	//comments
	//doors
    public static void main (String[] args)
    {
    	try {
			Person player = new Adventurer("First", "Last", null, null, 0, 0);
			Room[][] definedMap = Utilities.generateDefaultMap(player);
			player.setRoom(definedMap[Constants.DEFAULT_X][Constants.DEFAULT_Y]);
			Board board = new Board(definedMap);
			boolean gameOn = true;
			
			
			Scanner in = new Scanner(System.in);
			System.out.println("You wake up on the street. You are alone. You have nothing. You don't know here you are."); //Add name later.getFirstName());
			board.printMap();
			Utilities.printLegend(player);
			
			while(gameOn)
			{
			    String x = in.nextLine();
			    if (x.contains("up"))
			    {
			    	Utilities.changeRoom(player, Constants.UP, board.getMap());
			    }
			    else if (x.contains("down"))
			    {
			    	Utilities.changeRoom(player, Constants.DOWN, board.getMap());
			    }
			    else if (x.contains("left"))
			    {
			    	Utilities.changeRoom(player, Constants.LEFT, board.getMap());
			    }
			    else if (x.contains("right"))
			    {
			    	Utilities.changeRoom(player, Constants.RIGHT, board.getMap());
			    }
			    else
			    {
			    	System.out.println("You are confused and are unable to complete that action.");
			    }
			    board.printMap();
			    Utilities.printLegend(player);
			    //gameOn = false;

			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}



