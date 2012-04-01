import fearlesscode.util.*;

/**
 * A pályán megjelenő ajtót reprezentáló objektum.
 * 
 * A Door objektum az Entity osztály kiterjesztése így ez is megvalósítja a meetPlayer
 * metódust. Abban az esteben, ha a játékos rendelkezik az összes megszerzett kulccsal,
 * akkor a játék végetér.  
 */
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
	 * @param player Az adott Player objektum, amelyikkel a Door objektum találkozott.
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