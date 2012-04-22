package fearlesscode.gui;

import fearlesscode.model.core.*;
import java.awt.*;

public class GameFrame extends Frame
{
	private PlayFieldDrawer drawer;
	public GameFrame(Game game)
	{
		super();
		this.drawer=new PlayFieldDrawer(game.getPlayField());
	}
	public void paint(Graphics g)
	{
		drawer.draw((Graphics2D)g);
	}
	public void update(Graphics g)
	{
		Graphics offgc;
		Image offscreen = null;
		java.awt.Rectangle box = g.getClipRect();

		// buffer
		offscreen = createImage(box.width, box.height);
		offgc = offscreen.getGraphics();
		// buffer törlés
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, box.width, box.height);
		offgc.setColor(getForeground());
		// rajzolás a bufferra
		offgc.translate(-box.x, -box.y);
		paint(offgc);
		// átmásoljuk a buffert a képernyőre
		g.drawImage(offscreen, box.x, box.y, this);
	}
}