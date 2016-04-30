package apps.trenzi.models.json;

import ds.util.access.Rand;

public class Collection3 
{
	public String collectionImageUrl;
	public String collectionTitle;
	public String collectionSubTitle;
	public String collectionDetailUrl;
	
	public String brandLogo;
	public String brandName;
	
	public static Collection3 sample()
	{
		Collection3 res = new Collection3();
		
		res.collectionTitle = Rand.string(10, 20);
		res.collectionImageUrl = Rand.string(Rand.nextLen(7, 12));
		
		return res;		
	}

}
