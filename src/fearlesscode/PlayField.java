package fearlesscode;

import fearlesscode.util.*;
import java.util.*;

public class PlayField
{
	private boolean blockMode;
	private Game game;
	private Player player;
	private Entity spawnPosition;
	private ArrayList<BlockContainer> blocks;

	public PlayField(Game game)
	{
		Logger.reg(this, "pf");
		this.game=game;
		blocks=new ArrayList<BlockContainer>();
	}
	/**
	 * 
	 * @param position
	 * @param block
	 */
	public void addBlock(Position position, Block block)   //blokk hozzáadása a listához
	{
		Logger.call(this, "addBlock(Position, Block)");
		blocks.add(new BlockContainer(position, block));
		Logger.ret(this, "addBlock(Position, Block)");
	}

	/**
	 * 
	 * @param block
	 * @param direction
	 */
	public void move(Block block, int direction)     //blokk mozgatása: melyiket milyen irányba
	{
		block=blocks.get(0).block;                 //lekérjük a 0. blokkot
		Logger.call(this, "move(Block, int)");          
		block.getNeighbour(direction);              //lekérkük egy szomszédját(direction iránybeli)         
		player.getActiveBlocks();                    //megnézzük a player melyik blokkban van jelen
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
	 * 
	 * @param player
	 */
	public void setPlayer(Player player)  //beállítja a játékost
	{
		Logger.call(this, "setPlayer(Player)");
		this.player=player;
		Logger.ret(this, "setPlayer(Player)");
	}

	public Player getPlayer()   //visszaadja a játékost
	{
		return player;
	}

	/**
	 * 
	 * @param entity
	 */
	public void setSpawnPosition(Entity entity)       //beállítja hogy az újjáéledés melyik objektumon(kulcson) történjen
	{
		Logger.call(this, "setSpawnPosition(Entity)");

		Logger.ret(this, "setSpawnPosition(Entity)");
	}

	public void tick()               //játék mozgatója
	{
		Logger.call(this, "tick()");
		ArrayList<Block> l=player.getActiveBlocks();
		l.get(0).processCollisions();   // ütközések ellenőrzése egy blokkban itt:0.blokkban
		l.get(0).checkBorders();         //blokkok közötti mozgást kezeli
		Logger.ret(this, "tick()");
	}

	public void toggleMode()                  //váltás blokk mód és játék mód között
	{
		Logger.call(this, "toggleMode()");

		Logger.ret(this, "toggleMode()");
	}

	public void win()                        //győzelem esetén hívjuk meg
	{
		Logger.call(this, "win()");
		game.loadNextLevel();                //győzelem esetén következő pálya betöltése
		Logger.ret(this, "win()");
	}

	public void resetPlayer()                 //player visszaállítása ha kiesett
	{
		Logger.call(this, "resetPlayer()");

		Logger.ret(this, "resetPlayer()");
	}

	public ArrayList<BlockContainer> getBlocks()
	{
		return blocks;
	}
}