package itmd510.fp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminTypeController 
{
	
	  @FXML
	    private Label alabel;

	    @FXML
	    private Label ownerlabel;

	    // method call to admin login
	    @FXML
	    void adminlogin(ActionEvent event) 
	    {
	    	try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Admin.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("ADMIN PAGE");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
			  
	    	
	    }
	    
	    // method call to hotelowner login 
	    @FXML
	    void ownerlogin(ActionEvent event) 
	    {
	    	try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/HotelAdmin.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("HOTEL ADMIN");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
			  

	    }

// method call to go to home page
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
	    //method call to view menu
	    @FXML
	    void gotomenu(ActionEvent event) 
	    {
	    	try
			  {
	  		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/viewmenu.fxml"));
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
	    
	    
	    // method call to display room information
	    @FXML
	    void gotorooms(ActionEvent event) 
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
				  e.printStackTrace();
			  }
	    }

}
