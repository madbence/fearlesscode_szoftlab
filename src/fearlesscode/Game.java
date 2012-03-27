package fearlesscode;

import fearlesscode.util.*;

public class Game {

	private PlayField playField;

	/**
	 * Letrehoz egy új Game példányt.
	 *
	 * A Game objektum felelős a pályák betöltéséért, valamint a főbb jatekmozzanatok kezeléséért.
	 */
	public Game()
	{
		Logger.reg(this, "g");
	}


	/**
	 * Betölti a következő pályát.
	 *
	 * Az aktuális pálya ismeretében megkeresi a következő pálya specifikációját,
	 * es legyártatja a PlayFieldBuilder osztállyal.
	 */
	public void loadNextLevel()
	{
		Logger.call(this, "loadNextLevel()");
		playField=PlayFieldBuilder.createPlayField(this);
		Logger.ret(this, "loadNextLevel()");
	}

	/**
	 * Elindítja a játékot.
	 * 
	 * Betölti a megfelelő specifikációval rendelkező pályát, majd elindítja a játékot vele.
	 */
	public void start()
	{
		Logger.call(this, "start()");
		playField=PlayFieldBuilder.createPlayField(this);
		Logger.ret(this, "start()");
	}

	public PlayField getPlayField()
	{
		return playField;
	}

}