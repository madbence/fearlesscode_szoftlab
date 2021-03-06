package fearlesscode.model.entity;

import fearlesscode.gui.*;
import fearlesscode.model.core.*;
import fearlesscode.model.physics.*;
import fearlesscode.model.container.*;
import fearlesscode.model.block.*;
import fearlesscode.model.misc.*;

/**
 * Az Entity osztály üres implementációja, a játékosok alapértelmezetten ennek az osztály egy példányának a helyén jönnek létre.
 */
public class SpawnPoint extends Entity
{
	/**
	 * A SpawPoint konstruktora. Mivel üres implementáció, csak a szülő osztály konstruktorát hívja meg.
	 * @param playField Az Entity konstruktorának továbbadott PlayField objektum.
	 */
	public SpawnPoint(PlayField playField)
	{
		super(playField);
	}

	/**
	 * Ha a játékos egy SpawPointtal ütközik, nem történik semmi, így a metódus implementációja teljesen üres.
	 * @param player A játékos, akivel ütközik az objektum.
	 */
	public void meetPlayer(PlayerContainer player)
	{
		  
	}

	/**
	 * A SpawnPoint információinak lekérése.
	 * @param pos A SpawnPoint poziciója.
	 * @return A saját koordinátája a Block-on belül.
	 */
	public String getInfo(EntityPosition pos)
	{
		//@TODO: pozíciót megszerezni.
		return getName()+"\r\n"+
		"  Coordinates:("+pos.getX()+","+pos.getY()+")";
	}

	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return "["+ID+":SpawnPoint]";
	}

	/**
	 * Visszaadja a befoglaló dobozt.
	 */
	public Rectangle getBoundingBox()
	{
		return new Rectangle(0, 0);
	}

	/**
	 * Származtatás miatt kötelezően megvalósítandó metódus. A SpawnPoint grafikusan nem jelenik meg a képernyőn, ezért null-al tér vissza.
	 */
	public EntityDrawer getEntityDrawer()
	{
		return null;
	}
}