<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align= "center">
            <h1>Upasana's Friendly Neighborhood Bank</h1>
            <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
                <table style ="with: 100%">
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="name" placeholder="Enter username"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name ="password" placeholder="Enter password"></td>
                    </tr>
                    <tr>
                        <td>SSN</td>
                        <td><input type="text" name ="ssn" placeholder="Enter SSN"></td>
                    </tr>
                </table>
                <br><!-- comment -->
                <input type="submit" value="Submit" />
            </form>
            <br>
            
            <h1>Registration Section for New User</h1>
            <form action="register.jsp">
           		<input type="submit" value="Register">
            </form>
        </div>
</body>
</html>