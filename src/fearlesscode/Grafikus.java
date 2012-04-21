package fearlesscode;

import fearlesscode.gui.*;
import fearlesscode.util.*;
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
	public Block b;
	public boolean bm=true;
	public static int rem=0;
	public void paint(Graphics g)
	{
		pfd.draw((Graphics2D)g);
	}
	public void update(Graphics g)
	{
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
			frame.pf=PlayFieldBuilder.createPlayField(g, "maps/default.json");
			frame.pfd=new PlayFieldDrawer(frame.pf);
			frame.b=frame.pf.getBlocks().get(1).getBlock();
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
					frame.dir=0;
				}
				else if(e.getKeyChar() == 's')
				{
					frame.dir=2;
				}
				else if(e.getKeyChar() == ' ')
				{
					frame.bm=!frame.bm;
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
		frame.setUndecorated(true);
		frame.setVisible(true);
		Timer t=new Timer();
		t.schedule(new TimerTask()
		{
			public void run()
			{
				//System.out.println("run");
				//frame.repaint();
				if(frame.bm)
				{
					if(Grafikus.rem > 0)
					{
						Grafikus.rem--;
						Logger.enable();
					}
					else
					{
						Logger.disable();
					}
					if(frame.dir == 1)
					{
						Speed s=frame.pf.getPlayers().get(0).getPlayer().getSpeed();
						frame.pf.getPlayers().get(0).getPlayer().move(new Speed(2-s.getX(), 0));
					}
					else if(frame.dir == 3)
					{
						Speed s=frame.pf.getPlayers().get(0).getPlayer().getSpeed();
						frame.pf.getPlayers().get(0).getPlayer().move(new Speed(-2-s.getX(), 0));
					}
					if(frame.jump)
					{
						frame.jump=false;
						frame.pf.getPlayers().get(0).getPlayer().move(new Speed(0, -6));
					}
					frame.pf.tick();
				}
				else
				{
					if(frame.dir != -1)
					{
						System.out.println(frame.b.getName());
						frame.pf.move(frame.b, (frame.dir+2)%4);
						frame.dir=-1;
					}
				}
				frame.repaint();
			}
		}, 1000, (long)(1000/30));
	}
}