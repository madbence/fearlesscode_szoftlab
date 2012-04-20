package fearlesscode.gui;

import fearlesscode.model.entity.*;
import java.awt.*;

public class DoorDrawer extends EntityDrawer
{
	public DoorDrawer(Door subject)
	{
		super(subject);
	}
	public void draw(Graphics2D g)
	{
		g.setPaint(Color.yellow);
		g.fillRect(0,0,10,20);
	}
}