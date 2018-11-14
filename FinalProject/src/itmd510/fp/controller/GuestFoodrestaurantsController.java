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

public class GuestFoodrestaurantsController 
{
	 @FXML
	    private Label time1;

	    @FXML
	    private Label time2;

	    @FXML
	    private Label time3;

	    @FXML
	    private Label cuisines4;

	    @FXML
	    private Label cuisines3;

	    @FXML
	    private Label time4;

	    @FXML
	    private Label cuisines2;

	    @FXML
	    private Label cuisines1;

	    @FXML
	    private Label title1;

	    @FXML
	    private Label title2;

	    @FXML
	    private Label title3;

	    @FXML
	    private Label title4;

	    // method call to view bombay wrap menu

	    @FXML
	    void showbombaywrapmenu(ActionEvent event)
	    {
	    	try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/viewmenu.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("Main Window");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

	   

	    //method call to view global fusion menu

	    @FXML
	    void viewglobalfusionmenu(ActionEvent event) 
	    {
	    	 try
			  {
	    		 ((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/viewmenu.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("Main Window");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }

	    }

	    //method call to go to home page.
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
	    } //end of class

	 

	  


	  

	  
}
