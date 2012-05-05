package fearlesscode.gui;

import fearlesscode.model.entity.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Kirajzol egy kulcsot.
 */
public class KeyDrawer extends EntityDrawer
{
    private BufferedImage texture;
	/**
	 * Létrehoz egy rajzolót a megadott kulcs objektumhoz.
	 */
	public KeyDrawer(Key subject)
	{
		super(subject);
	}

	/**
	 * A kulcs állapotától függően kirajzol egy kulcsot (felvett/nem felvett).
	 * @param g A kirajzolandó grafikus felület.
	 */
	public void draw(Graphics2D g)
	{
        Key k=(Key)entity;

        String imgPath = "images/key_default.png";
        if(k.isObtained()){
            imgPath = "images/key_obtained.png";
            //System.out.println("Key is obtained.");
        }

        try {
            texture = ImageIO.read(getClass().getResourceAsStream(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(texture, null, 0, 0);
	}
}