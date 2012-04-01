import fearlesscode.util.*;
import java.util.*;

/**
 * Wrapper osztály téglalap tárolásához.
 *
 * Egy-egy téglalap négy paraméterrel reprezentálunk. Egy pont és a hozzá tartozó szélességi, valamint magassági adatokkal.
 * A téglalap kezdőpontjának a bal felső sarkot tekintjük.
 */

public class Rectangle extends Shape
{
	/**
	 * A téglalap kezdőpontjának az X koordinátáját jelenti.
	 */
	public double x;

	/**
	 * A téglalap kezdőpontjának az Y koordinátáját jelenti.
	 */
	public double y;

	/**
	 * A téglalap szélességét jelenti.
	 */
	public double width;

	/**
	 * A téglalap magasságát jelenti.
	 */
	public double height;

	/**
	 * Példányosít egy Rectangle objektumot.
	 *
	 * A megadott paramétereknek megfelelően létrehoz egy téglalapot.
	 * @param x A téglalap kezdőpozíciójának x koordinátája.
	 * @param y A téglalap kezdőpozíciójának y koordinátája.
	 * @param width A téglalap szélességének az értéke.
	 * @param height A téglalap magasságának az értéke.
	 */
	public Rectangle (double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
