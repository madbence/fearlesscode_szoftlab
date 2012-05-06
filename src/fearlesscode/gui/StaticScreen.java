package fearlesscode.gui;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class StaticScreen implements Drawer
{
	private BufferedImage image;

	public StaticScreen(String img)
	{
		try
		{
			image=ImageIO.read(getClass().getResourceAsStream(img));
		}
		catch(Exception e)
		{

		}
	}
	public void draw(Graphics2D g)
	{
		g.drawImage(image,null,0,0);
	}
}