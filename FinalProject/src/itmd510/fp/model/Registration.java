package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import itmd510.fp.dao.DataSource;

public class Registration
{
	String fname;
	String lname;
	String username;
	String password;
	String confirmpassword;
	String Number;
	

	public String getFname() {
		return fname;
	}

public void setFname(String fname) {
		this.fname = fname;
	}


public String getLname() {
		return lname;
	}


public void setLname(String lname) {
		this.lname = lname;
	}

public String getUsername() {
		return username;
	}

public void setUsername(String username) {
		this.username = username;
	}

public String getPassword() {
		return password;
	}

public void setPassword(String password) {
		this.password = password;
	}

public String getConfirmpassword() {
		return confirmpassword;
	}

public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}


public String getNumber() {
		return Number;
	}


public void setNumber(String number) {
		Number = number;
	}


Connection connection;
	
	public Registration()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}
	
	public boolean RegisterMe(String fname,String lname,String username,String password,String confirmpassword,String Number) throws SQLException 
	{	
		
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="insert into users(fname,lname,username,password,confirmpassword,mbnumber) values(?,?,?,?,?,?)";
		
		//String query="insert into Admin(username,password) values(?,?)";
		
		System.out.println("3");
		try
		{
			String pass=DigestUtils.shaHex(password);
			String pass1=DigestUtils.shaHex(confirmpassword);
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, fname);
			preparedstatement.setString(2, lname);
			preparedstatement.setString(3, username);
			preparedstatement.setString(4, pass);
			preparedstatement.setString(5, pass1);
			preparedstatement.setString(6, Number);
			
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
