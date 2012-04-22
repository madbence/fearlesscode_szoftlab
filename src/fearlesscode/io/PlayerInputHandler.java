package fearlesscode.io;

import fearlesscode.controller.*;

public class PlayerInputHandler extends InputHandler
{
	private PlayerController controller;
	private PlayerKeyConfiguration config;
	public PlayerController getController()
	{
		return controller;
	}
	public PlayerKeyConfiguration getConfig()
	{
		return config;
	}
	public void setController(PlayerController c)
	{
		controller=c;
	}
	public void setConfig(PlayerKeyConfiguration c)
	{
		config=c;
	}
	public boolean handleKeyPressed(int k)
	{
		if(k == config.getLeft())
		{
			controller.moveLeft();
		}
		else if(k == config.getRight())
		{
			controller.moveRight();
		}
		else if(k == config.getJump())
		{
			controller.jump();
		}
		else
		{
			return false;
		}
		return true;
	}
	public boolean handleKeyReleased(int k)
	{
		if(k == config.getLeft())
		{
			controller.stopMove();
		}
		else if(k == config.getRight())
		{
			controller.stopMove();
		}
		else
		{
			return false;
		}
		return true;
	}
}