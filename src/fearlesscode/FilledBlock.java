package fearlesscode;

import fearlesscode.util.*;


/**
 * A sima blokkot reprezentálja, kezeli a benne található objektumokat
 * (objektumok interakciója a játékossal).
 */
public class FilledBlock extends Block
{
	public FilledBlock(PlayField pf)
	{
		super(pf);
	}
	
	/**
	 * A blokkok kközötti mozgást kezeli le.
	 */
	public void checkBorders()
	{
		Logger.call(this,"checkBorders()");
		player.player.getSpeed();
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
				//playField.resetPlayer();
			}
		}
		else if(Logger.ask("Kilepett egy blokkbol?"))
		{
		player.player.leaveBlock(this);
		}
		Logger.ret(this,"checkBorders()");
	}
	
	/**
	 * Végignézi az összes objektumot, hogy ütközik-e a jétékossal,
	 * ha pedig igen, meghívja a meetPlayer metódusukat.
	 */
	public void processCollisions()
	{
		Logger.call(this,"processCollisions()");
		player.player.getSpeed();
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