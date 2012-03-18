package fearlesscode;

public class Key extends Entity {

	private boolean isObtained;

	public Key(PlayField playField){
		Logger.call(this,"Key.init()");
		super(playField);
		isObtained=false;
		Logger.ret(this,"Key.init()");
	}


    public void meetPlayer(Player player){
    	Logger.call(this,"Key.meetPlayer(player)");
    	if(!Logger.ask("Has the key already been obtained?"))
		{
			player.addKey();
			playField.setSpawnPosition(this);
			isObtained=true;
		}
    	Logger.ret(this,"Key.meetPlayer(player)");
	}

}