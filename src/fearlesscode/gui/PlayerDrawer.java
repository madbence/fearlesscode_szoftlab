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
    private static long lastMilisec = 0;
    private static Integer frame = 0;

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
        String color = "white";
        String imgPath = "images/player_";
        
        if(player.getID() == 1){
            color = "red";
        }

        imgPath = imgPath + color + "_";

        String direction = "left";

        if(lastMilisec == 0){
            lastMilisec = System.currentTimeMillis();
        }

        if((System.currentTimeMillis() - lastMilisec) > 200){
            lastMilisec = System.currentTimeMillis();
            frame = (frame + 1)%4;
        }

        if(player.getSpeed().getX() > 0){
            direction = "right";
        }
        
        if(player.getSpeed().getY() != 0){
            imgPath = imgPath + "fall_" + direction + ".png";
        } else {
            if(player.getSpeed().getX() == 0){
                imgPath = imgPath + direction +".png";
            } else {
                imgPath = imgPath + direction + "_move_" + frame.toString() + ".png";
            }
        }

        try {
            texture = ImageIO.read(getClass().getResourceAsStream(imgPath));

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        g.drawImage(texture, null, 0, 0);
	}
}