package fearlesscode;

import fearlesscode.util.*;

public class Key extends Entity
{

	public Key(PlayField playField)
	{
		//Logger.call(this,"Key.init()");
		super(playField);
		Logger.reg(this, "key");
		//Logger.ret(this,"Key.init()");
	}

    public void meetPlayer(Player player)
    {
    	Logger.call(this,"meetPlayer(player)");
    	if(!Logger.ask("Meg lett mar szerezve a kulcs?"))
		{
			player.addKey();
			playField.setSpawnPosition(this);
		}
    	Logger.ret(this,"meetPlayer(player)");
	}
}