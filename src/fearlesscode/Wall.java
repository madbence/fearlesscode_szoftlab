package fearlesscode;

import fearlesscode.util.*;

public class Wall extends Entity
{
	public Wall(PlayField playField)
	{
		//Logger.call(this,"Wall.init()");
		super(playField);		       
		//Logger.ret(this,"Wall.init()");
	}
	public void meetPlayer(Player player){
    	Logger.call(this,"Wall.meetPlayer(player)");
		if(Logger.ask(this,"Oldalr�l �tk�z�tt falnak?"){
		player.move(Direction dir);
		}
		else{
		player.move(Direction dir);
		}
    	Logger.ret(this,"Wall.meetPlayer(player)");
	}
}