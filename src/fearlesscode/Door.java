package fearlesscode;

import fearlesscode.util.*;


/**
*	A Door értesíti a PlayFieldet, ha a pályának vége,
*   ezt akkor teszi, ha a játékosnál lévo ̋ kulcsok száma megegyezik
*   az ajtó kinyitásához szükséges kulcsok számával.
*/
public class Door extends Entity
{
	/**
	*A Door konstruktora
	*@param requiredKeys Az ajtó kinyitásához szükséges kulcsok száma.
	*@param playField referencia a PlayFieldre.
	*/
	public Door(int requiredKeys, PlayField playField)
	{
		super(playField);
		Logger.reg(this, "door");
		//Logger.call(this,"Door.init()");
		//Logger.ret(this,"Door.init()");
	}
	
	/**
	* Ha a játékosnál lévo ̋ kulcsok száma megegyezik a szükséges
	* kulcsok számával, értesíti a PlayFieldet, hogy a pályának vége.
	*/
	
	public void meetPlayer(Player player)
	{
		Logger.call(this,"meetPlayer(player)");
		player.getObtainedKeys();
		if(Logger.ask("Nyithato az ajto?"))
		{
			playField.win();
		}
		Logger.ret(this,"meetPlayer(player)");
	}
}