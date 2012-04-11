package fearlesscode;

import fearlesscode.util.*;
import java.util.*;

/**
 * Ütközések detektálására szolgáló objektum.
 * 
 * Az objektum segítségével különböző Shape objektumok ütközését tudjuk meghatározni. A játék során lényegében csak
 * Rectangle objektumokat fogunk ütköztetni, de a modularitásnak köszönhetően ez könnyen bővíthető.
 */
public class CollisionProcesser
{
	/**
	 * Két Rectangle objektum ütközéséről dönt.
	 *
	 * @param main A egyik ütköztetendő Rectangle.
	 * @param other A másik ütköztetendő Rectangle.
	 * @return A visszatérési érték true, ha a két téglalap ütközött, false ha nem.
	 */
	public boolean isCollied(Rectangle main, Rectangle other)
	{
		boolean isCollied = false;

		if(this.isPointInRectangle(main.x, main.y, other))
		{
			isCollied = true;
		}

		if(this.isPointInRectangle(main.x + main.height, main.y, other))
		{
			isCollied = true;
		}

		if(this.isPointInRectangle(main.x, main.y + main.width, other))
		{
			isCollied = true;
		}

		if(this.isPointInRectangle(main.x + main.height, main.y + main.width, other))
		{
			isCollied = true;
		}

		return isCollied;
	}

	/**
	 * Egy pont egy adott intervallumba eséséről dönt.
	 *
	 * @param point A vizsgálandó pont.
	 * @param intervalStart Az intervallum kezdete.
	 * @param intervalStart Az intervallum vége.
	 * @return True értékkel tér vissza, ha az adott pont a meghatározott intervallumba esik.
	 */
	private boolean isPointInInterval(double point, double intervalStart, double intervalEnd)
	{
		boolean isInInterval = false;

		if(point > intervalStart && point < intervalEnd)
		{
			isInInterval = true;
		}

		return isInInterval;
	}

	/**
	 * Egy pont egy adott téglalapba eséséről dönt.
	 *
	 * @param px A vizsgálandó pont X koordinátája.
	 * @param py Az vizsgálandó pont Y koordinátája.
	 * @param rectangle A vizsgálandó téglalap
	 * @return True értékkel tér vissza, ha az adott pont a meghatározott intervallumba esik.
	 */
	private boolean isPointInRectangle(double px, double py, Rectangle rectangle)
	{
		boolean isInRectangle = false;

		if(this.isPointInInterval(px, rectangle.x, rectangle.x + rectangle.width) &&
			this.isPointInInterval(py, rectangle.y, rectangle.y + rectangle.height))
		{
			isInRectangle = true;
		}

		return isInRectangle;
	}
}
