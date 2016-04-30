package ds.zendy.sitemap;

import java.util.Comparator;

public class SitemapLinkByNumber implements Comparator<SitemapLink> 
{

	@Override
	public int compare(SitemapLink a, SitemapLink b) 
	{
		String ak = a.getSequenceNumber();
		String bk = b.getSequenceNumber();
		return ak.compareTo(bk);
	}

}
