package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;

public class Login 

{
	private String user;
	private String pass;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	Connection connection;
	
	public Login()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}
	
	public boolean isDbConnected()
	{
		
		try
		{
			return !connection.isClosed();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
			
		
	}
	
	public boolean isLogin(String username) throws SQLException 
	{	
		System.out.println("1");
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="select * from users where username = ?";
		//String query="insert into employee values (?,?)";
		System.out.println("3");
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, username);
		//	preparedstatement.setString(2, password);
			
			resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				
				return true;
			}
			else
			{
				

				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("i m reaching here catch exception");

			return false;
		}
		finally{
			
			preparedstatement.close();
			resultset.close();
			
		}
		
		
		
		
		
	}
	

}
