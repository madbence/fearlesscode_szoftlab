package fearlesscode;

import fearlesscode.util.*;


/**
 * Az Entity egy blokkon található statikus (nem mozgó) objektumot reprezentál,
 * minden leszármazottnak kötelessége viselkedést definiálni a játékossal való találkozásra.
 */
public abstract class Entity
{
	/**
	 * PlayField referencia, a leszármazottak a viselkedés leírásának megkönnyítése
	 * érdekében felhasználhatják.
	 */
	protected PlayField playField;
	
	/**
	 * Entity konstruktor
	 * @param playField A tartalmazó playField referenciája.
	 */
	public Entity(PlayField playField)
	{
		this.playField=playField;
	}
	
	/**
	 * Kötelezően implementálandó metódus, a játékossal
	 * való találkozás forgatókönyvét írja le.
	 */
	public abstract void meetPlayer(Player p);
}
