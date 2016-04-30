package apps.trenzi.models.json;

import java.util.ArrayList;
import java.util.List;

import ds.zendy.metag.DaUsing1;

public class BrandGroup2 
{
	@DaUsing1(String[].class)
	public List<String[]> rows = new ArrayList<String[]>();
	
	public void add(String[] r) 
	{
		rows.add(r);
	}

}
