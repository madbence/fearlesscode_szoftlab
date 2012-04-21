package fearlesscode.controller;

import fearlesscode.model.player.*;
import fearlesscode.model.misc.*;

public class PlayerController
{
	private Player player;
	public PlayerController(Player player)
	{
		this.player=player;
	}
	public void moveLeft()
	{
		this.player.move(new Speed(-1, 0));
	}
	public void moveRight()
	{
		this.player.move(new Speed(1, 0));
	}
	public void jump()
	{
		if(Math.abs(player.getSpeed().getY())<0.001)
		{
			this.player.move(new Speed(0, -5));
		}
	}
}