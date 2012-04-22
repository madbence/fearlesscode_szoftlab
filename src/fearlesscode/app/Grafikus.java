package fearlesscode.app;

import fearlesscode.model.util.*;
import fearlesscode.model.core.*;
import fearlesscode.controller.*;
import fearlesscode.menu.*;
import fearlesscode.io.*;
import fearlesscode.gui.*;
import fearlesscode.tools.*;
import java.util.*;
import java.awt.event.*;


public class Grafikus
{
	public static void main(String[] args)
	{
		Grafikus app=Grafikus.getInstance();
		//try{app.play(1);}catch(Exception e){}
		app.loadMainMenu();
	}

	private final Game game;
	private final GameFrame gameFrame;
	private Timer clock;
	private int level=1;
	private static Grafikus instance;
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
	}

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
		b1.setController(new BlockController(game.getPlayField().getBlocks().get(1).getBlock(), game.getPlayField()));
		b1.setConfig(new BlockKeyConfiguration(KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A));
		dispatcher.attach(b1);

		BlockInputHandler b2=new BlockInputHandler();
		b2.setController(new BlockController(game.getPlayField().getBlocks().get(1).getBlock(), game.getPlayField()));
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

	public void play(int n) throws Exception
	{
		PlayField playField=PlayFieldBuilder.createPlayField(game, "maps/level"+level+".json");
		game.start(playField);
		gameFrame.clearKeyListeners();
		InputDispatcher dispatcher=createInputDispatcher();

		gameFrame.addKeyListener(dispatcher);
		gameFrame.setDrawer(new PlayFieldDrawer(playField));

		clock=new Timer();
		clock.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				game.getPlayField().tick();
				gameFrame.repaint();
			}
		},0,(long)(1000/30));
		resize(200*playField.getWidth(), 150*playField.getHeight());
	}
	public void playNext()
	{
		try
		{
			play(++level);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
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
	public int getLevel()
	{
		return level;
	}
}