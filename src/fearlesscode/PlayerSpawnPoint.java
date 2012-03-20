package fearlesscode;

class PlayerSpawnPoint
{
	private Player player;
	private Entity spawPoint;

	/**
	 * Egy új Player csomagolóobjektumot hoz létre
	 * 
	 * Az objektum tárolja a Player referenciáját és az újraéledési helyét (egy Entity)
	 *
	 * @param p A játékos referenciája
	 * @param e Az újraéledési helye
	 */
	public PlayerSpawnPoint(Player p, Entity e)
	{
		player=p;
		spawPoint=e;
	}

	/**
	 * Visszaadja a tárolt játékost
	 * @return Az eltárolt játékos
	 */
	public Player getPlayer()
	{
		return player;
	}

	/**
	 * Visszaadja az újjáéledési helyet
	 * @return Az eltárolt újraéledési hely
	 */
	public Entity getSpawnPoint()
	{
		return spawPoint;
	}
}