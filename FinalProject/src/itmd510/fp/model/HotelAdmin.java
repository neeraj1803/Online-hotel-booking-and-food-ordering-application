package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;

public class HotelAdmin 
{
Connection connection;
	
	public HotelAdmin()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}
	
	public boolean AdminLogin(String username,String password) throws SQLException 
	{	
		System.out.println("1");
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="select * from HotelAdmin where username = ? and password = ?";
		
		System.out.println("3");
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			
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
