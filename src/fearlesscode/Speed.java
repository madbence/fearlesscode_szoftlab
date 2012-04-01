package fearlesscode;

/**
 * A j�t�kos sebess�g�t reprezent�l� oszt�ly. 
 */
public class Speed
{

     /**
       * V�zszintes(x) �s f�gg�leges(y) ir�ny� sebess�g.
       */
	private double x;
	private double y;
	
	/**
      * Speed oszt�ly konstruktora.
      *
      * @param x V�zszintes ir�ny� sebess�g.
	  * @param y F�gg�leges ir�ny� sebess�g.
      */
	public Speed(double x, double y)
	{
		this.x=x;
		this.y=y;
	}

	/**
      * A v�zsintes ir�ny� sebess�get adja vissza(getter met�dus).
      *
	  * @return x V�zszintes ir�ny� sebess�g.
      */
	public double getX()
	{
		return x;
	}

	/**
      * A f�gg�leges ir�ny� sebess�get adja vissza(getter met�dus).
      *
	  * @return y F�gg�leges ir�ny� sebess�g.
      */
	public double getY()
	{
		return y;
	}
}
