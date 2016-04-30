package apps.trenzi.models;

import apps.trenzi.models.json.Header7;
import apps.trenzi.models.json.Header8;
import apps.trenzi.models.json.Collection3;
import apps.trenzi.models.json.Collection7;
import apps.trenzi.models.json.Feedback4;
import apps.trenzi.models.json.Product4;
import apps.trenzi.models.json.Product6;
import apps.trenzi.models.json.Product8;
import apps.trenzi.models.json.ProductType5;
import apps.trenzi.models.json.UserPref3;
import ds.util.access.Sampler;
import ds.util.render.JsonHeader;
import ds.util.render.JsonList;
import ds.util.render.JsonResult;

public class DataAccess {

	public static boolean validGender(String gender) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void setGender(String gender) {
		// TODO Auto-generated method stub
		
	}

	public static void setBrands(String[] brands) {
		// TODO Auto-generated method stub
		
	}

	public static Object loadHomeView(String dev, JsonList<Collection3> json)
	{
		json.data = Sampler.start(Collection3.class).sample(10);
		return json;
	}

	public static Object loadUserPref(String dev, JsonResult<UserPref3> json)
	{

		return json;
	}

	public static Object loadProductView(String dev, JsonResult<Product4> json)
	{
		

		return json;
	}

	public static Object clickProduct(String dev, String prod, String lsa, JsonResult<Feedback4> json)
	{
		return json;
	}

	public static Object loadProductTypes(String dev, String gender, String words, JsonList<ProductType5> json)
	{

		return json;
	}

	public static Object loadProducts(String dev, String gender, String prodtype, JsonList<Product6> json) 
	{

		return json;
	}

	public static Object loadCollectForOwner(String dev, String owner, JsonHeader<Header7, Collection7> json)
	{

		return json;
	}

	public static Object loadFavorCol(String dev, JsonHeader<Header8, Product8> json)
	{
		return json;
	}

}
