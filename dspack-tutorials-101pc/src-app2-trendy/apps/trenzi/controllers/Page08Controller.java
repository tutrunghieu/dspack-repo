package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.json.Header8;
import apps.trenzi.models.json.Product8;
import ds.util.render.JsonHeader;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@SiteNote1(ImageUrl="images/s8.jpg")
@SiteNote(Rename="page8", ImageUrl="https://www.dropbox.com/s/2d8o0ei04t9wytu/s8.jpg?dl=0&raw=1")
public class Page08Controller extends BaseController
{
	public Object favorAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		try { return DataAccess.loadFavorCol(dev, new JsonHeader<Header8, Product8>()); }
		catch(Exception xp) { return error(103, xp); }
		
	}

}
