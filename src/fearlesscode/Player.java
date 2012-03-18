package fearlesscode;

import fearlesscode.util.*;

public class Player {

	private int obtainedKeys;
	private int speed;
	private Block activeBlocks;

	public Player(){
            Logger.reg(this, "addKey()");
	}


	public void addKey(){
            Logger.call(this, "addKey()");
            
            Logger.ret(this, "addKey()");
	}

	/**
	 * 
	 * @param block
	 */
	public void enterBlock(Block block){
            Logger.call(this, "enterBlock(Block)");
            
            Logger.ret(this, "addKey(Block)");
	
	}

	public void getActiveBlocks(){
            Logger.call(this, "getActiveBlocks()");
            
            Logger.ret(this, "getActiveBlocks()");
	
	}

	public int getObtainedKeys(){
            Logger.call(this, "getObtainedKeys()");
            
            Logger.ret(this, "getObtainedKeys()");
            return 0;
	}

	/**
	 * 
	 * @param block
	 */
	public void leaveBlock(Block block){
            Logger.call(this, "leaveBlock(Block)");
            
            Logger.ret(this, "leaveBlock(Block)");
	}

	/**
	 * 
	 * @param dir
	 */
	public void move(Direction dir){
            Logger.call(this, "move(Direction)");
            
            Logger.ret(this, "move(Direction)");
	}

}