package fearlesscode.gui;

import fearlesscode.model.core.*;
import fearlesscode.app.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Frame-ből származtatott osztály(ablak), melyen a játékot megjelenítjük.
 */
public class GameFrame extends Frame
{

	/**
	 * Kirajzoló objektum a natív ablaknak.
	 */
	private Drawer drawer;
	
	/**
	 * Az osztály konstruktora. Meghívja a Frame ősosztály konstruktorát és ezután létrehoz
	 * egy WindowAdapter-t mely a játék ablakának bezárása esetén meghívja a játék exit(kilépő) metódusát.
	 */
	public GameFrame()
	{
		super();
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				Grafikus.getInstance().exit();
			}
		});
		setResizable(false);
	}

	/**
	 * A natív frame ezt a rajzolót fogja használni a rendereléshez.
	 * @param d A kirajzoló objektum.
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
		Graphics2D gd=(Graphics2D)g;
		gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		drawer.draw(gd);
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

	/**
	 * Begyűjti az összes, ehhez az objektumhoz beregisztrált KeyListenert egy listába és törli őket.
	 */
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