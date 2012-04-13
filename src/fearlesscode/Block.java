package fearlesscode;

import java.util.ArrayList;
import java.util.List;
import fearlesscode.util.*;

/**
 * Absztarkt osztály a speciális blokkok leszármaztatásához.
 * 
 * A játéktér azonos méretű elemkre osztott darabokból áll. Ezek típusa lehet üres~ vagy játékblokk. Mindkét verzió
 * egy közös ősből száramazik, mégpedig ebből, az úgynevezett Block osztályból.
 */
public abstract class Block implements BlockInfo
{

	public static final double HEIGHT=150;
	public static final double WIDTH=200;
	/**
	 * Egy adott Blockban található Entityk tárolására szolgál.
	 */
	protected List<EntityContainer> entities;

	/**
	 * A szomszédossági kapcsolatokat írja le a többi a játéktéren található szomszédos Blockokhoz.
	 */
	protected Block[] neighbours;

	/**
	 * Egy adott Blockban található Playerek tárolására szolgál.
	 */
	protected ArrayList<PlayerContainer> players;

	/**
	 * PlayFieldre mutató referencia.
	 */
	protected PlayField playField;
	
	/**
	 * Privát statikus számláló.
	 */
	private static int count;

	/**
	 * Protected azonosító.
	 */
	protected int ID;

	/**
	 * Block konstruktora PlayField referenciával.
	 * @param pf PlayField referencia.
	 */
	public Block(PlayField pf)
	{
		entities=new ArrayList<EntityContainer>();
		players=new ArrayList<PlayerContainer>();
		neighbours=new Block[4];
		playField=pf;
		ID=++count;
	}
	
	/**
	 * A Block ID-jának gettere.
	 * @return A Block ID-ja. 
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * Hozzáad egy objektumot a blokkhoz a megadott helyen.
	 * 
	 * @param position Entitás pozicíója.
	 * @param entity Entitás referenciája.
	 */
	public void addEntity(EntityPosition position, Entity entity)
	{
		entities.add(new EntityContainer(entity,position));
	}
	
	public List<EntityContainer> getEntities()
	{
		return entities;
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
	 * @return Visszaadja a paraméterként meghatározott irányú szomszédot.
	 */
	public Block getNeighbour(int dir)
	{
		return neighbours[dir];
	}
		
	/**
	 * Visszaadja az adott Block szomszédait.
	 * @return A Blockokat tartalmazó tömb.
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
	 * @param neighbour A szomszédos block.
	 * @param dir A szomszédos block iránya.
	 * @param bool Visszairányba is beállítja e vagy sem.
	 */
	public void setNeighbour(Block neighbour, int dir, boolean bool)
	{
		if(bool)
		{
			neighbour.setNeighbour(this,(dir+2)%4,false);	 
		}
		neighbours[dir]=neighbour;
	}

	/**
	 * Felülírja az eddigi szomszédait, és a kapottakat állítja be.
	 * @param neighbours Az új szomszédok.
	 */
	public void setNeighbours(Block[] neighbours)
	{
		for(int i=0; i<4; i++)
		{
			if(neighbours[i]!=null)
			{
				this.setNeighbour(neighbours[i],i,true);
			}
			else
			{
				neighbours[i]=null;
			}
		}
	}

	/**
	 * Beállítja a játékosok referenciáját és pozícióját az adott blokkon.
	 * @param player A player referenciája.
	 * @param position A player poziciója.
	 */
	public void setPlayer(Player player, EntityPosition position)
	{
		players.add(new PlayerContainer(player,position));
	}

	public abstract boolean matches(Block other);
}