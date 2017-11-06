package items;

public abstract class Weapon implements Item{
	/**
	 * Abstract class for weapons, which are used by the user.
	 * @author Thomas Zhou
	 */
	private String name;
	private String about;
	private int price;
	private int power;
	public Weapon(String name, String about, int price, int power) {
		this.name = name;
		this.setAbout(about);
		this.setPrice(price);
		this.setPower(power);
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public abstract void printDescription();

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
