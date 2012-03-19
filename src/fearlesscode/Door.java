package fearlesscode;

import fearlesscode.util.*;

public class Door extends Entity
{
	public Door(int requiredKeys, PlayField playField)
	{
		super(playField);
		Logger.reg(this, "door");
		//Logger.call(this,"Door.init()");
		//Logger.ret(this,"Door.init()");
	}
	public void meetPlayer(Player player)
	{
		Logger.call(this,"meetPlayer(player)");
		player.getObtainedKeys();
		if(Logger.ask("Nyithato az ajto?"))
		{
			playField.win();
		}
		Logger.ret(this,"meetPlayer(player)");
	}
}