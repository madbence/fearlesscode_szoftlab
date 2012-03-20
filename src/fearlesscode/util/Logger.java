package fearlesscode.util;

import java.util.*;
import java.io.*;

public class Logger
{
	public static int level;
	public static boolean en;
	public static HashMap<Object, String> list;
	static
	{
		list=new HashMap<Object, String>();
		level=0;
		en=true;
	}

	/**
	 * A megadott objektum nevét adja vissza a Logger saját lookup táblájából
	 *
	 * @param obj A lekérdezni kívánt objektum
	 * @return Az objektum neve, vagy "undefined" String
	 */
	private static String getName(Object obj)
	{
		String name;
		if(!list.containsKey(obj))
		{
			name="undefined";
		}
		else
		{
			name=list.get(obj);
		}
		return name;
	}

	/**
	 * Visszaadja a kívánt behúzást string formában
	 * 
	 * @param n A behúzások száma
	 * @return N*2 darab szóköz
	 */
	private static String getIndentation(int n)
	{
		String s="";
		for(int i=0;i<n;i++)
		{
			s+="  ";
		}
		return s;
	}

	/**
	 * Egy függvényhívást jelez a Logger osztálynak
	 * 
	 * Alapértelmezetten kiírja a kimenetre az alábbi formában:
	 * [behúzások]->[objektum neve].[üzenet]
	 *
	 * @param obj A hívó objektum
	 * @param message A hívó által küldött üzenet (tipikusan egy metódus neve, paraméterlistáva)
	 */
	public static void call(Object obj, String message)
	{
		print(getName(obj), message, false);
		level++;
	}

	/**
	 * Egy függvényvisszatérést jelez a Logger osztálynak
	 * 
	 * Alapértelmezetten kiírja a kimenetre az alábbi formában:
	 * [behúzások]<-[objektum neve].[üzenet]
	 *
	 * @param obj A hívó objektum
	 * @param message A hívó által küldött üzenet (tipikusan egy metódus neve, paraméterlistáva)
	 */
	public static void ret(Object obj, String message)
	{
		level--;
		print(getName(obj), message, true);
	}

	/**
	 * Egy függvényhívást jelez a Logger osztálynak
	 * 
	 * Alapértelmezetten kiírja a kimenetre az alábbi formában:
	 * [behúzások]->[név].[üzenet]
	 *
	 * @param name Tetszőleges név (nem a Logger keresi a a listájából)
	 * @param message A hívó által küldött üzenet (tipikusan egy metódus neve, paraméterlistáva)
	 */
	public static void call(String name, String message)
	{
		print(name, message, false);
		level++;
	}

	/**
	 * Egy függvényvisszatérést jelez a Logger osztálynak
	 * 
	 * Alapértelmezetten kiírja a kimenetre az alábbi formában:
	 * [behúzások]<-[név].[üzenet]
	 *
	 * @param name Tetszőleges név (nem a Logger keresi a a listájából)
	 * @param message A hívó által küldött üzenet (tipikusan egy metódus neve, paraméterlistáva)
	 */
	public static void ret(String name, String message)
	{
		level--;
		print(name, message, true);
	}

	/**
	 * A paraméterek függvényében kiírást végez
	 *
	 * Ha a loggolás engedélyezve van (en statikus attribútum), akkor történik meg a kiírás:
	 * Ha az utolsó (dir) paraméter igaz, akkor:
	 * [behúzások]<-[név].[üzenet]
	 * Egyébként
	 * [behúzások]->[név].[üzenet]
	 */
	public static void print(String name, String message, boolean dir)
	{
		if(!en)
		{
			return;
		}
		System.out.print(getIndentation(level)+(dir?"<-":"->")+name+"."+message+"\n");
	}

	/**
	 * A paraméterben kapott objektumot hozzárendeli a megadott stringhez
	 * 
	 * A későbbiekben a Logger az objektum referenciája alapján tudja kikeresni a nevét
	 * így sokkal használhatóbb (szemléletesebb), mint egy HashCode
	 * 
	 * @param obj A tárolni kívánt objektum referenciája
	 * @param name A tárolni kívánt objektum neve
	 */
	public static void reg(Object obj, String name)
	{
		list.put(obj, name);
	}

	/**
	 * Egy paraméterben megadott kérdést tesz föl a felhasználónak a standard inputon
	 *
	 * A felhasználó a standard inputon válaszolhat "y" vagy "n" válaszokkal, "y" esetén
	 * a metódus true logikai értékkel tér vissza, egyébként hamissal.
	 * Ha a beolvasás során kivétel keletkezik, szintén hamis a visszatérési érték
	 *
	 * @param q A feltenni kívánt kérdés
	 * @return A felhasználó válasza
	 */
	public static boolean ask(String q)
	{
		System.out.print(getIndentation(level)+"\""+q+"\" (y/n) ");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			String line=in.readLine();
			if(line.equals("y"))
			{
				return true;
			}
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	/**
	 * Bekapcsolja a loggolást
	 */
	public static void on()
	{
		en=true;
	}

	/**
	 * Kikapcsolja a loggolást
	 */
	public static void off()
	{
		en=false;
	}
}