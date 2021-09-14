<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
	<div align="center">
		<h1>You have successfully logged in</h1>
		<br>
		<h1>Account Details Section</h1>
            <form action="<%=request.getContextPath()%>/Account" method="post">
            <table>
            	<tr>
                    <td>SSN</td>
                    <td><input type="text" name ="ssn" placeholder="Enter SSN"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Get Account Details">
            </form>
            <br>
        <h1>Balance Section</h1>
        	<form action="Debit.jsp" method="post">
        	<input type="submit" value="Withdraw">
        	</form>
        	<br>
        	<form action="Credit.jsp" method="post">
        	<input type="submit" value="Deposit">
        	</form>
        	
	</div>
</body>
</html>