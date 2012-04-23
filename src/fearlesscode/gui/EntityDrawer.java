package fearlesscode.gui;

import fearlesscode.model.entity.*;
import java.awt.*;

/**
 * Az egyes entitások rajzoló osztályai ebből származnak.
 */
public abstract class EntityDrawer implements Drawer
{
	/**
	 * A tárolt entitás.
	 */
	protected Entity entity;

	/**
	 * Létrehoz egy rajzolót a megadott entitásnak.
	 * @param subject A kirajzolandó entitás.
	 */
	public EntityDrawer(Entity subject)
	{
		entity=subject;
	}

	/**
	 * A leszármazottak saját maguk definiálják a kirajzolást.
	 * @param g A grafikus felület, amire rajzolni kell.
	 */
	public abstract void draw(Graphics2D g);
}