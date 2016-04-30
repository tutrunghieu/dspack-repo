package ds.zendy.sitemap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ds.util.access.ClassAccess;
import ds.zendy.metag.SiteNote;

public class SitemapLink extends SitemapItem
{
	private SitemapGroup outerGroup;

	public SitemapLink(Method mk, SitemapGroup g, int m) 
	{
		targetMethod = mk;
		targetClass = g.targetClass;
		outerGroup = g;
	}

	public String getActionUrl() 
	{
		String name = targetMethod.getName();
		name = name.substring(0, name.length()-6).toLowerCase();
		return outerGroup.metagActionUrl() + "/" + name;
	}

	
	public List<String> getSiteNotePurpose()
	{
		List<String> res = new ArrayList<String>();
		
		for(Annotation ak: ClassAccess.getAnnotations(targetMethod))
			res.add( ClassAccess.getString(ak, "Meaning", "") );
		
		return res;
	}


	public String getMinorNumber(int dv) 
	{
		SiteNote n = targetMethod.getAnnotation(SiteNote.class);
		if(n == null) return dv + "";
		
		return n.Number();
	}


	public List<String> getSiteNoteDone() { return this.getSiteNote___("Done"); }
	
	public List<String> getSiteNoteExamples() { return this.getSiteNote___("Example"); }
	
	private List<String> getSiteNote___(String name) 
	{
		List<String> res = new ArrayList<String>();

		for(Annotation ak: ClassAccess.getAnnotations(targetMethod))
			res.add( ClassAccess.getString(ak, name, "") );
		
		return res;		
	}
	

	public String getSequenceNumber() 
	{
		String s = this.outerGroup.getGroupNumber() + "";
		
		for(Annotation ak: ClassAccess.getAnnotations(targetMethod))
		{
			String nk =  ClassAccess.getString(ak, "Number", "");  
			if(!nk.isEmpty()) return s + "." + nk;
		}
		
		return s;
	}

	public List<Object> getSiteNoteConcepts()
	{
		List<Object> res = new ArrayList<Object>();
		
		for(Annotation ak: ClassAccess.getAnnotations(targetMethod))
		try 
		{ 
			Method mk = ak.getClass().getMethod("Concepts");
			Class<?>[] arr = (Class<?>[]) mk.invoke(ak);
			if(arr != null) for(Class<?> ck: arr) res.add(ck.getName());
		}
		catch(Exception xp) {}
		
		return res;
	}

	public Method getActionMethod() 
	{
		return targetMethod;
	}

	public Class<?> getActionClass() 
	{
		return targetClass;
	}

	
}
