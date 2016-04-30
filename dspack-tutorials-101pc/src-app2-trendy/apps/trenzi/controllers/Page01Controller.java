package apps.trenzi.controllers;

import apps.trenzi.BaseController;
import apps.trenzi.models.BlankTokenException;
import apps.trenzi.models.DataAccess;
import apps.trenzi.models.InvalidGenderException;
import ds.zendy.metag.MkDone;
import ds.zendy.metag.SiteNote;
import ds.zendy.metag.SiteNote1;

@MkDone("100%")
@SiteNote1(ImageUrl="images/s1.jpg")
@SiteNote(Rename="page1", ImageUrl="https://www.dropbox.com/s/0zk78deeeep6ps7/s1.jpg?dl=0&raw=1")
public class Page01Controller extends BaseController
{
	@SiteNote(Meaning="To set user preference", Example="dev=1234&gender=male", Done="100%")
	public Object setAction()
	{
		String dev = super.getParameter("dev", "").trim(); 
		if( dev.isEmpty() ) return error(101, BlankTokenException.class);
				
		String gender = super.getParameter("gender", "").trim().toLowerCase(); 
		if(! DataAccess.validGender(gender) ) return error(102, InvalidGenderException.class);
		
		try { DataAccess.setGender(gender); }
		catch(Exception xp) { return error(103, xp); }
		
		return error0();
	}
	
	public static void main(String[] args) throws Exception { BaseController.test("set"); }
}
