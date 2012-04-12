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
	 * @param info Az esemény forrása
	 * @param string Az esemény leírása
	 * @return A specifikált kimeneti nyelv szerinti formátumban az esemény szöveges reprezentációja.
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
}