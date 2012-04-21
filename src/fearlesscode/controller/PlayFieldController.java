package fearlesscode.controller;

import fearlesscode.io.*;

public class PlayFieldController
{
	private ArrayList<PlayerInputHandler> players;
	private BlockController block;
	private PlayField playField;
	public PlayFieldController(PlayField pf)
	{
		playField=pf;
	}
	public addPlayerController(PlayerInputHandler handler)
	{
		players.add(handler);
	}
	public setBlockController(BlockInputHandler handler)
	{
		block=handler;
	}
	public void press(int k)
	{
		if(playField.isBlockMode())
		{
			block.handleKeyPressed(k);
		}
		else
		{
			for(PlayerInputHandler player:players)
			{
				if(player.handleKeyPressed(k))
				{
					return;
				}
			}
		}
	}
}