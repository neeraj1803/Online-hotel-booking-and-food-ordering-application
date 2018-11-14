package itmd510.fp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.AdminaddMenu;
import itmd510.fp.model.AdminaddRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminaddRoomController 
{
	public AdminaddRoom room = new AdminaddRoom();   // Object creation of Adminaddroom Model
	
    Stage dialogStage= new Stage();
    Scene scene;
    Connection connection=null;
    PreparedStatement statement=null;
    ResultSet set=null;
	
	@FXML
    private TextField roomno;

    @FXML
    private Label l1;

    @FXML
    private TextField rate;

    @FXML
    private TextField roomtype1;
    @FXML
    private TextField rate1;

    @FXML
    private Label l2;

    @FXML
    private TextField roomno1;

    @FXML
    private TextField roomtype;
    
    public AdminaddRoomController()
  	{
  		//database connection call to Datasource class
  		connection=DataSource.connectdb();
  	}
      
    //call to view rooms method
    @FXML
    void viewroom(ActionEvent event) 
    {
    	try
		  {
		((Node)event.getSource()).getScene().getWindow().hide(); 
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Displaymenu.fxml"));
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
 // admin add room method for neeraj's delight
    @FXML
    void addroom1(ActionEvent event) 
    {
    	try
		{
		if(room.Addroom(roomno.getText(),roomtype.getText(),rate.getText()))
		{
			
			infobox("You have added the new Room into the Website",null,"Success");  //Alert box
	   		Node node=(Node) event.getSource();
	   		dialogStage=(Stage)node.getScene().getWindow();
	   		dialogStage.close();
	   		//scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/AdminType.fxml")));
	   		//dialogStage.setScene(scene);
	   		//dialogStage.show();
	   		
			
		}
		else
		{
			
			infobox("Sorry we cannot get the room added as we have observed some input issues",null,"Failed");
		}
		
		}
		catch(Exception e)
		{
			infobox("Sorry we cannot get the room added as we have observed some input issues",null,"Failed");
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
    
    // admin add room method for holiday inn
    @FXML
    void addroom2(ActionEvent event)
    {
    	try
		{
		if(room.Addroom(roomno.getText(),roomtype.getText(),rate.getText()))
		{
			
			infobox("You have added the new Room into the Website",null,"Success");
	   		Node node=(Node) event.getSource();
	   		dialogStage=(Stage)node.getScene().getWindow();
	   		dialogStage.close();
	   		scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/AdminType.fxml")));
	   		dialogStage.setScene(scene);
	   		dialogStage.show();
	   		
			
		}
		else
		{
			
			infobox("Sorry we cannot get the room added as we have observed some input issues",null,"Failed");
		}
		
		}
		catch(Exception e)
		{
			infobox("Sorry we cannot get the room added as we have observed some input issues",null,"Failed");
		}
		
		

    }
    
    //method call to go to home page
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
		 
		  stage.setTitle("HOME PAGE");
		  stage.setScene(new Scene(root1));
		  stage.show();
		 
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }

    }

}  //End of the class
