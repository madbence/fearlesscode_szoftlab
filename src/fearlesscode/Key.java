package fearlesscode;

import fearlesscode.util.*;

/**
 * Egy kulcsot reprezentál, amit a játékosnak föl kell szednie.
 * Amennyiben játékossal találkozik, és még nem szerezte meg a kulcsot (ez a saját belsőállapota), akkor értesíti a játékost a fölvételről.
 */
public class Key extends Entity implements Info
{
	/**
	 * A kulcsok számát nyilvántartó osztály szintű változó.
	 */
	private static int count = 0;
	
	/**
	 * A kulcs állapotát leíró boolean. Ha true akkor a kulcs már fel lett véve. Ha false akkor még nem lett felvéve.
	 */
	private boolean isObtained;

	/**
	 * A Key konstruktora.
	 * 
	 * Létrehoz egy kulcs objektumot, nem felvett állapottal.
	 *
	 * @param playField Az aktuális pálya referenciája.
	 */
	public Key(PlayField playField)
	{
		super(playField);
		String name = "key"+(count++);
		Logger.reg(this, name);
		Logger.call(this,"init()");
		isObtained = false;
		Logger.ret(this,"init()");
	}

	/**
	 * Ha a játékos ütközik egy kulcs objektummal, akkor a megszerzettsége állapotától
	 * függően megnöveli a játékos kulcsainak a számát.
	 *
	 * @param player A játékos, akivel a kulcs interakcióban van.
	 */
	public void meetPlayer(Player player)
	{
		Logger.call(this,"meetPlayer(player)");
		if( !isObtained )
		{
			player.addKey();
			playField.setSpawnPosition(player, this);
			isObtained = true;
		}
		Logger.ret(this,"meetPlayer(player)");
	}
	
	/**
	 * A count gettere.
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * A Key informácioinak lekérése.
	 * @return A saját koordinátái a Block-on belül, és hogy felvették-e. 
	 */
	public String getInfo()
	{
		
	}
	
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	String getName()
	{
		
	}
}