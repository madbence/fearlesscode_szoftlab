package fearlesscode;

import fearlesscode.util.*;


/**
* Az üres blokkot reprezentálja, gyakorlatilag a Block osztály default (üres)
* implemetáció- ja.
*/
public class EmptyBlock extends Block
{

	/**
	* Az EmptyBlock konstruktora, PlayField referenciával.
	*/
	public EmptyBlock(PlayField pf)
	{
		super(pf);
		Logger.call(this,"init()");
		Logger.ret(this,"Block.init()");
	}
	
	/**
	* Mivel üres blokk, semmi sincs benne, így ez a metódus nem csinál semmit.
	*/
	public void checkBorders()
	{
		Logger.call(this,"checkBorders()");
		Logger.ret(this,"checkBorders()");
	}
	
	/**
	* Mivel üres blokk, semmi sincs benne, így ez a metódus nem csinál semmit.
	*/
	public void processCollisions()
	{
		Logger.call(this,"processCollisions()");
		Logger.ret(this,"processCollisions()");
	}
}