package fearlesscode.io;

import fearlesscode.controller.*;

public abstract class InputHandler
{
	public abstract boolean handleKeyPressed(int key);
	public abstract boolean handleKeyReleased(int key);
}