package fearlesscode;

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
	public MapFromJson(String file) throws CommandException
	{
		InputStream is;
		try 
		{
			is = new BufferedInputStream(new FileInputStream(file));
			rawMap = new JSONObject(new JSONTokener(is));
		}
		catch (Exception e)
		{
			throw new CommandException("JSON File "+file+ " not found.");
		}
		
	}
	
	/**
	 * A Map méretét tároló JSONObject-et lekérdező privát metódus.
	 *
	 * @return A Map méretének JSONObject-je.
	 */
	private JSONObject getSize() throws JSONException
	{
		return rawMap.getJSONObject("size");
	}
	
	/**
	 * A Map Block-jait tároló JSONArray-t lekérdező privát metódus.
	 *
	 * @return A Map Block-jainak JSONArray-je.
	 */
	private JSONArray getBlocks() throws JSONException
	{
		return rawMap.getJSONArray("blocks");
	}
	
	/**
	 * A Mapból egy Block-ot tároló JSONObjectet lekérdező privát metódus.
	 *
	 * @param numberOfBlock A Block sorszáma.
	 * @return A Map egy Block-ját tároló JSONObject.
	 */
	private JSONObject getBlock(int numberOfBlock) throws JSONException
	{
		return this.getBlocks().getJSONObject(numberOfBlock);
	}
	
	/**
	 * A Map egy Blockjában egy Entity-t tároló JSONObjectet lekérdező privát metódus.
	 *
	 * @param numberOfBlock A Block sorszáma.
	 * @param numberOfEntity Az Entity sorszáma.
	 * @return A Map Block-jának Entity-jét tároló JSONObject.
	 */
	private JSONObject getEntity(int numberOfBlock, int numberOfEntity) throws JSONException
	{
		return this.getBlock(numberOfBlock).getJSONArray("entities").getJSONObject(numberOfEntity);
	}
	
	
	/**
	 * A Map x irányú méretének lekérdezésére szolgáló metódus.
	 *
	 * @return A Map x irányú mérete.
	 */
	public int getMapSizeX()
	{
		try
		{
			return this.getSize().getInt("x");
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
	public int getMapSizeY()
	{
		try 
		{
			return this.getSize().getInt("y");
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
	public int getNumberOfBlocks()
	{
		return this.getMapSizeX()*this.getMapSizeY();
		
	}
	
	/**
	 * Egy adott Block- típusának lekérdezésére szolgáló metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Block típusa boolean-ként. Ha FilledBlock akkor true, ha EmptyBlock akkor false.
	 */
	public boolean isFilledBlock(int numberOfBlock)
	{
		String type = new String();
		try
		{
			type = this.getBlock(numberOfBlock).getString("type");
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
	public int getXPositionOfBlock(int numberOfBlock)
	{
		try
		{
			return this.getBlock(numberOfBlock).getJSONObject("position").getInt("x");
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
	public int getYPositionOfBlock(int numberOfBlock)
	{
		try
		{
			return this.getBlock(numberOfBlock).getJSONObject("position").getInt("y");
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
	public int getNumberOfEntitiesInBlock(int numberOfBlock)
	{
		try 
		{
			//ha EmptyBlockról van szó
			if(this.isFilledBlock(numberOfBlock) == false)
			{	
				//akkor biztos hogy üres
				return 0;
			}
			return this.getBlock(numberOfBlock).getJSONArray("entities").length();
			
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
	public String getTypeOfEntityInBlock(int numberOfBlock,int numberOfEntity)
	{
		try
		{
			return this.getEntity(numberOfBlock, numberOfEntity).getString("type");
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
	public double getXPositionOfEntityInBlock(int numberOfBlock, int numberOfEntity)
	{
		if( this.getTypeOfEntityInBlock(numberOfBlock, numberOfEntity).equals("wall") )
		{
			return -1;
		}
		try
		{
			return this.getEntity(numberOfBlock, numberOfEntity).getJSONObject("position").getDouble("x");
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
	public double getYPositionOfEntityInBlock(int numberOfBlock, int numberOfEntity)
	{
		if( this.getTypeOfEntityInBlock(numberOfBlock, numberOfEntity).equals("wall") )
		{
			return -1;
		}
		try
		{
			return this.getEntity(numberOfBlock, numberOfEntity).getJSONObject("position").getDouble("y");
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
	public int getNumberOfRequiredKeys(int numberOfBlock, int numberOfEntity)
	{
		if( "Door".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)) )
		{
			try
			{
				return this.getEntity(numberOfBlock, numberOfEntity).getInt("requiredKeys");
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
		}
		return -1;	
	}
	
	/**
	 * Egy adott SpawnPoint PlayerID-ját lekérdező metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Door által elvárt kulcsok száma. Ha nem Door-ról van szó akkor a visszatérési érték -1.
	 */
	public int getPlayerIDofSpawnPoint(int numberOfBlock, int numberOfEntity)
	{
		if( "SpawnPoint".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)) )
		{
			try
			{
				return this.getEntity(numberOfBlock, numberOfEntity).getInt("playerID");
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
		}
		return -1;	
	}
	
	/**
	 * Egy adott Block-ban lévő adott Wall poziciójának x koordinátáját lekérő metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Wall x koordinátája.
	 */
	public double getXPositionOfWallInBlock(int numberOfBlock,int numberOfEntity)
	{
		if( "Wall".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)) )
		{
			try
			{
				return this.getEntity(numberOfBlock, numberOfEntity).getJSONObject("position").getDouble("x");
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
	 * Egy adott Block-ban lévő adott Wall poziciójának y koordinátáját lekérő metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Wall y koordinátája.
	 */
	public double getYPositionOfWallInBlock(int numberOfBlock,int numberOfEntity)
	{
		if("Wall".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)))
		{
			try
			{
				return this.getEntity(numberOfBlock, numberOfEntity).getJSONObject("position").getDouble("y");
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
	 * Egy adott Block-ban lévő adott Wall szélességét visszaadó metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Wall szélessége.
	 */
	public double getWidthOfWall(int numberOfBlock,int numberOfEntity)
	{
		if("Wall".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)))
		{
			try
			{
				return this.getEntity(numberOfBlock, numberOfEntity).getDouble("width");
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
	 * Egy adott Block-ban lévő adott Wall magasságát visszaadó metódus.
	 *
	 * @param numberOfBlock Annak a Block-nak a sorszáma, amiről információt szeretnénk.
	 * @param numberOfEntity Annak az Entity-nek a sorszáma, amiről információt szeretnénk.
	 * @return Az adott Wall magassága.
	 */
	public double getHeightOfWall(int numberOfBlock,int numberOfEntity)
	{
		if("Wall".equals(this.getTypeOfEntityInBlock(numberOfBlock,numberOfEntity)))
		{
			try
			{
				return this.getEntity(numberOfBlock, numberOfEntity).getDouble("height");
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
			return -1;
		}
		return -1;
	}
	
}
