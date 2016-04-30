package ds.zendy.sitemap;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ds.util.access.SystemAccess;
import ds.util.stream.Joiner;
import ds.util.stream.Lamb;

public class SitemapDB 
{
	private Class<?> rootClass;
	
	private List<SitemapGroup> groups = new ArrayList<SitemapGroup>();
	private Map<String, SitemapLink> actions;

	public static SitemapDB getInstance(Class<?> clname)
	{
		SitemapDB res = new SitemapDB();
		res.rootClass = clname;
		return res;
	}
	
	public SitemapGroup addGroup(Class<?> cl)
	{
		SitemapGroup t = new SitemapGroup(cl, this.groups.size()+1) ;
		groups.add(t);
		return t;
	}
	
	public static boolean ECHO_EXAMPLE = false;
	public static boolean ECHO_GROUP = false;

	public void printText(PrintWriter out)
	{

	}
	public void printHtml(PrintWriter out)
	{
		if(!ECHO_GROUP) out.print("<table border=0>");
		
		int g = 0;
		
		for(SitemapGroup gk: groups)
		{
			g++;
			
			if(ECHO_GROUP) {
				out.println("<h3>" + gk.metagActionUrl() + "</h3>");
			}
			
			String gcol = " style=' background-color:" + (g%2==0 ? "lavender" : "lightblue") + ";' ";
			
			if(ECHO_GROUP) out.print("<table border=0>");
			int f = 0;
			for(SitemapLink lj: gk.getActionItemsSorted())
			{
				List<String> ejj = lj.getSiteNoteExamples();
				ejj = Lamb.pref("/" + lj.getActionUrl() + "?", ejj);
				ejj = Lamb.anchor(" target=_blank ", ejj);
				
				String tf = (f++ == 0 ? "<td rowspan="+gk.getActionItems().size()+">"
						+ "<img style='width: 48px;' src='"+Lamb.shorter(gk.metagImageUrlArray(), "")+"'></td>" : "");
				
				String row = Joiner.start("</td><td>").joinObjects(
								lj.getSequenceNumber() + ") " + lj.getActionUrl(), 
								Joiner.start("<br>").join(lj.getSiteNotePurpose()),
								Joiner.start("<br>").join(ejj),
								Joiner.start("<br>").join(lj.getSiteNoteConcepts()),								
								Joiner.start("<br>").join(lj.getSiteNoteDone()
										)								
							); 
				out.println("<tr   "+gcol+">"+tf+"<td>" + row + "</td></tr>");
			}					
			
			if(ECHO_GROUP) out.print("</table>");
			
		} //for each group
		if(!ECHO_GROUP) out.print("</table>");
		
		return;
	}

	public void addGroups() 
	{
		String name = '/' + rootClass.getName().replace('.', '/') + ".class";

		File f = new File( rootClass.getResource(name).getFile() );
		
		int len = f.getAbsolutePath().length() - name.length() + 1;
		
		for(File fk: f.getParentFile().listFiles())
		if( selectedClass(fk) ) 
		try
		{
			String nk = fk.getAbsolutePath();
			nk = nk.substring(len, nk.length()-6).replace('\\', '/').replace('/', '.');
			//System.out.println(nk);
			
			this.addGroup(Class.forName(nk));
		}
		catch(Exception xp) {}

		return;
	}

	protected boolean selectedClass(File fk) 
	{
		if(fk.isDirectory()) return false;
		
		String nk = fk.getName();
		if(! nk.endsWith("Controller.class")) return false;
		return true;
	}

	public void printAndShow(File f, String fmt) throws Exception
	{
		f.getParentFile().mkdirs();
		
		if(fmt.equals("txt"))
		{
			PrintWriter out = new PrintWriter(f);
			this.printText(out);
			out.close();			
		}
		
		else if(fmt.equals("html"))
		{
			PrintWriter out = new PrintWriter(f);
			out.println("<style>td { padding: 7px; }\n</style>"); 
			this.printHtml(out);
			out.close();			
		}
		
		SystemAccess.openFile(f);		
	}

	public List<SitemapGroup> getGroups() 
	{
		return groups;		
	}

	public SitemapLink lookup(String url)
	{
		if(actions != null) return actions.get(url);
		
		actions  = new TreeMap<String, SitemapLink>();
		
		for(SitemapGroup gk: groups)
		for(SitemapLink fj: gk.getActionItems())
		{
			actions.put(fj.getActionUrl(), fj);			
		}
		
		return actions.get(url);
	}


}
