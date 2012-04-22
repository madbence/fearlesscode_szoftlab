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
		player.move(new Speed(-1-player.getSpeed().getX(), 0));
	}
	public void moveRight()
	{
		player.move(new Speed(1-player.getSpeed().getX(), 0));
	}
	public void jump()
	{
		if(Math.abs(player.getSpeed().getY())<0.001)
		{
			player.move(new Speed(0, -5));
		}
	}
	public void stopMove()
	{
		player.move(new Speed(-player.getSpeed().getX(), 0));
	}
}