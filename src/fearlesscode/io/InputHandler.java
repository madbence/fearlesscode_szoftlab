package fearlesscode.io;

import fearlesscode.controller.*;

public abstract class InputHandler
{
	public abstract void handleKeyPressed(int key);
	public abstract void handleKeyReleased(int key);
}