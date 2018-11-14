package itmd510.fp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelAdminmenuController 
{
	
	//method to call add menu method
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

	//method to call update menu 
    @FXML
    void updatemenu(ActionEvent event) 
    {
    	try
		  {
			
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Hotelownerupdatemenu.fxml"));
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

  //method to update room rates
    @FXML
    void updateroominformation(ActionEvent event)
    {
    	// hotel owner can update room rates
    	
    	try
		  {
			
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Hotelownerupdateroom.fxml"));
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

   //method call to add rooms 
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
  		((Node)event.getSource()).getScene().getWindow().hide(); 
  	  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Sample.fxml"));
  	  Parent root1 = (Parent)fxmlloader.load();
  	  
  	  Stage stage=new Stage();
  	  stage.initStyle(StageStyle.DECORATED);
  	  stage.setTitle("WELCOME USER");
  	  stage.setScene(new Scene(root1));
  	  stage.show();
  	
  	  }
  	  catch(Exception e)
  	  {
  		  System.out.println("Cannot load new window");
  	  }
    }

    //method call to view hotel menu
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

    
    //method call to view rooms
    @FXML
    void viewrooms(ActionEvent event) 
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

}  //end of class
