package itmd510.fp.controller;

import java.net.URL;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.SearchRoom;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oracle.jdbc.OracleResultSet;

public class SearchroomController implements Initializable
{
	SearchRoom SR=new SearchRoom();  //object creation of SearchRoom Model
	
	 Stage dialogStage= new Stage();
	    Scene scene;
	    
	Connection connection=null;
 PreparedStatement statement=null;
 ResultSet set=null;
	

 
 	@FXML
 	private Label rt;

 	@FXML
 	private Label g;

    @FXML
    private Label check;
    	
    @FXML
    private Button calculateroom;
    
    //roomtypeguestsnoofrooms
    @FXML
    public ComboBox<String> roomtype;
    
    @FXML
    public ComboBox<String> guests;
    
    @FXML
    private Label noofrooms;
    
    @FXML
    private DatePicker checkin;
    
    @FXML
    private DatePicker checkout;
    
    @FXML
    private TextField cid;
    
    @FXML
    private TextField d1;

    @FXML
    private TextField d2;

    //creation of observable list
    ObservableList<String> list = (ObservableList<String>) FXCollections.observableArrayList("Classic Room","Priemere Room","Privilege Room");
    //ObservableList<Integer> list1 = (ObservableList<Integer>) FXCollections.observableArrayList(1,2,3,4,5,6,7,8);
    ObservableList<String> list1 = (ObservableList<String>) FXCollections.observableArrayList("1","2","3","4","5","6","7","8");

	@Override
	public void initialize(URL location, ResourceBundle resources)
	
	{
		cid.setText(autoCustomerID());   //auto create customer id
		roomtype.setItems(list);   //fill in the listview with the observable list
		guests.setItems(list1);
	}
    

    //constructor to establish connection with database
    public SearchroomController()
    {
    	connection=DataSource.connectdb();
    }
    
    //method to print date into a text field
    @FXML
    void showdate(ActionEvent event)
    {
    	LocalDate ld=checkin.getValue();
    	d1.setText(ld.toString());
    }

    @FXML
    void showdate1(ActionEvent event) 
    {
    	LocalDate ld=checkout.getValue();
    	d2.setText(ld.toString());
    }
    
    void noofguest(ActionEvent event)
    {
    	String guest=guests.getSelectionModel().getSelectedItem().toString();
    	g.setText(guests.toString());
    }
    
    void roomtypes(ActionEvent event)
    {
    	String rooms=roomtype.getSelectionModel().getSelectedItem().toString();
    	rt.setText(roomtype.toString());
    }
    
    //method to search hotel rooms
    @FXML
    void SearchHotel(ActionEvent event)
    {
    	
    		
      	
    	try
		{
		
    		((Node)event.getSource()).getScene().getWindow().hide(); 
			
		if(SR.Roomsearch(cid.getText(),roomtype.getPromptText(),guests.getPromptText(),d1.getText(),d2.getText()))
		{
			
			infobox("We have offers in other room types too..Have a look at the rates of all Rooms",null,"Success");
			
	   		
	   	 FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Bookroom1.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("Hotel Neeraj's Delight Booking");
		  stage.setScene(new Scene(root1));
		  stage.show();
	   		
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
    
 // to create auto customer id
 	private String autoCustomerID()
 	{
 	String cid="";
 	String sql="select count(cid) from searchedrooms";
 	try
 	{
 		PreparedStatement statement=connection.prepareStatement(sql);
 	    OracleResultSet set=(OracleResultSet) statement.executeQuery();
 	    set.next();
 	    if(set.getInt(1)==0)
 	    	cid="C001";
 	    else
 	    {
 	    	 sql="select max(cid) from searchedrooms";
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
	
	    @FXML
	    void gototariff(ActionEvent event)
	    {
	    	
	    	try
			  {	
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/tariff.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("TARIFF'S");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    	
	    }

	
	    @FXML
	    void gohome(ActionEvent event) 
	    {
	    	try
			  {	
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/sample.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("HOMEPAGE");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }

	    }

	
	   
}
//end of class