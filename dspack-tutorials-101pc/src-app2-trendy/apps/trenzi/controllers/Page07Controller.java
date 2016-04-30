package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankInputException;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.json.Collection7;
import apps.trenzi.models.json.Header7;
import ds.util.render.JsonHeader;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@SiteNote1(ImageUrl="images/s7.jpg")
@SiteNote(Rename="page7", ImageUrl="https://www.dropbox.com/s/jji6xvq74b2murw/s7.jpg?dl=0&raw=1")
public class Page07Controller extends BaseController
{
	public Object colsAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String owner = super.getParameter("owner", "").trim(); 
		if( owner.isEmpty() ) return error(101, BlankInputException.class);
				
		try { return DataAccess.loadCollectForOwner(dev, owner, new JsonHeader<Header7, Collection7>()); }
		catch(Exception xp) { return error(103, xp); }
		
		
	}

}
