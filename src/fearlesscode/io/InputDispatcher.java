package fearlesscode.io;

import java.util.*;
import java.awt.event.*;

/**
 * A beérkezett billentyűeseményeket üzenetszórással eljuttatja a feliratkozott InputHandlereknek.
 */
public class InputDispatcher extends KeyAdapter
{
	/**
	 * A feliratkozott InputHandlerek.
	 */
	private ArrayList<InputHandler> listeners;

	/**
	 * Inicializálja az objektumot.
	 */
	public InputDispatcher()
	{
		super();
		listeners=new ArrayList<InputHandler>();
	}

	/**
	 * Feliratkoztatja a megadott InputHandlert az eseményekre.
	 */
	public void attach(InputHandler handler)
	{
		listeners.add(handler);
	}

	/**
	 * A billentyűzetlenyomásoknál szétszórja a kapott billentyűkódot a feliratkozottaknak.
	 * @param e A kapott esemény.
	 */
	public void keyPressed(KeyEvent e)
	{
		for(InputHandler listener:listeners)
		{
			listener.handleKeyPressed(e.getKeyCode());
		}
	}

	/**
	 * A billentyűzet felengedésekkor szétszórja a kapott billentyűkódot a feliratkozottak között.
	 * @param e A kapott esemény.
	 */
	public void keyReleased(KeyEvent e)
	{
		for(InputHandler listener:listeners)
		{
			listener.handleKeyReleased(e.getKeyCode());
		}
	}
}