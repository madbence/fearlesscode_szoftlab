package fearlesscode.gui;

import fearlesscode.model.entity.*;
import java.awt.*;

public abstract class EntityDrawer
{
	protected Entity entity;
	public EntityDrawer(Entity subject)
	{
		entity=subject;
	}
	public abstract void draw(Graphics2D g);
}