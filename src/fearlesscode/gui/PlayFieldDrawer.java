package fearlesscode.gui;

import fearlesscode.model.core.*;
import fearlesscode.model.container.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Kirajzolja a játékteret.
 */
public class PlayFieldDrawer implements Drawer
{
    private static BufferedImage texture = null;

	/**
	 * A kirajzolandó játéktér.
	 */
	private PlayField playField;

	/**
	 * Létrehoz egy rajzolót a megadott játéktérhez.
	 */
	public PlayFieldDrawer(PlayField subject)
	{
		playField=subject;
	}

	/**
	 * Végigiterál a blokkok konténerein, és meghívja a rajzolójuk draw() metódusát.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		synchronized(playField)
		{
				if(texture == null){
	            try {
	                texture = ImageIO.read(getClass().getResourceAsStream("images/window_bg.png"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        g.drawImage(texture, null, 0, 0);
			g.drawString(String.valueOf(playField.getTick()), 10, 38);
			long mem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
			g.drawString("Memory usage: "+((double)mem/1000000)+" MB", 50, 38);
			for(BlockContainer bc:playField.getBlocks())
			{
				BlockContainerDrawer drawer=bc.getContainerDrawer();
				if(drawer != null)
				{
					drawer.draw(g);
				}
			}
		}
	}
}