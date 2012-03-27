package fearlesscode;

import java.util.ArrayList;
import java.util.List;
import fearlesscode.util.*;

public abstract class Block
{
	protected List<EntityContainer> entities;
	protected Block[] neighbours;
	protected PlayerContainer player;
	protected PlayField playField;

	/**
	 * Block konstruktora PlayField referenciával.
	 * @param pf PlayField referencia
	 */
	public Block(PlayField pf)
	{
		entities=new ArrayList<EntityContainer>();
		neighbours=new Block[4];
		playField=pf;
	}

	/**
	 * Hozzáad egy objektumot a blokkhoz a megadott helyen.
	 * 
	 * @param position Entitás pozicíója
	 * @param entity Entitás referenciája
	 */
	public void addEntity(EntityPosition position, Entity entity)
	{
		entities.add(new EntityContainer(entity,position));
	}
	
	/**
	 * A blokkok közötti mozgást kezeli le.
	 */
	public abstract void checkBorders();

	/**
	 * Visszaadja a megadott irányban található szomszédot. A dir egy szám,
	 * 0 jelenti az északot, és az óramutató járásával megegyező irányban 
	 * történik a számozás.
	 * @param dir A szomszédos Block iránya.
	 */
	public Block getNeighbour(int dir)
	{
		return neighbours[dir];
	}
	
	/**
	 * Felülírja az eddigi szomszédait, és a kapottakat állítja be.
	 */
	public Block[] getNeighbours()
	{
		return neighbours;
	}
	
	/**
	 * Lefuttatja az ütközésdetektálást.
	 */
	public abstract void processCollisions();

	/**
	 * A megadott szomszédot beállítja a megfelelő irányban
	 * a harmadik paraméter függvényében (igaz/hamis) fordított irányban is
	 * beállítja a szomszédságot. Ez a harmadik paraméter a végtelen
	 * ciklusok elkerülésére van bevezetve. 
	 * @param neighbour A szomszédos block
	 * @param dir A szomszédos block iránya
	 * @param bool Visszairányba is beállítja e vagy sem.
	 */
	public void setNeighbour(Block neighbour, int dir, boolean bool)
	{
		if(bool)
		{
			setNeighbour(neighbour,(dir+2)%4,false);     
		}
		neighbours[dir]=neighbour;
	}

	/**
	 * Felülírja az eddigi szomszédait, és a kapottakat állítja be.
	 * @param neighbours Az új szomszédok.
	 */
	public void setNeighbours(Block[] neighbours)
	{
		//this.neighbours=neighbours;
	}

	/**
	 * Beállítja a játékos referenciáját és pozícióját az adott blokkon.
	 * @param player A player referenciája
	 * @param position A player poziciója
	 */
	public void setPlayer(Player player, EntityPosition position)
	{
		this.player=new PlayerContainer(player,position);
    }
}