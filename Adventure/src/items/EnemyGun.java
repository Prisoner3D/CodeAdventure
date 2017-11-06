package items;

import people.Person;

public class EnemyGun extends Weapon {
	/**
	 * Enemy Gun used by the Enemy Boss only.
	 * @author Thomas Zhou
	 */
	private static String name = "Gun";
	private static String about = "Enemy gun!";
	private static int price = 999;
	private static int power = 2;
	
	public EnemyGun() {
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
