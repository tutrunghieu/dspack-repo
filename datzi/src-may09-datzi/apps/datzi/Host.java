package apps.datzi;

public class Host extends Player
{

	public Host() 
	{
		super(0);
	}

	public Object getName() 
	{
		return "host";
	}

	public boolean qualifiedForNextMove()
	{
		return true;
	}
}
