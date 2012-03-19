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
	public void addBlock(Position position, Block block)   //blokk hozz�ad�sa a list�hoz
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
	public void move(Block block, int direction)     //blokk mozgat�sa: melyiket milyen ir�nyba
	{
		block=blocks.get(0).block;                 //lek�rj�k a 0. blokkot
		Logger.call(this, "move(Block, int)");          
		block.getNeighbour(direction);              //lek�rk�k egy szomsz�dj�t(direction ir�nybeli)         
		player.getActiveBlocks();                    //megn�zz�k a player melyik blokkban van jelen
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
	public void setPlayer(Player player)  //be�ll�tja a j�t�kost
	{
		Logger.call(this, "setPlayer(Player)");
		this.player=player;
		Logger.ret(this, "setPlayer(Player)");
	}

	public Player getPlayer()   //visszaadja a j�t�kost
	{
		return player;
	}

	/**
	 * 
	 * @param entity
	 */
	public void setSpawnPosition(Entity entity)       //be�ll�tja hogy az �jj��led�s melyik objektumon(kulcson) t�rt�njen
	{
		Logger.call(this, "setSpawnPosition(Entity)");

		Logger.ret(this, "setSpawnPosition(Entity)");
	}

	public void tick()               //j�t�k mozgat�ja
	{
		Logger.call(this, "tick()");
		ArrayList<Block> l=player.getActiveBlocks();
		l.get(0).processCollisions();   // �tk�z�sek ellen�rz�se egy blokkban itt:0.blokkban
		l.get(0).checkBorders();         //blokkok k�z�tti mozg�st kezeli
		Logger.ret(this, "tick()");
	}

	public void toggleMode()                  //v�lt�s blokk m�d �s j�t�k m�d k�z�tt
	{
		Logger.call(this, "toggleMode()");

		Logger.ret(this, "toggleMode()");
	}

	public void win()                        //gy�zelem eset�n h�vjuk meg
	{
		Logger.call(this, "win()");
		game.loadNextLevel();                //gy�zelem eset�n k�vetkez� p�lya bet�lt�se
		Logger.ret(this, "win()");
	}

	public void resetPlayer()                 //player vissza�ll�t�sa ha kiesett
	{
		Logger.call(this, "resetPlayer()");

		Logger.ret(this, "resetPlayer()");
	}

	public ArrayList<BlockContainer> getBlocks()
	{
		return blocks;
	}
}