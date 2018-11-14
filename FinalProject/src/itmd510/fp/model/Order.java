package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;
import javafx.scene.control.TextField;

public class Order
{	
	String Cid;
	String food;
	String Rate;
	String name;
	String address;
	String mobile;
	
	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}
	
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getRate() {
		return Rate;
	
	}

	public void setRate(String rate) {
		Rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	Connection connection;
	
	public Order()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}

	public boolean Confirmorder(String cid,String food,String Rate,String name,String address,String mobile) throws SQLException 
	{	
		
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="insert into cus_order(cid,food,rate,name,address,mbnumber) values(?,?,?,?,?,?)";
		//String query="insert into employee values (?,?)";
		System.out.println("3");
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, cid);
			preparedstatement.setString(2, food);
			preparedstatement.setString(3, Rate);
			preparedstatement.setString(4, name);
			preparedstatement.setString(5, address);
			preparedstatement.setString(6, mobile);
		
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