package fearlesscode.io;

import java.io.*;

public class GameSaver
{
	/**
	 * Az elmentett pálya száma
	 */
	private int savedLevel;

	/**
	 * A fájl, amiben tároljuk a mentést.
	 */
	private String fileName;

	/**
	 * Létrehozz a GameSaver objektumot.
	 */
	public GameSaver()
	{
		fileName="save.dat";
	}

	/**
	 * Beállítja az elmentendő pályát.
	 */
	public void setLevel(int n)
	{
		savedLevel=n;
		save();
	}

	/**
	 * Lekéri az elmentett pálya számát.
	 */
	public int getLevel()
	{
		load();
		return savedLevel;
	}

	/**
	 * Elvégzi a mentést.
	 */
	private void save()
	{
		try
		{
			BufferedWriter wr=new BufferedWriter(new FileWriter(fileName));
			wr.write(String.valueOf(savedLevel));
			wr.close();
		}
		catch(Exception e)
		{
			System.err.println("Save failed ("+e.getMessage()+")");
		}
	}

	/**
	 * Elvégzi a betöltést.
	 */
	private void load()
	{
		try
		{
			BufferedReader r=new BufferedReader(new FileReader(fileName));
			String line=r.readLine();
			savedLevel=Integer.parseInt(line);
			r.close();
		}
		catch(Exception e)
		{
			System.err.println("Load failed ("+e.getMessage()+")");
		}
	}
}