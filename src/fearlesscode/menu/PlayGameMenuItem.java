package fearlesscode.menu;

import fearlesscode.app.*;

public class PlayGameMenuItem extends MenuItem
{
	public PlayGameMenuItem()
	{
		super("Play Game");
	}
	public void activate()
	{
		try
		{
			Grafikus.getInstance().play(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}