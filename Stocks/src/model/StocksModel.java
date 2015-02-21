package model;

import lib.YahooStockDAO;

public class StocksModel 
{
	private double investment;
	private String stock1;
	private String stock2;
	private String stock3;
	private double stock1price;
	private double stock2price;
	private double stock3price;
	
	public StocksModel(double investment, String stock1, String stock2, String stock3)
	{
		this.investment = Math.round((investment)*100.00)/100.00;
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		
		this.stock1price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock1).getPrice())*100.00)/100.00;
		this.stock2price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock2).getPrice())*100.00)/100.00;
		this.stock3price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock3).getPrice())*100.00)/100.00;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
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
}