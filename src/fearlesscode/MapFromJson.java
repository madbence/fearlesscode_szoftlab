import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.json.*;

/**
 * A pálya információkat JSON file-ból betöltő osztály.
 *
 * A pályára vonatkozó összes információt lekérdező osztály.
 */
public class MapFromJson
{
	
	/**
	 * Az egész JSON állományt tartalmazó változó.
	 */
	private JSONObject rawMap;
	
	/**
	 * A MapFromJson osztály konstruktora, amiben a rawMap attribútumba eltároljuk a
	 * a konstruktor paraméterében megadott file JSON tartalmát.  
	 *
	 * @param file A JSON-t tartalmazó file elérési útja.
	 */
	public MapFromJson(String file)
	{
		InputStream is;
		try 
		{
			is = new BufferedInputStream(new FileInputStream(file));
			rawMap = new JSONObject(new JSONTokener(is));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * A Map x irányú méretének lekérdezésére szolgáló metódus.
	 *
	 * @return A Map x irányú mérete.
	 */
	int getMapSizeX()
	{
		try
		{
			return rawMap.getJSONObject("size").getInt("x");
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * A Map y irányú méretének lekérdezésére szolgáló metódus.
	 *
	 * @return A Map y irányú mérete.
	 */
	int getMapSizeY()
	{
		try 
		{
			return rawMap.getJSONObject("size").getInt("y");
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * A Map-ben található Block-ok számának lekérdezésére szolgáló metódus.
	 *
	 * @return A Map-ben található Block-ok száma.
	 */
	int getNumberOfBlocks()
	{
		return this.getMapSizeX()*this.getMapSizeY();
		
	}
	
	/**
	 * Egy adott Block- típusának lekérdezésére szolgáló metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Block típusa boolean-ként. Ha FilledBlock akkor true, ha EmptyBlock akkor false.
	 */
	boolean isFilledBlock(int numberOfBlock)
	{
		String type = new String();
		try
		{
			type = rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock).getString("type");
		}
		catch (JSONException e)
		{
			//e.printStackTrace();
		}
		if("FilledBlock".equals(type))
		{
			return true;			//ha FilledBlock típusú akkor TRUE
		}
		if("EmptyBlock".equals(type))
		{
			return false;			//ha EmptyBlock típusú akkor FALSE
		}
		return false;
	}
	
	/**
	 * Egy adott Block x poziciójának lekérdezésére szolgáló metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Block x poziciója.
	 */
	int getXPositionOfBlock(int numberOfBlock)
	{
		try
		{
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONObject("position").getInt("x");
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Egy adott Block y poziciójának lekérdezésére szolgáló metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Block y poziciója.
	 */
	int getYPositionOfBlock(int numberOfBlock)
	{
		try
		{
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONObject("position").getInt("y");
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Egy adott Block-ban lévő Entity-k számának lekérdezésére szolgáló metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Block-ban található Entity-k száma.
	 */
	int getNumberOfEntitiesInBlock(int numberOfBlock)
	{
		try 
		{
			//ha EmptyBlockról van szó
			if(this.isFilledBlock(numberOfBlock) == false)
			{	
				//akkor biztos hogy üres
				return 0;
			}
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONArray("entities").length();
			
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Egy adott Block-ban lévő adott Entity típusát lekérdező metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Entity típusa Stringként. (Wall, Key, Door, SpawnPoint)
	 */
	String getTypeOfEntityInBlock(int numberOfBlock,int numberOfEntity)
	{
		try
		{
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONArray("entities").getJSONObject(numberOfEntity).getString("type");
		}
		catch (JSONException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ex";
	}
	
	/**
	 * Egy adott Block-ban lévő adott Entity x pozicióját lekérdező metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Entity x poziciója double-ként.
	 */
	double getXPositionOfEntityInBlock(int numberOfBlock, int numberOfEntity)
	{
		if( this.getTypeOfEntityInBlock(numberOfBlock, numberOfEntity).equals("wall") )
		{
			return -1;
		}
		try
		{
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONArray("entities").getJSONObject(numberOfEntity)
					.getJSONObject("position").getDouble("x");
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Egy adott Block-ban lévő adott Entity y pozicióját lekérdező metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Entity y poziciója double-ként.
	 */
	double getYPositionOfEntityInBlock(int numberOfBlock, int numberOfEntity)
	{
		if( this.getTypeOfEntityInBlock(numberOfBlock, numberOfEntity).equals("wall") )
		{
			return -1;
		}
		try
		{
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONArray("entities").getJSONObject(numberOfEntity)
					.getJSONObject("position").getDouble("y");
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Egy adott Door elvárt kulcsainak számát lekérdező metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Door által elvárt kulcsok száma. Ha nem Door-ról van szó akkor a visszatérési érték -1.
	 */
	int getNumberOfRequiredKeys(int numberOfBlock, int numberOfEntity)
	{
		if( "Door".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)) )
		{
			try
			{
				return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
						.getJSONArray("entities").getJSONObject(numberOfEntity)
						.getInt("requiredKeys");
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
		}
		return -1;	
	}
	
	/**
	 * Egy adott Block-ban lévő adott Wall adott Point-jának x koordinátáját lekérő metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @param numberOfPoint Annak a Point-nak a sorszáma amiről információt szeretnénk.
	 * @return Az adott Wall adott Pointjának x koodrinátája.
	 */
	double getXPointOfWallInBlock(int numberOfBlock,int numberOfEntity,int numberOfPoint)
	{
		if( "Wall".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)) )
		{
			try
			{
				return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
						.getJSONArray("entities").getJSONObject(numberOfEntity).
						getJSONArray("points").getJSONObject(numberOfPoint).getDouble("x");
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
			return -1;
		}
		return -1;
	}
	
	/**
	 * Egy adott Block-ban lévő adott Wall adott Point-jának y koordinátáját lekérő metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @param numberOfPoint Annak a Point-nak a sorszáma amiről információt szeretnénk.
	 * @return Az adott Wall adott Pointjának y koodrinátája.
	 */
	double getYPointOfWallInBlock(int numberOfBlock,int numberOfEntity,int numberOfPoint)
	{
		if("Wall".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)))
		{
			try
			{
				return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
						.getJSONArray("entities").getJSONObject(numberOfEntity).
						getJSONArray("points").getJSONObject(numberOfPoint).getDouble("y");
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
			return -1;
		}
		return -1;
	}
	
	
	/**
	 * Egy adott Block-ban lévő Player-ek számát lekérdező metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Block-ban lévő Player-ek száma.
	 */
	int getNumberOfPlayersInBlock(int numberOfBlock)
	{
		try 
		{
			if(this.isFilledBlock(numberOfBlock)==false)
			{
				return 0;
			}
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONArray("players").length();
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Egy adott Block-ban lévő, adott Player x pozicióját lekérő metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfPlayer Annak a Player-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Player x poziciója.
	 */
	double getXPositionOfPlayerInBlock(int numberOfBlock, int numberOfPlayer)
	{
		try
		{
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock)
					.getJSONArray("players").getJSONObject(numberOfPlayer).getJSONObject("position").getDouble("x");
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Egy adott Block-ban lévő, adott Player y pozicióját lekérő metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfPlayer Annak a Player-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Player y poziciója.
	 */
	double getYPositionOfPlayerInBlock(int numberOfBlock, int numberOfPlayer)
	{
		try
		{
			return rawMap.getJSONArray("blocks").getJSONObject(numberOfBlock).getJSONArray("players")
					.getJSONObject(numberOfPlayer).getJSONObject("position").getDouble("y");
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
}
