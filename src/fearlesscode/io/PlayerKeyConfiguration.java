package fearlesscode.io;

/**
 * Egy játékos irányításához tartozó konfigurációt tárolja.
 */
public class PlayerKeyConfiguration
{
	/**
	 * A bal iránybillentyű kódja.
	 */
	private int left;

	/**
	 * A jobb iránybillentyű kódja.
	 */
	private int right;

	/**
	 * Az ugrás kódja.
	 */
	private int jump;

	/**
	 * Létrehoz egy új konfigurációt a megadott billentyűkkel.
	 * @param l A balra mozgás kódja.
	 * @param r A jobbra mozgás kódja.
	 * @param j Az ugrás kódja.
	 */
	public PlayerKeyConfiguration(int l, int r, int j)
	{
		left=l;
		right=r;
		jump=j;
	}

	/**
	 * Visszaadja a balra mozgás kódját.
	 * @return A balra mozgás kódja.
	 */
	public int getLeft()
	{
		return left;
	}

	/**
	 * Visszaadja a jobbra mozgás kódját.
	 * @return A jobbra mozgás kódja.
	 */
	public int getRight()
	{
		return right;
	}

	/**
	 * Visszaadja az ugrás kódját.
	 * @return Az ugrás kódja.
	 */
	public int getJump()
	{
		return jump;
	}

	/**
	 * Beállítja a balra mozgás kódját.
	 * @param key A balra mozgás kódja.
	 */
	public void setLeft(int key)
	{
		left=key;
	}

	/**
	 * Beállítja a jobbra mozgás kódját.
	 * @param key A jobbra mozgás kódja.
	 */
	public void setRight(int key)
	{
		right=key;
	}

	/**
	 * Beállítja az ugrás kódját.
	 * @param key Az ugrás kódja.
	 */
	public void setJump(int key)
	{
		jump=key;
	}
}