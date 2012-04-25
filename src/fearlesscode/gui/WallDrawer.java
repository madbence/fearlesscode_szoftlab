package fearlesscode.gui;

import fearlesscode.model.entity.*;
import java.awt.*;

/**
 * Kirajzol egy falat.
 */
public class WallDrawer extends EntityDrawer
{
	/**
	 * Létrehoz egy rajzolót a megadott falnak.
	 * @param subject A kirajzolandó fal.
	 */
	public WallDrawer(Wall subject)
	{
		super(subject);
	}

	/**
	 * Kirajzolja a falat annak paraméterei függvényében (szélesség, magasság).
	 * Natív AWT metódusokat használ.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		Wall wall=(Wall)entity;
		g.setPaint(Color.magenta);
		g.drawString(wall.getName(), 0, -10);
		g.setPaint(Color.black);
		g.fillRect(0,0,(int)wall.getWidth(),(int)wall.getHeight());
	}
}