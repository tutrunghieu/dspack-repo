package ds.zendy.sitemap;

import java.lang.reflect.Method;

public class SitemapItem 
{
	protected Class<?> targetClass;
	protected Method targetMethod;
	
	public String metagActionClassName() 
	{
		return targetClass.getSimpleName();
	}

//	public Object metagActionObject() throws Exception
//	{
//		return targetClass.newInstance();	
//	}
//	
//	public String metagActionMethod() 
//	{
//		return targetMethod.getName();
//	}
}
