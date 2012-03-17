package fearlesscode;

public abstract class Block {

	private Entity entities;
	private Block neighbours;
	private Player player;

	public void Block(){

	}

	/**
	 * 
	 * @param position
	 * @param entity
	 */
	public void addEntity(Position position, Entity entity){

	}

	public abstract void checkBorders();

	/**
	 * 
	 * @param direction
	 */
	public void getNeighbour(Direction direction){

	}

	public abstract void processCollisions();

	/**
	 * 
	 * @param neighbour
	 * @param dir
	 * @param bool
	 */
	public void setNeighbour(Block neighbour, Direction dir, boolean bool){

	}

	/**
	 * 
	 * @param neighbours
	 */
	public void setNeighbours(Block[] neighbours){

	}

	/**
	 * 
	 * @param player
	 * @param position
	 */
	public void setPlayer(Player player, Position position){

	}

}