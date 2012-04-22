package fearlesscode.menu;

public class PlayGameMenuItem extends MenuItem
{
	public PlayGameMenuItem()
	{
		super("Play Game");
	}
	public void activate()
	{
		System.exit(0);
	}
}