package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.json.Collection3;
import apps.trenzi.models.json.UserPref3;
import ds.util.render.JsonList;
import ds.util.render.JsonResult;
import ds.zendy.metag.MkDone;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@MkDone("100%")
@SiteNote1(ImageUrl="images/s3.jpg")
@SiteNote(Rename="page3", ImageUrl="https://www.dropbox.com/s/aum2q828izv9rg0/s3.jpg?dl=0&raw=1")
public class Page03Controller extends BaseController
{
	
	@SiteNote(Number = "1", Example = "dev=1234", Meaning="To get personal related collections")
	public Object colsAction() 
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		try { return DataAccess.loadHomeView(dev, new JsonList<Collection3>()); }
		catch(Exception xp) { return error(103, xp); }
	}
	
	@SiteNote(Number = "2", Example="dev=1234", Meaning="To get user preferences")
	public Object prefAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		try { return DataAccess.loadUserPref(dev, new JsonResult<UserPref3>()); }
		catch(Exception xp) { return error(103, xp); }
	}
	
}