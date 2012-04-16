package fearlesscode.util;

import java.util.*;
import java.io.*;
import fearlesscode.*;

/**
 * Az események naplózásáért felelős osztály.
 */
public class Logger
{
	/**
	 * Eseményeket ír ki a képernyőre.
	 * pl.: [3:Player] has moved to position (10,15).
	 * @param info Az esemény forrása.
	 * @param string Az esemény leírása.
	 */
	public static void log(Info info, String string)
	{
		System.out.println(info.getName()+" has "+ string);
	}
	
	/**
	 * Eseményeket ír ki a képernyőre.
	 * pl.: Game mode has been toggled.
	 * @param string Az esemény leírása
	 */
	public static void log(String string)
	{
		System.out.println(string);
	}

	/**
	 * A megadott hibaüzenetet kiírja a képernyőre (a dokumentációnak megfelelő formátumban).
	 * @param str A hibaüzenet.
	 */
	public static void error(String str)
	{
		System.out.println("Error: "+str);
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
}