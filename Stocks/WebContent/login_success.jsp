<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
</head>
<body>
	<%
		User user = (User) request.getAttribute("user");
	%>
	<h1>
		Hello
		<%=user.getUserName()%></h1>
	<h2>You have successfully logged in</h2>

</body>
</html>