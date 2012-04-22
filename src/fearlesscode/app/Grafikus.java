package fearlesscode.app;

import fearlesscode.model.util.*;
import fearlesscode.model.core.*;
import fearlesscode.controller.*;
import fearlesscode.io.*;
import fearlesscode.gui.*;
import java.util.*;
import java.awt.event.*;


public class Grafikus
{
	public static void main(String[] args)
	{
		Grafikus app=new Grafikus(args[0]);
	}

	public Game game;
	public Grafikus(String map)
	{
		game=new Game();
		try
		{
			PlayField playField=PlayFieldBuilder.createPlayField(game, map);
			game.start(playField);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		final GameFrame gameFrame=new GameFrame(game);
		Timer clock=new Timer();
		final InputDispatcher dispatcher=createInputDispatcher();
		clock.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				game.getPlayField().tick();
				gameFrame.repaint();
			}
		},0,(long)(1000/30));
		gameFrame.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				dispatcher.handleKeyPressed(e.getKeyCode());
			}
			public void keyReleased(KeyEvent e)
			{
				dispatcher.handleKeyReleased(e.getKeyCode());
			}
		});
		gameFrame.setSize(400, 300);
		gameFrame.setVisible(true);

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

		PlayerInputHandler p1=new PlayerInputHandler();
		p1.setController(new PlayerController(game.getPlayField().getPlayers().get(0).getPlayer(), game.getPlayField()));
		p1.setConfig(new PlayerKeyConfiguration(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP));
		dispatcher.attach(p1);

		PlayerInputHandler p2=new PlayerInputHandler();
		p2.setController(new PlayerController(game.getPlayField().getPlayers().get(1).getPlayer(), game.getPlayField()));
		p2.setConfig(new PlayerKeyConfiguration(KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W));
		dispatcher.attach(p2);

		BlockInputHandler b=new BlockInputHandler();
		b.setController(new BlockController(game.getPlayField().getBlocks().get(1).getBlock(), game.getPlayField()));
		b.setConfig(new BlockKeyConfiguration(KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A));
		dispatcher.attach(b);

		return dispatcher;
	}
}