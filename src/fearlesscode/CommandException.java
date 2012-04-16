package fearlesscode;

/**
 * Hibás parancs esetén ilyen kivétel keletkezik
 */
public class CommandException extends Exception
{
	/**
	 * Létrehoz egy kivételt a megadott hibaüzenettel.
	 */
	public CommandException(String message)
	{
		super(message);
	}
}