package fearlesscode.gui;

import fearlesscode.model.block.*;
import java.awt.*;

public abstract class BlockDrawer
{
	protected Block block;
	public BlockDrawer(Block subject)
	{
		block=subject;
	}
	public abstract void draw(Graphics2D g);
}