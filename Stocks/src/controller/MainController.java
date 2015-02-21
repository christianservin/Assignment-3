package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Stocks;

@WebServlet("/main")
public class MainController extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		double investment = Double.parseDouble(request.getParameter("investment"));
		String stock1 = request.getParameter("stock1");
		String stock2 = request.getParameter("stock2");
		String stock3 = request.getParameter("stock3");
		
		Stocks stocks = new Stocks(investment, stock3, stock3, stock3);
		
		request.setAttribute("stocks", stocks);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("result_view.jsp");
		requestDispatcher.forward(request, response);
		
		//else 
		{
			//response.sendRedirect("index.jsp");
		}
	}
}