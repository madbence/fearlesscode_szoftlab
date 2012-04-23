package fearlesscode.controller;

import fearlesscode.model.block.*;
import fearlesscode.model.core.*;

/**
 * Egy blokkot irányít.
 */
public class BlockController
{
	/**
	 * Az irányítandó blokk.
	 */
	private Block block;

	/**
	 * A blokk ezen a játéktéren van.
	 */
	private PlayField playField;

	/**
	 * Létrehoz egy kontrollert.
	 * @param block Az irányítandó blokk.
	 * @param pf A tartalmazó PlayField.
	 */
	public BlockController(Block block, PlayField pf)
	{
		this.block=block;
		playField=pf;
	}

	/**
	 * Felfele mozgatja a blokkot.
	 */
	public void moveNorth()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 2);
		}
	}

	/**
	 * Jobbra mozgatja a blokkot.
	 */
	public void moveEast()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 3);
		}
	}

	/**
	 * Lefele mozgatja a blokkot.
	 */
	public void moveSouth()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 0);
		}
	}

	/**
	 * Balra mozgatja a blokkot.
	 */
	public void moveWest()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 1);
		}
	}
}