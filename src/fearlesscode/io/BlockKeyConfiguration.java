package fearlesscode.io;

/**
 * Egy blokk mozgatásához tartozó billentyűzetkiosztást tárolja.
 */
public class BlockKeyConfiguration
{
	/**
	 * A felfelé mozgatás billentyűkódja.
	 */
	private int north;

	/**
	 * A jobbra mozgatás billentyűkódja.
	 */
	private int east;

	/**
	 * A lefelé mozgatás billentyűkódja.
	 */
	private int south;

	/**
	 * A balra mozgatás billentyűkódja.
	 */
	private int west;

	/**
	 * Létrehoz egy konfigurációt a megadott billenytűkkel.
	 * @param n A felfelé mozgatás kódja.
	 * @param e A jobbra mozgatás kódja.
	 * @param s A lefelé mozgatás kódja.
	 * @param w A balra mozgatás kódja.
	 */
	public BlockKeyConfiguration(int n, int e, int s, int w)
	{
		north=n;
		east=e;
		south=s;
		west=w;
	}

	/**
	 * Visszaadja a felfelé mozgatás billentyűkódját.
	 * @return A kért kód.
	 */
	public int getNorth()
	{
		return north;
	}

	/**
	 * Visszaadja a jobbra mozgatás billentyűkódját.
	 * @return A kért kód.
	 */
	public int getEast()
	{
		return east;
	}

	/**
	 * Visszaadja a lefelé mozgatás billentyűkódját.
	 * @return A kért kód.
	 */
	public int getSouth()
	{
		return south;
	}

	/**
	 * Visszaadja a balra mozgatás billentyűkódját.
	 * @return A kért kód.
	 */
	public int getWest()
	{
		return west;
	}
}