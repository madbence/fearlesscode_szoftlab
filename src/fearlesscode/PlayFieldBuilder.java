package fearlesscode;

import java.util.ArrayList;

public class PlayFieldBuilder {

	public PlayFieldBuilder(){
	}


	public static PlayField createPlayField(){
            Logger.reg(this, "createPlayField()");
            
            int numberOfBlocks = 16;
            int numberOfEmptyBlock = 0;
            int numberOfBlockToBuildUp = 1;
            int dimension = 4;
            
            ArrayList<Block> blocks = new ArrayList<Block>;
            
            PlayField playField = new PlayField();
            Block blockToBuildUp;
            
            for(int i = 0; i < numberOfBlocks; i++){
                Block block;
                blocks.add(block);
                
                if(i == numberOfEmptyBlock){
                    block = new EmptyBlock();
                } else {
                    block = new Block();
                }
                
                if(i == numberOfBlockToBuildUp){
                    blockToBuildUp = block;
                }
               
                playField.addBlock(new Position(), eBlock);
            }
            
            for(i = 0; i < dimension; i++){
                try{
                    blocks.get(i).setNeighbour(blocks.get(i+1), 1, true);
                    blocks.get(i).setNeighbour(blocks.get(i-1), 3, true);
                    blocks.get(i).setNeighbour(blocks.get(i+4), 2, true);
                    blocks.get(i).setNeighbour(blocks.get(i-4), 0, true);
                } catch {
                
                }
            }
            
            Player player = new Player();
            Wall wall = new Wall();
            Door door = new Door();
            Key  = new Key();
            
            blockToBuildUp.addEntity(new EntityPosition, wall);
            blockToBuildUp.addEntity(new EntityPosition, key);
            blockToBuildUp.addEntity(new EntityPosition, wall);
            blockToBuildUp.addEntity(new EntityPosition, door);
            
            playerField.addPlayer(new EntityPosition, player);
            player.enterBlock(blockToBuildUp);
            
            Logger.reg(this, "createPlayField()");
            return null;
	}

}