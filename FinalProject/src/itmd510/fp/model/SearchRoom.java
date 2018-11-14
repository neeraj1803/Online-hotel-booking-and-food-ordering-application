package itmd510.fp.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;

public class SearchRoom
{
	String cid;
	String roomtype;
	String guestno;
	String checkin;
	String checkout;
	
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getGuestno() {
		return guestno;
	}
	public void setGuestno(String guestno) {
		this.guestno = guestno;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	
Connection connection;
	
	public SearchRoom()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
		
	}

	
	public boolean Roomsearch(String cid,String roomtype,String guestno,String checkin,String checkout) throws SQLException 
	{	
		
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="insert into searchedrooms(cid,roomtype,noofguests,checkin,checkout) values(?,?,?,?,?)";
		//String query="insert into employee values (?,?)";
		System.out.println("3");
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, cid);
			preparedstatement.setString(2, roomtype);
			preparedstatement.setString(3, guestno);
			preparedstatement.setString(4, checkin);
			preparedstatement.setString(5, checkout);
			
			
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
