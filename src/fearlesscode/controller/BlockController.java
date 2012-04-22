package fearlesscode.controller;

import fearlesscode.model.block.*;
import fearlesscode.model.core.*;

public class BlockController
{
	private Block block;
	private PlayField playField;
	public BlockController(Block block, PlayField pf)
	{
		this.block=block;
		playField=pf;
	}
	public void moveNorth()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 2);
		}
	}
	public void moveEast()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 3);
		}
	}
	public void moveSouth()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 0);
		}
	}
	public void moveWest()
	{
		if(playField.isBlockMode())
		{
			block.getPlayField().move(block, 1);
		}
	}
}