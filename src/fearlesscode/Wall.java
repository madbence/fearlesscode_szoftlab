package fearlesscode;

import fearlesscode.util.*;
import java.util.*;

public class Wall extends Entity
{
	public static int count=0;

	private ArrayList<EntityPosition> points;
	/**
	 * Létrehoz egy új fal objektumot, a megadott pontokkal határolva
	 * 
	 * A megadott pontok relatívak a fal origójához
	 *
	 * @param playField PlayField referencia az Entity ősosztály konstruktorához
	 * @param points A fal pontjainak listája
	 */
	public Wall(PlayField playField, ArrayList<EntityPosition> points)
	{
		super(playField);
		String name="wall"+(count++);
		Logger.reg(this, name);
		Logger.call(this,"init()");
		this.points=points;
		Logger.ret(this,"init()");
	}

	/**
	 * A fal játékossal való találkozás eseménykezelője
	 *
	 * Ha a játékos és a fal találkozási felülete függőleges, úgy az X irányú mozgás
	 * szűnik meg a játékos részéről, ha vízszintes, akkor pedig a függőleges (Y)
	 * @param player A játékos, akivel a fal interakcióba került
	 */
	public void meetPlayer(Player player)
	{
		Logger.call(this,"meetPlayer(player)");
		Speed oldSpeed=player.getSpeed();
		if(Logger.ask("Falkent viselkedik?"))
		{
			player.move(new Speed(0, oldSpeed.getY()));
		}
		else
		{
			player.move(new Speed(oldSpeed.getX(), 0));
		}
		Logger.ret(this,"meetPlayer(player)");
	}
}