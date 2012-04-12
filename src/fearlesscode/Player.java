package fearlesscode;

import fearlesscode.util.*;
import java.util.*;


/**
 * A játékos(okat) reprezentáló osztály. 
 * 
 * A Player számon tartja magáról, hogy mely blokkokban van jelen, valamint a nála lévő kulcsok számát.
 */
public class Player implements Info, Collideable
{
	/**
	 * A játékos jelenlegi sebessége, ebből számítható a következő poziciója.
	 */
	private Speed speed;
	
	/**
	 * A megszerzett kulcsok száma.
	 */
	private int obtainedKeys;
	
	/**
	 * A játékos jelenleg ezekben a blokkokban van jelen. Ha ez több egynél, akkor a mozgatása nem feltétlenül lehetséges.
	 */
	private ArrayList<Block> activeBlocks;

	/**
	 * Számolja a létrehozott játékosokat.
	 */
	private static int count=0;

	/**
	 * A játékos azonosítója.
	 */
	private int id;

	/**
	* A Player konstruktora.
	* 
	* Egy új üres listát hoz létre az activeBlockoknak.
	*/
	public Player()
	{
		activeBlocks=new ArrayList<Block>();
		id=count++;
		obtainedKeys = 0;
		speed = new Speed(0, 0);
	}


	/**
	 * A sebesség gettere.
	 *
	 * @return A sebesség.
	 */
	public Speed getSpeed()
	{
		return speed;
	}

	/**
	 * A felvett kulcsok számának növelésére szolgáló metódus.
	 */
	public void addKey()
	{
		obtainedKeys++;
	}

	/**
	 * A felvett kulcsok számát nullázza.
	 */
	public void resetKeys()
	{
		obtainedKeys=0;
	}

	/**
	 * A Block-ba történő beléptetést végző metódus.
	 *
	 * @param block Referencia, hogy melyik Block-ba történik a belépés.
	 */
	public void enterBlock(Block block)
	{
		activeBlocks.add(block);
	}

	/**
	 * Az aktív blokkok gettere.
	 * 
	 * @return Az aktiív blokkok listája.
	 */
	public ArrayList<Block> getActiveBlocks()
	{
		return activeBlocks;
	}

	/**
	 * A felvett kulcsok számának gettere.
	 *
	 * @return A felvett kulcsok száma.
	 */
	public int getObtainedKeys()
	{
		return 0;
	}

	/**
	 * A játékos kilép a megadott blokkból.
	 *
	 * @param block Referecina, hogy melyik Blockból történik a kilépés.
	 */
	public void leaveBlock(Block block)
	{
		activeBlocks.remove(activeBlocks.indexOf(block));
	}

	/**
	 * A játékos sebességét megváltoztatja a megadott mértékben. Ténylegesen nem
	 * mozgatja a játékost, csak egy sebességvektort állít.
	 *
	 * @param newSpeed Az új sebesség.
	 */
	public void move(Speed newSpeed)
	{
		speed=new Speed(speed.getX()+newSpeed.getX(), speed.getY()+newSpeed.getY());
	}
	
	/**
	 * A Player informácioinak lekérésére.
	 * @return A saját koordinátája a Block-on belül, és hogy hány kulcs van nála.
	 */
	public String getInfo()
	{
		return null;
	}
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return null;
	}

	/**
	 * Visszaadja a játékos azonosítóját.
	 */
	public int getID()
	{
		return id;
	}

	/**
	 * Visszaadja a befoglaló téglalap méretét.
	 */
	public Rectangle getBoundingBox()
	{
		return new Rectangle(10, 20);
	}

	/**
	 * Az aktuális sebesség alapján visszaadja a következő pozíciót.
	 * @param current Az aktuális pozíció.
	 * @return A sebesség és a paraméter alapján számolt pozíció.
	 */
	public EntityPosition getNextPosition(EntityPosition current)
	{
		return new EntityPosition(current.getX()+speed.getX(), current.getY()+speed.getY());
	}
}