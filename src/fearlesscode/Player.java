package fearlesscode;

import fearlesscode.util.*;
import java.util.*;

public class Player
{
	private Speed speed;
	private ArrayList<Block> activeBlocks;

	public Player()
	{
		Logger.reg(this, "player");
		activeBlocks=new ArrayList<Block>();
	}

	public Speed getSpeed()
	{
		Logger.call(this, "getSpeed()");
		Logger.ret(this, "getSpeed()");
		return speed;
	}


	public void addKey()
	{
		Logger.call(this, "addKey()");
		Logger.ret(this, "addKey()");
	}

	/**
	 * 
	 * @param block
	 */
	public void enterBlock(Block block)
	{
		Logger.call(this, "enterBlock(block)");
		activeBlocks.add(block);
		Logger.ret(this, "enterBlock(block)");
	}

	public ArrayList<Block> getActiveBlocks()
	{
		Logger.call(this, "getActiveBlocks()");
		Logger.ret(this, "getActiveBlocks()");
		return activeBlocks;
	}

	public int getObtainedKeys()
	{
		Logger.call(this, "getObtainedKeys()");
		Logger.ret(this, "getObtainedKeys()");
		return 0;
	}

	/**
	 * 
	 * @param block
	 */
	public void leaveBlock(Block block)
	{
		Logger.call(this, "leaveBlock(block)");
		activeBlocks.remove(activeBlocks.indexOf(block));
		Logger.ret(this, "leaveBlock(block)");
	}

	/**
	 * 
	 * @param dir
	 */
	public void move(Speed newSpeed)
	{
		Logger.call(this, "move(newSpeed)");

		Logger.ret(this, "move(newSpeed)");
	}

}