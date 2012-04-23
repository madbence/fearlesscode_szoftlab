package fearlesscode.menu;

/**
 * Egy menüpontot reprezentáló osztály.
 */
public abstract class MenuItem
{
	/**
	 * A menüpont felirata.
	 */
	private String title;

	/**
	 * A menüpont állapota (aktív, inaktív).
	 */
	private boolean active;

	/**
	 * Létrehoz egy menüpontot.
	 * @param str A menüpont felirata.
	 */
	public MenuItem(String str)
	{
		title=str;
		active=false;
	}

	/**
	 * A menüpont aktiválásakor történős eseményeket a leszármazottaknak kell definiálnia.
	 */
	public abstract void activate();

	/**
	 * Visszaadja a menüpont feliratát.
	 * @return A menüpont felirata.
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Beállítja a menüpont aktív/inaktív voltát.
	 * @param state Az új állapot.
	 */
	public void setActive(boolean state)
	{
		active=state;
	}

	/**
	 * Visszaadja a menüpont állapotát.
	 * @return A menüpont állapota (igaz, ha aktív).
	 */
	public boolean isActive()
	{
		return active;
	}
}