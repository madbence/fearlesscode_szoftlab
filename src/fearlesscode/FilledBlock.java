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
		for(int i = 0; i < this.players.size(); i++)
		{
			PlayerContainer player = this.players.get(i);

			player.getPlayer().getSpeed();
			if(Logger.ask("Blokk szelehez ert?"))
			{
				if(Logger.ask("Lehetseges az atjutas?"))
				{
					Block neighbour = playField.getBlocks().get(1).block;
					player.getPlayer().enterBlock(neighbour);
					neighbour.setPlayer(player.getPlayer(),null);
				}
				else if(Logger.ask("Kiesik?"))
				{
					//playField.resetPlayer();
				}
			}
			else if(Logger.ask("Kilepett egy blokkbol?"))
			{
				player.getPlayer().leaveBlock(this);
			}
			Logger.ret(this,"checkBorders()");
		}
	}
	
	/**
	 * Végignézi az összes objektumot, hogy ütközik-e a jétékosokkal,
	 * ha pedig igen, meghívja a meetPlayer metódusukat.
	 */
	public void processCollisions()
	{
		Logger.call(this,"processCollisions()");
        
		for(int i = 0; i < this.players.size(); i++)
		{
			PlayerContainer player = this.players.get(i);

			player.getPlayer().getSpeed();
			if(Logger.ask("Volt utkozes fallal?"))
			{
				entities.get(0).getEntity().meetPlayer(player.getPlayer());
			}
			if(Logger.ask("Volt utkozes ajtoval?"))
			{
				entities.get(1).getEntity().meetPlayer(player.getPlayer());
			}
			if(Logger.ask("Volt utkozes kulccsal?"))
			{
				entities.get(2).getEntity().meetPlayer(player.getPlayer());
			}
		}

		Logger.ret(this,"processCollisions()");
	}
}