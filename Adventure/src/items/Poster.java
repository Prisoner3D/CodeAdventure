package items;

import people.Person;

public class Poster extends Clue{
	/**
	 * Poster - A poster found in a room that drives the story.
	 * @author Thomas Zhou
	 */
	private static String name = "Note";
	private static String about = "You see a poster with 'Only way out is death...'";
	
	public Poster(String name, String about) {
		super(name, about);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printAbout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tossItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useItem(Person person) {
		// TODO Auto-generated method stub
		
	}

}
