package fearlesscode.gui;

import fearlesscode.model.entity.*;
import java.awt.*;

/**
 * Egy ajtót kirajzoló osztály.
 */
public class DoorDrawer extends EntityDrawer
{
	/**
	 * Létrehoz egy rajzolót egy ajtónak.
	 * @param subject A kirajzolandó ajtó.
	 */
	public DoorDrawer(Door subject)
	{
		super(subject);
	}

	/**
	 * Kirajzol egy ajtót. Natív AWT metódusokat használ.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		g.setPaint(Color.yellow);
		g.fillRect(0,0,(int)Door.WIDTH,(int)Door.HEIGHT);
	}
}