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
	public static final int TIME=200;

    private static BufferedImage[] white = new BufferedImage[12];
    private static BufferedImage[] red = new BufferedImage[12];

    private static long lastMilisec = 0;
    private static long prevMilisec = 0;
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
        String prefix = "images/player_";
        String type = ".png";
        String color = "white";
        Integer frameNumber = 0;
        Integer imageNumber = 0;

        if(white[0] == null){
            try {
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber = 0;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left" + type));
                frameNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right" + type));
                frameNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_fall_left" + type));
                frameNumber++;
                white[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_fall_right" + type));
                frameNumber++;

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        frameNumber = 0;
        imageNumber = 0;

        if(red[0] == null){
            color = "red";
            try {
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber = 0;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                imageNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right_move_"+ imageNumber.toString() + type));
                frameNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_left" + type));
                frameNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_right" + type));
                frameNumber++;
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_fall_left" + type));
                frameNumber++;
                // 9
                red[frameNumber] = ImageIO.read(getClass().getResourceAsStream(prefix + color + "_fall_right" + type));
                frameNumber++;

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        Integer direction = 0;

        BufferedImage texture;

        if(lastMilisec == 0){
            lastMilisec = System.currentTimeMillis();
        }

        prevMilisec = System.currentTimeMillis();

        if((System.currentTimeMillis() - lastMilisec) > TIME){
            lastMilisec = System.currentTimeMillis();
            frame = (frame + 1)%4;
        }

        if(player.getSpeed().getX() > 0){
            direction = 1;
        }
        
        if(player.getSpeed().getY() != 0){
            frameNumber = 10 + direction;

        } else {
            if(player.getSpeed().getX() == 0){
                frameNumber = 8 + direction;
            } else {
                frameNumber = frame + (4*direction);
            }
        }

        if(player.getID() == 1){
            texture = red[frameNumber];

        } else {
            texture = white[frameNumber];
        }

        g.drawImage(texture, null, 0, 0);
	}
}