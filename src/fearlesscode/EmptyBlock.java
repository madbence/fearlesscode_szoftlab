package fearlesscode;

import fearlesscode.util.*;

public class EmptyBlock extends Block
{
	public EmptyBlock(PlayField pf)
	{
		super(pf);
		Logger.call(this,"init()");
		Logger.ret(this,"Block.init()");
	}
	public void checkBorders()
	{
		Logger.call(this,"checkBorders()");
		Logger.ret(this,"checkBorders()");
	}
	public void processCollisions()
	{
		Logger.call(this,"processCollisions()");
		Logger.ret(this,"processCollisions()");
	}
}