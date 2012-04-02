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
	 * Az EntityContainer konstruktora, beállítja az Entity referenciáját,
	 * és pozicióját.
	 *
	 * @param en Az eltárolandó Entity.
	 * @param pos Az eltárolandó pozíció.
	 */
	public EntityContainer(Entity en, EntityPosition pos)
	{
		entity = en;
		position = pos;
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
}
