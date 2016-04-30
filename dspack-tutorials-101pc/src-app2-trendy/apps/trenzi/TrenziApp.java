package apps.trenzi;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apps.trenzi.controllers.Page01Controller;
import ds.util.render.JsonWriter;
import ds.util.stream.Lamb;
import ds.zendy.sitemap.SitemapDB;
import ds.zendy.sitemap.SitemapLink;

public class TrenziApp 
{
	public static void process(HttpServletRequest request, HttpServletResponse response, String conf) 
	{
		PrintWriter out = null;
		
		try { out = response.getWriter(); }
		catch(Exception xp) {}
		
		try { processInner(request, response, conf); }
		catch(Exception xp) { out.println(xp); }
	}

	private static void processInner(HttpServletRequest request, HttpServletResponse response, String conf) throws Exception
	{
		String[] cells = request.getRequestURI().split("/");
		
		String ak = Lamb.get(cells, 1, ""); 
		String ck = Lamb.get(cells, 2, ""); 
		String mk = Lamb.get(cells, 3, ""); 
		
		SitemapDB db = getSitemap();
		
		String pk = ck + "/" + mk;
		System.out.println("Searching for " + pk);
		SitemapLink lk = db.lookup(pk);
		
		System.out.println("Creating object for " + lk.metagActionClassName());
		Object act0 = lk.getActionClass().newInstance();
		
		System.out.println("Converting object " + act0.getClass().getName());
		BaseController act = (BaseController)act0;
		act.request = request;
		act.response = response;
		act.setUri123(ak, ck, mk);
		act.setUrl01(request.getRequestURL().toString());

		System.out.println("Invoking method " + pk);
		Object obj = lk.getActionMethod().invoke(act);

		System.out.println("Rendering json " + pk);
		JsonWriter.start().write(response.getWriter(), obj);
	}

	private static SitemapDB getSitemap() 
	{
		if(db != null) return db;
		db = SitemapDB.getInstance(Page01Controller.class);
		db.addGroups();

		return db;
	}
	
	public static SitemapDB db;
}
