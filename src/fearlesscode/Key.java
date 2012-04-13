package fearlesscode;

import fearlesscode.util.*;

/**
 * Egy kulcsot reprezentál, amit a játékosnak föl kell szednie.
 * Amennyiben játékossal találkozik, és még nem szerezte meg a kulcsot (ez a saját belsőállapota), akkor értesíti a játékost a fölvételről.
 */
public class Key extends Entity implements Info
{
	
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
		isObtained = false;
	}

	/**
	 * Ha a játékos ütközik egy kulcs objektummal, akkor a megszerzettsége állapotától
	 * függően megnöveli a játékos kulcsainak a számát.
	 *
	 * @param player A játékos, akivel a kulcs interakcióban van.
	 */
	public void meetPlayer(PlayerContainer player)
	{
		if( !isObtained )
		{
			player.getPlayer().addKey();
			playField.setSpawnPosition(player.getPlayer(), this);
			isObtained = true;
			Logger.log(this,"been picked up.");
		}
		Logger.log(this,"already been picked up.");
		
	}
	
	/**
	 * A Key informácioinak lekérése.
	 * @return A saját koordinátái a Block-on belül, és hogy felvették-e. 
	 */
	public String getInfo()
	{
		//@TODO: pozíciót megszerezni.
		return getName()+"\n"+
		"	isObtained: "+isObtained+"\n"+
		"	Coordinates: (pos)";
	}

	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return "["+ID+":Key]";
	}

	public Rectangle getBoundingBox()
	{
		return new Rectangle(10, 20);
	}
}