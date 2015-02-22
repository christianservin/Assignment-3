package model;

import lib.YahooStockDAO;

public class StocksModel 
{
	private double totalInvestment;
	private String stock1;
	private String stock2;
	private String stock3;
	private double stock1price;
	private double stock2price;
	private double stock3price;
	private double stock1investment;
	private double stock2investment;
	private double stock3investment;
	
	public StocksModel(double investment, String stock1, String stock2, String stock3)
	{
		this.totalInvestment = Math.round((investment)*100.00)/100.00;
		
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		
		this.stock1price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock1).getPrice())*100.00)/100.00;
		this.stock2price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock2).getPrice())*100.00)/100.00;
		this.stock3price = Math.round((double)(YahooStockDAO.getInstance().getStockPrice(stock3).getPrice())*100.00)/100.00;
		
		this.setStock1investment(this.totalInvestment/3);
		this.setStock2investment(this.totalInvestment/3);
		this.setStock3investment(this.totalInvestment/3);
	}

	public double getInvestment() {
		return totalInvestment;
	}

	public void setInvestment(double investment) {
		this.totalInvestment = investment;
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