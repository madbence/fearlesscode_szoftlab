package fearlesscode;

/**
 * A játékos sebességét reprezentáló osztály.
 */
public class Speed
{

	/**
	 * Vízszintes irányú sebesség.
	 */
	private double x;
	
	/**
	 * Függőleges irányú sebesség.
	 */
	private double y;
	
	/**
	 * Speed osztály konstruktora.
	 *
	 * @param x Vízszintes irányú sebesség.
	 * @param y Függőleges irányú sebesség.
	 */
	public Speed(double x, double y)
	{
		this.x=x;
		this.y=y;
	}

	/**
	 * A vízszintes irányú sebességet adja vissza.
	 *
	 * @return x Vízszintes irányú sebesség.
	 */
	public double getX()
	{
		return x;
	}

	/**
	 * A függőleges irányú sebességet adja vissza.
	 *
	 * @return y Függőleges irányú sebesség.
	 */
	public double getY()
	{
		return y;
	}
}
