package apps.trenzi;

import apps.trenzi.controllers.Page01Controller;
import ds.zendy.sitemap.SitemapDB;
import ds.zendy.sitemap.SitemapGroup;

public class print3_controllers_and_their_annotations 
{

	public static void main(String[] args) 
	{
		SitemapDB db = SitemapDB.getInstance(Page01Controller.class);
		db.addGroups();

		for(SitemapGroup gk: db.getGroups())
		{
			System.out.println("======" + gk.getGroupNumber());
			System.out.println("action-class: " + gk.metagActionClassName());
			System.out.println("action-url: " + gk.metagActionUrl());
			
			for(String t: gk.metagImageUrlArray()) System.out.println("image-url: " + t);
			System.out.println("done: " + gk.metagDone());
		}
		
		return;
	}

}
