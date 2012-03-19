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
        	
            Wall wall = new Wall(playField);
            Door door = new Door(0, playField);
            Key  key = new Key(playField);
            
            blocks.get(0).addEntity(null,wall);
            blocks.get(0).addEntity(null,door);
            blocks.get(0).addEntity(null,key);
        	
        		
        }
        
        /*ArrayList<Block> blocks = new ArrayList<Block>();
        
        PlayField playField = new PlayField();
        Block blockToBuildUp = new FilledBlock();
        
        Player player = new Player();
        Wall wall = new Wall(playField);
        Door door = new Door(0, playField);
        Key  key = new Key(playField);
        
        blockToBuildUp.addEntity(null, wall);
        blockToBuildUp.addEntity(null, key);
        blockToBuildUp.addEntity(null, wall);
        blockToBuildUp.addEntity(null, door);
        
        
        playField.addPlayer(null, player);
        player.enterBlock(blockToBuildUp);
        
        blocks.add(blockToBuildUp);
        
        for(int i =1; i<numberOfBlocks; i++)
        {
        	if(i<numberOfBlocks-1){
        		blocks.add(new FilledBlock());
        	}
        	else{
        		blocks.add(new EmptyBlock());
        	}
        }
        
        for(int i = 0; i < dimension; i++)
        {
            try
            {
                blocks.get(i).setNeighbour(blocks.get(i+1), 1, true);
                blocks.get(i).setNeighbour(blocks.get(i-1), 3, true);
                blocks.get(i).setNeighbour(blocks.get(i+4), 2, true);
                blocks.get(i).setNeighbour(blocks.get(i-4), 0, true);
            }
            catch(Exception e)
            {
            
            }
        }
        
        
        
        */
        /*for(int i = 0; i < numberOfBlocks; i++)
        {
           
            Block block;
            
            
            if(i == numberOfEmptyBlock)
            {
            	block = new EmptyBlock();
                block.addBlock(block);
            }
            else
            {
            	block=new FilledBlock();
            	blocks.addBlock(block);
            }
            
            playField.addBlock(new Position(), block);
        }
        
        
        for(i = 0; i < dimension; i++)
        {
            try
            {
                blocks.get(i).setNeighbour(blocks.get(i+1), 1, true);
                blocks.get(i).setNeighbour(blocks.get(i-1), 3, true);
                blocks.get(i).setNeighbour(blocks.get(i+4), 2, true);
                blocks.get(i).setNeighbour(blocks.get(i-4), 0, true);
            }
            catch(Exception e)
            {
            
            }
        }
        
        Player player = new Player();
        Wall wall = new Wall(playField);
        Door door = new Door(0, playField);
        Key  key = new Key(playField);
        
        blockToBuildUp.addEntity(null, wall);
        blockToBuildUp.addEntity(null, key);
        blockToBuildUp.addEntity(null, wall);
        blockToBuildUp.addEntity(null, door);
        

        playField.setPlayer(player,null);
        player.enterBlock(blockToBuildUp);

        
        Logger.ret("PlayFieldBuilder", "createPlayField()");
        return null;
	}

}