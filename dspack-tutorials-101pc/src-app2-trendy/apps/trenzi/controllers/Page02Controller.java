package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankInputException;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.InvalidGenderException;
import ds.zendy.metag.MkDone;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@MkDone("100%")
@SiteNote1(ImageUrl="images/s2.jpg")
@SiteNote(Rename="page2", ImageUrl="https://www.dropbox.com/s/h8oidcd0mrlmb7z/s2.jpg?dl=0&raw=1")
public class Page02Controller extends BaseController
{
	
	@SiteNote(Number = "1", Example="dev=1234", Meaning="To get brands for gender")
	public Object brandsAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String gender = super.getParameter("gender", "").trim().toLowerCase(); 
		if(! DataAccess.validGender(gender) ) return error(102, InvalidGenderException.class);
		
		try { DataAccess.setGender(gender); }
		catch(Exception xp) { return error(103, xp); }
		
		return error0();
	}
	
	@SiteNote1(Number = "2", Meaning="To set user preference", Example="dev=1234&brands=nike;g2000;addidas")
	public Object setAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String brands = super.getParameter("brands", "").trim().toLowerCase(); 
		if( brands.isEmpty() ) return error(102, BlankInputException.class);
		
		try { DataAccess.setBrands(brands.split(";")); }
		catch(Exception xp) { return error(103, xp); }
		
		return error0();
	}
	
	public static void main(String[] args) throws Exception 
	{ 
		BaseController.test("set"); 
	}

}
