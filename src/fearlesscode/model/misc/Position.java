package fearlesscode.model.misc;

/**
 * Egy blokk pozícióját tárolja a PlayField objektumon belül.
 */
public class Position
{
	/**
	 * Vízszintes pozíció.
	 */
	private int x;

	/**
	 * Függőleges pozíció.
	 */
	private int y;

	/**
	 * A Position konstruktora.
	 * @param x Vízszintes pozíció.
	 * @param y Függőleges pozíció.
	 */
	public Position(int x, int y)
	{
		this.x=x;
		this.y=y;
	}

	/**
	 * A vízszintes pozíció gettere.
	 * @return A tárolt vízszintes pozíció.
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * A függőleges pozíció gettere.
	 * @return A tárolt függőleges pozíció.
	 */
	public int getY()
	{
		return y;
	}
}