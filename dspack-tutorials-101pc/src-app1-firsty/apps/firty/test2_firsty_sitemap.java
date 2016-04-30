package apps.firty;

import java.io.File;

import apps.firty.sitemap.HomeController;
import ds.util.access.SystemAccess;
import ds.zendy.sitemap.SitemapDB;

public class test2_firsty_sitemap 
{
	public static void main(String[] args) throws Exception
	{
		SitemapDB db = SitemapDB.getInstance(HomeController.class);
		db.addGroups();
		
		File f = SystemAccess.getDesktopFile("out-firsty-sitemap.html");
		db.printAndShow(f, "html");
//		PrintWriter out = SystemAccess.getDesktopWriter(pref);
//		db.printText(out);
//		out.close();
//		SystemAccess.openDesktopFile(pref);
	}
}
