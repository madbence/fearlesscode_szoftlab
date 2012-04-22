package fearlesscode.controller;

import fearlesscode.model.core.*;

public class PlayFieldController
{
	private PlayField playField;
	public PlayFieldController(PlayField pf)
	{
		playField=pf;
	}
	public void toggleMode()
	{
		playField.toggleMode();
	}
}