package fearlesscode.menu;

public abstract class MenuItem
{
	private String title;
	private boolean active;
	public MenuItem(String str)
	{
		title=str;
	}
	public abstract void activate();
	public String getTitle()
	{
		return title;
	}
	public void setActive(boolean state)
	{
		active=state;
	}
}