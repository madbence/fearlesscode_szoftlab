package fearlesscode.io;

public class PlayFieldKeyConfiguration
{
	private int toggle;
	public PlayFieldKeyConfiguration()
	{

	}
	public PlayFieldKeyConfiguration(int t)
	{
		toggle=t;
	}
	public int getToggleMode()
	{
		return toggle;
	}
	public void setToggleMode(int key)
	{
		toggle=key;
	}
}