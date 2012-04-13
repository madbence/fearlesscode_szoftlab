package fearlesscode;


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
		return true;
	}

	private boolean matchesEast()
	{
		for(EntityContainer container:block1.getEntities())
		{
			container.getEntity().accept(this);
			double height1=height;
			if(container.getPosition().getX()+width>Block.WIDTH)
			{
				boolean pairFound=false;
				for(EntityContainer pair:block2.getEntities())
				{
					pair.getEntity().accept(this);
					if(pair.getPosition().getX()<0)
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
		return true;
	}

	private boolean matchesSouth()
	{
		for(EntityContainer container:block1.getEntities())
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
		return true;
	}

	private boolean matchesWest()
	{
		for(EntityContainer container:block1.getEntities())
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