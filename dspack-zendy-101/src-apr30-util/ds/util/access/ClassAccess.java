package ds.util.access;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassAccess {

	public static List<Annotation> getAnnotations(Method m) 
	{
		List<Annotation> res = new ArrayList<Annotation>();
		
		Annotation[] a = m.getAnnotations();
		if(a == null) return res;
		
		for(Annotation ak: a) res.add(ak);
		return res;
	}

	public static List<Annotation> getAnnotations(Class<?> m) 
	{
		List<Annotation> res = new ArrayList<Annotation>();
		
		Annotation[] a = m.getAnnotations();
		if(a == null) return res;
		
		for(Annotation ak: a) res.add(ak);
		return res;
	}

	public static Object get(Annotation ak, String name, Object dv) 
	{
		try 
		{ 
			Method mk = ak.getClass().getMethod(name);
			return mk.invoke(ak);
		}

		catch(Exception xp) { return dv; }
	}

	public static String getString(Annotation ak, String name, String dv) 
	{
		try 
		{ 
			Method mk = ak.getClass().getMethod(name);
			return mk.invoke(ak).toString();
		}

		catch(Exception xp) { return dv; }		
	}

	public static Double getDouble(Annotation ak, String name, double dv) 
	{
		try 
		{ 
			Method mk = ak.getClass().getMethod(name);
			return (Double)mk.invoke(ak);
		}

		catch(Exception xp) { return dv; }		
	}

}
