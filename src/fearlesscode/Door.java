package fearlesscode;

public class Door extends Entity
{
	private int requiredKeys;
	
	public Door(int requiredKeys, PlayField playField)
	{
		super(playField);
		Logger.call(this,"Door.init()");       
		this.requiredKeys=requiredKeys;
		Logger.ret(this,"Door.init()");
	}
	public void meetPlayer(Player player)
	{
		Logger.call(this,"Door.meetPlayer(player)");
		player.getObtainedKeys();
		if(Logger.ask("Is the door open?"))
		{
			playField.win();
		}
		
		Logger.ret(this,"Door.meetPlayer(player)");
	}
}

}