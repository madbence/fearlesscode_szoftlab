/**
 * Blokkot és a hozzátartozó pozíciót tömörítő wrapper osztály.
 */
public class BlockContainer
{
	/**
	 * A blokkohoz tartozó pozíció.
	 */
	private Position position;

	/**
	 * Az adott blokk.
	 */
	private Block block;

	/**
	 * Létrehoz egy BlockContainert a megadott paraméterekkel.
	 * @param p A blokkhoz tartozó pozíció.
	 * @param b Az adott blokk.
	 */
	public BlockContainer(Position p, Block b)
	{
		position=p;
		block=b;
	}
}