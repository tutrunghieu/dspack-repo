package ds.zendy.jsondb;

import java.util.Comparator;

import ds.util.access.SystemAccess;

public class JsonTableByNumber implements Comparator<JsonTable<?>> 
{

	@Override
	public int compare(JsonTable<?> a, JsonTable<?> b)
	{
		Integer[] ak = SystemAccess.getNumbersFromName(a.getDataClass().getSimpleName());
		Integer[] bk = SystemAccess.getNumbersFromName(b.getDataClass().getSimpleName());
		
		for(int n=Math.min(ak.length, bk.length), k=0; k<n; k++)
		{
			int dk = ak[k] - bk[k];
			if(dk != 0) return dk;
		}
		return ak.length - bk.length;
	}

}
