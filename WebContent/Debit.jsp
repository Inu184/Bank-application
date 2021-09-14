<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Debit</title>
</head>
<body>
	<div align="center">
	<h1>Deposit Section</h1>
		<form action="<%=request.getContextPath()%>/Withdraw" method="post">
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
			<input type="submit" value="Withdraw">
		</form>
	</div>
</body>
</html>