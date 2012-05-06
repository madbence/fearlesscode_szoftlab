package fearlesscode.controller;

import fearlesscode.model.player.*;
import fearlesscode.model.misc.*;
import fearlesscode.model.core.*;

/**
 * Egy játékost irányít.
 */
public class PlayerController
{
	/**
	 * Az irányítandó játékos.
	 */
	private Player player;

	/**
	 * A játékos ezen a játéktéren van.
	 */
	private PlayField playField;

	/**
	 * Balra mozgás flagje.
	 */
	private boolean left;

	/**
	 * Jobbra mozgás flagje.
	 */
	private boolean right;

	/**
	 * Létrehoz egy kontrollert a megadott játékossal és játéktérrel.
	 * @param player Az irányítandó játékos.
	 * @param pf A játékos játéktere.
	 */
	public PlayerController(Player player, PlayField pf)
	{
		this.player=player;
		playField=pf;
		left=false;
		right=false;
	}

	/**
	 * A játékost balra mozgatja, ha játékmódban vagyunk.
	 */
	public void moveLeft()
	{
		if(!playField.isBlockMode())
		{
			left=true;
			//player.move(new Speed(-1.5-player.getSpeed().getX(), 0));
			player.setForcedSpeed(new Speed(-1.5, 0));
		}
	}

	/**
	 * A játékost jobbra mozgatja, ha játékmódban vagyunk.
	 */
	public void moveRight()
	{
		if(!playField.isBlockMode())
		{
			right=true;
			//player.move(new Speed(1.5-player.getSpeed().getX(), 0));
			player.setForcedSpeed(new Speed(1.5, 0));
		}
	}

	/**
	 * A játékos ugrik, ha játékmódban vagyunk, és talajon áll (nem esik).
	 */
	public void jump()
	{
		if(!playField.isBlockMode())
		{
			if(Math.abs(player.getSpeed().getY())<0.001)
			{
				player.move(new Speed(0, -4.7));
			}
		}
	}

	/**
	 * Megállítja a játékost (vízszintes mozgásban csak), ha játékmódban vagyunk.
	 */
	public void stopMove(boolean dir)
	{
		if(!playField.isBlockMode())
		{
			if(dir)
			{
				left=false;
			}
			else
			{
				right=false;
			}
			if(!(left || right))
			{
				player.setForcedSpeed(new Speed(0,0));
				player.move(new Speed(-player.getSpeed().getX(), 0));
			}
		}
	}
}