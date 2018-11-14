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

public class GuestSearchHotelsController 
{
	

	   @FXML
	    private Label h1;

	    @FXML
	    private Label h2;

	   //method call to view amenities

	    @FXML
	    void getamenitiesforneeraj(ActionEvent event) 
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

	    //method to call reviews for the hotel
	    @FXML
	    void getreviewforneeraj(ActionEvent event)
	    {
	    	try
			  {	
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Guestreview.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("GUEST REVIEWS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

	  

	 
//method to get reviews of hotel
	    @FXML
	    void guesreviewforholidayinn(ActionEvent event) 
	    {
	    	try
			  {	
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Guestreview.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("GUEST REVIEWS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }

	    }
	    
	   //method to call or go to homepage
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
	    
	    //method to call tariff page
	    @FXML
	    void gototariff(ActionEvent event) 
	    {
	    	try
			  {	
	    		
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
	    
	    

}  //end of class
