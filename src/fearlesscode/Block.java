package fearlesscode;

import java.util.ArrayList;
import java.util.List;
import fearlesscode.util.*;

public abstract class Block {

	protected List<EntityContainer> entities;
	protected Block[] neighbours;
	protected PlayerContainer player;
	protected PlayField playField;

	public Block(PlayField pf)
	{
        //Logger.call("Block","init()");
        entities = new ArrayList<EntityContainer>();
        neighbours = new Block[4];
        playField=pf;
        //Logger.ret("Block","init()");
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
        Logger.call(this,"getNeighbour(dir)");
        Logger.ret(this,"getNeighbour(dir)");
        return neighbours[dir];

	}
    
    public Block[] getNeighbours(){
        Logger.call(this,"getNeighbours()");
        Logger.ret(this, "getNeighbours()");
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
        Logger.call(this,"setNeighbour(neighbour,dir,"+(bool?"true":"false")+")");
        if(bool)
        {
            setNeighbour(neighbour,(dir+2)%4,false);     
        }
        neighbours[dir]=neighbour;
        Logger.ret(this,"setNeighbour(neighbour,dir,"+(bool?"true":"false")+")");

	}

	/**
	 * 
	 * @param neighbours
	 */
	public void setNeighbours(Block[] neighbours){
        Logger.call(this,"setNeighbours(neighbours)");
        //this.neighbours=neighbours;
        Logger.ret(this,"setNeighbours(neighbours)");
	}

	/**
	 * 
	 * @param player
	 * @param position
	 */
	public void setPlayer(Player player, EntityPosition position){
        Logger.call(this,"setPlayer(player,position)");
        Logger.ret(this,"setPlayer(player,position)");
        this.player = new PlayerContainer(player,position);



    }

}