package fearlesscode;

import fearlesscode.util.*;

/**
 * A pályán megjelenő ajtót reprezentáló objektum.
 * 
 * A Door objektum az Entity osztály kiterjesztése így ez is megvalósítja a meetPlayer
 * metódust. Abban az esteben, ha a játékos rendelkezik az összes megszerzett kulccsal,
 * akkor a játék végetér.  
 */
public class Door extends Entity implements Info
{
	/**
	 * Az ajtó kinyitásához szükséges kulcsok száma.
	 */
	private int requiredKeys;

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
		this.requiredKeys-=player.getObtainedKeys();
		//új metódus
		//player.setObtainedKeys(0);
	}
	
	/**
	 * A Door informácioinak lekérése.
	 * @return A saját koordinátái a Block-on belül, elvárt kulcsok száma.
	 */
	public String getInfo()
	{
		
	}
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		
	}
}