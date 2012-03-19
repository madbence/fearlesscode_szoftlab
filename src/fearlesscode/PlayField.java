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
	public void addBlock(Position position, Block block)
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
	public void move(Block block, int direction)
	{
		Logger.call(this, "move(Block, int)");

		Logger.ret(this, "move(Block, int)");    
	}

	/**
	 * 
	 * @param player
	 */
	public void setPlayer(Player player)
	{
		Logger.call(this, "setPlayer(Player)");
		this.player=player;
		Logger.ret(this, "setPlayer(Player)");
	}

	public Player getPlayer()
	{
		return player;
	}

	/**
	 * 
	 * @param entity
	 */
	public void setSpawnPosition(Entity entity)
	{
		Logger.call(this, "setSpawnPosition(Entity)");

		Logger.ret(this, "setSpawnPosition(Entity)");
	}

	public void tick()
	{
		Logger.call(this, "tick()");
		ArrayList<Block> l=player.getActiveBlocks();
		l.get(0).processCollisions();
		l.get(0).checkBorders();
		Logger.ret(this, "tick()");
	}

	public void toggleMode()
	{
		Logger.call(this, "toggleMode()");

		Logger.ret(this, "toggleMode()");
	}

	public void win()
	{
		Logger.call(this, "win()");
		game.loadNextLevel();
		Logger.ret(this, "win()");
	}

	public void resetPlayer()
	{
		Logger.call(this, "resetPlayer()");

		Logger.ret(this, "resetPlayer()");
	}

	public ArrayList<BlockContainer> getBlocks()
	{
		return blocks;
	}
}