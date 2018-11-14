package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import itmd510.fp.dao.DataSource;

public class Table 
{
	String cid;
	String name;
	String mbnumber;
	String time;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbnumber() {
		return mbnumber;
	}
	public void setMbnumber(String mbnumber) {
		this.mbnumber = mbnumber;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
Connection connection;
	
	public Table()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}

	public boolean tablebook(String cid,String name,String mbnumber,String time) throws SQLException 
	{	
		
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="insert into tablebooking(cid,name,Mbnumber,time) values(?,?,?,?)";
		
		//String query="insert into Admin(username,password) values(?,?)";
		
		System.out.println("3");
		try
		{
		
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, cid);
			preparedstatement.setString(2, name);
			preparedstatement.setString(3, mbnumber);
			preparedstatement.setString(4, time);
		
			
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
