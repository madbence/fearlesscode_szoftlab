package fearlesscode;

import fearlesscode.util.*;

public class Door extends Entity
{
	/**
	 * A Door konstruktora
	 * @param requiredKeys Az ajtó kinyitásához szükséges kulcsok száma.
	 * @param playField referencia a PlayFieldre.
	 */
	public Door(int requiredKeys, PlayField playField)
	{
		super(playField);
	}
	
	/**
	 * Ha a játékosnál lévő kulcsok száma megegyezik a szükséges
	 * kulcsok számával, értesíti a PlayFieldet, hogy a pályának vége.
	 */
	public void meetPlayer(Player player)
	{
		player.getObtainedKeys();
		if(Logger.ask("Nyithato az ajto?"))
		{
			playField.win();
		}
	}
}