package fearlesscode.menu;

import fearlesscode.app.*;

/**
 * A MenuItem leszármazottja, viselkedése az activate() metódusban szerepel.
 */
public class ContinueGameMenuItem extends MenuItem
{
	public ContinueGameMenuItem()
	{
		super("cont");
	}

	/**
	 * A legutolsó (amire a játékos eljutott) pályától indít egy játékot.
	 */
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