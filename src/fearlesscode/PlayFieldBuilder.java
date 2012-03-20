package fearlesscode;

import java.util.ArrayList;

import fearlesscode.util.*;

public class PlayFieldBuilder
{
	public static PlayField createPlayField(Game game)
    {
        Logger.call("PlayFieldBuilder", "createPlayField()");
        
        int numberOfBlocks = 16;
        int numberOfEmptyBlock = 15;
        int numberOfBlockToBuildUp = 1;
        int dimension = 4;                  //blokk méreteinek beállítása
        
        PlayField pf = new PlayField(game);
        ArrayList<Block> blocks = new ArrayList<Block>();  //blokkokat arraylistben tároljuk
        
        for(int i = 0; i < numberOfBlocks; i++)// arraylistet feltöltjük blokkokkal
        {
            if(i == numberOfEmptyBlock)   //15 Filledblock ami nem tartalmaz Entity-t
            {
                blocks.add(new EmptyBlock(pf));
            }
            else
            {
            	blocks.add(new FilledBlock(pf)); // 1 block ami tartalmaz entity-t
            }
        }
        
        for(int i=0; i<numberOfBlocks; i++){             //szomszédosság beállítása
        	if(i%4!=0){
        		blocks.get(i).setNeighbour(blocks.get(i-1),3,true);
        	}
        	if(i>4){
        		blocks.get(i).setNeighbour(blocks.get(i-4),0,true);
        	}		
        }

        Logger.reg(blocks.get(0), "block");
        Logger.reg(blocks.get(1), "neighbour");
        
        Wall wall = new Wall(pf, null);
        Door door = new Door(0, pf);
        Key  key = new Key(pf);           //3 entitás létrehozása
        
        blocks.get(0).addEntity(null,wall);
        blocks.get(0).addEntity(null,door);
        blocks.get(0).addEntity(null,key);   //entitások hozzáadása egy blokkhoz
        
        for(int i=0; i<numberOfBlocks; i++){
        	pf.addBlock(null,blocks.get(i));
        }
        
        Player player = new Player();
        
        blocks.get(0).setPlayer(player, null);    //player beállítása a blokkban
        //pf.setPlayer(player);                      //player beállítása a playfieldben
        player.enterBlock(blocks.get(0));
       
        Logger.ret("PlayFieldBuilder", "createPlayField()");
        return pf;
	}

}