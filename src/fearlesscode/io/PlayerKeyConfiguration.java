package fearlesscode.io;

public class PlayerKeyConfiguration
{
	private int left;
	private int right;
	private int jump;
	public PlayerKeyConfiguration()
	{

	}
	public PlayerKeyConfiguration(int l, int r, int j)
	{
		left=l;
		right=r;
		jump=j;
	}
	public int getLeft()
	{
		return left;
	}
	public int getRight()
	{
		return right;
	}
	public int getJump()
	{
		return jump;
	}
	public void setLeft(int key)
	{
		left=key;
	}
	public void setRight(int key)
	{
		right=key;
	}
	public void setJump(int key)
	{
		jump=key;
	}
}