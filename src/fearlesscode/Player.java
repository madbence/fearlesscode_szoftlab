package fearlesscode;

import fearlesscode.util.*;
import java.util.*;


/**
 * A játékos(okat) reprezentáló osztály. 
 * 
 * A Player számon tartja magáról, hogy mely blokkokban van jelen, valamint a nála lévő kulcsok számát.
 */
public class Player
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
	* A Player konstruktora.
	* 
	* Egy új üres listát hoz létre az activeBlockoknak.
	*/
	public Player()
	{
		Logger.reg(this, "player");
		activeBlocks=new ArrayList<Block>();
	}


	/**
	 * A sebesség gettere.
	 *
	 * @return A sebesség.
	 */
	public Speed getSpeed()
	{
		Logger.call(this, "getSpeed()");
		Logger.ret(this, "getSpeed()");
		return speed;
	}

	/**
	 * A felvett kulcsok számának növelésére szolgáló metódus.
	 */
	public void addKey()
	{
		Logger.call(this, "addKey()");
		Logger.ret(this, "addKey()");
	}

	/**
	 * A Block-ba történő beléptetést végző metódus.
	 *
	 * @param block Referencia, hogy melyik Block-ba történik a belépés.
	 */
	public void enterBlock(Block block)
	{
		Logger.call(this, "enterBlock(block)");
		activeBlocks.add(block);
		Logger.ret(this, "enterBlock(block)");
	}

	/**
	 * Az aktív blokkok gettere.
	 * 
	 * @return Az aktiív blokkok listája.
	 */
	public ArrayList<Block> getActiveBlocks()
	{
		Logger.call(this, "getActiveBlocks()");
		Logger.ret(this, "getActiveBlocks()");
		return activeBlocks;
	}

	/**
	 * A felvett kulcsok számának gettere.
	 *
	 * @return A felvett kulcsok száma.
	 */
	public int getObtainedKeys()
	{
		Logger.call(this, "getObtainedKeys()");
		Logger.ret(this, "getObtainedKeys()");
		return 0;
	}

	/**
	 * A játékos kilép a megadott blokkból.
	 *
	 * @param block Referecina, hogy melyik Blockból történik a kilépés.
	 */
	public void leaveBlock(Block block)
	{
		Logger.call(this, "leaveBlock(block)");
		activeBlocks.remove(activeBlocks.indexOf(block));
		Logger.ret(this, "leaveBlock(block)");
	}

	/**
	 * A játékos sebességét megváltoztatja a megadott mértékben. Ténylegesen nem
	 * mozgatja a játékost, csak egy sebességvektort állít.
	 *
	 * @param newSpeed Az új sebesség.
	 */
	public void move(Speed newSpeed)
	{
		Logger.call(this, "move(newSpeed)");

		Logger.ret(this, "move(newSpeed)");
	}

}