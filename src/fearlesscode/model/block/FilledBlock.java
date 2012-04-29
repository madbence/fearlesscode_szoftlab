package fearlesscode.model.block;

import fearlesscode.tools.*;
import fearlesscode.model.core.*;
import fearlesscode.model.misc.*;
import fearlesscode.model.player.*;
import fearlesscode.model.container.*;
import fearlesscode.model.physics.*;
import java.util.*;
import fearlesscode.gui.*;

/**
 * A sima blokkot reprezentálja, kezeli a benne található objektumokat
 * (objektumok interakciója a játékossal).
 */
public class FilledBlock extends Block
{
	/**
	 * A blokk kirajzolója.
	 */
	private BlockDrawer drawer;

	/**
	 * A FilledBlock konstruktora.
	 * @param p A tartalmazó PlayField referenciája.
	 */
	public FilledBlock(PlayField pf)
	{
		super(pf);
	}
	
	/**
	 * A blokkok kközötti mozgást kezeli le.
	 */
	public void checkBorders()
	{
		/**
		 * Lista, hogy melyik játékosok fogják elhagyni a blokkot.
		 * Mivel iteráció közben nem lehet módosítani az objektumot, amin iterálunk,
		 * ezért kell a workaround.
		 */
		ArrayList<Player> leaveList=new ArrayList<Player>();

		/**
		 * Minden játékoson végigiterálunk.
		 */
		for(PlayerContainer player:players)
		{
			/**
			 * A kevesebb kód érdekében az egyes pozíciókat gyorsan is el lehet érni
			 */
			EntityPosition currentPosition=player.getPosition();
			EntityPosition nextPosition=player.getPlayer().getNextPosition(player.getPosition());

			/**
			 * Ha a játékos egy új blokkba lép, azt ezen a pozíción teszi majd meg.
			 */
			EntityPosition entryPosition=null;

			/**
			 * A blokk elhagyásának iránya (0 észak, 90 fokonként az cw irányban számoljuk).
			 * Ha nem megy ki a blokkból, -1.
			 */
			int dir=-1;

			/**
			 * Blokk-elhagyás sebességét lehet vele korrigálni.
			 */
			int speedScale=1;

			/**
			 * Segédváltozó, mely nyilvántartja, hogy a pálcikaember átlépett-e egy másik blokkba.
			 */
			boolean protect=false;

			/**
			 * Ha a játékos BAL oldalvonala elhagyta a blokk BAL oldalvonalát, kilépett a blokkból (3as irányban).
			 */
			if(nextPosition.getX()<=0 && currentPosition.getX()>0)
			{
				dir=3;
				entryPosition=new EntityPosition(
					Block.WIDTH+player.getPlayer().getSpeed().getX()*speedScale,
					currentPosition.getY()+player.getPlayer().getSpeed().getY()*speedScale);
			}
			/**
			 * Ha a játékos JOBB oldalvonala átlépte a blokk JOBB oldalvonalát, akkor kilépett 1-es irányban.
			 */
			else if(nextPosition.getX()+Player.WIDTH >= Block.WIDTH && currentPosition.getX()+Player.WIDTH < Block.WIDTH)
			{
				dir=1;
				entryPosition=new EntityPosition(
					-Player.WIDTH+player.getPlayer().getSpeed().getX()*speedScale,
					currentPosition.getY()+player.getPlayer().getSpeed().getY()*speedScale);
			}
			/**
			 * Ha a játékos FELSŐ oldalvonala elhagyta a blokk FELSŐ oldalvonalát, akkor kilépett 0-ás irányban.
			 */
			else if(nextPosition.getY()<=0 && currentPosition.getY()>0)
			{
				dir=0;
				entryPosition=new EntityPosition(
					currentPosition.getX()+player.getPlayer().getSpeed().getX()*speedScale,
					Block.HEIGHT+player.getPlayer().getSpeed().getY()*speedScale);
			}
			/**
			 * Ha a játékos ALSÓ oldalvonala elhagyta a blokk ALSÓ oldalvonalát, 2-es irányban lépett ki.
			 */
			else if(nextPosition.getY()+Player.HEIGHT >= Block.HEIGHT && currentPosition.getY()+Player.HEIGHT < Block.HEIGHT)
			{
				dir=2;
				entryPosition=new EntityPosition(
					currentPosition.getX()+player.getPlayer().getSpeed().getX()*speedScale,
					-Player.HEIGHT+player.getPlayer().getSpeed().getY()*speedScale);
			}

			/**
			 * Ha a játékos kilépett a blokkból.
			 */
			if(dir != -1)
			{
				/**
				 * Megkeressük a megfelelő szomszédot.
				 */
				Block neighbour=getNeighbour(dir);

				/**
				 * Ha a szomszédja létezik (nem a PlayField szélén akarunk átlépni),
				 * valamint illeszkedik a két blokk.
				 */
				if(neighbour != null && matches(neighbour, dir, true))
				{
					/**
					 * Akkor a játékos belép a blokkba a megadott pozíción.
					 */
					player.getPlayer().enterBlock(neighbour, entryPosition);
					protect=true;
				}
				/**
				 * Ha nincs szomszéd, vagy nem illeszkedik, viszont LEFELÉ hagytuk el a blokkot, akkor reset.
				 */
				else if(dir == 2)
				{
					playField.resetPlayer(player);
					return;
					//instant visszaterunk, mert nem kell tovabb szarozni.
				}
				/**
				 * Egyébként egyszerűen megállunk a blokk szélénél.
				 */
				else
				{
					//Logger.log(player.getPlayer(), "collided with the border of "+getName());
					player.getPlayer().move(
						new Speed(
							-player.getPlayer().getSpeed().getX()*(dir%2),
							-player.getPlayer().getSpeed().getY()*((dir+1)%2)));
				}
			}
			/**
			 * Ha a játékos TELJESEN kilépett a blokkból.
			 *
			 * Tehát a játékos JOBB oldalvonala elhagyta a blokk BAL oldalvonalát, stb.
			 */
			if( nextPosition.getY() > Block.HEIGHT ||
				nextPosition.getY()+Player.HEIGHT < 0 ||
				nextPosition.getX() > Block.WIDTH ||
				nextPosition.getX()+Player.WIDTH < 0)
			{
				/**
				 * Itt volt/van egy bug, néha el tudott veszni, reprodukálni a bugot nem nagyon sikerült még szándékosan.
				 *
				 * Mindenesetre nem hagyjuk, hogy teljesen elvesszen a játékos minden blokkreferenciája.
				 */
				if(player.getPlayer().getActiveBlocks().size()>1)
				{
					/**
					 * Elhagyjuk a blokkot. (itt csak jelezzük, a metódus elején részletezett okok miatt)
					 */
					leaveList.add(player.getPlayer());
				}
			}
			else
			{
				/**
				 * Egyébként minden normális, a játékos a következő pozícióra mozoghat.
				 */
				if(protect)
				{
					player.setPosition(player.getPlayer().getNextPosition(currentPosition));
					player.getPlayer().setProcessed(true);
				}
				else if(!player.getPlayer().isProcessed())
				{
					player.setPosition(player.getPlayer().getNextPosition(currentPosition));
				}
				else
				{
					player.getPlayer().setProcessed(false);
				}
			}
		}
		/**
		 * Utólag végrehajtjuk a blokk elhagyásokat.
		 */
		for(Player p:leaveList)
		{
			p.leaveBlock(this);
		}
	}
	
	/**
	 * Végignézi az összes objektumot, hogy ütközik-e a jétékosokkal,
	 * ha pedig igen, meghívja a meetPlayer metódusukat.
	 */
	public void processCollisions()
	{
		for(PlayerContainer player:players)
		{
			/**
			 * Elkérjük a játékos következő pozícióját, és a befoglaló téglalapját.
			 */
			Rectangle playerBox=player.getPlayer().getBoundingBox();
			EntityPosition nextPosition=player.getPlayer().getNextPosition(player.getPosition());
			for(EntityContainer container:entities)
			{
				/**
				 * Elkérjük az entitás befoglaló téglalapját.
				 */
				Rectangle entityBox=container.getEntity().getBoundingBox();

				/**
				 * Ha ez a két téglalap metszi egymást, ütközés van.
				 */
				if(CollisionProcesser.isCollied(nextPosition, playerBox, container.getPosition(), entityBox))
				{
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

	/**
	 * Metódus, ami 2 blokk szélének egyezőségét adja meg.
	 * @param other A másik blokk.
	 * @param dir A vizsgálat mely oldalon történjen.
	 * @param callback Történjen-e visszahívás (másik oldalról is elvégzi a vizsgálatot).
	 */
	public boolean matches(Block other, int dir, boolean callback)
	{
		BlockMatcher matcher=new BlockMatcher(this, other, dir);
		if(matcher.matches())
		{
			if(callback)
			{
				return other.matches(this, (dir+2)%4, false);
			}
			return true;
		}
		return false;
	}

	/**
	 * Visszaad egy blokkot kirajzoló objektumot, melynek előbb átadja önmagát paraméterként.
	 * @return Blokkot kirajzoló objektum.
	 */	
	public BlockDrawer getBlockDrawer()
	{
		if(drawer == null)
		{
			drawer=new FilledBlockDrawer(this);
		}
		return drawer;
	}
}