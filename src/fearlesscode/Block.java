package fearlesscode;

import java.util.ArrayList;
import java.util.List;
import fearlesscode.util.*;

public abstract class Block {

	protected List<EntityContainer> entities;
	protected Block[] neighbours;
	protected PlayerContainer player;

	public void Block(){
        Logger.call(this,"Block.init()");
        entities = new ArrayList<EntityContainer>();
        neighbours = new Block[4];
        Logger.ret(this,"Block.init()");
	}

	/**
	 * 
	 * @param position
	 * @param entity
	 */
	public void addEntity(EntityPosition position, Entity entity){
        Logger.call(this,"addEntity(position,entitiy)");
        Logger.ret(this,"addEntity(position,entity)");
        entities.add(new EntityContainer(entity,position));

	}

	public abstract void checkBorders();

	/**
	 *
     * @param dir
     */
	public Block getNeighbour(int dir){
        Logger.call(this,"Block.getNeighbour(dir)");
        Logger.ret(this,"Block.getNeighbour(dir)");
        return neighbours[dir];

	}
    
    public Block[] getNeighbours(){
        Logger.call(this,"Block.getNeighbours()");
        Logger.ret(this, "Block.getNeighbours()");
        return neighbours;
    }

	public abstract void processCollisions();

	/**
	 * 
	 * @param neighbour
	 * @param dir
	 * @param bool
	 */
	public void setNeighbour(Block neighbour, int dir, boolean bool){
        Logger.call(this,"Block.setNeighbour(neighbour,dir,bool)");
        if(bool){
              neighbours[dir]=neighbour;
        }
        else{
            //??? beállitja a szomszédságot???
            setNeighbour(neighbour,(dir+2)%4,false);
        }
        Logger.ret(this,"Block.setNeighbour(neighbour,dir,bool)");

	}

	/**
	 * 
	 * @param neighbours
	 */
	public void setNeighbours(Block[] neighbours){
        Logger.call(this,"Block.setNeighbours(neighbours)");
        this.neighbours=neighbours;
        Logger.ret(this,"Block.setNeighbours(neighbours)");
	}

	/**
	 * 
	 * @param player
	 * @param position
	 */
	public void setPlayer(Player player, EntityPosition position){
        Logger.call(this,"Block.setPlayer(player,position)");
        Logger.ret(this,"Block.setPlayer(player,position)");
        this.player = new PlayerContainer(player,position);



    }

}