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

    public static void main (String[] args)
    {
    	Person player = new Adventurer("First", "Last", null, null, 0, 0);
        Room[][] definedMap = Utilities.generateDefaultMap(player,Constants.DEFAULT_X,Constants.DEFAULT_Y);
        player.setRoom(definedMap[Constants.DEFAULT_X][Constants.DEFAULT_Y]);
        Board board = new Board(definedMap);
        boolean gameOn = true;
        
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome, to a house where you are locked. ! represents an enemy in the room, * represents your character."); //Add name later.getFirstName());
        board.printMap();
        while(gameOn)
        {
            String x = in.nextLine();
            if (x.equals("up"))
            {
            	Utilities.changeRoom(player, Constants.UP, board.getMap());
            	for (int i = 0; i < player.getRoom().getOccupants().length;i++)
                {
                	if (player.getRoom().getOccupants()[i] instanceof Enemy)
                	{
                		Utilities.changeRoom(player,  -1 * Constants.LEFT, board.getMap());
                		System.out.println("Oops room is locked");
                	}
                }
            }
            if (x.equals("down"))
            {
            	Utilities.changeRoom(player, Constants.DOWN, board.getMap());
            }
            if (x.equals("left"))
            {
            	Utilities.changeRoom(player, Constants.LEFT, board.getMap());
            }
            if (x.equals("right"))
            {
            	Utilities.changeRoom(player, Constants.RIGHT, board.getMap());
            }
            for (int i = 0; i < player.getRoom().getOccupants().length;i++)
            {
            	if (player.getRoom().getOccupants()[i] instanceof Enemy)
            	{
            		Utilities.changeRoom(player,  -1 * Constants.LEFT, board.getMap());
            		System.out.println("Oops room is locked");
            	}
            }
            board.printMap();
            //gameOn = false;

        }
		in.close();
    }

}



