<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>SELECT Stocks</title>
</head>
<body>
 
<sql:setDataSource var="database" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://198.199.109.101:3306/stocks"
     user="stocks"  password="assignment3"/>
 
<sql:query dataSource="${database}" var="result">
SELECT * from investment order by investment_id asc;
</sql:query>
 
<table border="1">
<tr>
   <th>Investment Total</th>
   <th>Investment Remainder</th>
   <th>Stock 1</th>
   <th>Stock 2</th>
   <th>Stock 3</th>
   <th>Stock 1 Price</th>
   <th>Stock 2 Price</th>
   <th>Stock 3 Price</th>
   <th>Stock 1 Shares</th>
   <th>Stock 2 Shares</th>
   <th>Stock 3 Shares</th>
   <th>Stock 1 Investment</th>
   <th>Stock 2 Investment</th>
   <th>Stock 3 Investment</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.investmentTotal}"/></td>
   <td><c:out value="${row.investmentRemainder}"/></td>
   <td><c:out value="${row.stock1}"/></td>
   <td><c:out value="${row.stock2}"/></td>
   <td><c:out value="${row.stock3}"/></td>
   <td><c:out value="${row.stock1price}"/></td>
   <td><c:out value="${row.stock2price}"/></td>
   <td><c:out value="${row.stock3price}"/></td>
   <td><c:out value="${row.stock1shares}"/></td>
   <td><c:out value="${row.stock2shares}"/></td>
   <td><c:out value="${row.stock3shares}"/></td>
   <td><c:out value="${row.stock1investment}"/></td>
   <td><c:out value="${row.stock2investment}"/></td>
   <td><c:out value="${row.stock3investment}"/></td>
</tr>
</c:forEach>
</table>
 
</body>
</html>