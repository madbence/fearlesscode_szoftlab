package fearlesscode.model.entity;

import fearlesscode.tools.*;
import fearlesscode.gui.*;
import fearlesscode.model.core.*;
import fearlesscode.model.physics.*;
import fearlesscode.model.container.*;
import fearlesscode.model.block.*;
import fearlesscode.model.misc.*;

/**
 * Egy kulcsot reprezentál, amit a játékosnak föl kell szednie.
 * Amennyiben játékossal találkozik, és még nem szerezte meg a kulcsot (ez a saját belsőállapota), akkor értesíti a játékost a fölvételről.
 */
public class Key extends Entity
{

	/**
	 * A kulcs szélessége.
	 */
	public static final double WIDTH=10;
	
	/**
	 * A kulcs magassága.
	 */
	public static final double HEIGHT=20;
	/**
	 * A kulcs állapotát leíró boolean. Ha true akkor, a kulcs már fel lett véve. Ha false, akkor még nem lett felvéve.
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
			Logger.log(player.getPlayer().getName()+" now has "+player.getPlayer().getObtainedKeys());
			playField.setSpawnPosition(player.getPlayer(), this);
			isObtained = true;
			Logger.log(this,"been picked up.");
		}
		else
		{
			Logger.log(this,"already been picked up.");
		}
	}
	
	/**
	 * A Key informácioinak lekérése.
	 * @param post A Key poziciója.
	 * @return A saját koordinátái a Block-on belül, és hogy felvették-e. 
	 */
	public String getInfo(EntityPosition pos)
	{
		return getName()+"\r\n"+
		"  Coordinates:("+pos.getX()+","+pos.getY()+")\r\n"+
		"  isObtained:"+isObtained;
	}

	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return "["+ID+":Key]";
	}

	/**
	 * Visszaadja a befoglaló dobozt.
	 */
	public Rectangle getBoundingBox()
	{
		return new Rectangle(WIDTH, HEIGHT);
	}

	/**
	 * Visszaad egy kulcsot kirajzoló objektumot, melynek előbb átadja önmagát paraméterként.
	 * @return Kulcsot kirajzoló objektum.
	 */
	public EntityDrawer getEntityDrawer()
	{
		if(drawer == null)
		{
			drawer=new KeyDrawer(this);
		}
		return drawer;
	}

	/**
	 * A kulcs állapotát lekérdező (getter)metódus.
	 * @return A kulcs állapotát leíró boolean. Ha true, akkor a kulcs már fel lett véve. Ha false, akkor még nem lett felvéve.
	 */
	public boolean isObtained()
	{
		return isObtained;
	}
}