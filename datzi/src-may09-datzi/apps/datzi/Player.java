package apps.datzi;

import java.util.Random;

public class Player 
{
	private Random coin;
	private double balance;

	public Player(double b) 
	{
		balance = b;
		coin = new Random( (System.nanoTime()%1997) );
	}

	public Object getName() 
	{
		return "player " + this.hashCode();
	}
	
	public boolean qualifiedForNextMove()
	{
		return balance > 0;
	}
	
	public String nextMove()
	{
		return coin.nextBoolean() ? "big" : "small";
	}

	public void modify(double i) 
	{
		balance += i;
	}

	public String getBalance() 
	{
		return (int)balance + "";
	}
	
	

}
