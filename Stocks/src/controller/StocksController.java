package controller;

import javax.swing.JOptionPane;
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
	
	//Getting Stock Prices
	double stockPrice1 = 0;
	double stockPrice2 = 0;
	double stockPrice3 = 0;
	//Getting Investment Amount
	double investmentAmount = 0;
	//Number of stock shares in integer form
	int stock1sh = 0;
	int stock2sh = 0;
	int stock3sh = 0;
	//Total left after all allocations into stocks
	double lastRemainder = 0;
	//Total spent on each stock
	double totStock1 = 0;
	double totStock2 = 0;
	double totStock3 = 0;
		
	StocksModel stocks;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		double investment = Double.parseDouble(request.getParameter("totalInvestment"));
		String stock1 = request.getParameter("stock1");
		String stock2 = request.getParameter("stock2");
		String stock3 = request.getParameter("stock3");

		try 
		{
			stocks = new StocksModel(investment, stock1, stock2, stock3);
			
			divideStocks();
			
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
	
	private void divideStocks()
	{
		//Getting Stock Prices
		stockPrice1 = stocks.getStock1price();
		stockPrice2 = stocks.getStock2price();
		stockPrice3 = stocks.getStock3price();
		
		//Getting Investment Amount
		investmentAmount = stocks.getInvestmentTotal();
		
		//Dividing investment by 3
		double investmentDivBy3 = investmentAmount/3;
		
		//Number of stock shares in double form
		double stock1Shares = 0;
		double stock2Shares = 0;
		double stock3Shares = 0;
		
		//Number of stock shares in integer form
		stock1sh = 0;
		stock2sh = 0;
		stock3sh = 0;
		
		//Remainder of stocks
		double stock1Rem = 0;
		double stock2Rem = 0;
		double stock3Rem = 0;
		
		if(stockPrice1 > stockPrice2 && stockPrice1 > stockPrice3)
		{
			
			stock1Shares = investmentDivBy3/stockPrice1;
			stock1sh = (int)stock1Shares;
			totStock1 = stock1sh*stockPrice1;
			stock1Rem = investmentDivBy3-(totStock1);
			
			if(stockPrice2 > stockPrice3)
			{
				stock2Shares = (investmentDivBy3 + stock1Rem)/stockPrice2;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stockPrice2;
				stock2Rem = (investmentDivBy3+ stock1Rem)-(totStock2);
				
				stock3Shares = (investmentDivBy3 + stock2Rem)/stockPrice3;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stockPrice3;
				stock3Rem = (investmentDivBy3+ stock2Rem)-(totStock3);
				lastRemainder = stock3Rem;
				
				//JOptionPane.showMessageDialog(null, " Total Remaining " + lastRemainder );
				
				
			}
			else if(stockPrice3 > stockPrice2)
			{
				stock3Shares = (investmentDivBy3 + stock1Rem)/stockPrice3;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stockPrice3;
				stock3Rem = (investmentDivBy3 + stock1Rem)-(totStock3);
				
				stock2Shares = (investmentDivBy3 + stock3Rem)/stockPrice2;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stockPrice2;
				stock2Rem = (investmentDivBy3+ stock3Rem)-(totStock2);
				lastRemainder = stock2Rem;
				
				//JOptionPane.showMessageDialog(null, "2 " + lastRemainder);
			}
			
			
		}
		
		else if(stockPrice2 > stockPrice1 && stockPrice2 > stockPrice3)
		{
			stock2Shares = investmentDivBy3/stockPrice2;
			stock2sh = (int)stock2Shares;
			totStock2 = stock2sh*stockPrice2;
			stock2Rem = investmentDivBy3-(totStock2);
			
			if(stockPrice1 > stockPrice3)
			{
				stock1Shares = (investmentDivBy3 + stock2Rem)/stockPrice1;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stockPrice1;
				stock1Rem = (investmentDivBy3+ stock2Rem)-(totStock1);
				
				stock3Shares = (investmentDivBy3 + stock1Rem)/stockPrice3;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stockPrice3;
				stock3Rem = (investmentDivBy3+ stock1Rem)-(totStock3);
				lastRemainder = stock3Rem;
				//JOptionPane.showMessageDialog(null, "3 " + lastRemainder);
				
			}
			else if(stockPrice3 > stockPrice1)
			{
				stock3Shares = (investmentDivBy3 + stock2Rem)/stockPrice3;
				stock3sh = (int)stock3Shares;
				totStock3 = stock3sh*stockPrice3;
				stock3Rem = (investmentDivBy3 + stock2Rem)-(totStock3);
				
				stock1Shares = (investmentDivBy3 + stock3Rem)/stockPrice1;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stockPrice1;
				stock1Rem = (investmentDivBy3+ stock3Rem)-(totStock1);
				lastRemainder = stock1Rem;
				//JOptionPane.showMessageDialog(null, "4 " + lastRemainder);
			}
		}
		
		else if(stockPrice3 > stockPrice2 && stockPrice3 > stockPrice1)
		{
			stock3Shares = investmentDivBy3/stockPrice3;
			stock3sh = (int)stock3Shares;
			totStock3 = stock3sh*stockPrice3;
			stock3Rem = investmentDivBy3-(totStock3);
			
			if(stockPrice1 > stockPrice2)
			{
				stock1Shares = (investmentDivBy3 + stock3Rem)/stockPrice1;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stockPrice1;
				stock1Rem = (investmentDivBy3+ stock3Rem)-(totStock1);
				
				stock2Shares = (investmentDivBy3 + stock1Rem)/stockPrice2;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stockPrice2;
				stock2Rem = (investmentDivBy3+ stock1Rem)-(totStock2);
				lastRemainder = stock2Rem;
				//JOptionPane.showMessageDialog(null, "5 " + lastRemainder);
			}
			else if(stockPrice2 > stockPrice1)
			{
				stock2Shares = (investmentDivBy3 + stock3Rem)/stockPrice2;
				stock2sh = (int)stock2Shares;
				totStock2 = stock2sh*stockPrice2;
				stock2Rem = (investmentDivBy3 + stock3Rem)-(totStock2);
				
				stock1Shares = (investmentDivBy3 + stock2Rem)/stockPrice1;
				stock1sh = (int)stock1Shares;
				totStock1 = stock1sh*stockPrice1;
				stock1Rem = (investmentDivBy3+ stock2Rem)-(totStock1);
				lastRemainder = stock1Rem;
				//JOptionPane.showMessageDialog(null, "6 " + lastRemainder);
				
			}
		}
		
	}
	
}