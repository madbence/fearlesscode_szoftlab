package fearlesscode;

/**
 * Az Entity pozicióját tároló segédosztály.
 */
public class EntityPosition
{
	/**
	* A tárolt x koordináta.
	*/
	private double x;
	
	/**
	* A tárolt y koordináta.
	*/
	private double y;
	
	
	/**
	* Az EntityPosition konstruktora, beállítja az x és y koordinátákat.
	*
	* @param x Az eltárolandó x koordináta.
	* @param y Az eltárolandó y koordináta.
	* @param pos Az eltárolandó pozíció.
	*/
	public EntityPosition(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	* A tárolt x koordinata gettere.
	*
	* @return A tárolt x koordinata.
	*/
	public double getX()
	{
		return this.x;
	}
	
	/**
	* A tárolt y koordinata gettere.
	*
	* @return A tárolt y koordinata.
	*/
	public double getY()
	{
		return this.y;
	}
	
	/**
	* A tárolt x koordinata settere.
	*/
	public void setX(double x)
	{
		this.x = x;
	}
	
	/**
	* A tárolt y koordinata settere.
	*/
	public void setY(double y)
	{
		this.y = y;
	}
}
