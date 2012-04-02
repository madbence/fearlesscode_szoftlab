package fearlesscode.util;

import java.util.*;
import java.io.*;

public class Logger
{
	/**
	 * Eseményeket ír ki a képernyőre.
	 * pl.: [3:Player] has moved to position (10,15).
	 */
	public static void log(Info info, String string)
	{
		System.out.println(info.getName()+" has "+ string);
	}
}