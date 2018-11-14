package itmd510.fp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.Adminupdateroom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelownerupdateroomController
{	
	Adminupdateroom up = new Adminupdateroom();   //Object creation of Adminupdateroom model
	
	Stage dialogStage= new Stage();
    Scene scene;
    Connection connection=null;
    PreparedStatement statement=null;
    ResultSet set=null;
    
    //constructor to call Datasource class and establish connection
    public HotelownerupdateroomController()
  	{
  		
  		connection=DataSource.connectdb();
  	}

	 @FXML
	    private TextField roomno;

	    @FXML
	    private TextField rate;

	    //method to call update room
	    @FXML
	    void updateroom(ActionEvent event) 
	    {
	    	try
			{
			if(up.updateroom(rate.getText(),roomno.getText()))
			{
				
				infobox("You have updated the room rate on the Website",null,"Success");
		   		Node node=(Node) event.getSource();
		   		dialogStage=(Stage)node.getScene().getWindow();
		   		dialogStage.close();
		   		//scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/AdminType.fxml")));
		   	//	dialogStage.setScene(scene);
		   	//	dialogStage.show();
		   		
				
			}
			else
			{
				
				infobox("Sorry we cannot get the room rate updated as we have observed some input issues",null,"Failed");
			}
			
			}
			catch(Exception e)
			{
				infobox("Sorry we cannot get the room rate updated  as we have observed some input issues",null,"Failed");
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

	    //method to view rooms
	    @FXML
	    void viewrooms(ActionEvent event) 
	    {
	    	try
			  {
	  		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Displaymenu.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("VIEW ROOMS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

	    //method call to go to homepage
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
} //end of class
