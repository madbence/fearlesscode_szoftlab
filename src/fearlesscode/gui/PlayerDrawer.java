package fearlesscode.gui;

import fearlesscode.model.player.*;
import java.awt.*;

/**
 * Egy játékost rajzol ki.
 */
public class PlayerDrawer implements Drawer
{
	/**
	 * A kirajzolandó játékos.
	 */
	private Player player;

	/**
	 * Létrehoz egy rajzolót a megadott játékoshoz.
	 * @param subject a kirajzolandó játékos.
	 */
	public PlayerDrawer(Player subject)
	{
		player=subject;
	}

	/**
	 * Kirajzolja a játékost. Natív AWT metódusokat használ.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		g.setPaint(Color.blue);
		g.fillRect(0,0,(int)Player.WIDTH,(int)Player.HEIGHT);
	}
}