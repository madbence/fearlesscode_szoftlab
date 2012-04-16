package fearlesscode;

import fearlesscode.util.*;

public class BlockMatcher
{
	private Block block1;
	private Block block2;
	private int dir;

	private double width;
	private double height;

	public BlockMatcher(Block b1, Block b2, int d)
	{
		block1=b1;
		block2=b2;
		dir=d;
	}

	public boolean matches()
	{
		switch(dir)
		{
			case 0: return matchesNorth();
			case 1: return matchesEast();
			case 2: return matchesSouth();
			default: return matchesWest();
		}
	}

	private boolean matchesNorth()
	{
		for(EntityContainer container:block1.getEntities())
		{
			try
			{
				if(container.getPosition().getY()<0)
				{
					container.getEntity().accept(this);
					double width1=width;
					boolean pairFound=false;
					for(EntityContainer pair:block2.getEntities())
					{
						pair.getEntity().accept(this);
						if(pair.getPosition().getY()+height>Block.HEIGHT)
						{
							if( Math.abs(container.getPosition().getX()-pair.getPosition().getX())<0.001 &&
								Math.abs(container.getPosition().getX()+width1-pair.getPosition().getX()-width)<0.001)
							{
								pairFound=true;
								break;
							}
						}
					}
					if(!pairFound)
					{
						return false;
					}
				}
			}
			catch(Exception e)
			{

			}
		}
		return true;
	}

	private boolean matchesEast()
	{
		for(EntityContainer container:block1.getEntities())
		{
			try
			{
				//Logger.debug("---matchesEast---");
				//Logger.debug(container.getEntity().getName());
				container.getEntity().accept(this);
				double height1=height;
				//Logger.debug("height: "+height);
				//Logger.debug("container.getPosition().getX()+width>Block.WIDTH:");
				//Logger.debug("  "+container.getPosition().getX()+"+"+width+">"+Block.WIDTH);
				//Logger.debug("  "+(container.getPosition().getX()+width>Block.WIDTH));
				if(container.getPosition().getX()+width>Block.WIDTH)
				{
					boolean pairFound=false;
					for(EntityContainer pair:block2.getEntities())
					{
						//Logger.debug("--pair--");
						//Logger.debug(pair.getEntity().getName());
						pair.getEntity().accept(this);
						if(pair.getPosition().getX()<0)
						{
							//Logger.debug("if:");
							//Logger.debug("  "+(Math.abs(container.getPosition().getY()-pair.getPosition().getY())<0.001));
							//Logger.debug("  "+(Math.abs(container.getPosition().getY()+height1-pair.getPosition().getY()-height)<0.001));
							//Logger.debug("    Y:"+container.getPosition().getY());
							//Logger.debug("    pY:"+pair.getPosition().getY());
							if( Math.abs(container.getPosition().getY()-pair.getPosition().getY())<0.001 &&
								Math.abs(container.getPosition().getY()+height1-pair.getPosition().getY()-height)<0.001)
							{
								pairFound=true;
								break;
							}
						}
					}
					if(!pairFound)
					{
						//Logger.debug("pairnotfound");
						return false;
					}
				}
				//Logger.debug("---!matchesEast---");
			}
			catch(Exception e)
			{
				//Ha nem fal, semmi gond.
			}
		}
		return true;
	}

	private boolean matchesSouth()
	{
		for(EntityContainer container:block1.getEntities())
		{
			try
			{
				container.getEntity().accept(this);
				double width1=width;
				if(container.getPosition().getY()+height>Block.HEIGHT)
				{
					boolean pairFound=false;
					for(EntityContainer pair:block2.getEntities())
					{
						pair.getEntity().accept(this);
						if(pair.getPosition().getY()<0)
						{
							if( Math.abs(container.getPosition().getX()-pair.getPosition().getX())<0.001 &&
								Math.abs(container.getPosition().getX()+width1-pair.getPosition().getX()-width)<0.001)
							{
								pairFound=true;
								break;
							}
						}
					}
					if(!pairFound)
					{
						return false;
					}
				}
			}
			catch(Exception e)
			{
				
			}
		}
		return true;
	}

	private boolean matchesWest()
	{
		for(EntityContainer container:block1.getEntities())
		{
			try
			{
				container.getEntity().accept(this);
				double height1=height;
				if(container.getPosition().getX()<0)
				{
					boolean pairFound=false;
					for(EntityContainer pair:block2.getEntities())
					{
						pair.getEntity().accept(this);
						if(pair.getPosition().getX()+width>Block.WIDTH)
						{
							if( Math.abs(container.getPosition().getY()-pair.getPosition().getY())<0.001 &&
								Math.abs(container.getPosition().getY()+height1-pair.getPosition().getY()-height)<0.001)
							{
								pairFound=true;
								break;
							}
						}
					}
					if(!pairFound)
					{
						return false;
					}
				}
			}
			catch(Exception e)
			{
				
			}
		}
		return true;
	}

	public void setWidth(double w)
	{
		width=w;
	}

	public void setHeight(double h)
	{
		height=h;
	}
}