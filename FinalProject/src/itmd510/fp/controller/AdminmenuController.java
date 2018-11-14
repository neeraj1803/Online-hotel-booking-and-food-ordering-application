package itmd510.fp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminmenuController 
{

	// method to add food item into the menu
	@FXML
    void addmenu(ActionEvent event) 
	{

		try
		  {
			
			
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/AdminaddMenu.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("ADD MENU");
		  stage.setScene(new Scene(root1));
		  stage.show();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
    }

	
	// method call to update the food rate in the menu
    @FXML
    void updatemenu(ActionEvent event) 
    {
    	try
		  {
    		
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Adminmenuupdatedelete.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("UPDATE MENU");
		  stage.setScene(new Scene(root1));
		  stage.show();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
    }

    //method call to delete food item from the menu
    @FXML
    void deletemenu(ActionEvent event)
    {
    	try
		  {
    		
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Adminmenuupdatedelete.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("DELETE MENU");
		  stage.setScene(new Scene(root1));
		  stage.show();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
    }

  //method call to updateroom rate
    @FXML
    void updateroominformation(ActionEvent event)
    {
    	try
		  {
  	
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Adminupdatedelroom.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("UPDATE ROOM RATES");
		  stage.setScene(new Scene(root1));
		  stage.show();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
    }
    
   // method call to delete room
    @FXML
    void deleteroom(ActionEvent event)
    {

    	try
		  {
  		
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Adminupdatedelroom.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("DELETE ROOM");
		  stage.setScene(new Scene(root1));
		  stage.show();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
    }

    // method call to add room 
    @FXML
    void addroom(ActionEvent event)
    {

    	//AdminaddRoomController
    	
    	try
		  {
		
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/AdminaddRoom.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("ADD ROOM INFORMATION");
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
    
    // method call to view menu
    @FXML
    void viewmenu(ActionEvent event) 
    {
    	try
		  {
		
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/viewmenu.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		 
		  stage.setTitle("VIEW MENU");
		  stage.setScene(new Scene(root1));
		  stage.show();
		 
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }

    }

    //method call to display menu
    @FXML
    void viewroom(ActionEvent event) 
    {
    	try
		  {
		
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
	
}  // end of class
