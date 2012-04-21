package fearlesscode;

import fearlesscode.util.*;
import java.util.*;
import fearlesscode.gui.*;

/**
 * Falat reprezentáló osztály.
 */
public class Wall extends Entity implements Info
{
	/**
	 * A fal szélessége.
	 */
	private double x;
	
	/**
	 * A fal magassága.
	 */
	private double y;

	/**
	 * Létrehoz egy új fal objektumot, a megadott pontokkal határolva.
	 *
	 * @ param playfield referencia az Entity ősosztály konstruktorához
	 * @ param x A fal szélessége.
	 * @ param y A fal magassága.
	 */
	public Wall(PlayField playField, double x, double y)
	{
		super(playField);
		this.x=x;
		this.y=y;
	}

	/**
	 * A fal játékossal való találkozás eseménykezelője.
	 *
	 * Ha a játékos és a fal találkozási felülete függőleges, úgy az X irányú mozgás
	 * szűnik meg a játékos részéről, ha vízszintes, akkor pedig a függőleges (Y).
	 *
	 * @ param player A játékos, akivel a fal interakcióba került
	 */
	public void meetPlayer(PlayerContainer player)
	{
		EntityPosition pos=container.getPosition();
		if( player.getPosition().getY()+Player.HEIGHT>pos.getY() && 
			player.getPosition().getY()<pos.getY()+y) //ha a Player a falfelett van
		{
			player.getPlayer().move(new Speed(
				-player.getPlayer().getSpeed().getX(),
				0));
		}
		else
		{
			player.getPlayer().move(new Speed(
				-player.getPlayer().getSpeed().getX()*0.05,
				-player.getPlayer().getSpeed().getY()));
		}
	}
	
	/**
	 * A Wall információinak lekérése.
	 * @param post A Wall poziciója.
	 * @return A saját koordinátája a Block-on belül, szélessége, magassága. 
	 */
	public String getInfo(EntityPosition pos)
	{
		return getName()+"\r\n"+
			"  Coordinates: ("+pos.getX()+","+pos.getY()+")\r\n"+
			"  Width: "+this.x+"\r\n"+
			"  Height: "+this.y;
	}
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return "["+ID+":Wall]";
	}

	/**
	 * Visszaadja a fal szélességeét.
	 * @return A fal szélessége.
	 */
	public double getWidth()
	{
		return x;
	}

	/**
	 * Visszaadja a fal magasságát.
	 * @return A fal magassága.
	 */
	public double getHeight()
	{
		return y;
	}

	/**
	 * Visszaadja a befoglaló dobozt.
	 */
	public Rectangle getBoundingBox()
	{
		return new Rectangle(x, y);
	}

	/**
	 * A visitor pattern alapján egy BlockMatcherrel kommunikál. Beállítja a saját szélességét, magasságát.
	 * @param matcher A kommunikációt kezdeményező objektum.
	 */
	public void accept(BlockMatcher matcher)
	{
		matcher.setWidth(x);
		matcher.setHeight(y);
	}

	public EntityDrawer getEntityDrawer()
	{
		return new WallDrawer(this);
	}
}