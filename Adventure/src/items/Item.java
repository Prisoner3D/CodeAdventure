package items;

public abstract class Item {
	private String name;
	private String about;
	private boolean decoy;
	
	public Item(String name, String about, boolean decoy)
	{
		this.name = name;
		this.about = about;
		this.decoy = decoy;
	}
	
	public String getAbout()
	{
		return about;
	}
}
