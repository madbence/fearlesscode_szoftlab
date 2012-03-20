package fearlesscode;

import fearlesscode.util.*;

public class Key extends Entity
{
	private static int count=0;
	private boolean isObtained;
	/**
	 * Létrehoz egy kulcs objektumot, nem felvett állapottal
	 * @param playField Az aktuális pálya referenciája
	 */
	public Key(PlayField playField)
	{
		super(playField);
		String name="key"+(count++);
		Logger.reg(this, name);
		Logger.call(this,"init()");
		isObtained=false;
		Logger.ret(this,"init()");
	}

	/**
	 * Ha a játékos ütközik egy kulcs objektummal, akkor a megszerzettsége állapotától
	 * függően megnöveli a játékos kulcsainak a számát
	 * @param player A játékos, akivel a kulcs interakcióban nem
	 */
    public void meetPlayer(Player player)
    {
    	Logger.call(this,"meetPlayer(player)");
    	if(!isObtained)
		{
			player.addKey();
			playField.setSpawnPosition(this);
			isObtained=true;
		}
    	Logger.ret(this,"meetPlayer(player)");
	}
}