package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankInputException;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.json.Product6;
import ds.util.render.JsonList;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@SiteNote1(ImageUrl="images/s6.jpg")
@SiteNote(Rename="page6", ImageUrl="https://www.dropbox.com/s/u2m9z9nxtxrxy32/s6.jpg?dl=0&raw=1")
public class Page06Controller extends BaseController
{
	@SiteNote(Meaning="To view products from one given collection",
			Example="dev=123&col=456")
	public Object productsAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String gender = super.getParameter("gender", "").trim(); 
		if( gender.isEmpty() ) return error(101, BlankInputException.class);
		
		String words = super.getParameter("words", "").trim(); 
		
		try { return DataAccess.loadProducts(dev, gender, words, new JsonList<Product6>()); }
		catch(Exception xp) { return error(103, xp); }
	}

}
