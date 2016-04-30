package ds.util.access;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Sampler<T> 
{
	private Class<T> innerClass;
	private Method innerMethod;
	
	public Class<T> getInnerClass()
	{
		return innerClass;
	}

	public static<T1> Sampler<T1> start(Class<T1> cl) 
	{
		Sampler<T1> res = new Sampler<T1>();
		res.innerClass = cl;
		
		try { res.innerMethod = cl.getMethod("sample"); }
		catch(Exception xp) { System.out.println("Method not found" + cl.getName()); }
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> sample(int n) 
	{
		List<T> res = new ArrayList<T> ();
		
		for(int k=0; k<n; k++)
		try { res.add( (T) innerMethod.invoke(null) ); }
		catch(Exception xp) { }
		
		return res;
	}

}
