package fearlesscode.gui;

import fearlesscode.model.entity.*;
import java.awt.*;

/**
 * Kirajzol egy kulcsot.
 */
public class KeyDrawer extends EntityDrawer
{
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
		if(k.isObtained())
		{
			g.setPaint(Color.green);
		}
		else
		{
			g.setPaint(Color.red);
		}
		g.fillRect(0,0,(int)Key.WIDTH,(int)Key.HEIGHT);
	}
}