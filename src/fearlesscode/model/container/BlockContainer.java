package fearlesscode.model.container;

import fearlesscode.model.block.*;
import fearlesscode.model.misc.*;
import fearlesscode.model.core.*;

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
	 * A tartalmazó PlayField referenciája.
	 */
	private PlayField playField;

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
	
	/**
	 * Position getter.
	 */
	public Position getPosition()
	{
		return this.position;
	}
	
	/**
	 * Block getter.
	 */
	public Block getBlock()
	{
		return this.block;
	}
	
	/**
	 * Position setter.
	 */
	public void setPosition(Position position)
	{
		this.position = position;
	}
	
	/**
	 * Block setter.
	 */
	public void setBlock(Block block)
	{
		this.block = block;
	}

	/**
	 * Beállítja a tartalmazó PlayFieldet.
	 * @param pf A tartalmazó PlayField.
	 */
	public void setPlayField(PlayField pf)
	{
		playField=pf;
	}

	/**
	 * Lekéri a tartalmazó PlayFieldet.
	 * @return A tartalmazó PlayField.
	 */
	public PlayField getPlayField()
	{
		return playField;
	}
}