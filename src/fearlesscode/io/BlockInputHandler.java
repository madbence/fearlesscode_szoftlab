package fearlesscode.io;

import fearlesscode.controller;

public class BlockInputHandler extends InputHandler
{
	private BlockController controller;
	private BlockKeyConfiguration config;
	public BlockController getController()
	{
		return controller;
	}
	public BlockKeyConfiguration getConfig()
	{
		return config;
	}
	public void setController(BlockController c)
	{
		controller=c;
	}
	public void setConfig(BlockKeyConfiguration c)
	{
		config=c;
	}
	public boolean handleKeyPressed(int k)
	{
		if(k == config.getNorth())
		{
			controller.moveNorth();
		}
		else if(k == config.getEast())
		{
			controller.moveEast();
		}
		else if(k == config.getSouth())
		{
			controller.moveSouth();
		}
		else if(k == config.getWest())
		{
			controller.moveWest();
		}
		else
		{
			return false;
		}
		return true;
	}
	public boolean handleKeyReleased(int k)
	{
		return false;
	}
}