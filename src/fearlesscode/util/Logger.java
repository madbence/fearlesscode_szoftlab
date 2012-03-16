package fearlesscode.util;

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
		System.out.print(getIndentation(level)+getName()+"."+message+"\n");
		level++;
	}
	public static void ret(Object obj, String message)
	{
		level--;
		System.out.print(getIndentation(level)+getName()+"."+message+"\n");
	}
}