package fearlesscode.io;

/**
 * A játéktér irányításához tartozó billentyűzetkiosztást tárolja.
 */
public class PlayFieldKeyConfiguration
{
	/**
	 * A játékmódváltás kódja.
	 */
	private int toggle;

	/**
	 * Létrehoz egy billentyűzetkiosztást a megadott billentyűvel.
	 * @param t A játékmódváltás kódja.
	 */
	public PlayFieldKeyConfiguration(int t)
	{
		toggle=t;
	}

	/**
	 * Visszaadja a játékmódváltás kódját.
	 * @return A módváltás kódja.
	 */
	public int getToggleMode()
	{
		return toggle;
	}

	/**
	 * Beállítja a módváltás kódját.
	 * @param key A módváltás kódja.
	 */
	public void setToggleMode(int key)
	{
		toggle=key;
	}
}