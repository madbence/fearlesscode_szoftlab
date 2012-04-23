package fearlesscode.io;

import fearlesscode.controller.*;

/**
 * A játéktér kontrollerének metódusait hívja az érkező bemenet és a konfiguráció függvényében.
 */
public class PlayFieldInputHandler extends InputHandler
{
	/**
	 * A tárolt kontroller.
	 */
	private PlayFieldController controller;

	/**
	 * A tárolt konfiguráció.
	 */
	private PlayFieldKeyConfiguration config;

	/**
	 * Beállítja a kontrollert.
	 * @param con A beállítandó kontroller.
	 */
	public void setController(PlayFieldController con)
	{
		controller=con;
	}

	/**
	 * Beállítja a konfigurációt.
	 * @param con A beállítandó konfiguráció.
	 */
	public void setConfig(PlayFieldKeyConfiguration con)
	{
		config=con;
	}

	/**
	 * A megfelelő billentyű leütésekor meghívja a kontroller megfelelő metódusát (toggleMode()).
	 * @param k A lenyomott billentyű kódja.
	 */
	public void handleKeyPressed(int k)
	{
		if(k == config.getToggleMode())
		{
			controller.toggleMode();
		}
	}

	/**
	 * Billentyű felengedésekor semmi sem történik.
	 * @param k A felengedett billentyű kódja.
	 */
	public void handleKeyReleased(int k)
	{
	}
}