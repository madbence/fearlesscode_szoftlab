package fearlesscode;

import fearlesscode.gui.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class Grafikus extends Frame
{
	public PlayFieldDrawer pfd;
	public PlayField pf;
	public int dir=-1;
	public boolean jump;
	public void paint(Graphics g)
	{
		pfd.draw((Graphics2D)g);
	}
	public void update(Graphics g)
	{
		System.out.println("update");
		Graphics offgc;
		Image offscreen = null;
		java.awt.Rectangle box = g.getClipRect();

		// create the offscreen buffer and associated Graphics
		offscreen = createImage(box.width, box.height);
		offgc = offscreen.getGraphics();
		// clear the exposed area
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, box.width, box.height);
		offgc.setColor(getForeground());
		// do normal redraw
		offgc.translate(-box.x, -box.y);
		paint(offgc);
		// transfer offscreen to window
		g.drawImage(offscreen, box.x, box.y, this);
    }

	public static void main(String args[])
	{
		final Grafikus frame = new Grafikus();
		Game g=new Game();
		try
		{
			frame.pf=PlayFieldBuilder.createPlayField(g, "maps/szilard.json");
			frame.pfd=new PlayFieldDrawer(frame.pf);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		frame.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyChar() == 'd')
				{
					frame.dir=1;
				}
				else if(e.getKeyChar() == 'a')
				{
					frame.dir=3;
				}
				else if(e.getKeyChar() == 'w')
				{
					frame.jump=true;
				}
			}
			public void keyReleased(KeyEvent e)
			{
				if(e.getKeyChar() == 'd')
				{
					frame.dir=-1;
				}
				else if(e.getKeyChar() == 'a')
				{
					frame.dir=-1;
				}
			}
		});
		frame.setSize(400, 300);
		frame.setVisible(true);
		Timer t=new Timer();
		t.schedule(new TimerTask()
		{
			public void run()
			{
				//System.out.println("run");
				//frame.repaint();
				if(frame.dir == 1)
				{
					frame.pf.getPlayers().get(0).getPlayer().move(new Speed(0.1, 0));
				}
				else if(frame.dir == 3)
				{
					frame.pf.getPlayers().get(0).getPlayer().move(new Speed(-0.1, 0));
				}
				if(frame.jump)
				{
					frame.jump=false;
					frame.pf.getPlayers().get(0).getPlayer().move(new Speed(0, -10));
				}
				frame.pf.tick();
				frame.repaint();
			}
		}, 1000, (long)(1000/30));
	}
}