package fearlesscode.menu;

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
		super("Exit");
	}

	/**
	 * Kilép a programból.
	 */
	public void activate()
	{
		System.exit(0);
	}
}