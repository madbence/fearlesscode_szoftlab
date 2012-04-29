package fearlesscode.app;

import fearlesscode.model.util.*;
import fearlesscode.model.core.*;
import fearlesscode.model.block.*;
import fearlesscode.controller.*;
import fearlesscode.menu.*;
import fearlesscode.io.*;
import fearlesscode.gui.*;
import fearlesscode.tools.*;
import java.util.*;
import java.awt.event.*;

/**
 * A program grafikus változatának fő osztálya.
 */
public class Grafikus
{
	/**
	 * Létrehoz egy Grafikus objektumot, majd betölti rajta a főmenüt.
	 * @param args Parancssori paraméterek (nem használjuk).
	 */
	public static void main(String[] args)
	{
		Grafikus app=Grafikus.getInstance();
		//try{app.play(1);}catch(Exception e){}
		app.loadMainMenu();
		if(args.length > 0)
		{
			app.level=Integer.parseInt(args[0]);
		}
	}

	/**
	 * A tárolt játék objektum.
	 */
	private final Game game;

	/**
	 * A tárolt grafikus felület.
	 */
	private final GameFrame gameFrame;

	/**
	 * A játék órája.
	 */
	private Timer clock;

	/**
	 * Az aktuális pálya száma.
	 */
	private int level;

	/**
	 * A játék mentését végző objektum.
	 */
	private GameSaver gameSaver;

	/**
	 * A Grafikus példányának tárolására (sigleton pattern).
	 */
	private static Grafikus instance;

	/**
	 * Visszaadja a Grafikus egyetlen példányát (sigleton pattern).
	 */
	public static Grafikus getInstance()
	{
		if(instance==null)
		{
			instance=new Grafikus();
		}
		return instance;
	}

	protected Grafikus()
	{
		game=new Game();
		gameFrame=new GameFrame();
		gameSaver=new GameSaver();
		level=gameSaver.getLevel();
	}

	/**
	 * Létrehozza a játékhoz szükséges InputHandlereket (részletesen a szekvenciadiargamokon).
	 */
	public InputDispatcher createInputDispatcher()
	{
		InputDispatcher dispatcher=new InputDispatcher();

		PlayFieldController pfc=new PlayFieldController(game.getPlayField());
		PlayFieldKeyConfiguration pfkc=new PlayFieldKeyConfiguration(KeyEvent.VK_SPACE);
		PlayFieldInputHandler pfih=new PlayFieldInputHandler();
		pfih.setController(pfc);
		pfih.setConfig(pfkc);
		dispatcher.attach(pfih);

		try
		{
			PlayerInputHandler p1=new PlayerInputHandler();
			p1.setController(new PlayerController(game.getPlayField().getPlayers().get(0).getPlayer(), game.getPlayField()));
			p1.setConfig(new PlayerKeyConfiguration(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP));
			dispatcher.attach(p1);
		}
		catch(Exception e)
		{
			Logger.debug("Map has no players");
		}

		try
		{
			PlayerInputHandler p2=new PlayerInputHandler();
			p2.setController(new PlayerController(game.getPlayField().getPlayers().get(1).getPlayer(), game.getPlayField()));
			p2.setConfig(new PlayerKeyConfiguration(KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W));
			dispatcher.attach(p2);
		}
		catch(Exception e)
		{
			Logger.debug("Map has only 1 player");
		}

		//@TODO: az üres blokkot kéne mozgatni...
		BlockInputHandler b1=new BlockInputHandler();
		int emptyBlockIndex=game.getPlayField().getEmptyBlockIndex();
		System.out.println(emptyBlockIndex);
		b1.setController(new BlockController(game.getPlayField().getBlocks().get(emptyBlockIndex).getBlock(), game.getPlayField()));
		b1.setConfig(new BlockKeyConfiguration(KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A));
		dispatcher.attach(b1);

		BlockInputHandler b2=new BlockInputHandler();
		b2.setController(new BlockController(game.getPlayField().getBlocks().get(emptyBlockIndex).getBlock(), game.getPlayField()));
		b2.setConfig(new BlockKeyConfiguration(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT));
		dispatcher.attach(b2);

		return dispatcher;
	}

	
	public void resize(int x, int y)
	{
		gameFrame.setVisible(false);
		gameFrame.setSize(x, y);
		gameFrame.setVisible(true);
	}

	/**
	 * A megadott pályától indít egy játékot.
	 * @param n A pálya száma.
	 */
	public void play(int n) throws Exception
	{
		PlayField playField=PlayFieldBuilder.createPlayField(game, "maps/original/level"+n+".json");
		level=n;
		game.start(playField);
		gameFrame.clearKeyListeners();
		InputDispatcher dispatcher=createInputDispatcher();

		gameFrame.addKeyListener(dispatcher);
		gameFrame.setDrawer(new PlayFieldDrawer(playField));

		if(clock != null)
		{
			clock.cancel();
		}
		clock=new Timer();
		clock.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if(!game.getPlayField().isBlockMode())
				{
					game.getPlayField().tick();
				}
				gameFrame.repaint();
			}
		},0,(long)(1000/30));
		resize(
			BlockContainerDrawer.WIDTH*playField.getWidth()+30,
			BlockContainerDrawer.HEIGHT*playField.getHeight()+50);
	}

	/**
	 * Elindítja a következő pályát, és növeli az aktuális pálya számát ennek megfelelően.
	 */
	public void playNext()
	{
		try
		{
			play(level+1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Betölti a főmenüt.
	 */
	public void loadMainMenu()
	{
		showStaticScreen();
		final Menu mainMenu=new Menu();
		mainMenu.addItem(new PlayGameMenuItem());
		mainMenu.addItem(new ContinueGameMenuItem());
		mainMenu.addItem(new ExitGameMenuItem());
		mainMenu.setActive(0);
		gameFrame.setDrawer(new MenuDrawer(mainMenu));
		gameFrame.repaint();
		gameFrame.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					mainMenu.setActive(mainMenu.getSelectedIndex()-1);
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					mainMenu.setActive(mainMenu.getSelectedIndex()+1);
				}
				else if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					mainMenu.activate();
				}
				else
				{
					return;
				}
				gameFrame.repaint();
			}
		});
	}
	public void showStaticScreen()
	{
		resize(400, 300);
		if(clock != null)
		{
			clock.cancel();
		}
		gameFrame.clearKeyListeners();
	}
	
	/**
	 * Visszaadja az aktuális pálya számát.
	 */
	public int getLevel()
	{
		return level;
	}

	/**
	 * Megjelenít egy statikus képernyőt ("Loading next level..." felirattal).
	 * Majd betölti a következő pályát.
	 */
	public void loadNextLevel()
	{

	}

	/**
	 * Megjeleníti a játék vége képernyőt, majd visszatér a főmenübe.
	 */
	public void endGame()
	{
		
	}

	/**
	 * Elmenti az aktuális szintet, majd kilép a programból.
	 */
	public void exit()
	{
		gameSaver.setLevel(level);
		System.exit(0);
	}
}