package fearlesscode.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import fearlesscode.menu.Menu;
import fearlesscode.menu.MenuItem;

import javax.imageio.ImageIO;

/**
 * Egy menüpontot rajzol ki.
 */
public class MenuItemDrawer implements Drawer
{
	/**
	 * A kirajzolandó menüpont.
	 */
	private MenuItem item;

	/**
	 * Létrehoz egy rajzolót a megadott menüponthoz.
	 * @param subject A kirajzolandó menüpont.
	 */
	public MenuItemDrawer(MenuItem subject)
	{
		item=subject;
	}

	/**
	 * A menüpont állapotától függően (aktív/inaktív) kirajzolja a menüpontot.
	 * Natív AWT metódusokat használ.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
        BufferedImage texture = null;

        String imgPath = "images/menus/" + item.getTitle();

        if(item.isActive()){
            imgPath = imgPath + "_active.png";

        } else {
            imgPath = imgPath + ".png";
        }

        try {
            texture = ImageIO.read(getClass().getResourceAsStream(imgPath));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        g.drawImage(texture, null, 0, 0);
	}
}