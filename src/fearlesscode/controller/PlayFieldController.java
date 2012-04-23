package fearlesscode.controller;

import fearlesscode.model.core.*;

/**
 * Egy játékteret irányít.
 */
public class PlayFieldController
{
	/**
	 * Az irányítandó játéktér.
	 */
	private PlayField playField;

	/**
	 * Létrehozza a kontrollert.
	 * @param pf Az irányítandó játéktér.
	 */
	public PlayFieldController(PlayField pf)
	{
		playField=pf;
	}

	/**
	 * Megváltoztatja a játékmódot a játéktéren.
	 */
	public void toggleMode()
	{
		playField.toggleMode();
	}
}