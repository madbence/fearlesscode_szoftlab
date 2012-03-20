package fearlesscode;

import fearlesscode.util.*;
import java.io.*;

class Szkeleton
{
	public static void main(String[] args)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		do
		{
			System.out.println("0. kilepes");
			System.out.println("1. inicializalas");
			System.out.println("2. blokk mozgatas");
			System.out.println("3. jatekos mozgatas");
			System.out.println("4. ido leptetese (tick)");
			System.out.println("5. blokk<->jatek mod kozott valtas");
			try
			{
				line=br.readLine();
			}
			catch(Exception e)
			{
				line="";
			}
			switch(Integer.parseInt(line))
			{
				case 0: return;
				case 1: init(); break;
				case 2: moveBlock(); break;
				case 3: movePlayer(); break;
				case 4: tick(); break;
				case 5: toggleMode(); break;
				default:
				System.out.println("Nem ertem... :(");
			}
		}
		while(true);
	}
	public static void init()
	{
		Game game=new Game();
		//inicializalas
		game.start();
	}
	public static void moveBlock()
	{
		Logger.off();
		Game game=new Game();
		//inicializalas
		game.start();
		Logger.on();

		game.getPlayField().move(null, 1);

	}
	public static void movePlayer()
	{
		Logger.off();
		Game game=new Game();
		//inicializalas
		game.start();
		Logger.on();

		//game.getPlayField().getPlayer().move(null);
	}
	public static void tick()
	{
		Logger.off();
		Game game=new Game();
		//inicializalas
		game.start();
		Logger.on();

		game.getPlayField().tick();	
	}
	public static void toggleMode()
	{
		Logger.off();
		Game game=new Game();
		//inicializalas
		game.start();
		Logger.on();

		game.getPlayField().toggleMode();
	}
}