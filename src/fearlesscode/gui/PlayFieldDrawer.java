package fearlesscode.gui;

import fearlesscode.model.core.*;
import fearlesscode.model.container.*;
import java.awt.*;

public class PlayFieldDrawer implements Drawer
{
	private PlayField playField;
	public PlayFieldDrawer(PlayField subject)
	{
		playField=subject;
	}
	public void draw(Graphics2D g)
	{
		for(BlockContainer bc:playField.getBlocks())
		{
			BlockContainerDrawer drawer=new BlockContainerDrawer(bc);
			if(drawer != null)
			{
				drawer.draw(g);
			}
		}
	}
}