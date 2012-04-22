package fearlesscode.gui;

import fearlesscode.model.core.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameFrame extends Frame
{
	private Drawer drawer;
	public GameFrame()
	{
		super();
	}

	/**
	 * A natív frame ezt a rajzolót fogja használni a rendereléshez.
	 */
	public void setDrawer(Drawer d)
	{
		drawer=d;
	}

	/**
	 * A rajzolás a natív Graphics objektumra történik, a beállított rajzoló objektummal.
	 * @param g A natív Graphics objektum.
	 */
	public void paint(Graphics g)
	{
		drawer.draw((Graphics2D)g);
	}

	/**
	 * A kép villogásának elkerülése érdekében dupla bufferelést használunk, ezt a natív update metódus felüldefiniálásával tesszük meg.
	 * @param g A natív Graphics objektum.
	 */
	public void update(Graphics g)
	{
		Graphics offgc;
		Image offscreen = null;
		java.awt.Rectangle box = g.getClipRect();

		// buffer
		offscreen = createImage(box.width, box.height);
		offgc = offscreen.getGraphics();
		// buffer törlés
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, box.width, box.height);
		offgc.setColor(getForeground());
		// rajzolás a bufferra
		offgc.translate(-box.x, -box.y);
		paint(offgc);
		// átmásoljuk a buffert a képernyőre
		g.drawImage(offscreen, box.x, box.y, this);
	}

	public void clearKeyListeners()
	{
		ArrayList<KeyListener> listeners=new ArrayList<KeyListener>();
		for(KeyListener listener:getKeyListeners())
		{
			listeners.add(listener);
		}
		for(KeyListener listener:listeners)
		{
			removeKeyListener(listener);
		}
	}
}