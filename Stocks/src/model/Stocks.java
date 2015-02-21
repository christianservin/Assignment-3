package model;

public class Stocks 
{
	private double investment;
	private String stock1;
	private String stock2;
	private String stock3;
	
	public Stocks(double investment, String stock1, String stock2, String stock3) 
	{
		this.investment = investment;
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
	}
	
	public double getInvestment() 
	{
		return investment;
	}
	public void setInvestment(double investment) 
	{
		this.investment = investment;
	}
	public String getStock1() 
	{
		return stock1;
	}
	public void setStock1(String stock1) 
	{
		this.stock1 = stock1;
	}
	public String getStock2() 
	{
		return stock2;
	}
	public void setStock2(String stock2) 
	{
		this.stock2 = stock2;
	}
	public String getStock3() 
	{
		return stock3;
	}
	public void setStock3(String stock3) 
	{
		this.stock3 = stock3;
	}
}