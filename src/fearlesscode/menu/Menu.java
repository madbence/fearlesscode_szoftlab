package fearlesscode.menu;

import fearlesscode.gui.*;
import java.util.*;


/**
 * Egy menüt reprezentáló osztály. Menüpontok tárolása és aktiválása/deaktiválása a feladata.
 */
public class Menu
{
	/**
	 * A menüben található menüpontok listája.
	 */
	private ArrayList<MenuItem> items;

	/**
	 * A kiválasztott menüpont indexe.
	 */
	private int selectedIndex;

	/**
	 * A menü konstruktora.
	 */
	public Menu()
	{
		items=new ArrayList<MenuItem>();
		selectedIndex=-1;
	}

	/**
	 * Hozzáad egy menüpontot a menühöz.
	 * @param item Az új menüpont.
	 */
	public void addItem(MenuItem item)
	{
		items.add(item);
	}

	/**
	 * Töröl egy menüpontot.
	 * @param item A törlendő menüpont.
	 */	
	public void removeItem(MenuItem item)
	{
		items.remove(item);
	}

	/**
	 * Törli az összes tárolt menüpontot.
	 */
	public void clear()
	{
		items.clear();
	}

	/**
	 * Visszaadja a menüben tárolt menüpontokat.
	 * @return A tárolt menüpontok.
	 */
	public ArrayList<MenuItem> getItems()
	{
		return items;
	}

	/**
	 * Aktiválja a kiválasztott menüpontot. Ha nincs kiválasztva semmi, nem történik semmi.
	 */
	public void activate()
	{
		if(selectedIndex<0)
		{
			return;
		}
		items.get(selectedIndex).activate();
	}

	/**
	 * Aktívra állítja a megadott indexű menüpontot, és inaktívvá teszi a többit.
	 * @param n Az aktiválandó menüpont indexe.
	 */
	public void setActive(int n)
	{
		if(n<0 || n>items.size())
		{
			return;
		}
		if(selectedIndex!=-1)
		{
			items.get(selectedIndex).setActive(false);
		}
		items.get(n).setActive(true);
		selectedIndex=n;
	}

	/**
	 * Visszaadja a kiválasztott menüpont indexét.
	 * @return A kiválasztott menüpont indexe.
	 */
	public int getSelectedIndex()
	{
		return selectedIndex;
	}
}