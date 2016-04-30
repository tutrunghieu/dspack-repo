package apps.trenzi.models.json;

import ds.util.access.Rand;

public class ProductType5 {

	public String protypeName;
	public String protypeImageUrl;
	public String protypeActionUrl;

	public static ProductType5 sample()
	{
		ProductType5 res = new ProductType5();
		
		res.protypeName = Rand.string(10, 17);
		res.protypeImageUrl = Rand.nextUrl(Rand.nextLen(14, 17));
		res.protypeActionUrl = Rand.nextUrl(Rand.nextLen(14, 17));		
		
		return res;
	}

}
