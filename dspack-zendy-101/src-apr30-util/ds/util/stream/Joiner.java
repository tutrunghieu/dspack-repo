package ds.util.stream;

import java.util.List;
import java.util.Set;

public class Joiner 
{
	protected String comma;
	
	public static Joiner start()
	{
		return new Joiner();
	}
	
	public static Joiner start(String cm)
	{
		Joiner res = new Joiner();
		res.comma = cm;
		return res;
	}
	
	public String joinObjects(Object... args)
	{
		String res = "";
		
		for(int k=0; k<args.length; k++)
		{
			if(k > 0) res += comma;
			res += args[k];
		}
		
		return res;
	}

	public String join(List<?> args)
	{
		String res = "";
		
		for(int k=0; k<args.size(); k++)
		{
			if(k > 0) res += comma;
			res += args.get(k);
		}
		
		return res;
	}

	public String join(Set<?> args)
	{
		String res = "";
		
		int k = 0;
		for(Object ak: args)
		{
			if(k++ > 0) res += comma;
			res += ak;
		}
		
		return res;
	}
}
