package apps.trenzi.models.json;

import java.util.ArrayList;
import java.util.List;

import ds.zendy.metag.DaUsing1;



public class Collection7 
{
	public String collectionName = "";
	public String collectionType = "NA";
	public String collectionActionUrl;
	public int numberOfPhotos = 10;
	
	@DaUsing1(String.class)
	public List<String> imageUrlArray = new ArrayList<String>();
	
}
