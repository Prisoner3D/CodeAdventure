package items;

import people.Person;

public interface Item {
	/**
	 * Interface for all items.
	 * @author Thomas Zhou
	 */
	void printAbout();
	
	void useItem();
	
	void tossItem();
	
	//void redundantMethod();
	
	void useItem(Person person);
}
