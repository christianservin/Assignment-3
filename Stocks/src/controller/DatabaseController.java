package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lib.Database;
import model.StocksModel;

@WebServlet("/database")
public class DatabaseController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			double investmentTotal = Double.parseDouble(request.getParameter("investmentTotal"));
			double investmentRemainder = Double.parseDouble(request.getParameter("investmentRemainder"));
			String stock1 = request.getParameter("stock1");
			String stock2 = request.getParameter("stock2");
			String stock3 = request.getParameter("stock3");
			double stock1price = Double.parseDouble(request.getParameter("stock1price"));
			double stock2price = Double.parseDouble(request.getParameter("stock2price"));
			double stock3price = Double.parseDouble(request.getParameter("stock3price"));
			int stock1shares = Integer.parseInt(request.getParameter("stock1shares"));
			int stock2shares = Integer.parseInt(request.getParameter("stock2shares")); 
			int stock3shares = Integer.parseInt(request.getParameter("stock3shares"));
			double stock1investment = Double.parseDouble(request.getParameter("stock1investment"));
			double stock2investment = Double.parseDouble(request.getParameter("stock2investment"));
			double stock3investment = Double.parseDouble(request.getParameter("stock3investment"));
			
			
			StocksModel stocks = new StocksModel(investmentTotal, investmentRemainder, stock1, stock2, stock3, stock1price, stock2price, stock3price, stock1shares, stock2shares, stock3shares, stock1investment, stock2investment, stock3investment);
			sendStocksDataToDatabase(investmentTotal, investmentRemainder, stock1, stock2, stock3, stock1price, stock2price, stock3price, stock1shares, stock2shares, stock3shares, stock1investment, stock2investment, stock3investment);

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
	
	public void sendStocksDataToDatabase(double investmentTotal,double investmentRemainder,String stock1,String stock2,String stock3,double stock1price,double stock2price,double stock3price,int stock1shares,int stock2shares,int stock3shares,double stock1investment,double stock2investment,double stock3investment)
	{	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Database db = new Database();
			db.testConnection();
			String command = "INSERT INTO investment (investmentTotal,investmentRemainder,stock1,stock2,stock3,stock1price,stock2price,stock3price,stock1shares,stock2shares,stock3shares,stock1investment,stock2investment,stock3investment) VALUES ('"+investmentTotal+"','"+investmentRemainder+"','"+stock1+"','"+stock2+"','"+stock3+"','"+stock1price+"','"+stock2price+"','"+stock3price+"','"+stock1shares+"','"+stock2shares+"','"+stock3shares+"','"+stock1investment+"','"+stock2investment+"','"+stock3investment+"');";
			db.executeUpdate(db.getConnection(), command);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}