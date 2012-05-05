package fearlesscode.gui;

import fearlesscode.model.entity.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.IOException;

/**
 * Kirajzol egy falat.
 */
public class WallDrawer extends EntityDrawer
{
    private static BufferedImage texture;
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
        g.setPaint(Color.black);
        g.fillRect(0, 0, (int) wall.getWidth(), (int) wall.getHeight());

        BufferedImage clipTemp = null;

        if(texture == null){
            try {
                String imgPath = "images/wall.png";
                texture = ImageIO.read(getClass().getResourceAsStream(imgPath));
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        try {
            clipTemp = texture.getSubimage(0,0,(int)wall.getWidth(),(int)wall.getHeight());
        } catch (RasterFormatException rfe){

        }

        g.drawImage(clipTemp, null, 0, 0);
	}
}