package fearlesscode.menu;

import fearlesscode.app.*;

/**
 * A MenuItem leszármazottja, viselkedése az activate() metódusban szerepel.
 */
public class PlayGameMenuItem extends MenuItem
{
	public PlayGameMenuItem()
	{
		super("Play Game");
	}

	/**
	 * Az első pályától indít egy játékot.
	 */
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