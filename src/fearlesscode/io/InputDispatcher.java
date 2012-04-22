package fearlesscode.io;

import java.util.*;

public class InputDispatcher
{
	private ArrayList<InputHandler> listeners;
	public InputDispatcher()
	{
		listeners=new ArrayList<InputHandler>();
	}
	public void attach(InputHandler handler)
	{
		listeners.add(handler);
	}
	public void handleKeyPressed(int k)
	{
		for(InputHandler listener:listeners)
		{
			if(listener.handleKeyPressed(k))
			{
				return;
			}
		}
	}
	public void handleKeyReleased(int k)
	{
		for(InputHandler listener:listeners)
		{
			if(listener.handleKeyReleased(k))
			{
				return;
			}
		}
	}
}