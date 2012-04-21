package fearlesscode.io;

public class BlockKeyConfiguration
{
	private int north;
	private int east;
	private int south;
	private int west;
	public BlockKeyConfiguration()
	{

	}
	public BlockKeyConfiguration(int n, int e, int s, int w)
	{
		north=n;
		east=e;
		south=s;
		west=w;
	}
	public int getNorth()
	{
		return north;
	}
	public int getEast()
	{
		return east;
	}
	public int getSouth()
	{
		return south;
	}
	public int getWest()
	{
		return west;
	}
}