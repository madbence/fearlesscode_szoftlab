package fearlesscode;

public class Proto
{

	public Proto()
	{

	}

	/**
	 * A program belépési pontja. Létrehoz egy Proto objektumot, amin végrehajtja a bemeneten érkező utasításokat.
	 * @param args A program parancssori paraméterei (nem használja a program).
	 */
	public static void main(String[] args)
	{
		System.out.println("En leszek a proto!");
	}

	/**
	 * Lépteti a modellt (1 egységgel)
	 */
	public void tick()
	{
		tick(1);
	}

	/**
	 * 
	 */
	public void tick(int n)
	{
		for(int i=0;i<n;i++)
		{
			game.getPlayField().tick();
		}
	}

	public void moveBlock(int id, int dir)
	{
		game.getPlayField().move(game.getPlayField().getBlock(id), dir);
	}

	public void toggleMode()
	{
		game.getPlayField().toggleMode();
	}

	public void movePlayer(int id, int x, int y)
	{
		game.getPlayField().getPlayer(id).move(new Speed(x, y));
	}

	public void getBlockInfo()
	{
		for(int i=0;i<game.getPlayField().getBlocks().size();i++)
		{
			getBlockInfo(i);
		}
	}

	/**
	 * 
	 */
	public void getBlockInfo(int n)
	{
		game.getPlayField().getBlock(n).
	}

	public void getEntityInfo()
	{

	}

	public void getEntityInfo(int n)
	{

	}

	public void getPlayerInfo()
	{

	}

	public void getPlayerInfo(int n)
	{

	}

	public void exit()
	{

	}

	public void loadMap(String file)
	{

	}

	public void include(String file)
	{

	}
}