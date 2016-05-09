package apps.datzi;

import java.io.File;

import ds.access.Explorer;
import ds.writers.html.HtmlWriter;

public class test1_sequence {

	public static void main(String[] args) throws Exception
	{
		Host h = new Host();
		Player p1 = new Player(5000);
		Player p2 = new Player(3000);
		Player p3 = new Player(4000);
		Player p4 = new Player(9000);
		
		File f = Explorer.getDesktop().get("out1.html");
		startSimulation(1000, f, h, p1, p2, p3, p4);

		Explorer.show(f);
	}

	private static void startSimulation(int n, File f, Host h, Player... p) throws Exception
	{
		HtmlWriter out = new HtmlWriter(f);
		
		out.table();
		
		out.tr();
		out.td("#");
		out.td(h.getName());
		for(int j=0; j<p.length; j++) {
			out.td(p[j].getName());
			out.td("");
		}
		out.trEnd();
		
		for(int step=0; step<n; step++)
		{
			out.tr();			
			out.td(step);
			String hk = h.nextMove();
			out.td(hk);
			for(int j=0; j<p.length; j++)
			{
				if(p[j].qualifiedForNextMove())
				{
					String vj = p[j].nextMove();
					if(vj.equals(hk)) p[j].modify(10);
					else p[j].modify(-10);
					
					out.td(vj);
					out.td(p[j].getBalance());
				}
				
				else {
					out.td("&nbsp;"); 
					out.td("&nbsp;"); 
					}
			}
			
			out.trEnd();
		}
		
		out.tableEnd();
		
		out.close();
	}

}
