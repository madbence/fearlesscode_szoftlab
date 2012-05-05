package fearlesscode.menu;

import fearlesscode.app.*;

/**
 * A MenuItem leszármazottja, a viselkedése az activate() metódusban található.
 */
public class ExitGameMenuItem extends MenuItem
{
	/**
	 * Létrehozza a menüpontot.
	 */
	public ExitGameMenuItem()
	{
		super("exit");
	}

	/**
	 * Kilép a programból.
	 */
	public void activate()
	{
		Grafikus.getInstance().exit();
	}
}