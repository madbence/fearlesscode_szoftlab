package fearlesscode.app;

import fearlesscode.model.util.*;
import fearlesscode.model.core.*;
import fearlesscode.controller.*;
import fearlesscore.io.*;
import java.util.*;


public class Grafikus
{
	public static void main(String[] args)
	{
		Grafikus app=new Grafikus(args[1]);
	}

	public Game game;
	public Grafikus(String map)
	{
		game=new Game();
		PlayField playField=PlayFieldBuilder.createPlayField(game, map);
		GameFrame gameFrame=new GameFrame(game);
		Timer clock=new Timer();
		final PlayFieldInputHandler handler=createInputHandler();
		clock.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				game.getPlayField().tick();
			}
		},0,(long)(1000/30));
		gameFrame.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				handler.handleKeyPressed(e.getKeyCode());
			}
			public void keyReleased(KeyEvent e)
			{
				handler.handleKeyReleased(e.getKeyCode());
			}
		});

	}

	public PlayFieldInputHandler createInputHandler()
	{
		PlayFieldController pfc=new PlayFieldController(game.getPlayField());

		PlayerInputHandler p1=new PlayerInputHandler();
		p1.setController(new PlayerController(game.getPlayField().getPlayers().get(0).getPlayer()));
		p1.setConfig(new PlayerKeyConfiguration(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP));
		pfc.addPlayerController(p1);

		PlayFieldInputHandler pfih=new PlayFieldInputHandler(pfc);
	}
}