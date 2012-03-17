package fearlesscode;

public class FilledBlock extends Block {

	public FilledBlock(){
        super();
        Logger.call(this,"FilledBlock.init()");
        Logger.call(this,"FilledBlock.init()");

	}


	public void checkBorders(){
        Logger.call(this,"FilledBlock.checkBorders()");
        boolean isAtBlockSide=false;
        boolean isPossibleToGetTrough=false;
        boolean doesFallOut=false;
        boolean isOutOfTheBlock=false;
        Block neighbour;
        EntityPosition pos;

        if(isAtBlockSide){
           if(isPossibleToGetTrough){
                player.player.enterBlock(neighbour);
                neighbour.setPlayer(player.player,pos);
           }
           else if(doesFallOut){
               //????????vissza kéne hogy hivjon a PlayField-re de nincs rá ref??????

           }
        }
        else if(isOutOfTheBlock){
           player.player.leaveBlock(this);
        }
        Logger.call(this,"FilledBlock.checkBorders()");

	}

	public void processCollisions(){
        Logger.call(this,"FilledBlock.processCollisions()");

        for(EntityContainer e : entities){
            boolean collision=false;
            if(collision)
            {
                e.entity.meetPlayer(player.player);
            }
        }
        Logger.ret(this,"FilledBlock.processCollisions()");
	}

}