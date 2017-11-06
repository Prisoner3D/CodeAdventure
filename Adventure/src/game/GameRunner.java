package game;

import items.Item;
import rooms.*;
import utilities.Constants;
import utilities.MapUtilities;
import utilities.Utilities;
import people.Adventurer;
import people.Enemy;
import people.Person;

import java.util.Scanner;

import board.Board;

public class GameRunner {

	//To Do

	// Clues
	// Finish storyline
	// Add board constructor
	// Overwrite methods in item
	// Add more comments
	// Add check if game is finished

    public static void main (String[] args)
    {
    	try {
    		Scanner in = new Scanner(System.in);
    		System.out.println("What is your full name?");
    		String name = in.nextLine();
    		String first;
			String last;
    		if (name.indexOf(' ') == -1)
    		{
    			first = name;
    			System.out.println("What is your last name?");
    			name = in.nextLine();
    			last = name;
    		}
    		else
    		{
    			first = name.substring(0, name.indexOf(' '));
        		last = name.substring(name.indexOf(' ') + 1);
    		}
			System.out.println("You wake up on the street. You are alone. You have nothing. You don't know where you are."); 
			
			Person player = new Adventurer(first, last, null, null, Constants.EMPTY_AL, 0);
			Room[][] definedMap = MapUtilities.generateDefaultMap(player);
			player.setRoom(definedMap[Constants.DEFAULT_X][Constants.DEFAULT_Y]);
			Board board = new Board(definedMap);
			boolean gameOn = true;
			
			
			//Add name later.getFirstName());
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



