package fearlesscode;

import java.util.ArrayList;
import fearlesscode.util.*;

/**
 * A PlayField-et felépítő osztály.
 * 
 * A PlayField összerakásáért felelős, elkészíti a blokkokat, elhelyezi rajtuk az objektumokat, a játékost, a blokkokat összerendezi a PlayField objektumban.
 */
public class PlayFieldBuilder
{
	/**
	 * A PlayField-et felépítő metódus.
	 *
	 * Felépítí a PlayField-et a megadott file alapján, felhasználva a MapFromJson segédosztályt. A szekvencia diagrammok között megadott 4.4.1-es diagram szerint.
	 * A MapFromJson osztályból a pályára vonatkozó összes információ lekérhető get metódusok segítségével, igy ezekből az információkból az PlayField könnyen felépíthető. 
	 *
	 * @param game A Game objektum referenciája.
	 * @param file A pályát tartalmazó file elérési útja.
	 */
	public static PlayField createPlayField(Game game, String file)
	{
		/*
		int numberOfBlocks = 16;
		int numberOfEmptyBlock = 15;
		int numberOfBlockToBuildUp = 1;
		int dimension = 4;					//blokk méreteinek beállítása
		
		PlayField pf = new PlayField(game);
		ArrayList<Block> blocks = new ArrayList<Block>();  //blokkokat arraylistben tároljuk
		
		for(int i = 0; i < numberOfBlocks; i++)// arraylistet feltöltjük blokkokkal
		{
			if(i == numberOfEmptyBlock)	  //15 Filledblock ami nem tartalmaz Entity-t
			{
				blocks.add(new EmptyBlock(pf));
			}
			else
			{
				blocks.add(new FilledBlock(pf)); // 1 block ami tartalmaz entity-t
			}
		}
		
		for(int i=0; i<numberOfBlocks; i++)
		{			 //szomszédosság beállítása
			if(i%4!=0)
			{
				blocks.get(i).setNeighbour(blocks.get(i-1),3,true);
			}
			if(i>4)
			{
				blocks.get(i).setNeighbour(blocks.get(i-4),0,true);
			}		
		}

		
		Wall wall = new Wall(pf, null);
		Door door = new Door(0, pf);
		Key	 key = new Key(pf);			  //3 entitás létrehozása
		
		blocks.get(0).addEntity(null,wall);
		blocks.get(0).addEntity(null,door);
		blocks.get(0).addEntity(null,key);	 //entitások hozzáadása egy blokkhoz
		
		for(int i=0; i<numberOfBlocks; i++)
		{
			pf.addBlock(null,blocks.get(i));
		}
		
		Player player = new Player();
		
		blocks.get(0).setPlayer(player, null);	  //player beállítása a blokkban
		//pf.setPlayer(player);						 //player beállítása a playfieldben
		player.enterBlock(blocks.get(0));
		return pf;*/
		PlayField pf = new PlayField(game);
		ArrayList<Block> blocks = new ArrayList<Block>();
		MapFromJson mfj = new MapFromJson(file);
		
		for(int i=0; i<mfj.getNumberOfBlocks();i++)
		{
			if(mfj.isFilledBlock(i))
			{
				blocks.add(new FilledBlock(pf));
			}
			else
			{
				blocks.add(new EmptyBlock(pf));
			}
		}
		for(int i=0; i<mfj.getNumberOfBlocks(); i++)
		{			 
			if(i%4!=0)
			{
				blocks.get(i).setNeighbour(blocks.get(i-1),3,true);
			}
			if(i>4)
			{
				blocks.get(i).setNeighbour(blocks.get(i-4),0,true);
			}		
		}
		for(int i=0; i<mfj.getNumberOfBlocks();i++)
		{
			if(mfj.isFilledBlock(i))								//ha FilledBlock-ról van szó
			{
				for(int j=0;j<mfj.getNumberOfEntitiesInBlock(j);j++)
				{
					EntityPosition entityPos = new EntityPosition(mfj.getXPositionOfEntityInBlock(i, j),mfj.getYPositionOfEntityInBlock(i, j));
					if("Wall".equals(mfj.getTypeOfEntityInBlock(i, j)))
					{
						double width = mfj.getWidthOfWall(i, j);
						double height = mfj.getHeightOfWall(i, j);
						Wall wall = new Wall(pf,width,height);
						blocks.get(i).addEntity(entityPos,wall);
					}
					else if("Door".equals(mfj.getTypeOfEntityInBlock(i,j)))
					{
						int keys = mfj.getNumberOfRequiredKeys(i, j);
						Door door = new Door(keys,pf);
						blocks.get(i).addEntity(entityPos,door);
					}
					else if("Key".equals(mfj.getTypeOfEntityInBlock(i,j)))
					{
						Key key = new Key(pf);
						blocks.get(i).addEntity(entityPos, key);
					}	
				}
			}
		}
		
		for(int i=0; i<mfj.getNumberOfBlocks();i++)
		{
			Position pos = new Position(mfj.getXPositionOfBlock(i),mfj.getYPositionOfBlock(i));
			pf.addBlock(pos, blocks.get(i));
		}
		
		for(int i=0; i<mfj.getNumberOfBlocks();i++)
		{
			for(int j=0; i<mfj.getNumberOfPlayersInBlock(i);j++)
			{
				Player player = new Player();
				double xSP = mfj.getXSpawnPointOfPlayerInBlock(i, j);
				double ySP = mfj.getYSpawnPointOfPlayerInBlock(i, j);
				EntityPosition spawnPos = new EntityPosition(xSP,ySP);
				SpawnPoint spawnPoint = new SpawnPoint(pf);
				blocks.get(i).addEntity(spawnPos,spawnPoint);
				double xEP = mfj.getXPositionOfPlayerInBlock(i, j);
				double yEP = mfj.getYPositionOfPlayerInBlock(i, j);
				EntityPosition entityPos = new EntityPosition(xEP,yEP);
				blocks.get(i).setPlayer(player, entityPos);
				pf.addPlayer(player, spawnPoint);
				player.enterBlock(blocks.get(i));
			}
		}
		return null;
	}

}