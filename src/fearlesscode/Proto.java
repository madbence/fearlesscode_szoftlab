package fearlesscode;

/**
 * A prototípus fő osztálya, kezeli a bemeneteket, és végrehajtja az azon érkező parancsokat.
 */
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
	 * Lépteti a modellt a megadott számú lépéssel.
	 * @param n A lépések száma.
	 */
	public void tick(int n)
	{
		for(int i=0;i<n;i++)
		{
			game.getPlayField().tick();
		}
	}

	/**
	 * Elmozdít egy blokkot.
	 * @param id A blokk azonosítója.
	 * @param dir A mozgatás iránya.
	 */
	public void moveBlock(int id, int dir)
	{
		game.getPlayField().move(game.getPlayField().getBlock(id), dir);
	}

	/**
	 * Megváltoztatja a PlayField játék-állapotát (játék és blokk mód között vált)
	 */
	public void toggleMode()
	{
		game.getPlayField().toggleMode();
	}

	/**
	 * Módosítja egy játékos sebességvektorát.
	 * @param id A játékos azonosítója.
	 * @param x A mozgatás vízszintes irányú komponense.
	 * @param y A mozgatás függőleges irányú komponense.
	 */
	public void movePlayer(int id, int x, int y)
	{
		game.getPlayField().getPlayer(id).move(new Speed(x, y));
	}

	/**
	 * Kiírja a játékban található összes blokk adatait.
	 */
	public void getBlockInfo()
	{
		for(int i=0;i<game.getPlayField().getBlocks().size();i++)
		{
			getBlockInfo(i);
		}
	}

	/**
	 * Kiírja egy blokk adatait.
	 * @param n A blokk azonosítója.
	 */
	public void getBlockInfo(int n)
	{
		game.getPlayField().getBlock(n);
	}

	/**
	 * Kiírja a játékban található összes entitás adatait.
	 */
	public void getEntityInfo()
	{

	}

	/**
	 * Kiírja egy entitás adatait.
	 * @param n Az entitás azonosítója.
	 */
	public void getEntityInfo(int n)
	{

	}

	/**
	 * Kiírja a játékban található összes játékos adatait.
	 */
	public void getPlayerInfo()
	{

	}

	/**
	 * Kiírja egy játékos adatait.
	 * @param n A játékos azonosítója.
	 */
	public void getPlayerInfo(int n)
	{

	}

	/**
	 * Kilép a protóból.
	 */
	public void exit()
	{

	}

	/**
	 * Betölt egy új pályát.
	 * @param file A betöltendő fájl neve.
	 */
	public void loadMap(String file)
	{

	}

	/**
	 * A parancs helyére behelyettesíti egy fájl tartalmát.
	 * @param file A beillesztendő fájl neve.
	 */
	public void include(String file)
	{

	}
}