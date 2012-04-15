package fearlesscode;

import fearlesscode.util.*;

/**
 * Az üres blokkot reprezentálja, gyakorlatilag a Block osztály default (üres)
 * implemetációja.
 */
public class EmptyBlock extends Block
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
	public String getInfo(Position pos)
	{
		String playersString = "Players:none\n";
		String entitiesString = "Entites:none\n";
		String neighbsString = "Neighbours:";
		String posString = "Coordinates:";
		posString+="("+pos.getX()+","+pos.getY()+")\n";
		
		for(int i = 0; i < 4; i++)
		{
			if(neighbours[i] != null)
			{
				neighbsString += neighbours[i].getName();
			}
			else
			{
				neighbsString += "[none]";
			}
		}
		return getName()+"\n"+
			"  "+posString+
			"  "+playersString+
			"  "+entitiesString+
			"  "+neighbsString;
	}
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return "["+this.ID+":EmptyBlock]";
	}

	public boolean matches(Block other, int dir, boolean callback)
	{
		return false;
	}
}