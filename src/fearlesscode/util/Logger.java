package fearlesscode.util;

import java.util.*;
import java.io.*;

public class Logger
{
	public static int level;
	public static HashMap<Object, String> list;
	static
	{
		list=new HashMap<Object, String>();
		level=0;
	}
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
	private static String getIndentation(int n)
	{
		String s="";
		for(int i=0;i<n;i++)
		{
			s+="  ";
		}
		return s;
	}
	public static void call(Object obj, String message)
	{
		print(getName(obj), message, false);
		level++;
	}
	public static void ret(Object obj, String message)
	{
		level--;
		print(getName(obj), message, true);
	}
	public static void call(String name, String message)
	{
		print(name, message, false);
		level++;
	}
	public static void ret(String name, String message)
	{
		level--;
		print(name, message, true);
	}
	public static void print(String name, String message, boolean dir)
	{
		System.out.print(getIndentation(level)+(dir?"<-":"->")+name+"."+message+"\n");
	}
	public static void reg(Object obj, String name)
	{
		list.put(obj, name);
	}
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
}