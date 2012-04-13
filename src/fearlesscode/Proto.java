package fearlesscode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * A prototípus fő osztálya, kezeli a bemeneteket, és végrehajtja az azon érkező parancsokat.
 */
public class Proto
{
	Game game;

	public Proto()
	{
		game = new Game();
	}

	/**
	 * A program belépési pontja. Létrehoz egy Proto objektumot, amin végrehajtja a bemeneten érkező utasításokat.
	 * @param args A program parancssori paraméterei (nem használja a program).
	 * @throws IOException 
	 */
	public static void main(String[] args)
	{
		try
		{
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String cmd;
			Proto proto = new Proto();
			
			while(true)
			{
				System.out.print ("> ");
				System.out.flush(); 
				cmd = stdin.readLine();
				System.out.println("\n");
				proto.commandSorter(cmd, proto);		
			}
		}
		catch(Exception e)
		{
			System.out.println("Uncaught exception...");
			e.printStackTrace();
		}
	}

	/**
	 * Lépteti a modellt (1 egységgel)
	 */
	public void tick()
	{
		tick(1);
	}

	/**
	 * Lépteti a modellt a megadott számú lépéssel.
	 * @param n A lépések száma.
	 */
	public void tick(int n)
	{
		for(int i=0;i<n;i++)
		{
			game.getPlayField().tick();
		}
	}

	/**
	 * Elmozdít egy blokkot.
	 * @param id A blokk azonosítója.
	 * @param dir A mozgatás iránya.
	 */
	public void moveBlock(int id, int dir) throws CommandException
	{
		game.getPlayField().move(game.getPlayField().getBlock(id), dir);
	}

	/**
	 * Megváltoztatja a PlayField játék-állapotát (játék és blokk mód között vált)
	 */
	public void toggleMode()
	{
		game.getPlayField().toggleMode();
	}

	/**
	 * Módosítja egy játékos sebességvektorát.
	 * @param id A játékos azonosítója.
	 * @param x A mozgatás vízszintes irányú komponense.
	 * @param y A mozgatás függőleges irányú komponense.
	 */
	public void movePlayer(int id, int x, int y) throws CommandException
	{
		game.getPlayField().getPlayer(id).move(new Speed(x, y));
	}

	/**
	 * Kiírja a játékban található összes blokk adatait.
	 */
	public void getBlockInfo() throws CommandException
	{
		for(int i=0;i<game.getPlayField().getBlocks().size();i++)
		{
			getBlockInfo(i);
		}
	}

	/**
	 * Kiírja egy blokk adatait.
	 * @param n A blokk azonosítója.
	 */
	public void getBlockInfo(int n) throws CommandException
	{
		System.out.println(game.getPlayField().getBlock(n).getInfo());
	}

	/**
	 * Kiírja a játékban található összes entitás adatait.
	 */
	public void getEntityInfo() throws CommandException
	{
		for(BlockContainer blockcontainer : game.getPlayField().getBlocks())
		{
			for(EntityContainer entitycontainer : blockcontainer.getBlock().getEntities())
			{
				System.out.println(entitycontainer.getEntity().getInfo());
			}
		}
	}

	/**
	 * Kiírja egy entitás adatait.
	 * @param n Az entitás azonosítója.
	 */
	public void getEntityInfo(int n) throws CommandException
	{
		for(BlockContainer blockcontainer : game.getPlayField().getBlocks())
		{									
			for( EntityContainer entitycontainer : blockcontainer.getBlock().getEntities())
			{
				if(entitycontainer.getEntity().getID() == n)
				{
					System.out.println(entitycontainer.getEntity().getInfo());
				}
			}
		}
	}

	/**
	 * Kiírja a játékban található összes játékos adatait.
	 */
	public void getPlayerInfo() throws CommandException
	{
		for(int i=0;i<2;i++)
		{
			getPlayerInfo(i);
		}
	}

	/**
	 * Kiírja egy játékos adatait.
	 * @param n A játékos azonosítója.
	 */
	public void getPlayerInfo(int n) throws CommandException
	{
		System.out.println(game.getPlayField().getPlayer(n).getInfo());
	}

	/**
	 * Kilép a protóból.
	 */
	public void exit()
	{
		System.out.println("Kilepes a protobol");
		System.exit(1);
	}

	/**
	 * Betölt egy új pályát.
	 * @param file A betöltendő fájl neve.
	 */
	public void loadMap(String file)
	{
		PlayField pf=PlayFieldBuilder.createPlayField(game, file);
		game.start(pf);
	}

	/**
	 * A parancs helyére behelyettesíti egy fájl tartalmát.
	 * @param file A beillesztendő fájl neve.
	 * @param proto Megkapja a Proto referenciáját.
	 */
	public void include(String file, Proto proto)
	{
		try
		{
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) 
			{
				commandSorter(strLine,proto);
			}
		}
		catch(Exception e)
		{
			System.out.println("File ERROR");
		}
	}	

	/**
	 * Értelmezi a parancsokat.
	 * @param command Az értelmezendő parancs.
	 * @param proto Megkapja a Proto referenciáját.
	 */
	public void commandSorter(String command,Proto proto)
	{
		try
		{
			String[] splitted = command.split("\\s+");
			if(splitted[0].equals("tick"))
			{
				if(splitted.length==1)
				{
					proto.tick();
				}
				else if(splitted.length==2)
				{
					int a = Integer.parseInt(splitted[1]);
					proto.tick(a);
				}
				else
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("moveBlock"))
			{
				if(splitted.length==3)
				{
					int a = Integer.parseInt(splitted[1]);
					int b = Integer.parseInt(splitted[2]);
					proto.moveBlock(a,b);
				}
				else
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("toggleMode"))
			{
				if(splitted.length==1)
				{
					proto.toggleMode();
				}
				else
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("movePlayer"))
			{
				if(splitted.length==4)
				{
					int a = Integer.parseInt(splitted[1]);
					int b = Integer.parseInt(splitted[2]);
					int c = Integer.parseInt(splitted[3]);
					proto.movePlayer(a,b,c);
				}
				else 
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("getBlockInfo"))
			{
				if(splitted.length==1)
				{
					proto.getBlockInfo();
				}
				else if(splitted.length==2)
				{
					int a = Integer.parseInt(splitted[1]);
					proto.getBlockInfo(a);
				}
				else 
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("getEntityInfo"))
			{
				if(splitted.length==1)
				{
					proto.getEntityInfo();
				}
				else if(splitted.length==2)
				{
					int a = Integer.parseInt(splitted[1]);
					proto.getEntityInfo(a);
				}
				else 
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("getPlayerInfo"))
			{
				if(splitted.length==1)
				{
					proto.getPlayerInfo();
				}
				else if(splitted.length==2)
				{
					int a = Integer.parseInt(splitted[1]);
					proto.getPlayerInfo(a);
				}
				else 
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("exit"))
			{
				if(splitted.length==1)
				{
					proto.exit();
				}
				else 
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("loadMap"))
			{
				if(splitted.length==2)
				{
					proto.loadMap(splitted[1]);
				}
				else
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
			if(splitted[0].equals("include"))
			{
				if(splitted.length==2)
				{
					proto.include(splitted[1], proto);
				}
				else 
				{
					System.out.println("Nem megfelelő paraméterek");
				}
			}
		}
		catch(CommandException ce)
		{
			System.out.println(ce.getMessage());
		}
	}
}