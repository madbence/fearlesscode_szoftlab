package fearlesscode.gui;

import fearlesscode.model.player.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Egy játékost rajzol ki.
 */
public class PlayerDrawer implements Drawer
{

    private BufferedImage texture;

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
        if(texture == null){
            String imgPath = "images/player_white_";
            if(player.getSpeed().getY() != 0){
                imgPath = imgPath + "fall_";
            }

            if(player.getSpeed().getX() > 0){
                imgPath = imgPath + "right.png";

            } else {
                imgPath = imgPath + "left.png";
            }

            try {
                texture = ImageIO.read(getClass().getResourceAsStream(imgPath));

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        g.drawImage(texture, null, 5, 0);
	}
}