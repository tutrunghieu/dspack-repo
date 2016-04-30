package ds.zendy.sitemap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ds.zendy.metag.MkDone;
import ds.zendy.metag.SiteNote;

public class SitemapGroup extends SitemapItem
{
	private List<SitemapLink> targetItems = new ArrayList<SitemapLink>();
	private int groupNumber;
	
	public int getGroupNumber()
	{
		return groupNumber;
	}
	
	public SitemapGroup()
	{
		
	}
	
	public SitemapGroup(Class<?> cl, int num)
	{
		targetClass = cl;
		groupNumber = num;
		
		for(Method mk: cl.getMethods())
		if( selectedMethod(mk) ) {
			targetItems.add(new SitemapLink(mk, this, targetItems.size()+1) );
		}
	}

	protected boolean selectedMethod(Method mk) 
	{
		if(! Modifier.isPublic(  mk.getModifiers() ) ) return false;
		if(! mk.getName().endsWith("Action") ) return false;
		return true;
	}

	public List<SitemapLink> getActionItems()
	{
		return targetItems;
	}
	
	public List<SitemapLink> getActionItemsSorted()
	{
		return targetItems.stream()
				.sorted(new SitemapLinkByNumber())
				.collect(Collectors.toList());
	}

	public String metagActionUrl() 
	{
		String name = getSiteNoteRename();
		if(! name.isEmpty() ) return name;
		
		name = targetClass.getSimpleName();
		name = name.substring(0, name.length()-10).toLowerCase();
		return name;
	}

	private String getSiteNoteRename() 
	{
		SiteNote n = targetClass.getAnnotation(SiteNote.class);
		return n==null ? "" : n.Rename();
	}

	public Object getSiteNoteSlogan() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> metagImageUrlArray()
	{
		List<String> res = new ArrayList<String>();
		
		Annotation[] arr = this.targetClass.getAnnotations();
		for(Annotation ak: arr)
		try
		{
			Method mk = ak.getClass().getMethod("ImageUrl");
			res.add( mk.invoke(ak).toString() );					
		}
		catch(Exception xp) {}
		
		return res;		
	}

	public String metagDone() 
	{
		MkDone a = this.targetClass.getAnnotation(MkDone.class);
		if(a != null) return a.value();
		
		return "";
	}


}
