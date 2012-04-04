package fearlesscode;

import fearlesscode.util.*;

/**
 * A játék fő mozzanatait kezelő osztály.
 * A játék fő mozzanatait (pálya betöltés, játék megnyerése) kezeli. Kezdetben inicializál minden objektumot.
 * Felelőssége a pálya betöltése (és inicializálása).
 */
public class Game
{

	/**
	 * A tárolt PlayField referenciája.
	 */
	private PlayField playField;

	/**
	 * Létrehoz egy új Game példányt.
	 *
	 * A Game objektum felelős a pályák betöltéséért, valamint a főbb jatekmozzanatok kezeléséért.
	 */
	public Game()
	{
		
	}

	/**
	 * Betölti a következő pályát.
	 *
	 * Az aktuális pálya ismeretében megkeresi a következő pálya specifikációját,
	 * és legyártatja a PlayFieldBuilder osztállyal.
	 */
	public void loadNextLevel()
	{
		//playField = PlayFieldBuilder.createPlayField(this);
	}

	/**
	 * Elindítja a játékot.
	 * 
	 * Betölti a megfelelő specifikációval rendelkező pályát, majd elindítja a játékot vele.
	 */
	public void start()
	{
		//playField = PlayFieldBuilder.createPlayField(this);
	}
	
	/**
	 * A tárolt PlayField gettere.
	 *
	 * @return A tárolt PlayFiled.
	 */
	public PlayField getPlayField()
	{
		return playField;
	}

}