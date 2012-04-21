package fearlesscode.gui;

import fearlesscode.*;
import java.awt.*;

public class KeyDrawer extends EntityDrawer
{
	public KeyDrawer(Key subject)
	{
		super(subject);
	}
	public void draw(Graphics2D g)
	{
		Key k=(Key)entity;
		if(k.isObtained())
		{
			g.setPaint(Color.green);
		}
		else
		{
			g.setPaint(Color.red);
		}
		g.fillRect(0,0,10,20);
	}
}