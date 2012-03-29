package fearlesscode;

import fearlesscode.util.*;
import java.util.*;


/**
*	A Player számon tartja magáról, hogy mely blokkokban van jelen,
*   valamint a nála lévo ̋ kulcsok számát.
*	obtainedKeys A megszerzett kulcsok száma.
*	activeBlocks A játékos jelenleg ezekben a blokkokban van jelen. Ha ez több egynél, akkor a mozgatás nem feltétlenül lehetséges.
*	speed A játékos jelenlegi sebessége, ebbo ̋l számítható a következo ̋ pozíciója.
*/
public class Player
{
	private Speed speed;
	private ArrayList<Block> activeBlocks;

	public Player()
	{
		Logger.reg(this, "player");
		activeBlocks=new ArrayList<Block>();
	}

	public Speed getSpeed()
	{
		Logger.call(this, "getSpeed()");
		Logger.ret(this, "getSpeed()");
		return speed;
	}

	/**
	 * Megnöveli a nála lévő kulcsok számát.
	 */
	public void addKey()
	{
		Logger.call(this, "addKey()");
		Logger.ret(this, "addKey()");
	}

	/**
	 * A játékos belép a megadott blokkba.
	 * @param block
	 */
	public void enterBlock(Block block)
	{
		Logger.call(this, "enterBlock(block)");
		activeBlocks.add(block);
		Logger.ret(this, "enterBlock(block)");
	}

	/**
	 * A játékos által elfoglalt blokkokat adja vissza.
	 */
	public ArrayList<Block> getActiveBlocks()
	{
		Logger.call(this, "getActiveBlocks()");
		Logger.ret(this, "getActiveBlocks()");
		return activeBlocks;
	}

	/**
	 * A játékos által birtokolt kulcsok számát adja vissza.
	 */
	public int getObtainedKeys()
	{
		Logger.call(this, "getObtainedKeys()");
		Logger.ret(this, "getObtainedKeys()");
		return 0;
	}

	/**
	 * A játékos kilép a megadott blokkból.
	 * @param block
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
	 * @param dir
	 */
	public void move(Speed newSpeed)
	{
		Logger.call(this, "move(newSpeed)");

		Logger.ret(this, "move(newSpeed)");
	}

}