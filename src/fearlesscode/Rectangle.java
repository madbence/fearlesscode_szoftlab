package fearlesscode;

import fearlesscode.util.*;
import java.util.*;

/**
 * Wrapper osztály téglalap tárolásához.
 * 
 * Egy-egy téglalapot négy paraméterrel reprezentálunk. Egy pont és a hozzá tartozó szélességi, valamint magassági adatokkal.
 * A téglalap kezdőpontjának a bal felső sarkot tekintjük.
 */
public class Rectangle extends Shape
{
	/**
	 * A téglalap szélességét jelenti.
	 */
	private double width;

	/**
	 * A téglalap magasságát jelenti.
	 */
	private double height;

	/**
	 * Példányosít egy Rectangle objektumot.
	 *
	 * A megadott paramétereknek megfelelően létrehoz egy téglalapot.
	 * @param width A téglalap szélességének az értéke.
	 * @param height A téglalap magasságának az értéke.
	 */
	public Rectangle (double width, double height)
	{
		this.width = width;
		this.height = height;
	}

	/**
	 * A szélessége gettere.
	 * @return A téglalap szélessége.
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * A magasság gettere.
	 * @return A téglalap magassága.
	 */
	public double getHeight()
	{
		return height;
	}
}
