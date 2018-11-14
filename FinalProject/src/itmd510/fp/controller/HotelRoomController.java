	package itmd510.fp.controller;

import javafx.scene.Node;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.Foodmenu;
import itmd510.fp.model.HotelRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oracle.jdbc.OracleResultSet;

public class HotelRoomController implements Initializable
{
	public HotelRoom H=new HotelRoom();     // Object creation of HotelRoom model
	
	 Stage dialogStage= new Stage();
	    Scene scene;
	    
	Connection connection=null;
   PreparedStatement statement=null;
   ResultSet set=null;
	
   private ObservableList<HotelRoom> data;
	  @FXML
	    private Button confirm;

	    @FXML
	    private TextField number;

	    @FXML
	    private TextArea Address;

	    @FXML
	    private ListView<String> listview;

	    @FXML
	    private TextField name;

	    @FXML
	    private TableView<HotelRoom> tableview;

	    @FXML
	    private TableColumn<?, ?> col2;

	    @FXML
	    private TableColumn<?, ?> col3;

	    @FXML
	    private TextField t1;

	    @FXML
	    private TextField t2;

	    @FXML
	    private TableColumn<?, ?> col1;

	    @FXML
	    private TextField t3;
	    
	    @FXML
	    private TextField cid;
	    
	    @FXML
	    private Label info;
	    
	    //method to call or view amenities

	    @FXML
	    void gotosearchhotels(ActionEvent event) 
	    {
	    	try
			  {	
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Amenities.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("Amenities");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    	
	    }
	    
	    //method to call ratings
	    @FXML
	    void rateus(ActionEvent event) 
	    {
	    	 try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Ratings.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("RATE US");
			  stage.setScene(new Scene(root1));
			  stage.show();
			
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }

	    }
	    
		@Override
		public void initialize(URL location, ResourceBundle resources)
		{
		
			cid.setText(autoCustomerID());  // method call to create auto customer id
			
			data = FXCollections.observableArrayList();
			
			setcelltable();   //to set table
			try {
				LoadData();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//event on which click of a row will populate data in textfields
			tableview.setOnMouseClicked(e -> 
			{  System.out.println("Hello");
			
			{
				//String a=tableview.getSelectionModel().getSelectedItem().getFood().valueOf(i);
		  	t1.setText(tableview.getSelectionModel().getSelectedItem().getRoomNo());
			
			t2.setText(tableview.getSelectionModel().getSelectedItem().getRoom());	
			t3.setText(tableview.getSelectionModel().getSelectedItem().getRate());	
			
			
			}
			});
			
			confirm.setOnAction(e -> BookHotel());
			
			
		}

		//method to create auto customer id
		private String autoCustomerID()
		{
		String cid="";
		String sql="select count(cid) from roombooking";
		try
		{
			PreparedStatement statement=connection.prepareStatement(sql);
		    OracleResultSet set=(OracleResultSet) statement.executeQuery();
		    set.next();
		    if(set.getInt(1)==0)
		    	cid="C001";
		    else
		    {
		    	 sql="select max(cid) from roombooking";
		    	statement=connection.prepareStatement(sql);
		    	set=(OracleResultSet) statement.executeQuery();
		    	set.next();
		    	cid=set.getString(1);
		    	int x=Integer.parseInt(cid.substring(1))+1;
		    	int n=String.valueOf(x).length();
		    	cid=cid.substring(0, 4-n) + String.valueOf(x);
		    	
		    }
		    	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return cid;
		}
	    
		public void BookHotel() 
		{
	
			try
    		{
			
			
				// method to book a hotel room
    		if(H.Confirmroom(cid.getText(),t1.getText(),t2.getText(),t3.getText(),name.getText(),Address.getText(),number.getText()))
    		{
    			
		   		 
		   		infobox("We have confirmed your Booking..We are waiting to have you at our Hotel",null,"Success");
		   		try
				  {
		   			
		   		
				  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Ratings.fxml"));
				  Parent root1 = (Parent)fxmlloader.load();
				  Stage stage=new Stage();
				  stage.initStyle(StageStyle.DECORATED);
				  stage.setTitle("RATE US");
				  stage.setScene(new Scene(root1));
				  stage.show();
				  }
				  catch(Exception e)
				  {
					  System.out.println("Cannot load new window");
				  }
		   		
    		}
    		else
    		{
    			
    			infobox("Sorry we cannot get you registered as we have observed some input issues",null,"Failed");
    		}
    		
    		}
    		catch(Exception e)
    		{
    			infobox("Sorry we cannot get you registered as we have observed some input issues",null,"Failed");
    			e.printStackTrace();
    		}
    		
			
			
			
		}


		public static void infobox(String infomessage,String headerText,String title)
		{
		
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(infomessage);
			alert.setHeaderText(headerText);
			alert.setTitle(title);
			alert.showAndWait();
			
			
		}

		//method to set a column of a table
		private void setcelltable()
		{
			col3.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
			col2.setCellValueFactory(new PropertyValueFactory<>("Room"));
			col1.setCellValueFactory(new PropertyValueFactory<>("Rate"));
		}	

//method to load data from database into the tableview
		private void LoadData() throws SQLException
		{
			try 
			{
				statement=connection.prepareStatement("select * from rooms");
				
				set=statement.executeQuery();
				
			
			
			while(set.next())

			{
				try 
				{
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
			
						//constructor to establish connection with the database.
		public HotelRoomController()
		{
			connection=DataSource.connectdb();
		} 

	    

} //end of class.
