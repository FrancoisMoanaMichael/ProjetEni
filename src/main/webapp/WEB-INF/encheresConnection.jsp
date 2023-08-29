<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>

<body>
	<form action="LoginServlet" method="post">
		login:<input type="text" name="login"/>
		password:<input type="password" name="password"/>
		<input type="submit" value=">>"/>
	</form>
</body>
</html>