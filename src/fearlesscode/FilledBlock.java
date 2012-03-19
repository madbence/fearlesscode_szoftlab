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
		if(Logger.ask("Blokk széléhez ért?"))
		{
			if(Logger.ask("Lehetséges az átjutás?"))
			{
			FilledBlock neighbour = neighbours[0];
			player.player.enterBlock(neighbour);
			neighbour.setPlayer(player.player,pos);
			}
			else if(Logger.ask("Kiesik?"))
			{
				//????????vissza kéne hogy hivjon a PlayField-re de nincs rá ref??????
			}
		}
		else if(Logger.ask("Kilépett egy blokkból?"))
		{
		player.player.leaveBlock(this);
		}
		Logger.ret(this,"checkBorders()");
	}
	public void processCollisions()
	{
		Logger.call(this,"processCollisions()");
		if(Logger.ask("Volt ütközés fallal?"))
		{
			entities.get(0).entity.meetPlayer(player.player);
		}
		if(Logger.ask("Volt ütközés ajtóval?"))
		{
			entities.get(1).entity.meetPlayer(player.player);
		}
		if(Logger.ask("Volt ütközés kulccsal?"))
		{
			entities.get(2).entity.meetPlayer(player.player);
		}
		Logger.ret(this,"processCollisions()");
	}
}