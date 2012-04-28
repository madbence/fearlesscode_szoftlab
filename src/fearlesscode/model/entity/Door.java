package fearlesscode.model.entity;

import fearlesscode.tools.*;
import fearlesscode.gui.*;
import fearlesscode.model.core.*;
import fearlesscode.model.physics.*;
import fearlesscode.model.container.*;
import fearlesscode.model.block.*;
import fearlesscode.model.misc.*;

/**
 * A pályán megjelenő ajtót reprezentáló objektum.
 * 
 * A Door objektum az Entity osztály kiterjesztése így ez is megvalósítja a meetPlayer
 * metódust. Abban az esteben, ha a játékos rendelkezik az összes megszerzett kulccsal,
 * akkor a játék végetér.  
 */
public class Door extends Entity
{
	public static final double WIDTH=10;
	public static final double HEIGHT=20;
	/**
	 * Az ajtó kinyitásához szükséges kulcsok száma.
	 */
	private int requiredKeys;

	/**
	 * A Door konstruktora
	 * @param requiredKeys Az ajtó kinyitásához szükséges kulcsok száma.
	 * @param playField referencia a PlayFieldre.
	 */
	public Door(int requiredKeys, PlayField playField)
	{
		super(playField);
		this.requiredKeys=requiredKeys;
	}
	
	/**
	 * Ha a játékosnál lévő kulcsok száma megegyezik a szükséges
	 * kulcsok számával, értesíti a PlayFieldet, hogy a pályának vége.
	 * @param player Az adott Player objektum, amelyikkel a Door objektum találkozott.
	 */
	public void meetPlayer(PlayerContainer player)
	{
		Logger.log("player had "+player.getPlayer().getObtainedKeys()+" keys");
		Logger.log("door requires "+requiredKeys+" keys");
		this.requiredKeys-=player.getPlayer().getObtainedKeys();
		player.getPlayer().resetKeys();
		if(requiredKeys>0)
		{
			Logger.log(this,"not opened.");
		}
		else
		{
			Logger.log(this, "opened.");
			playField.win();
		}
	}
	
	/**
	 * A Door informácioinak lekérése.
	 * @return A saját koordinátái a Block-on belül, elvárt kulcsok száma.
	 */
	public String getInfo(EntityPosition pos)
	{
		//@TODO: pozíciót megszerezni.
		return getName()+"\n"+
		"  Coordinates:("+pos.getX()+","+pos.getY()+")\r\n"+
		"  requiredKeys:"+requiredKeys;
	}
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		//@TODO: id-t megszerezni.
		return "["+ID+":Door]";
	}

	/**
	 * Visszaadja a befoglaló dobozt.
	 * @return Az objektum befoglaló doboza.
	 */
	public Rectangle getBoundingBox()
	{
		return new Rectangle(WIDTH, HEIGHT);
	}

	public EntityDrawer getEntityDrawer()
	{
		if(drawer == null)
		{
			drawer=new DoorDrawer(this);
		}
		return drawer;
	}
}