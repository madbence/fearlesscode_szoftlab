package fearlesscode.gui;

import fearlesscode.model.block.*;
import fearlesscode.model.container.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Egy FilledBlock objektumot kirajzol.
 */
public class FilledBlockDrawer extends BlockDrawer
{
    private BufferedImage texture;
	/**
	 * Létrehoz egy új rajzolót a megadott FilledBlocknak.
	 * @param subject A kirajzolandó FilledBlock.
	 */
	public FilledBlockDrawer(FilledBlock subject)
	{
		super(subject);
	}

	/**
	 * Végigiterál az entitásokon, és a játékosokon, és mindnek meghívja a draw metódusát.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
        g.setPaint(Color.red);
        g.drawRect(0,0,200,150);
        g.clipRect(0,0,200,150);
        if(texture == null){
            try {
                String imgPath = "images/block_bg.png";
                texture = ImageIO.read(getClass().getResourceAsStream(imgPath));
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        g.drawImage(texture, null, 0, 0);

        for(EntityContainer entity:block.getEntities())
        {
            EntityContainerDrawer drawer=new EntityContainerDrawer(entity);
            drawer.draw(g);
        }
        for(PlayerContainer player:block.getPlayers())
        {
            PlayerContainerDrawer drawer=new PlayerContainerDrawer(player);
            drawer.draw(g);
        }
        g.setClip(null);
	}
}