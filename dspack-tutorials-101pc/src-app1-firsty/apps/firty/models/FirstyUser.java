package apps.firty.models;

public class FirstyUser 
{
	public FirstyUser(int id, String name)
	{
		userId = id + "";
		userName = name;
		userEmail = name + "@gmail.com";
		
	}
	
	public String userId;
	public String userName;
	public String userEmail;
	
	public String userPassRand;
	public String userPassHashed;
	

}
