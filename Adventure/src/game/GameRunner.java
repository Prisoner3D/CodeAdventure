package game;

import items.Item;
import rooms.*;
import utilities.Utilities;
import people.Adventurer;
import people.Person;

import java.util.Scanner;

import board.Board;

public class GameRunner {

    public static void main (String[] args)
    {
        Room[][] definedMap = Utilities.generateDefaultMap();
        Board board = new Board(definedMap);
        
        board.printMap();
        Adventurer player = new Adventurer("Bobby", "Johnson", 20, board.getmap()[0][0]);
        player.print();
        		/*
        for (int j = 0; j < definedMap.length; j++)
        {
        	Room[] row = definedMap[j];
            for (int i = 0; i<row.length;i++)
            {
                boolean[] doors = {true,true,true,true};
                Person[] people = {};
                Item[] items = {};
                
                row[i] = new Road(doors, people, items, i, j);
                row[i].print();
            }
            System.out.println();

        } */
/*
        School tech = new School(map);


        boolean gameOn = true;
        Person player1 = Utilities.createPerson();
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Welcome to the Halls of Tech, " + player1.getFirstName());
            map[0][0].addOccupant(player1);

            tech.printMap();
            player1.printRoom();
            String move = player1.chooseMove();
            Utilities.movePlayer(tech, player1,move);
            //gameOn = false;

        }
		in.close();
		*/
    }

}



