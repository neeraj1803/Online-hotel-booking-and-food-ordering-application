package itmd510.fp.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.HotelRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DisplaymenuController implements Initializable
{	
	public HotelRoom H=new HotelRoom();    // object creation of HotelRoom Model
	
	 Stage dialogStage= new Stage();
	    Scene scene;
	    
	Connection connection=null;
  PreparedStatement statement=null;
  ResultSet set=null;
	
  private ObservableList<HotelRoom> data;
	
	 @FXML
	    private TableView<HotelRoom> tableview;

	    @FXML
	    private TableColumn<?, ?> col2;

	    @FXML
	    private TableColumn<?, ?> col3;

	    @FXML
	    private TableColumn<?, ?> col1;

		@Override
		public void initialize(URL location, ResourceBundle resources) 
		{
			// TODO Auto-generated method stub
			data = FXCollections.observableArrayList();
			setcelltable();    // method call to set table columns
			try {
				LoadData();   //method call to load data into tableview
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	     
		//method to set columns
		private void setcelltable()
		{
			col3.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
			col2.setCellValueFactory(new PropertyValueFactory<>("Room"));
			col1.setCellValueFactory(new PropertyValueFactory<>("Rate"));
		}	

		//method to load data into the table view
		private void LoadData() throws SQLException
		{
			try 
			{
				statement=connection.prepareStatement("select * from rooms");
				
				set=statement.executeQuery();
				
			
			
			while(set.next())

			{
				try 
				{ // add data from database into table
					data.add(new HotelRoom(set.getString(1),set.getString(2),set.getString(3)));
				} 
				catch (SQLException e) 
				{
				
					e.printStackTrace();
				}
				
			} 
			}
			catch (SQLException e1)
			{
				
				e1.printStackTrace();
			}
			tableview.setItems(data);
			
			 
		   
		}
		
		
		// constructor to establish database connection
		public DisplaymenuController()
		{
			connection=DataSource.connectdb();
		} 

	    
}
