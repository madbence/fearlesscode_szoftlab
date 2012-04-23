package fearlesscode.gui;

import fearlesscode.model.block.*;
import java.awt.*;

/**
 * Absztrakt osztály, az egyes blokktípusok kiterjeszthetik.
 */
public abstract class BlockDrawer implements Drawer
{
	/**
	 * A kirajzolandó blokk.
	 */
	protected Block block;

	/**
	 * Létrehoz egy új BlokkDrawer-t.
	 * @param subject A kirajzolandó blokk.
	 */
	public BlockDrawer(Block subject)
	{
		block=subject;
	}

	/**
	 * A kirajzolást a leszármazottaknak kell definiálniuk.
	 * @param g A grafikus felület, amire rajzolni kell.
	 */
	public abstract void draw(Graphics2D g);
}