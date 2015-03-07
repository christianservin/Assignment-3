package model;

import lib.YahooStockDAO;

public class StocksModel 
{
	private double investmentTotal;
	private double investmentRemainder;
	private String stock1;
	private String stock2;
	private String stock3;
	private double stock1price;
	private double stock2price;
	private double stock3price;
	private int stock1shares;
	private int stock2shares;
	private int stock3shares;
	private double stock1investment;
	private double stock2investment;
	private double stock3investment;
	
	public StocksModel(double investmentTotal, String stock1, String stock2, String stock3)
	{
		this.investmentTotal = Math.round((investmentTotal)*100.00)/100.00;
		
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		
		this.stock1price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock1).getPrice())*100.00)/100.00;
		this.stock2price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock2).getPrice())*100.00)/100.00;
		this.stock3price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock3).getPrice())*100.00)/100.00;
	}

	public StocksModel(double investmentTotal, double investmentRemainder,
			String stock1, String stock2, String stock3, double stock1price,
			double stock2price, double stock3price, int stock1shares,
			int stock2shares, int stock3shares, double stock1investment,
			double stock2investment, double stock3investment) {
		super();
		this.investmentTotal = investmentTotal;
		this.investmentRemainder = investmentRemainder;
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		this.stock1price = stock1price;
		this.stock2price = stock2price;
		this.stock3price = stock3price;
		this.stock1shares = stock1shares;
		this.stock2shares = stock2shares;
		this.stock3shares = stock3shares;
		this.stock1investment = stock1investment;
		this.stock2investment = stock2investment;
		this.stock3investment = stock3investment;
	}




	public double getInvestmentTotal() {
		return investmentTotal;
	}


	public void setInvestmentTotal(double investmentTotal) {
		this.investmentTotal = investmentTotal;
	}


	public double getInvestmentRemainder() {
		return investmentRemainder;
	}


	public void setInvestmentRemainder(double investmentRemainder) {
		this.investmentRemainder = investmentRemainder;
	}


	public String getStock1() {
		return stock1;
	}


	public void setStock1(String stock1) {
		this.stock1 = stock1;
	}


	public String getStock2() {
		return stock2;
	}


	public void setStock2(String stock2) {
		this.stock2 = stock2;
	}


	public String getStock3() {
		return stock3;
	}


	public void setStock3(String stock3) {
		this.stock3 = stock3;
	}


	public double getStock1price() {
		return stock1price;
	}


	public void setStock1price(double stock1price) {
		this.stock1price = stock1price;
	}


	public double getStock2price() {
		return stock2price;
	}


	public void setStock2price(double stock2price) {
		this.stock2price = stock2price;
	}


	public double getStock3price() {
		return stock3price;
	}


	public void setStock3price(double stock3price) {
		this.stock3price = stock3price;
	}


	public int getStock1shares() {
		return stock1shares;
	}


	public void setStock1shares(int stock1shares) {
		this.stock1shares = stock1shares;
	}


	public int getStock2shares() {
		return stock2shares;
	}


	public void setStock2shares(int stock2shares) {
		this.stock2shares = stock2shares;
	}


	public int getStock3shares() {
		return stock3shares;
	}


	public void setStock3shares(int stock3shares) {
		this.stock3shares = stock3shares;
	}


	public double getStock1investment() {
		return stock1investment;
	}


	public void setStock1investment(double stock1investment) {
		this.stock1investment = stock1investment;
	}


	public double getStock2investment() {
		return stock2investment;
	}


	public void setStock2investment(double stock2investment) {
		this.stock2investment = stock2investment;
	}


	public double getStock3investment() {
		return stock3investment;
	}


	public void setStock3investment(double stock3investment) {
		this.stock3investment = stock3investment;
	}
}