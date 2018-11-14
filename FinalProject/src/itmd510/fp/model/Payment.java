package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;

public class Payment
{
	private String cardnumber;
	private String month;
	private String year;
	private String cvv;
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	Connection connection;
	
	public Payment()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}
	
	public boolean payneeraj(String cardnumber,String month,String year,String cvv) throws SQLException 
	{	
		System.out.println("1");
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="select * from payment where cardnumber=? and month=? and year=? and cvv=?";
		//String query="insert into employee values (?,?)";
		System.out.println("3");
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, cardnumber);
			preparedstatement.setString(2, month);
			preparedstatement.setString(3, year);
			preparedstatement.setString(4, cvv);
			
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
