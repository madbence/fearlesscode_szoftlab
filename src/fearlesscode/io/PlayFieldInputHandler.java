package fearlesscode.io;

import fearlesscode.controller.*;

public class PlayFieldInputHandler extends InputHandler
{
	private PlayFieldController controller;
	private PlayFieldKeyConfiguration config;
	public void setController(PlayFieldController con)
	{
		controller=con;
	}
	public void setConfig(PlayFieldKeyConfiguration con)
	{
		config=con;
	}
	public boolean handleKeyPressed(int k)
	{
		if(k == config.getToggleMode())
		{
			controller.toggleMode();
			return true;
		}
		return false;
	}
	public boolean handleKeyReleased(int k)
	{
		return false;
	}
}