package fearlesscode.menu;

import fearlesscode.app.*;

public class ContinueGameMenuItem extends MenuItem
{
	public ContinueGameMenuItem()
	{
		super("Continue Game");
	}
	public void activate()
	{
		try
		{
			Grafikus.getInstance().play(Grafikus.getInstance().getLevel());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}