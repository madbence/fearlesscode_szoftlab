package fearlesscode.io;

import fearlesscode.controller.*;

/**
 * Egy blokk kontrollerhez irányítja az érkezett bemenetet, az aktuális konfiguráció függvényében.
 */
public class BlockInputHandler extends InputHandler
{
	/**
	 * A kontroller, ami irányítja a blokkot.
	 */
	private BlockController controller;

	/**
	 * A tárolt billentyűkiosztás.
	 */
	private BlockKeyConfiguration config;

	/**
	 * Visszaadja a tárolt kontrollert.
	 * @return A tárolt kontroller.
	 */
	public BlockController getController()
	{
		return controller;
	}

	/**
	 * Visszaadja a tárolt konfigurációt.
	 * @return A tárolt konfiguráció.
	 */
	public BlockKeyConfiguration getConfig()
	{
		return config;
	}

	/**
	 * Beállítja a kontrollert.
	 * @param c A kontroller, amit beállítunk.
	 */
	public void setController(BlockController c)
	{
		controller=c;
	}

	/**
	 * Beállítja a konfigurációt.
	 * @param c A beállítandó konfiguráció.
	 */
	public void setConfig(BlockKeyConfiguration c)
	{
		config=c;
	}

	/**
	 * Ha a leütött billentyű és a konfiguráció függvényében meghívja a kontroller egyes metódusait.
	 * @param k A leütött billentyű kódja (KeyEvent konstansok).
	 */
	public void handleKeyPressed(int k)
	{
		if(k == config.getNorth())
		{
			controller.moveNorth();
		}
		else if(k == config.getEast())
		{
			controller.moveEast();
		}
		else if(k == config.getSouth())
		{
			controller.moveSouth();
		}
		else if(k == config.getWest())
		{
			controller.moveWest();
		}
	}
	/**
	 * Felengedett billentyű esetén nem történik semmi.
	 * @param k A leütött billentyű kódja (KeyEvent konstansok).
	 */
	public void handleKeyReleased(int k)
	{

	}
}