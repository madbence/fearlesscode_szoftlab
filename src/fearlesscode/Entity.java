/**
 * @author
 * @version 1.0
 * @created 15-m�rc.-2012 13:12:50
 */
public abstract class Entity {

	protected PlayField playField;

	public Entity(){

	}

	/**
	 * 
	 * @param player
	 */
	public abstract void meetPlayer(Player player);

}