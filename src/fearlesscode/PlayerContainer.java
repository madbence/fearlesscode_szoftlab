package fearlesscode;


/**
 * A Playert és a Player pozicióját tároló segédosztály.
 * 
 * A Block (és leszármazottai) tartalmazzák, így tárolódik el egy-egy játékos pozíciója a blokkon belül.
 */
public class PlayerContainer
{
	/**
	 * A tárolt játékos referenciája
	 */
	private Player player;

	/**
	 * A tárolt pozíció referenciája (a játékos pozíciója).
	 */
	private EntityPosition position;

	/**
	 * A PlayerContainer konstruktora, beállítja a Player referenciáját,
	 * és pozicióját.
	 * @param player Az eltárolandó játékos.
	 * @param pos Az eltárolandó pozíció.
	 */
	public PlayerContainer(Player player, EntityPosition pos)
	{
		this.player=player;
		this.position=pos;
	}

	/**
	 * A tárolt játékos gettere.
	 * @return A tárolt játékos.
	 */
	public Player getPlayer()
	{
		return player;
	}

	/**
	 * A tárolt pozíció gettere.
	 * @return A tárolt pozíció.
	 */
	public EntityPosition getPosition()
	{
		return position;
	}
}
