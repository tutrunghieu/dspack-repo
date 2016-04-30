package apps.firty.models;

public class FirstyProduct {

	public FirstyProduct(int id, String name)
	{
		prodId = id + "";
		prodName = name;		
	}
	
	public String prodId;
	public String prodName;
	public String prodPrice;
	
	public String prodBrand;
	public String prodSupplier;	
}
