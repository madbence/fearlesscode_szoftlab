package fearlesscode;

import fearlesscode.util.*;


/**
*	Az Entity egy blokkon található statikus (nem mozgó) objektumot reprezentál,
*   minden leszármazottnak kötelessége viselkedést definiálni a
*   játékossal való találkozásra.
*/
public abstract class Entity
{
	/**
	* playField PlayFieldreferencia,aleszármazottakaviselkedésleírásánakmegkönnyí-
	* tése érdekében felhasználhatják.
	*/
	protected PlayField playField;
	
	
	public Entity(PlayField playField)
	{
		//Logger.call(this,"Entity.create()");
		this.playField=playField;
		//Logger.ret(this,"Entity.create()");
	}
	
	/**
	* Kötelezo ̋en implementálandó metódus, a játékossal
	* való találkozás forgatókönyvét írja le.
	*/
    public abstract void meetPlayer(Player p);
}
