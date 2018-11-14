package itmd510.fp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource 

{
	protected Connection connection=null;
	
	
	public static Connection connectdb()
    {
		try
		{	
			String dbURL = "jdbc:oracle:thin:@www.papademas.net:1521:orcl";
		    String dbuser = "ora_neeraj";
		    String dbpassword = "oracle";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection(dbURL,dbuser,dbpassword);
			return connection;
			
		}
		catch(Exception e)
		{	
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
    	
    }
	

	

}
