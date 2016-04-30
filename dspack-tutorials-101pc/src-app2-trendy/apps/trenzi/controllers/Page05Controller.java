package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankInputException;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.json.ProductType5;
import ds.util.render.JsonList;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@SiteNote1(ImageUrl="images/s5.jpg")
@SiteNote(Rename="page5", ImageUrl="https://www.dropbox.com/s/jmxh68kggzqvogw/s5.jpg?dl=0&raw=1")
public class Page05Controller extends BaseController
{
	@SiteNote(Meaning="To get the list of product types for current user",
			Example="dev=123&gender=male", Concepts={ProductType5.class})
	public Object protypesAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String gender = super.getParameter("gender", "").trim(); 
		if( gender.isEmpty() ) return error(101, BlankInputException.class);
		
		String words = super.getParameter("words", "").trim(); 
		
		try { return DataAccess.loadProductTypes(dev, gender, words, new JsonList<ProductType5>()); }
		catch(Exception xp) { return error(103, xp); }
	}
	


}
