package fearlesscode;

import fearlesscode.util.*;

public class EmptyBlock extends Block
{
	public EmptyBlock()
        {
                super();
                Logger.call(this,"EmptyBlock.init()");
                Logger.ret(this,"EmptyBlock.init()");
	}
	public void checkBorders()
        {
                Logger.call(this,"EmptyBlock.checkBorders()");
                Logger.ret(this,"EmptyBlock.checkBorders()");
	}
	public void processCollisions()
        {
                Logger.call(this,"EmptyBlock.processCollisions()");
                Logger.ret(this,"EmptyBlock.processCollisions()");
	}
}