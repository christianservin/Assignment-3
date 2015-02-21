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
		double investment = Double.parseDouble(request.getParameter("investment"));
		String stock1 = request.getParameter("stock1");
		String stock2 = request.getParameter("stock2");
		String stock3 = request.getParameter("stock3");

		try 
		{
			StocksModel stocks = new StocksModel(investment, stock1, stock2, stock3);
			
			request.setAttribute("stocks", stocks);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("result_view.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("index.jsp");
		}
	}
}