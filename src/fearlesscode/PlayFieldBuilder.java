package fearlesscode;

import java.util.ArrayList;

import com.sun.tools.internal.ws.processor.model.Block;

import fearlesscode.util.*;

public class PlayFieldBuilder
{
	public static PlayField createPlayField(Game game)
    {
        Logger.call("PlayFieldBuilder", "createPlayField()");
        
        int numberOfBlocks = 16;
        int numberOfEmptyBlock = 0;
        int numberOfBlockToBuildUp = 1;
        int dimension = 4;
        
        PlayField pf = new PlayField(game);
        ArrayList<Block> blocks = new ArrayList<Block>();
        
        for(int i = 0; i < numberOfBlocks; i++)
        {
            if(i == numberOfEmptyBlock)
            {
                block.addBlock(new EmptyBlock(pf));
            }
            else
            {
            	blocks.addBlock(new FilledBlock(pf));
            }
        }
        
        for(int i=0; i<numberOfBlocks; i++){
        	if(i%4!=0){
        		blocks.get(i).setNeighbour(blocks.get(i-1),3,true);
        	}
        	if(i>4){
        		blocks.get(i).setNeighbour(blocks.get(i-4),0,true);
        	}		
        }
        
        Wall wall = new Wall(playField);
        Door door = new Door(0, playField);
        Key  key = new Key(playField);
        
        blocks.get(0).addEntity(null,wall);
        blocks.get(0).addEntity(null,door);
        blocks.get(0).addEntity(null,key);
        
        for(int i=0; i<numberOfBlocks; i++){
        	pf.addBlock(null,blocks.get(i));
        }
        
        Player player = new Player();
        
        blocks.get(0).setPlayer(player);
        pf.setPlayer(player);
        player.enterBlock(blocks.get(0));
       
        Logger.ret("PlayFieldBuilder", "createPlayField()");
        return pf;
	}

}