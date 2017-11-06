package items;

import people.Person;

public class EnemyStick extends Weapon {
	/**
	 * Enemy Stick used by the regular Enemy only.
	 * @author Thomas Zhou
	 */
	private static String name = "Hammer";
	private static String about = "It can hit stuff!";
	private static int price = 999;
	private static int power = 0;
	
	public EnemyStick() {
		super(name, about, price, power);
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

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		
	}
}
