package fearlesscode.controller;

import fearlesscode.model.block.*;

public class BlockController
{
	private Block block;
	public BlockController(Block block)
	{
		this.block=block;
	}
	public void moveNorth()
	{
		block.getPlayField().move(block, 2);
	}
	public void moveEast()
	{
		block.getPlayField().move(block, 3);
	}
	public void moveSouth()
	{
		block.getPlayField().move(block, 0);
	}
	public void moveWest()
	{
		block.getPlayField().move(block, 1);
	}
}