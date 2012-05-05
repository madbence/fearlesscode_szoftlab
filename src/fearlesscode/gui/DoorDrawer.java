package fearlesscode.gui;

import fearlesscode.model.entity.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Egy ajtót kirajzoló osztály.
 */
public class DoorDrawer extends EntityDrawer
{
    private BufferedImage texture;

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
        if(texture == null){
            try {
                String imgPath = "images/door.png";
                texture = ImageIO.read(getClass().getResourceAsStream(imgPath));
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        g.drawImage(texture, null, -5, 0);
	}
}