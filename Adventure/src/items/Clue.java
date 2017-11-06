package items;

public abstract class Clue implements Item{
	/**
	 * Abstract class for clues, which are hints that drive the story.
	 * @author Thomas Zhou
	 */
	private String name;
	private String about;

	public Clue (String name, String about)
	{
		this.name = name;
		this.about = about;
	}
}
