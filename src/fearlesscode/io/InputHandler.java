package fearlesscode.io;

import fearlesscode.controller.*;

/**
 * Az egyes inputkezelő osztályok innen származnak.
 */
public abstract class InputHandler
{
	/**
	 * A leszármazottak saját maguk definiálják mit tesznek egy billentyű lenyomásakor.
	 * @param key A lenyomott billentyű.
	 */
	public abstract void handleKeyPressed(int key);

	/**
	 * A leszármazottak saját maguk definiálják mit tesznek egy billentyű felengedésekor.
	 * @param key A felengedett billentyű.
	 */
	public abstract void handleKeyReleased(int key);
}