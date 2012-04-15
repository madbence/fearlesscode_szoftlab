package fearlesscode;

/**
 * Az Entity-t és az Entity pozicióját tároló segédosztály.
 * 
 * A Block (és leszármazottai) tartalmazzák, így tárolódik el egy-egy Entity pozíciója a blokkon belül.
 */
public class EntityContainer
{
	/**
	 * A tárolt Entity referenciája
	 */
	private Entity entity;
	
	/**
	 * A tárolt pozíció referenciája (az Entity pozíciója).
	 */
	private EntityPosition position;

	/**
	 * A konténer ezen az objektumon belül van.
	 */
	private Block block;

	/**
	 * Az EntityContainer konstruktora, beállítja az Entity referenciáját,
	 * és pozicióját.
	 *
	 * @param en Az eltárolandó Entity.
	 * @param pos Az eltárolandó pozíció.
	 */
	public EntityContainer(Entity en, EntityPosition pos)
	{
		entity=en;
		position=pos;
		entity.setContainer(this);
	}
	
	/**
	 * A tárolt Entity gettere.
	 *
	 * @return A tárolt Entity.
	 */
	public Entity getEntity()
	{
		return entity;
	}

	/**
	 * A tárolt pozíció gettere.
	 *
	 * @return A tárolt pozíció.
	 */
	public EntityPosition getPosition()
	{
		return position;
	}

	/**
	 * A tartalmazó objektum gettere.
	 * @return A konténert tartalmazó objektum.
	 */
	public Block getBlock()
	{
		return block;
	}

	/**
	 * A tartalmazó objektum settere.
	 * @param block A beállítandó objektum.
	 */
	public void setBlock(Block block)
	{
		this.block=block;
	}
}
