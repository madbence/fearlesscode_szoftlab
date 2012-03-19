package fearlesscode;



import java.util.ArrayList;
import java.util.List;
import fearlesscode.util.*;


/**
	 * 
	 * 
	 * A szomszédos blokkokat nyilvántartja, és biztosítja a közöttük lévo ̋ kölcsönös kapcso- latot, valamint értesíti a rajta található objektumokat a játékos interakciójáról (rájuk lép, kilép a blokkból).
	 * neighbours: A blokk szomszédjainak listája.
	 * entities: A blokkon található objektumok (és pozíciójuk).
	 * player: A játékos referenciája (és pozíciója).
	 * playField: Referencia a PlayField-re.
	 */
public abstract class Block {

	protected List<EntityContainer> entities;
	protected Block[] neighbours;
	protected PlayerContainer player;
	protected PlayField playField;

	/**
	 * Block konstruktora PlayField referenciával.
	 * Létrehozza az atribútumokat. Beállyítja a playField referenciáját.
	 * @param pf PlayField referencia
	 */
	public Block(PlayField pf)
	{
        //Logger.call("Block","init()");
        entities = new ArrayList<EntityContainer>();
        neighbours = new Block[4];
        playField=pf;
        //Logger.ret("Block","init()");
	}

	/**
	 * Hozzáad egy objektumot a blokkhoz a megadott helyen.
	 * 
	 * @param position  Entitás pozicíója
	 * @param entity	Entitás referenciája
	 */
	public void addEntity(EntityPosition position, Entity entity){
        Logger.call(this,"addEntity(position,entitiy)");
        Logger.ret(this,"addEntity(position,entity)");
        entities.add(new EntityContainer(entity,position));

	}
	
	/**
	 * A blokkok közötti mozgást kezeli le.
	 * 
	 */
	public abstract void checkBorders();

	/**
	 * Visszaadja a megadott irányban található szomszédot. A dir egy szám,
	 * 0 jelenti az északot, és az óramutató járásával megegyezo ̋ irányban 
	 * történik a számozás.
     * @param dir A szomszédos Block iránya.
     */
	public Block getNeighbour(int dir){
        Logger.call(this,"getNeighbour(dir)");
        Logger.ret(this,"getNeighbour(dir)");
        return neighbours[dir];

	}
	
    /**
	 * Felülírja az eddigi szomszédait, és a kapottakat állítja be.
	 *
	 */
    public Block[] getNeighbours(){
        Logger.call(this,"getNeighbours()");
        Logger.ret(this, "getNeighbours()");
        return neighbours;
    }
	
	/**
	*Lefuttatja az ütközésdetektálást.
	*/
	public abstract void processCollisions();

	/**
	 * A megadott szomszédot beállítja a megfelelő̋ irányba
	 * a harmadik paraméter függvényében (igaz/hamis) viszont
	 * beállítja a szomszédságot. Ez a harmadik paraméter a végtelen
	 * ciklusok elkerülésére van be- vezetve. 
	 * @param neighbour A szomszédos block
	 * @param dir	A szomszédos block iránya
	 * @param bool	Visszairányba is beállítja e vagy sem.
	 */
	public void setNeighbour(Block neighbour, int dir, boolean bool){
        Logger.call(this,"setNeighbour(neighbour,dir,"+(bool?"true":"false")+")");
        if(bool)
        {
            setNeighbour(neighbour,(dir+2)%4,false);     
        }
        neighbours[dir]=neighbour;
        Logger.ret(this,"setNeighbour(neighbour,dir,"+(bool?"true":"false")+")");

	}

	/**
	 * Felülírja az eddigi szomszédait, és a kapottakat állítja be.
	 * @param neighbours	Az új szomszédok.
	 */
	public void setNeighbours(Block[] neighbours){
        Logger.call(this,"setNeighbours(neighbours)");
        //this.neighbours=neighbours;
        Logger.ret(this,"setNeighbours(neighbours)");
	}

	/**
	 * Beállítja a játékos referenciáját és pozícióját az adott blok- kon.
	 * @param player A player referenciája
	 * @param position	A player poziciója
	 */
	public void setPlayer(Player player, EntityPosition position){
        Logger.call(this,"setPlayer(player,position)");
        Logger.ret(this,"setPlayer(player,position)");
        this.player = new PlayerContainer(player,position);



    }

}