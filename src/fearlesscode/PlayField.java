package fearlesscode;

import fearlesscode.util.*;
import java.util.*;

public class PlayField
{
	private boolean blockMode;
	private Game game;
	private ArrayList<Player> players;
	private Entity spawnPosition;
	private ArrayList<BlockContainer> blocks;


	/**
	 * Példányosít egy PlayField objektumot
	 *
	 * Alapértelmezetten teljesen üres, nincsenek benne blokkok, mindent setterekkel állíthatunk be
	 * @param game Egy Game objektum referencia, ha értesíteni kell a pálya megnyeréséről
	 */
	public PlayField(Game game)
	{
		Logger.reg(this, "pf");
		this.game=game;
		blocks=new ArrayList<BlockContainer>();
		players=new ArrayList<Player>();
	}
	/**
	 * Egy új blokkot ad hozzá a PlayField objektumhoz a megadott koordinátán
	 *
	 * @param position A blokk helye
	 * @param block Az elhelyezendő blokk
	 */
	public void addBlock(Position position, Block block)
	{
		Logger.call(this, "addBlock(Position, Block)");
		blocks.add(new BlockContainer(position, block));
		Logger.ret(this, "addBlock(Position, Block)");
	}

	/**
	 * A megadott blokkot a megadott irányba elmozdítja (kicseréli a megadott irány beli szomszédjával)
	 *
	 * @param block Az elmozdítandó blokk
	 * @param direction A mozgatás iránya
	 */
	public void move(Block block, int direction)
	{
		block=blocks.get(0).block;
		Logger.call(this, "move(Block, int)");          
		block.getNeighbour(direction);      
		//player.getActiveBlocks();
		if(Logger.ask("Letrejohet a csere?"))
		{
			block.getNeighbours();                
			blocks.get(1).block.getNeighbours();
			blocks.get(1).block.setNeighbours(null);
			block.setNeighbours(null);
			block.setNeighbour(blocks.get(1).block, 3, true);
		}
		Logger.ret(this, "move(Block, int)");    
	}

	/**
	 * Egy új játékos referenciát ad hozzá a játékosok listájához
	 * 
	 * @param player Az új játékos referenciája
	 */
	public void addPlayer(Player player)
	{
		Logger.call(this, "setPlayer(Player)");
		//@TODO listához adni
		players.add(player);
		Logger.ret(this, "setPlayer(Player)");
	}

	/**
	 * Visszaadja a játékosok listáját
	 * 
	 * @return A PlayField objektumban eltárolt játékosok listája
	 */
	public ArrayList<Player> getPlayers()
	{
		return players;
	}

	/**
	 * Beállítja a megadott játékos újraéledési helyét a pályán belül (egy Entity objektumra)
	 * @param player A módosítani kívánt játékos referenciája
	 * @param entity Az új újraéledési pont
	 */
	public void setSpawnPosition(Player player, Entity entity)
	{
		Logger.call(this, "setSpawnPosition(Entity)");
		//@TODO implementálni
		Logger.ret(this, "setSpawnPosition(Entity)");
	}

	/**
	 * A játék-mód eseménykezelője
	 *
	 * Minden egyes frissítésre lefuttatja az ütközésdetektálásokat, és a mozgást
	 * (blokkon belüli, és kívüli)
	 */
	public void tick()
	{
		Logger.call(this, "tick()");
		//@TODO javítani multiplayerre
		//ArrayList<Block> l=player.getActiveBlocks();
		//l.get(0).processCollisions();   // ütközések ellenőrzése egy blokkban itt:0.blokkban
		//l.get(0).checkBorders();         //blokkok közötti mozgást kezeli
		Logger.ret(this, "tick()");
	}

	/**
	 * Váltás játék-mód és blokk-mód között
	 *
	 * Játék módban a blokkok nem mozognak, blokk módban a tick nem fut
	 */
	public void toggleMode()
	{
		Logger.call(this, "toggleMode()");

		Logger.ret(this, "toggleMode()");
	}

	/**
	 * A metódus bejelenti a Game objektumnak, hogy a pálya végére ért a játékos
	 *
	 * Ha minden feltétel teljesül, a pálya véget ér, és betöltődik a következő pálya
	 */
	public void win()
	{
		Logger.call(this, "win()");
		game.loadNextLevel();
		Logger.ret(this, "win()");
	}

	/**
	 * A megadott játékost visszahelyezi az újraéledési helyére
	 *
	 * @param player Az áthelyezni kívánt játékos
	 */
	public void resetPlayer(Player player)
	{
		Logger.call(this, "resetPlayer()");

		Logger.ret(this, "resetPlayer()");
	}

	/**
	 * Visszaadja a PlayField blokkjait
	 * 
	 * @return A PlayFieldben lévő minden blokk
	 */
	public ArrayList<BlockContainer> getBlocks()
	{
		return blocks;
	}
}