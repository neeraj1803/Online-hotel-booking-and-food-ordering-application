package itmd510.fp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import itmd510.fp.dao.DataSource;

public class HotelRoom

{
	
	private String RoomNo;
	private String Room;
	private String Rate;
	
	public HotelRoom(String RoomNo, String Room,String Rate) 
	{
		
		this.RoomNo = RoomNo;
		this.Room = Room;
		this.Rate = Rate;
	}
	
	Connection connection;
	public HotelRoom()
	{
		connection=DataSource.connectdb();
		if(connection == null)
			System.exit(1);
	}	

	public String getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}

	public String getRoom() {
		return Room;
	}

	public void setRoom(String room) {
		Room = room;
	}

	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}

	
	public boolean Confirmroom(String cid,String roomNo,String Room,String Rate,String name,String address,String mobile) throws SQLException 
	{	
		
		PreparedStatement preparedstatement =null;
		ResultSet resultset = null;
		System.out.println("2");
		String query="insert into roombooking values(?,?,?,?,?,?,?)";
		
		System.out.println("3");
		try
		{
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, cid);
			preparedstatement.setString(2, roomNo);
			preparedstatement.setString(3, Room);
			preparedstatement.setString(4, Rate);
			preparedstatement.setString(5, name);
			preparedstatement.setString(6, address);
			preparedstatement.setString(7, mobile);
			System.out.println("4");
			resultset=preparedstatement.executeQuery();
			System.out.println("5");
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
