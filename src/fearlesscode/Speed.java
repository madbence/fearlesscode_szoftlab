package fearlesscode;

/**
 * A játékos sebességét reprezentáló osztály. 
 */
public class Speed
{

     /**
       * Vízszintes(x) és függõleges(y) irányú sebesség.
       */
	private double x;
	private double y;
	
	/**
      * Speed osztály konstruktora.
      *
      * @param x Vízszintes irányú sebesség.
	  * @param y Függõleges irányú sebesség.
      */
	public Speed(double x, double y)
	{
		this.x=x;
		this.y=y;
	}

	/**
      * A vízsintes irányú sebességet adja vissza(getter metódus).
      *
	  * @return x Vízszintes irányú sebesség.
      */
	public double getX()
	{
		return x;
	}

	/**
      * A függõleges irányú sebességet adja vissza(getter metódus).
      *
	  * @return y Függõleges irányú sebesség.
      */
	public double getY()
	{
		return y;
	}
}
