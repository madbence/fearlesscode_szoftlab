import fearlesscode.util.*;

/**
 * Az üres blokkot reprezentálja, gyakorlatilag a Block osztály default (üres)
 * implemetációja.
 */
public class EmptyBlock extends Block implements Info
{

	/**
	 * Az EmptyBlock konstruktora, PlayField referenciával.
	 */
	public EmptyBlock(PlayField pf)
	{
		super(pf);
	}
	
	/**
	 * Mivel üres blokk, semmi sincs benne, így ez a metódus nem csinál semmit.
	 */
	public void checkBorders()
	{

	}
	
	/**
	 * Mivel üres blokk, semmi sincs benne, így ez a metódus nem csinál semmit.
	 */
	public void processCollisions()
	{

	}
	
	/**
	 * Az EmptyBlock információk lekérésére.
	 * @return A saját koordinátái a PlayField-en belül, és a szomszédai.
	 */
	public String getInfo()
	{
		
	}
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	String getName()
	{
		
	}
}