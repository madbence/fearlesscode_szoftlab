package fearlesscode.io;

import fearlesscode.controller.*;

public class PlayFieldInputHandler extends InputHandler
{
	private PlayFieldController controller;
	public PlayFieldInputHandler(PlayFieldController con)
	{
		controller=con;
	}
	public boolean handleKeyPressed(int k)
	{
		controller.press(k);
	}
	public boolean handleKeyReleased(int k)
	{
		controller.release(k);
	}
}