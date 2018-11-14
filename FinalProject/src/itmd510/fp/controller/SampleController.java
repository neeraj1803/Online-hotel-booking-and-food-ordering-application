package itmd510.fp.controller;


import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;

public class SampleController implements Initializable

{		
	

    @FXML
    private JFXButton button;
	
	 @FXML
	    private Tab aboutus;

	    @FXML
	    private Tab contactustab;

	    @FXML
	    private Pane hometab;
	  @FXML
	    private Label welcomemess;
	  @FXML
	    private JFXDrawer drawer;

	    @FXML
	    private JFXHamburger hamburger;

	    @FXML
	    private Button audio;
		
	    //method call to welcome page
	  @FXML
	    void Gotomainpage(ActionEvent event)
	  
	  	{
		  
		  try
		  {
			  ((Node)event.getSource()).getScene().getWindow().hide(); 
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/welcome.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("Welcome");
		  stage.setScene(new Scene(root1));
		  stage.show();
		  
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
		  
	    }	
			
	  //method call to registration page
	    @FXML
	    void Gotoregistrationpage(ActionEvent event) 
	    {
	    	 try
			  {
	    		 ((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/registration.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			 
			  stage.setTitle("REGISTRATION");
			  stage.setScene(new Scene(root1));
			  
			  stage.show();
			 
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
			  
	    	
	    	
	    }
	    //method call to go to login page

	    @FXML
	    void gotologin(ActionEvent event)
	    {
	    	try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Login.fxml"));
			  Parent root1 = (Parent)fxmlloader.load(); 
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("LOGIN");
			
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
			  
	    }

	    //method call to admin type page

	    @FXML
	    void Gotoadminloginpage(ActionEvent event) 
	    {

	    	try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/AdminType.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("ADMIN TYPE");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
			  
	    	
	    	
	    }	
	//method call to go to about us tab
	    @FXML
	    void gotoaboutustab(ActionEvent event) 
	    
	    {
	    	try
			  {
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/aboutus.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("ABOUT US");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
			  
	    	
	    }
	
	    @FXML
	    void process(ActionEvent event)
	    {
	    	try
			  {
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Process.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("OUR APPLICATION PROCESS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

	 
	    @FXML
	    void gotocontactuspage(ActionEvent event)
	    {
	    	try
			  {
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/contactus.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("CONTACT US");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

	    @FXML
	    void gotoviewphotos(ActionEvent event) 
	    {
	    	try
			  {
				  
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/photos.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("VIEW OUR PHOTOS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    	
	    }
	    
	    @FXML
	    void gotofaqs(ActionEvent event) 
	    {
	    	try
			  {
	    		
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/FAQ.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("FAQS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
	    }

		
	    

	    @FXML
	    void gotorateus(ActionEvent event) 
	    {
	    	try
	  	  {
	  		
	  	  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Ratings.fxml"));
	  	  Parent root1 = (Parent)fxmlloader.load();
	  	  
	  	  Stage stage=new Stage();
	  	  stage.initStyle(StageStyle.DECORATED);
	  	  stage.setTitle("RATINGS");
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
			// TODO Auto-generated method stub
		
			Rectangle rectangle=new Rectangle(300,100);  // 300 width an
			PathTransition pathtransition=new PathTransition();
			pathtransition.setNode(button);
			pathtransition.setDuration(Duration.seconds(5));
			pathtransition.setPath(rectangle);
			pathtransition.setCycleCount(pathtransition.INDEFINITE);
			pathtransition.play();
			
		}

			
		

	  
}

