package itmd510.fp.controller;


import java.io.IOException;
import com.sun.glass.ui.Window.Level;
import com.sun.javafx.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SearchhotelController 


{
	
	   @FXML
	    private Label h1;

	    @FXML
	    private Label h2;
	    
	    //methodcall to go to tariff
	    @FXML
	    void tariff(ActionEvent event) 
	    {
	    	try
			  {	
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/tariff.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("TARIFF & PACKAGES");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

	    @FXML
	    void bookneerajsdelight(ActionEvent event) 
	    {

	    	  try
			  {
	    		  ((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/searchroom.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("SEARCH ROOMS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

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

	  
	   
	    
	    @FXML
	    void gohome(ActionEvent event) 
	    {
	    	try
			  {
	    		
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