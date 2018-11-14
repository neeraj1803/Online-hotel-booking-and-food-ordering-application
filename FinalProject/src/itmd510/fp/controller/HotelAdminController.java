package itmd510.fp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import itmd510.fp.model.HotelAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelAdminController 
{
	public HotelAdmin A = new HotelAdmin();   // object creation of HotelAdmin Model

	 @FXML
	    private TextField ausername;

	    @FXML
	    private Label adminlabel;

	    @FXML
	    private PasswordField apassword;

	    
	    Stage dialogStage= new Stage();
	    Scene scene;
	    
	    
	    Connection connection=null;
	    PreparedStatement statement=null;
	    ResultSet set=null;
	    
	    //method for hotel admin login
	    @FXML
	    void adlogin(ActionEvent event)
	    {
	    	try
	    	{
	    	if(A.AdminLogin(ausername.getText(),apassword.getText()))
	    	{
	    		    infobox("Mr Hotel Owner You are all set to go ahead!!",null,"Success");
			   		Node node=(Node) event.getSource();
			   		dialogStage=(Stage)node.getScene().getWindow();
			   		dialogStage.close();
			   		scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/HotelAdminmenu.fxml")));
			   		dialogStage.setScene(scene);
			   		dialogStage.show();
			}
	    	else
	    	{
	    		 infobox("Mr Hotel Owner Please enter proper Credentials!!",null,"Failed");
	    		
	    	}
	    	}
	    	catch(Exception e)
	    	{
	    		
	    		e.printStackTrace();
	    		
	    	}
	     }
	    
	    //method to create alert box
	    public static void infobox(String infomessage,String headerText,String title)
	  		{
	  		
	  			Alert alert = new Alert(AlertType.CONFIRMATION);
	  			alert.setContentText(infomessage);
	  			alert.setHeaderText(headerText);
	  			alert.setTitle(title);
	  			alert.showAndWait();
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

}  // end of class
