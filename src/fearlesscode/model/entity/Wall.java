package fearlesscode.model.entity;

import fearlesscode.tools.*;
import java.util.*;
import fearlesscode.gui.*;
import fearlesscode.model.core.*;
import fearlesscode.model.physics.*;
import fearlesscode.model.container.*;
import fearlesscode.model.misc.*;
import fearlesscode.model.player.*;
import fearlesscode.model.block.*;

/**
 * Falat reprezentáló osztály.
 */
public class Wall extends Entity
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
	 * A fal játékossal való találkozásának eseménykezelője.
	 *
	 * Ha a játékos és a fal találkozási felülete függőleges, úgy az X irányú mozgás
	 * szűnik meg a játékos részéről, ha vízszintes, akkor pedig a függőleges (Y).
	 *
	 * @ param player A játékos, akivel a fal interakcióba került.
	 */
	public void meetPlayer(PlayerContainer player)
	{
		//Logger.log(this, "collided with "+player.getPlayer().getName());

		EntityPosition w=container.getPosition();
		EntityPosition p=player.getPosition();

		double px1=p.getX();
		double px2=px1+Player.WIDTH;
		double py1=p.getY();
		double py2=py1+Player.HEIGHT;

		double wx1=w.getX();
		double wx2=wx1+x;
		double wy1=w.getY();
		double wy2=wy1+y;

		if((px2<wx1 && px1>wx2) || (py1<wy2 && py2>wy1))
		{
			double sx;
			if(px1<wx1)
			{
				sx=px2-wx1;
			}
			else
			{
				sx=px1-wx2;
			}
			player.getPlayer().move(new Speed(
				-player.getPlayer().getSpeed().getX()-sx,
				0));
		}
		else
		{
			double sy;
			if(py1<wy1)
			{
				sy=py2-wy1;
			}
			else
			{
				sy=py1-wy2;
			}
			player.getPlayer().move(new Speed(
				0/*-player.getPlayer().getSpeed().getX()*0.05*/,
				-player.getPlayer().getSpeed().getY()-sy));
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

	/**
	 * Visszaad egy falat kirajzoló objektumot, melynek előbb átadja önmagát paraméterként.
	 * @return Falat kirajzoló objektum.
	 */	
	public EntityDrawer getEntityDrawer()
	{
		if(drawer == null)
		{
			drawer=new WallDrawer(this);
		}
		return drawer;
	}
}