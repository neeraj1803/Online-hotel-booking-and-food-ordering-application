package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;

public class AdminupdateMenu 
{
	
Connection connection;
	
	public AdminupdateMenu()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}
	
	public boolean Updatemenu(String rate,String food) throws SQLException 
	{	
		
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		String value=food.toString();
		String value1=rate.toString();
		
		// String query="Update menu set Rate= ' "+value+ "'";
		String query="Update menu set Rate= ? where Food = ?";
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, rate);
			preparedstatement.setString(2, food);
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
			e.printStackTrace();
			return false;
		}
		finally{
			
			preparedstatement.close();
			resultset.close();
			
		}
		
	}
	

}
