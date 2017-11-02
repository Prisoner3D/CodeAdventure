package items;

public abstract class Clue implements Item{
	private String name;
	private String about;

	public Clue (String name, String about)
	{
		this.name = name;
		this.about = about;
	}
}
