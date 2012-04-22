package fearlesscode.tools;

import java.util.*;
import java.io.*;
import fearlesscode.model.misc.*;

/**
 * Az események naplózásáért felelős osztály.
 */
public class Logger
{
	private static boolean enabled=true;
	/**
	 * Eseményeket ír ki a képernyőre.
	 * pl.: [3:Player] has moved to position (10,15).
	 * @param info Az esemény forrása.
	 * @param string Az esemény leírása.
	 */
	public static void log(Info info, String string)
	{
		print(info.getName()+" has "+ string);
	}
	
	/**
	 * Eseményeket ír ki a képernyőre.
	 * pl.: Game mode has been toggled.
	 * @param string Az esemény leírása
	 */
	public static void log(String string)
	{
		print(string);
	}

	/**
	 * A megadott hibaüzenetet kiírja a képernyőre (a dokumentációnak megfelelő formátumban).
	 * @param str A hibaüzenet.
	 */
	public static void error(String str)
	{
		print("Error: "+str);
	}

	/**
	 * Debuggolásra szólgáló logger metódus.
	 *
	 * @param str A kiirandó szöveg.
	 */
	public static void debug(String str)
	{
		System.err.println("Debug: "+str);
	}

	public static void enable()
	{
		enabled=true;
	}
	public static void disable()
	{
		enabled=false;
	}
	public static void print(String s)
	{
		if(enabled)
		{
			System.out.println(s);
		}
	}
}