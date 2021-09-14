<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<h1>Welcome new user</h1>
		<form action= "<%=request.getContextPath()%>/Register" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" placeholder="Enter username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" placeholder="Enter password"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" placeholder="Enter email"></td>
				</tr>
				<tr>
					<td>Balance</td>
					<td><input type="text" name="balance" placeholder="Enter balance"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Register" />
		</form>
		
	</div>
</body>
</html>