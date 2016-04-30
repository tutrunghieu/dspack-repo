package ds.util.stream;

import java.util.List;
import java.util.function.Consumer;

public class Lamb {

	public static List<String> pref(String p, List<String> list)
	{
		for(int k=0; k<list.size(); k++)
		{
			String lk = list.get(k);
			list.set(k, p + lk);
		}
			
		return list;
	}
	
	public static List<String> surf(String p, List<String> list)
	{
		for(int k=0; k<list.size(); k++)
		{
			String lk = list.get(k);
			list.set(k, lk + p);
		}
			
		return list;
	}

	public static List<String> anchor(String clname, List<String> list) 
	{
		for(int k=0; k<list.size(); k++)
		{
			String lk = list.get(k);
			list.set(k, "<a "+clname+" href='"+lk+"'>"+lk+"</a>");
		}
			
		return list;
	}

	public static<T> T first(List<T> list, T dv) 
	{
		return (list.size()==0 ? dv : list.get(0) );
	}

	public static String shorter(List<String> list, String dv)
	{
		String ms = null;
		int ml = Integer.MAX_VALUE;
		for(String sk: list) 
		{
			int lk = sk.length();
			if(lk < ml) { ms = sk; ml = lk; }
		}
		return ms==null ? dv : ms;
	}

	public static void loop(int n, Consumer<Integer> c)
	{
		for(int k=0; k<n; k++) c.accept(k);
	}

	public static String get(String[] cells, int k, String dv)
	{
		return (k < cells.length ? cells[k] : dv);
	}

}
