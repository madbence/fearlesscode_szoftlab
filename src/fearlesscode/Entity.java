package fearlesscode;

public abstract class Entity {
	
	protected PlayField playField;
	
	public Entity(PlayField playField)
	{
		Logger.call(this,"Entity.init()");
		this.playField=playField;
		Logger.ret(this,"Entity.init()");
	}
	
    public abstract void meetPlayer(Player p);
	

}


}