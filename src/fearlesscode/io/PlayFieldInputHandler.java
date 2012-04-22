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
	public void handleKeyPressed(int k)
	{
		if(k == config.getToggleMode())
		{
			controller.toggleMode();
		}
	}
	public void handleKeyReleased(int k)
	{
	}
}