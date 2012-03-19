package fearlesscode;

import fearlesscode.util.*;

public class Wall extends Entity
{
	public Wall(PlayField playField)
	{
		//Logger.call(this,"Wall.init()");
		super(playField);   //õsosztály beállítja a playField referenciát
		Logger.reg(this, "w");
		//Logger.ret(this,"Wall.init()");
	}
	public void meetPlayer(Player player){
    	Logger.call(this,"meetPlayer(player)");
		if(Logger.ask("Falkent viselkedik?")){
			player.move(null);        //játékos mozgatásának korrigálása
		}
		else{
			player.move(null);          //játékos mozgatásának korrigálása
		}
    	Logger.ret(this,"meetPlayer(player)");
	}
}