package fearlesscode;

import fearlesscode.util.*;

public class Key extends Entity
{
	/**
	 * Létrehoz egy kulcs objektumot, nem felvett állapottal
	 */
	public Key(PlayField playField)
	{
		//Logger.call(this,"Key.init()");
		super(playField);
		Logger.reg(this, "key");
		//Logger.ret(this,"Key.init()");
	}

	/**
	 * Ha a játékos ütközik egy kulcs objektummal, akkor a megszerzettsége állapotától
	 * függően megnöveli a játékos kulcsainak a számát
	 * @param Player player A játékos, akivel a kulcs interakcióban nem
	 */
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