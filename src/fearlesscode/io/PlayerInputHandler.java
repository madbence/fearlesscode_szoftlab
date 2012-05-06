package fearlesscode.io;

import fearlesscode.controller.*;

/**
 * Egy játékost irányít (meghívja a kontroller megfelelő metódusait) az érkezett bemenet és a konfiguráció függvényében.
 */
public class PlayerInputHandler extends InputHandler
{
	/**
	 * A tárolt kontroller.
	 */
	private PlayerController controller;

	/**
	 * A tárolt konfiguráció.
	 */
	private PlayerKeyConfiguration config;

	/**
	 * Visszaadja a tárolt kontrollert.
	 * @return a tárolt kontroller.
	 */
	public PlayerController getController()
	{
		return controller;
	}

	/**
	 * Visszaadja a tárolt konfigurációt.
	 * @return A tárolt konfiguráció.
	 */
	public PlayerKeyConfiguration getConfig()
	{
		return config;
	}

	/**
	 * Beállítja a kontrollert.
	 * @param c A beállítandó kontroller.
	 */
	public void setController(PlayerController c)
	{
		controller=c;
	}

	/**
	 * Beállítja a konfigurációt.
	 * @param c A beállítandó konfiguráció.
	 */
	public void setConfig(PlayerKeyConfiguration c)
	{
		config=c;
	}

	/**
	 * A megfelelő billentyű lenyomásakor a kontroller metódusait hívja.
	 * @param k A lenyomott billentyű kódja (KeyEvent konstans).
	 */
	public void handleKeyPressed(int k)
	{
		if(k == config.getLeft())
		{
			controller.moveLeft();
		}
		else if(k == config.getRight())
		{
			controller.moveRight();
		}
		else if(k == config.getJump())
		{
			controller.jump();
		}
	}

	/**
	 * A megfelelő billentyű felengedésekor meghívja a kontroller megfelelő metódusát (megállítja a játékost).
	 * @param k A felengedett billentyű kódja (KeyEvent konstans).
	 */
	public void handleKeyReleased(int k)
	{
		if(k == config.getLeft())
		{
			controller.stopMove(true);
		}
		else if(k == config.getRight())
		{
			controller.stopMove(false);
		}
	}
}