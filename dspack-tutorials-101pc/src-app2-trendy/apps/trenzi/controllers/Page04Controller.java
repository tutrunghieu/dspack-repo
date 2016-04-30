package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankInputException;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.json.Feedback4;
import apps.trenzi.models.json.Product4;
import ds.util.render.JsonResult;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@SiteNote1(ImageUrl="images/s4.jpg")
@SiteNote(Rename="page4", ImageUrl="https://www.dropbox.com/s/i0i2b8awoluhpdi/s4.jpg?dl=0&raw=1")
public class Page04Controller extends BaseController
{

	@SiteNote(Number = "1", Example = "dev=1234&prod=1234", Meaning="To get the detailed product")
	public Object prodAction() 
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		try { return DataAccess.loadProductView(dev, new JsonResult<Product4>()); }
		catch(Exception xp) { return error(103, xp); }
	}
	
	@SiteNote(Number = "2", Example = "dev=1234&prod=1234", Meaning="To get the detailed product")
	public Object likeAction() 
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String prod = super.getParameter("prod", "").trim(); 
		if( prod.isEmpty() ) return error(101, BlankInputException.class);
		
		try { return DataAccess.clickProduct(dev, prod, "like", new JsonResult<Feedback4>()); }
		catch(Exception xp) { return error(103, xp); }

	}

	@SiteNote(Number = "3", Example = "dev=1234&prod=1234&col=42432", Meaning="To save the product in collection")
	public Object saveAction() 
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String prod = super.getParameter("prod", "").trim(); 
		if( prod.isEmpty() ) return error(101, BlankInputException.class);
		
		try { return DataAccess.clickProduct(dev, prod, "save", new JsonResult<Feedback4>()); }
		catch(Exception xp) { return error(103, xp); }


	}

	
	@SiteNote(Number = "4", Example = "dev=1234&prod=1234&tar=facebook", Meaning="To share the prodcut on facebook")
	public Object shareAction() 
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String prod = super.getParameter("prod", "").trim(); 
		if( prod.isEmpty() ) return error(101, BlankInputException.class);
		
		try { return DataAccess.clickProduct(dev, prod, "share", new JsonResult<Feedback4>()); }
		catch(Exception xp) { return error(103, xp); }


	}
	
	@SiteNote(Number = "5", Example = "dev=1234&prod=1234", Meaning="To follow or get alert from the product")
	public Object followAction() 
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String prod = super.getParameter("prod", "").trim(); 
		if( prod.isEmpty() ) return error(101, BlankInputException.class);
		
		try { return DataAccess.clickProduct(dev, prod, "follow", new JsonResult<Feedback4>()); }
		catch(Exception xp) { return error(103, xp); }


	}
	

	@SiteNote(Number = "6", Example = "dev=1234&prod=1234", Meaning="To buy the product")
	public Object buyAction() 
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String prod = super.getParameter("prod", "").trim(); 
		if( prod.isEmpty() ) return error(101, BlankInputException.class);
		
		try { return DataAccess.clickProduct(dev, prod, "buy", new JsonResult<Feedback4>()); }
		catch(Exception xp) { return error(103, xp); }


	}
	
}
