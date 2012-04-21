package fearlesscode.model.physics;

import java.util.*;
import fearlesscode.model.misc.*;

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
	public static boolean isCollied(EntityPosition mainPos, Rectangle main, EntityPosition otherPos, Rectangle other)
	{
		boolean isCollied = false;

		if(isPointInRectangle(mainPos.getX(), mainPos.getY(), otherPos, other))
		{
			isCollied = true;
		}

		if(isPointInRectangle(mainPos.getX(), mainPos.getY()+main.getHeight(), otherPos, other))
		{
			isCollied = true;
		}

		if(isPointInRectangle(mainPos.getX()+main.getWidth(), mainPos.getY(), otherPos, other))
		{
			isCollied = true;
		}

		if(isPointInRectangle(mainPos.getX()+main.getWidth(), mainPos.getY()+main.getHeight(), otherPos, other))
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
	private static boolean isPointInInterval(double point, double intervalStart, double intervalEnd)
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
	private static boolean isPointInRectangle(double px, double py, EntityPosition pos, Rectangle rectangle)
	{
		boolean isInRectangle = false;

		if(isPointInInterval(px, pos.getX(), pos.getX() + rectangle.getWidth()) &&
			isPointInInterval(py, pos.getY(), pos.getY() + rectangle.getHeight()))
		{
			isInRectangle = true;
		}

		return isInRectangle;
	}
}
