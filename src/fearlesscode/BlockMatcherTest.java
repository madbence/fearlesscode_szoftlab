package fearlesscode;

import fearlesscode.util.*;

public class BlockMatcherTest
{
	public static void main(String[] args)
	{
		Block b1=new FilledBlock(null);
		Block b2=new FilledBlock(null);

		b1.addEntity(
			new EntityPosition(-10, 20),
			new Wall(null,220, 10));
		b2.addEntity(
			new EntityPosition(-10, 20),
			new Wall(null,220, 10));

		b1.addEntity(
			new EntityPosition(185, 75),
			new SpawnPoint(null));

		//Logger.debug("Match: "+b1.matches(b2, 0, true));
		Logger.debug("Match: "+b1.matches(b2, 1, true));
		//Logger.debug("Match: "+b1.matches(b2, 2, true));
		//Logger.debug("Match: "+b1.matches(b2, 3, true));
		//Logger.debug("Match: "+b2.matches(b1, 0, true));
		//Logger.debug("Match: "+b2.matches(b1, 1, true));
		//Logger.debug("Match: "+b2.matches(b1, 2, true));
		Logger.debug("Match: "+b2.matches(b1, 3, true));
	}
}