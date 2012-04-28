package fearlesscode.model.container;

import fearlesscode.model.misc.*;
import fearlesscode.model.player.*;
import fearlesscode.gui.*;

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
	 * A konténer kirajzolója.
	 */
	private PlayerContainerDrawer drawer;

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

	/**
	 * A tárolt pozíció settere.
	 * @param pos Az új pozíció.
	 */
	public void setPosition(EntityPosition pos)
	{
		position=pos;
	}

	/**
	 * Visszaadja a konténer rajzolóját (vagy létrehoz egyet, ha még nincs).
	 * @return A konténer rajzolója.
	 */
	public PlayerContainerDrawer getContainerDrawer()
	{
		if(drawer == null)
		{
			drawer=new PlayerContainerDrawer(this);
		}
		return drawer;
	}
}
