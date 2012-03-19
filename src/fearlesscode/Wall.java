package fearlesscode;

import fearlesscode.util.*;

public class Wall extends Entity
{
	public Wall(PlayField playField)
	{
		//Logger.call(this,"Wall.init()");
		super(playField);   //�soszt�ly be�ll�tja a playField referenci�t
		Logger.reg(this, "w");
		//Logger.ret(this,"Wall.init()");
	}
	public void meetPlayer(Player player){
    	Logger.call(this,"meetPlayer(player)");
		if(Logger.ask("Falkent viselkedik?")){
			player.move(null);        //j�t�kos mozgat�s�nak korrig�l�sa
		}
		else{
			player.move(null);          //j�t�kos mozgat�s�nak korrig�l�sa
		}
    	Logger.ret(this,"meetPlayer(player)");
	}
}