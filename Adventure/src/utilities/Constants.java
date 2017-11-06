package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import items.BB;
import items.EnemyGun;
import items.EnemyPlank;
import items.EnemyStick;
import items.Hammer;
import items.Item;

public class Constants {
	/*
	 * Constants used throughout the various methods of this program.
	 * @author Thomas Zhou
	 */
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	public static final int DEFAULT_X = 1;
	public static final int DEFAULT_Y = 1;
	
	public static final boolean[] ALL_DOORS = {true,true,true,true};
	public static final boolean[] HOUSE_DOORS = {true,true,false,false};
	
	public static final ArrayList<Item> DEFAULT_ENEMY =  new ArrayList<Item>(Arrays.asList(new EnemyStick()));
	public static final ArrayList<Item> DEFAULT_BRUTE =  new ArrayList<Item>(Arrays.asList(new EnemyPlank()));
	public static final ArrayList<Item> DEFAULT_BOSS =  new ArrayList<Item>(Arrays.asList(new EnemyGun()));
	public static final ArrayList<Item> EMPTY_AL = new ArrayList<>();
	public static final ArrayList<Item> SHOP =  new ArrayList<Item>(Arrays.asList(new Hammer(), new BB()));
}
