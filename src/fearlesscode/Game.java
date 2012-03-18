package fearlesscode;

import fearlesscode.util.*;

public class Game {

	private PlayField playField;

	/**
	 * Letrehoz egy ugy Game peldanyt
	 *
	 * A Game objektum felelos a palyak betolteseert, valamint a fobb jatekmozzanatok kezeleseert
	 */
	public Game()
	{
		Logger.reg(this, "game");
	}


	/**
	 * Betolti a kovetkezo palyat
	 *
	 * Az aktualis palya ismeretében megkeresi a kovetkezo palya specifikaciojat,
	 * es legyartatja a PlayFieldBuilder osztallyal.
	 */
	public void loadNextLevel()
	{
		Logger.call(this, "loadNextLevel()");
		playField=PlayFieldBuilder.createPlayField();
		Logger.ret(this, "loadNextLevel()");
	}

	/**
	 * Elinditja a jatekot
	 * 
	 * Betolti a megfelelo specifikacioval rendelkezo palyat, majd elinditja a jatekot vele.
	 */
	public void start()
	{
		Logger.call(this, "start()");
		playField=PlayFieldBuilder.createPlayField();
		Logger.ret(this, "start()");
	}

}