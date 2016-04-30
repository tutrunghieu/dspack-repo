package apps.trenzi.models.json;

import java.util.ArrayList;
import java.util.List;

import ds.zendy.metag.DaUsing1;


public class Header7 
{
	public String brandBannerUrl;
	
	public String brandTitle;
	public String brandSubTitle;
	
	@DaUsing1(Collection7.class)
	public List<Collection7> collections = new ArrayList<Collection7>();	
}
