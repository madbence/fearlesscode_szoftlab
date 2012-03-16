package fearlesscode;

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