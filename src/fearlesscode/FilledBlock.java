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
		/*
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
		}*/
	}
	
	/**
	 * Végignézi az összes objektumot, hogy ütközik-e a jétékosokkal,
	 * ha pedig igen, meghívja a meetPlayer metódusukat.
	 */
	public void processCollisions()
	{
		for(int i = 0; i < this.players.size(); i++)
		{
			PlayerContainer player = this.players.get(i);
			Rectangle playerBox=player.getPlayer().getBoundingBox();
			EntityPosition nextPosition=player.getPlayer().getNextPosition(player.getPosition());
			for(EntityContainer container:entities)
			{
				Rectangle entityBox=container.getEntity().getBoundingBox();
				if(CollisionProcesser.isCollied(nextPosition, playerBox, container.getPosition(), entityBox))
				{
					Logger.log(player.getPlayer(),"collided with "+container.getEntity().getName());
					container.getEntity().meetPlayer(player);
				}
			}
		}
	}
	
	/**
	 * A FilledBlock információk lekérésére.
	 * @param pos A FilledBlock poziciója.
	 * @return A Block koordinátáit a PlayField-en belül, melyik Player-ek, és milyen Entity-k tartózkodnak benne, és hogy milyen szomszédai vannak.
	 */
	public String getInfo(Position pos)
	{
		String entityList="";
		if(entities.size()>0)
		{
			for(EntityContainer container:entities)
			{
				entityList+=container.getEntity().getName();
			}
		}
		else
		{
			entityList="none";
		}

		String playerList="";
		if(players.size()>0)
		{
			for(PlayerContainer container:players)
			{
				playerList+=container.getPlayer().getName();
			}
		}
		else
		{
			playerList="none";
		}

		String neighbourList="";
		for(Block neighbour:neighbours)
		{
			if(neighbour != null)
			{
				neighbourList+=neighbour.getName();
			}
			else
			{
				neighbourList+="[none]";
			}
		}
		String posString ="("+pos.getX()+","+pos.getY()+")";

		return getName()+"\r\n"+
			"  Coordinates:"+posString+"\r\n"+
			"  Players:"+playerList+"\r\n"+
			"  Entities:"+entityList+"\r\n"+
			"  Neighbours:"+neighbourList;
	}
	
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	public String getName()
	{
		return "["+ID+":FilledBlock]";
	}

	public boolean matches(Block other)
	{
		return false;
	}
}