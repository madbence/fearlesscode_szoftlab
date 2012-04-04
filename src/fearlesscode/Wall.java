package fearlesscode;

import fearlesscode.util.*;
import java.util.*;

/**
 * Falat reprezentáló osztály.
 */
public class Wall extends Entity implements Info
{
	/**
	 * A  fal szélessége.
	 */
	private double x;
	
	/**
	 * A fal magassága.
	 */
	private double y;

	/**
	 * Létrehoz egy új fal objektumot, a megadott pontokkal határolva.
	 *
	 * @ param playfield referencia az Entity ősosztály konstruktorához
	 * @ param x A fal szélessége.
	 * @ param y A fal magassága.
	 */
	public Wall(PlayField playField, double x, double y)
	{
		super(playField);
		this.x=x;
		this.y=y;
	}

	/**
	 * A fal játékossal való találkozás eseménykezelője.
	 *
	 * Ha a játékos és a fal találkozási felülete függőleges, úgy az X irányú mozgás
	 * szűnik meg a játékos részéről, ha vízszintes, akkor pedig a függőleges (Y).
	 *
	 * @ param player A játékos, akivel a fal interakcióba került
	 */
	public void meetPlayer(Player player)
	{

	}
	
	/**
	 * A Wall információinak lekérése.
	 * @return A saját koordinátája a Block-on belül, szélessége, magassága. 
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