package apps.trenzi.models.json;

import java.util.ArrayList;
import java.util.List;

import ds.zendy.metag.DaUsing1;

public class Collection9 {

	public String bannerImageUrl;
	
	@DaUsing1(Product9.class)	
	public List<Product9> alertItems = new ArrayList<Product9>();

}
