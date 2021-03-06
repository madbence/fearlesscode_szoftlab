package fearlesscode.model.player;

import fearlesscode.tools.*;
import java.util.*;
import fearlesscode.gui.*;
import fearlesscode.model.block.*;
import fearlesscode.model.container.*;
import fearlesscode.model.misc.*;
import fearlesscode.model.physics.*;

/**
 * A játékos(okat) reprezentáló osztály. 
 * 
 * A Player számon tartja magáról, hogy mely blokkokban van jelen, valamint a nála lévő kulcsok számát.
 */
public class Player implements Info, Collideable
{
	/**
	 * A játékos szélessége.
	 */
	public static final double WIDTH=10;

	/**
	 * A játékos magassága.
	 */
	public static final double HEIGHT=20;

	/**
	 * A játékos jelenlegi sebessége, ebből számítható a következő poziciója.
	 */
	private Speed speed;

	/**
	 * A játékos kényszerített sebessége (az irányító által)
	 */
	private Speed forcedSpeed;
	
	/**
	 * A megszerzett kulcsok száma.
	 */
	private int obtainedKeys;
	
	/**
	 * A játékos jelenleg ezekben a blokkokban van jelen. Ha ez több egynél, akkor a mozgatása nem feltétlenül lehetséges.
	 */
	private ArrayList<Block> activeBlocks;

	/**
	 * A játékos azonosítója.
	 */
	private int ID;

	/**
	 * Megadja, hogy a pálcikaember mozgatása megtötént-e(egy adott tick alatt).
	 */
	private boolean processed;

	/**
	 * A pálcikaember rajzolója.
	 */
	private PlayerDrawer drawer;

	/**
	* A Player konstruktora.
	* 
	* Egy új üres listát hoz létre az activeBlockoknak.
	*/
	public Player(int id)
	{
		activeBlocks=new ArrayList<Block>();
		ID=id;
		obtainedKeys = 0;
		speed = new Speed(0, 0);
		forcedSpeed = new Speed(0, 0);
	}

	/**
	 * Beállítja, hogy megtörtént-e a játékos mozgatása egy játékütem alatt.
	 *
	 * @param bool true esetén volt mozgatás, false estén pedig nem.
	 */
	public void setProcessed(boolean bool)
	{
		processed=bool;
	}
	
	/**
	 * Lekérdezhető, hogy volt-e mozgatás(getter metódus).
	 *
	 * @return boolean: megtörtént-e a mozgatás.
	 */
	public boolean isProcessed()
	{
		return processed;
	}

	/**
	 * A sebesség gettere.
	 *
	 * @return A sebesség.
	 */
	public Speed getSpeed()
	{
		return speed;
	}

	/**
	 * A kényszerített sebesség gettere.
	 *
	 * @return A sebesség.
	 */
	public Speed getForcedSpeed()
	{
		return forcedSpeed;
	}

	/**
	 * A felvett kulcsok számának növelésére szolgáló metódus.
	 */
	public void addKey()
	{
		obtainedKeys++;
	}

	/**
	 * A felvett kulcsok számát nullázza.
	 */
	public void resetKeys()
	{
		obtainedKeys=0;
	}

	/**
	 * Eltávolítja a Playerre vonatkozó referenciákat.
	 */
	public void reset()
	{
		ArrayList<Block> copy=(ArrayList<Block>) activeBlocks.clone();
		for(Block b:copy)
		{
			leaveBlock(b);
		}
		activeBlocks.clear();
		speed=new Speed(0,0);
		forcedSpeed = new Speed(0, 0);
	}

	/**
	 * A Block-ba történő beléptetést végző metódus.
	 *
	 * @param block Referencia, hogy melyik Block-ba történik a belépés.
	 * @param pos Az a pozíció, melyre a játékos kerül a blokkban.
	 */
	public void enterBlock(Block block, EntityPosition pos)
	{
		Logger.log(this, "entered "+block.getName()+" at ("+pos.getX()+","+pos.getY()+").");
		if(!activeBlocks.contains(block))
		{
			activeBlocks.add(block);
			block.addPlayer(this, pos);
		}
	}

	/**
	 * Az aktív blokkok gettere.
	 * 
	 * @return Az aktiív blokkok listája.
	 */
	public ArrayList<Block> getActiveBlocks()
	{
		return activeBlocks;
	}

	/**
	 * A felvett kulcsok számának gettere.
	 *
	 * @return A felvett kulcsok száma.
	 */
	public int getObtainedKeys()
	{
		return obtainedKeys;
	}

	/**
	 * A játékos kilép a megadott blokkból.
	 *
	 * @param block Referecina, hogy melyik Blockból történik a kilépés.
	 */
	public void leaveBlock(Block block)
	{
		Logger.log(this, "left "+block.getName()+".");
		activeBlocks.remove(block);
		block.removePlayer(this);
	}

	/**
	 * A játékos sebességét megváltoztatja a megadott mértékben. Ténylegesen nem
	 * mozgatja a játékost, csak egy sebességvektort állít.
	 *
	 * @param newSpeed Az új sebesség.
	 */
	public void move(Speed newSpeed)
	{
		speed=new Speed(speed.getX()+newSpeed.getX(), speed.getY()+newSpeed.getY());
	}

	/**
	 * Beállítja a játékos kényszerített sebességét.
	 *
	 * @param newSpeed Az új sebesség.
	 */
	public void setForcedSpeed(Speed newSpeed)
	{
		forcedSpeed=newSpeed;
	}
	
	/**
	 * A Player informácioinak lekérésére.
	 * @return A saját koordinátája a Block-on belül, és hogy hány kulcs van nála.
	 */
	public String getInfo(EntityPosition pos)
	{
		return getName()+"\r\n"+
		    "  Coordinates:("+pos.getX()+","+pos.getY()+")\r\n"+
			"  Obtained Keys:"+this.obtainedKeys+"\r\n"+
			"  Speed:("+speed.getX()+","+speed.getY()+")";
	}
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return "["+ID+":Player]";
	}

	/**
	 * Visszaadja a játékos azonosítóját.
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * Visszaadja a befoglaló téglalap méretét.
	 */
	public Rectangle getBoundingBox()
	{
		return new Rectangle(10, 20);
	}

	/**
	 * Az aktuális sebesség alapján visszaadja a következő pozíciót.
	 * @param current Az aktuális pozíció.
	 * @return A sebesség és a paraméter alapján számolt pozíció.
	 */
	public EntityPosition getNextPosition(EntityPosition current)
	{
		return new EntityPosition(current.getX()+speed.getX(), current.getY()+speed.getY());
	}

	/**
	 * Visszaad egy pálcikaembert kirajzoló objektumot, melynek előbb átadja önmagát paraméterként.
	 * @return Pálcikaembert kirajzoló objektum.
	 */	
	public PlayerDrawer getPlayerDrawer()
	{
		if(drawer == null)
		{
			drawer=new PlayerDrawer(this);
		}
		return drawer;
	}
}