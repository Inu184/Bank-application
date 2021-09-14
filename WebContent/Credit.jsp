<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credit</title>
</head>
<body>
	<div align="center">
	<h1>Credit Section</h1>
		<form action="<%=request.getContextPath()%>/Deposit" method="post">
			<table>
				<tr>
					<td>SSN</td>
					<td><input type="text" name="ssn" placeholder="Enter ssn here"></td>
				</tr>
				<tr>
					<td>Amount</td>
					<td><input type="text" name="amount"></td>
				</tr>
			</table>	
			<input type="submit" value="Deposit">
		</form>
	</div>
</body>
</html>