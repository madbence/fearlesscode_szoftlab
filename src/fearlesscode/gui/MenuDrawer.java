package fearlesscode.gui;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import fearlesscode.menu.Menu;
import fearlesscode.menu.MenuItem;

import javax.imageio.ImageIO;

/**
 * Kirajzol egy menüt.
 */
public class MenuDrawer implements Drawer
{
	/**
	 * A kirajzolandó menü.
	 */
	private Menu menu;

	/**
	 * Létrehoz egy rajzolót a megadott menühöz.
	 */
	public MenuDrawer(Menu subject)
	{
		menu=subject;
	}

	/**
	 * Végigiterál a menüpontokon, és azok rajzolóján meghívja a draw metódust.
	 * Közben a grafikus felületet úgy transzformálja, hogy a menüpontok egymás alá kerüljenek.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		AffineTransform t=g.getTransform();
        BufferedImage texture = null;
        String imgPath = "images/menu_bg.png";

        try {
            texture = ImageIO.read(getClass().getResourceAsStream(imgPath));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        g.drawImage(texture, null, 0, 0);

		g.translate(100, 60);
		for(MenuItem item:menu.getItems())
		{
			MenuItemDrawer drawer=new MenuItemDrawer(item);
			drawer.draw(g);
			g.translate(0, 70);
		}
		g.setTransform(t);
	}
}