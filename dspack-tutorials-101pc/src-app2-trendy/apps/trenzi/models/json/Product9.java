package apps.trenzi.models.json;

import ds.zendy.metag.DaNote1;

public class Product9 
{
	
	public String productImageUrl;
	public String productTitle;
	
	public String brandName;
	public String brandLogo;
	
	@DaNote1("The link to remove/unfollow this alert")
	public String alertRemoveUrl;
	
	@DaNote1("The link to view more details on this alert")
	public String alertActionUrl;
	
	public String alertType;
	
	@DaNote1("The discount percentage")
	public String alertPerc;
	
	public String alertPriceOld;
	public String alertPriceNew;
	
	@DaNote1("The end of promotion period")
	public String alertDateExpiry = "31-12-2016";
}
