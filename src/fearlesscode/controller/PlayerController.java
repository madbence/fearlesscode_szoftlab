package fearlesscode.controller;

import fearlesscode.model.player.*;
import fearlesscode.model.misc.*;
import fearlesscode.model.core.*;

public class PlayerController
{
	private Player player;
	private PlayField playField;
	public PlayerController(Player player, PlayField pf)
	{
		this.player=player;
		playField=pf;
	}
	public void moveLeft()
	{
		if(!playField.isBlockMode())
		{
			player.move(new Speed(-1-player.getSpeed().getX(), 0));
		}
	}
	public void moveRight()
	{
		if(!playField.isBlockMode())
		{
			player.move(new Speed(1-player.getSpeed().getX(), 0));
		}
	}
	public void jump()
	{
		if(!playField.isBlockMode())
		{
			if(Math.abs(player.getSpeed().getY())<0.001)
			{
				player.move(new Speed(0, -5));
			}
		}
	}
	public void stopMove()
	{
		if(!playField.isBlockMode())
		{
			player.move(new Speed(-player.getSpeed().getX(), 0));
		}
	}
}