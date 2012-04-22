package fearlesscode.menu;

public class ExitGameMenuItem extends MenuItem
{
	public ExitGameMenuItem()
	{
		super("Exit");
	}
	public void activate()
	{
		System.exit(0);
	}
}