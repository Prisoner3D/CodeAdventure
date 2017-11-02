package items;

import people.Person;

public interface Item {

	void printAbout();
	
	void useItem();
	
	void tossItem();
	
	//void redundantMethod();
	
	void useItem(Person person);
}
