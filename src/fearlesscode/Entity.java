package fearlesscode;

public abstract class Entity
{
	protected PlayField playField;
	public Entity(PlayField playField)
	{
		//Logger.call(this,"Entity.create()");
		this.playField=playField;
		//Logger.ret(this,"Entity.create()");
	}
    public abstract void meetPlayer(Player p);
}
