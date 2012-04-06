package fearlesscode;

import fearlesscode.util.*;

/**
 * Az Entity osztály üres implementációja, a játékosok alapértelmezetten ennek az osztály egy példányának a helyén jönnek létre.
 */
public class SpawnPoint extends Entity implements Info
{
	
	/**
	 * A SpawPoint konstruktora. Mivel üres implementáció, csak a szülő osztály konstruktorát hívja meg.
	 * @param playField Az Entity konstruktorának továbbadott PlayField objektum.
	 */
	public SpawnPoint(PlayField playField, double x, double y)
	{
		super(playField);
	}

	/**
	 * Ha a játékos egy SpawPointtal ütközik, nem történik semmi, így a metódus implementációja teljesen üres.
	 * @param player A játékos, akivel ütközik az objektum.
	 */
	public void meetPlayer(Player player)
	{
		
	}
	
	/**
	 * A SpawnPoint információinak lekérése.
	 * @return A saját koordinátája a Block-on belül.
	 */
	public String getInfo()
	{
		return null;
	}
		
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return null;
	}
}