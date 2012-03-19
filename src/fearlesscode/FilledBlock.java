package fearlesscode;

import fearlesscode.util.*;

public class FilledBlock extends Block
{
	public FilledBlock(PlayField pf)
	{
		super(pf);
		Logger.call("FilledBlock", "init()");
		Logger.ret("FilledBlock", "init()");
	}
	public void checkBorders()
	{
		Logger.call(this,"checkBorders()");
		if(Logger.ask("Blokk szelehez ert?"))
		{
			if(Logger.ask("Lehetseges az atjutas?"))
			{
				Block neighbour = playField.getBlocks().get(1).block;
				player.player.enterBlock(neighbour);
				neighbour.setPlayer(player.player,null);
			}
			else if(Logger.ask("Kiesik?"))
			{
				playField.resetPlayer();
			}
		}
		else if(Logger.ask("Kilepett egy blokkbol?"))
		{
		player.player.leaveBlock(this);
		}
		Logger.ret(this,"checkBorders()");
	}
	public void processCollisions()
	{
		Logger.call(this,"processCollisions()");
		if(Logger.ask("Volt utkozes fallal?"))
		{
			entities.get(0).entity.meetPlayer(player.player);
		}
		if(Logger.ask("Volt utkozes ajtoval?"))
		{
			entities.get(1).entity.meetPlayer(player.player);
		}
		if(Logger.ask("Volt utkozes kulccsal?"))
		{
			entities.get(2).entity.meetPlayer(player.player);
		}
		Logger.ret(this,"processCollisions()");
	}
}