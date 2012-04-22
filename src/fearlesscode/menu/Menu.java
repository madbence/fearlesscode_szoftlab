package fearlesscode.menu;

import fearlesscode.gui.*;

public class Menu
{
	private ArrayList<MenuItem> items;
	private int selectedIndex;
	public Menu()
	{
		items=new ArrayList<MenuItem>();
		selectedIndex=-1;
	}
	public void addItem(MenuItem item)
	{
		items.add(item);
	}
	public void removeItem(Menuitem item)
	{
		items.remove(item);
	}
	public void clear()
	{
		items.clear();
	}
	public ArrayList<MenuItem> getItems()
	{
		return items;
	}
	public void activate()
	{
		if(selectedIndex<0)
		{
			return;
		}
		items.get(selectedIndex).activate();
	}
	public void setActive(int n)
	{
		if(n<0 || n>items.size())
		{
			return;
		}
		items.get(selectedIndex).setActive(false);
		items.get(n).setActive(true);
		selectedIndex=n;
	}
	public int getSelectedIntex()
	{
		return selectedIndex;
	}
}