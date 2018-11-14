package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;

public class AdminaddRoom
{

Connection connection;
	
	public AdminaddRoom()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}
	
	public boolean Addroom(String roomnumber,String roomtype,String roomrate) throws SQLException 
	{	
		
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="insert into rooms(roomno,roomtype,roomrate) values(?,?,?)";
		System.out.println("3");
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, roomnumber);
			preparedstatement.setString(2, roomtype);
			preparedstatement.setString(3, roomrate);
			
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
