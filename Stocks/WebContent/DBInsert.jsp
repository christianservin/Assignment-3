<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="model.StocksModel"%>
 
<html>
<head>
<title>INSERT Stocks</title>
</head>
<body>
 
<%StocksModel stocks = (StocksModel)request.getAttribute("stocks");%> 
 
<sql:setDataSource var="database" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://198.199.109.101:3306/stocks"
     user="stocks"  password="assignment3"/>


<sql:update dataSource="${database}" var="result">
INSERT INTO investment (investmentTotal,investmentRemainder,stock1,stock2,stock3,stock1price,stock2price,stock3price,stock1shares,stock2shares,stock3shares,stock1investment,stock2investment,stock3investment) VALUES ('<%=stocks.getInvestmentTotal()%>','<%=stocks.getInvestmentRemainder()%>','<%=stocks.getStock1()%>','<%=stocks.getStock2()%>','<%=stocks.getStock3()%>','<%=stocks.getStock1price()%>','<%=stocks.getStock2price()%>','<%=stocks.getStock3price()%>','<%=stocks.getStock1shares()%>','<%=stocks.getStock2shares()%>','<%=stocks.getStock1shares()%>','<%=stocks.getStock1investment()%>','<%=stocks.getStock2investment()%>','<%=stocks.getStock3investment()%>');
</sql:update>
 
 
</body>
</html>