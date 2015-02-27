package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StocksModel;

@WebServlet("/main")
public class StocksController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		double investment = Double.parseDouble(request.getParameter("totalInvestment"));
		String stock1 = request.getParameter("stock1");
		String stock2 = request.getParameter("stock2");
		String stock3 = request.getParameter("stock3");

		try 
		{
			StocksModel stocks = new StocksModel(investment, stock1, stock2, stock3);
			
			divideStocks(stocks);
			
			request.setAttribute("stocks", stocks);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("result_view.jsp");
			requestDispatcher.forward(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("index.jsp");
		}
	}
	
	private void divideStocks(StocksModel stocks)
	{
		//Getting Stock Prices
		double stock1price = stocks.getStock1price();
		double stock2price = stocks.getStock2price();
		double stock3price = stocks.getStock3price();
		
		//Getting Investment Amount
		double investmentTotal = stocks.getInvestmentTotal();
		
		//Dividing investment by 3
		double investmentTotalDivBy3 = investmentTotal/3;
		
		//Number of stock shares in double form
		double stock1Shares = 0;
		double stock2Shares = 0;
		double stock3Shares = 0;
		
		//Number of stock shares in integer form
		int stock1sh = 0;
		int stock2sh = 0;
		int stock3sh = 0;
		
		//Remainder of stocks
		double stock1Rem = 0;
		double stock2Rem = 0;
		double stock3Rem = 0;
		
		//Total spent on each stock
		double totStock1 = 0;
		double totStock2 = 0;
		double totStock3 = 0;
		
		//Total left after all allocations into stocks
		double lastRemainder = 0;
		
		if(stock1price > stock2price && stock1price > stock3price)
		{
			stock1Shares = investmentTotalDivBy3/stock1price;
			stock1sh = (int)stock1Shares;
			totStock1 = stock1sh*stock1price;
			stock1Rem = investmentTotalDivBy3-(totStock1);
			
			if(stock2price > stock3price)
			{
				stock2Shares = (investmentTotalDivBy3 + stock1Rem)/stock2price;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stock2price;
				stock2Rem = (investmentTotalDivBy3+ stock1Rem)-(totStock2);
				
				stock3Shares = (investmentTotalDivBy3 + stock2Rem)/stock3price;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stock3price;
				stock3Rem = (investmentTotalDivBy3+ stock2Rem)-(totStock3);
				lastRemainder = stock3Rem;
			}
			else if(stock3price > stock2price)
			{
				stock3Shares = (investmentTotalDivBy3 + stock1Rem)/stock3price;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stock3price;
				stock3Rem = (investmentTotalDivBy3 + stock1Rem)-(totStock3);
				
				stock2Shares = (investmentTotalDivBy3 + stock3Rem)/stock2price;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stock2price;
				stock2Rem = (investmentTotalDivBy3+ stock3Rem)-(totStock2);
				lastRemainder = stock2Rem;				
			}
		}
		
		else if(stock2price > stock1price && stock2price > stock3price)
		{
			stock2Shares = investmentTotalDivBy3/stock2price;
			stock2sh = (int)stock2Shares;
			totStock2 = stock2sh*stock2price;
			stock2Rem = investmentTotalDivBy3-(totStock2);
			
			if(stock1price > stock3price)
			{
				stock1Shares = (investmentTotalDivBy3 + stock2Rem)/stock1price;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stock1price;
				stock1Rem = (investmentTotalDivBy3+ stock2Rem)-(totStock1);
				
				stock3Shares = (investmentTotalDivBy3 + stock1Rem)/stock3price;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stock3price;
				stock3Rem = (investmentTotalDivBy3+ stock1Rem)-(totStock3);
				lastRemainder = stock3Rem;
			}
			else if(stock3price > stock1price)
			{
				stock3Shares = (investmentTotalDivBy3 + stock2Rem)/stock3price;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stock3price;
				stock3Rem = (investmentTotalDivBy3 + stock2Rem)-(totStock3);
				
				stock1Shares = (investmentTotalDivBy3 + stock3Rem)/stock1price;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stock1price;
				stock1Rem = (investmentTotalDivBy3+ stock3Rem)-(totStock1);
				lastRemainder = stock1Rem;
			}
		}
		
		else if(stock3price > stock2price && stock3price > stock1price)
		{
			stock3Shares = investmentTotalDivBy3/stock3price;
			stock3sh = (int)stock3Shares;
			totStock3 = stock3sh*stock3price;
			stock3Rem = investmentTotalDivBy3-(totStock3);
			
			if(stock1price > stock2price)
			{
				stock1Shares = (investmentTotalDivBy3 + stock3Rem)/stock1price;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stock1price;
				stock1Rem = (investmentTotalDivBy3+ stock3Rem)-(totStock1);
				
				stock2Shares = (investmentTotalDivBy3 + stock1Rem)/stock2price;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stock2price;
				stock2Rem = (investmentTotalDivBy3+ stock1Rem)-(totStock2);
				lastRemainder = stock2Rem;
			}
			else if(stock2price > stock1price)
			{
				stock2Shares = (investmentTotalDivBy3 + stock3Rem)/stock2price;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stock2price;
				stock2Rem = (investmentTotalDivBy3 + stock3Rem)-(totStock2);
				
				stock1Shares = (investmentTotalDivBy3 + stock2Rem)/stock1price;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stock1price;
				stock1Rem = (investmentTotalDivBy3+ stock2Rem)-(totStock1);
				lastRemainder = stock1Rem;				
			}
		}
	}
}