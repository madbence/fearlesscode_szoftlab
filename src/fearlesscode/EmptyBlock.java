package fearlesscode;

import fearlesscode.util.*;

/**
 * Az üres blokkot reprezentálja, gyakorlatilag a Block osztály default (ü̈res)
 * implemetációja.
 */
public class EmptyBlock extends Block
{

	/**
	 * Az EmptyBlock konstruktora, PlayField referenciával.
	 */
	public EmptyBlock(PlayField pf)
	{
		super(pf);
	}
	
	/**
	 * Mivel üres blokk, semmi sincs benne, így ez a metódus nem csinál semmit.
	 */
	public void checkBorders()
	{

	}
	
	/**
	 * Mivel ü̈res blokk, semmi sincs benne, így ez a metódus nem csinál semmit.
	 */
	public void processCollisions()
	{

	}
}