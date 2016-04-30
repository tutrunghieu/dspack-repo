package apps.trenzi.models.json;

import java.util.ArrayList;
import java.util.List;

import ds.zendy.metag.DaUsing1;

public class Product4 
{
	public String productId;
	public String productTitle;
	public String productSubTitle;
	
	@DaUsing1(String.class)	
	public List<String> productImageUrlArray = new ArrayList<String>();
	
	public String productLikeUrl;
	public String productSaveUrl;
	public String productShareUrl;
	
	public String productBuyNowUrl;
	public String productBuyAt;
	
	public String brandName;
	public String brandLogo;
}
