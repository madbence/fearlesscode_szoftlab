package fearlesscode.io;

import java.util.*;
import java.awt.event.*;

public class InputDispatcher extends KeyAdapter
{
	private ArrayList<InputHandler> listeners;
	public InputDispatcher()
	{
		super();
		listeners=new ArrayList<InputHandler>();
	}
	public void attach(InputHandler handler)
	{
		listeners.add(handler);
	}
	public void keyPressed(KeyEvent e)
	{
		for(InputHandler listener:listeners)
		{
			listener.handleKeyPressed(e.getKeyCode());
		}
	}
	public void keyReleased(KeyEvent e)
	{
		for(InputHandler listener:listeners)
		{
			listener.handleKeyReleased(e.getKeyCode());
		}
	}
}