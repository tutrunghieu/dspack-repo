package apps.trenzi;

import java.io.File;

import apps.trenzi.controllers.Page01Controller;
import ds.util.access.SystemAccess;
import ds.zendy.sitemap.SitemapDB;

public class print2_trenzi_sitemap 
{

	public static void main(String[] args) throws Exception
	{
		SitemapDB db = SitemapDB.getInstance(Page01Controller.class);
		db.addGroups();
		
		
		File f = SystemAccess.getDesktopFile("out-firsty-sitemap.html");
		//db.ECHO_GROUP = true;
		
		db.printAndShow(f, "html");
	}
}
