package com.xadmin.BankApp.dao;


	
	import java.sql.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import com.xadmin.BankApp.bean.*;
	import java.sql.PreparedStatement;
	import java.util.*;
	public class UserDao {
	    private String jdbcURL = "jdbc:mysql://localhost:3306/upasana_practise";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "root";
	    private String jdbcDriver = "com.mysql.jdbc.Driver";
	    
	    private static final String INSERT=" insert into users" + " (name,password,email,balance) values " + " (?,?,?,?);";
	    private static final String SELECT="select * from users;";
	    private static final String DELETE="delete from users where ssn=?;";
	    private static final String UPDATE="update users set balance = ? where ssn=? ;";
	    private static final String SELECT_SSN="select*from users where ssn=?;";
	    
	    private Connection getConnection()
	    {
	        Connection connection =null;
	        try{
	            Class.forName(jdbcDriver);
	            connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	        catch(ClassNotFoundException e){
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    public boolean validate(User user)
	    {
	        boolean val=false;
	        try(Connection connection = getConnection();
	                PreparedStatement ps= connection.prepareStatement("select * from users where name = ? and password = ?;")){
	                ps.setString(1,user.getUsername());
	                ps.setString(2,user.getPassword());
	                
	                ResultSet rs=ps.executeQuery();
	                val=rs.next();/** As to the concrete question about rs.next(), it shifts the cursor to the next row of the result set from the database and returns true if there is any row, otherwise false. In combination with the if statement (instead of the while) this means that the programmer is expecting or interested in only one row, the first row. */
	        }
	        catch(SQLException e){
	            printSQLException(e);
	        }
	        
	        return val;
	    }
	    
	    public boolean insertUser(User user)
	    {
	        boolean ret=true;
	    	try(Connection connection = getConnection();
	                PreparedStatement ps =connection.prepareStatement(INSERT)){
	            ps.setString(1,user.getUsername());
	            ps.setString(2,user.getPassword());
	            ps.setString(3,user.getEmail());
	            ps.setInt(4, user.getBalance());
	            ps.executeUpdate();
	        }
	        catch(SQLException e){
	            printSQLException(e);
	            ret=false;
	        }
	    	return ret;
	    }
	    
	    public User selectUser(int ssn)
	    {
	        User user=null;
	        try(Connection connection=getConnection();
	                PreparedStatement ps=connection.prepareStatement(SELECT_SSN)){
	            ps.setInt(1, ssn);
	            ResultSet rs=ps.executeQuery();
	            
	            while(rs.next()){
	                String name=rs.getString("name");
	                String password=rs.getString("password");
	                String email =rs.getString("email");
	                int balance=rs.getInt("balance");
	                user=new User(name,password,email,balance,ssn);
	            }
	        }
	        catch(SQLException e){
	            printSQLException(e);
	        }
	        return user;
	    }
	    
	    public List<User> selectAllUsers()
	    {
	        List<User> users=new ArrayList<>();
	        try(Connection connection =getConnection();
	                PreparedStatement ps=connection.prepareStatement(SELECT)){
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	                String name=rs.getString("name");
	                String password=rs.getString("password");
	                String email =rs.getString("email");
	                int balance=rs.getInt("balance");
	                int ssn=rs.getInt("ssn");
	                User user=new User(name,password,email,ssn,balance);
	                users.add(user);
	            }
	            
	        }
	        catch(SQLException e){
	            printSQLException(e);
	        }
	        return users;
	    }
	    
	    public boolean updateW(int ssn,int amount){
	        boolean withdrawn=false;
	        User temp=selectUser(ssn);
	        
	        if(temp==null)
	        	return withdrawn;
	        int initial=temp.getBalance();
	        int fin=0;
	        if((initial - amount) >0)
	             fin= initial-amount;
	       
	        try(Connection connection=getConnection();
	                PreparedStatement ps=connection.prepareStatement(UPDATE)){
	            ps.setInt(1,fin);
	            ps.setInt(2,ssn);
	            withdrawn= ps.executeUpdate()>0;
	        }
	        catch(SQLException e){
	            printSQLException(e);
	        }
	        return withdrawn;
	    }
	    
	    public boolean updateD(int ssn,int amount){
	        boolean withdrawn=false;
	        User temp=selectUser(ssn);
	        if(temp==null)
	        	return withdrawn;
	        int initial=temp.getBalance();
	        int fin=initial+amount;
	        
	        try(Connection connection=getConnection();
	                PreparedStatement ps=connection.prepareStatement(UPDATE)){
	            ps.setInt(1,fin);
	            ps.setInt(2,ssn);
	            withdrawn= ps.executeUpdate()>0;
	        }
	        catch(SQLException e){
	            printSQLException(e);
	        }
	        return withdrawn;
	    }
	    
	    public boolean deleteUser(int ssn){
	        boolean deleted=false;
	        try(Connection connection = getConnection();
	                PreparedStatement ps=connection.prepareStatement(DELETE)){
	            ps.setInt(1,ssn);
	            deleted=ps.executeUpdate()>0;

	        }
	        catch(SQLException e){
	            printSQLException(e);
	        }
	        return deleted;
	    }
	    
	    private void printSQLException(SQLException ex)
	    {
	        for(Throwable e:ex)
	        {
	            if(e instanceof SQLException)
	            {
	                e.printStackTrace(System.err);
	                System.err.println("SQL State : "+ ((SQLException) e).getSQLState());
	                System.err.println("Error Code : "+ ((SQLException)e).getErrorCode());
	                System.err.println("Message : "+ ((SQLException)e).getMessage());
	                Throwable t=ex.getCause();
	                while(t!=null){
	                    System.out.println("Cause : "+t);
	                    t=t.getCause();
	                }
	            }
	        }
	    }
	    
	}



