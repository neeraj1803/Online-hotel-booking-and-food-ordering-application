package itmd510.fp.controller;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import itmd510.fp.Main;
import itmd510.fp.dao.DataSource;
import itmd510.fp.model.FieldValidation;
import itmd510.fp.model.*;


public class LoginController extends Registration implements Initializable
{	
	public Login l = new Login();  //object creation of Login model
	
		@FXML
		private Label error;
	   @FXML
	    private Label llabel;

	   @FXML
	    private TextField tusername;
	    
	    @FXML
	    private Label donthaveacc;


	    @FXML
	    private Label isConnected;
	
	    @FXML
	    private PasswordField tpassword;
	    
	    @FXML
	    private Label passwordv;

	    @FXML
	    private Label usernamev;
	    
	
	    Stage dialogStage= new Stage();
	    Scene scene;
	    
	    
	    Connection connection=null;
	    PreparedStatement statement=null;
	    ResultSet set=null;
	    
	    
	    //method call to go to homepage
	    @FXML
	    void GOHOME(ActionEvent event) 
	    {
	    	try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
	    	 FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/sample.fxml"));
	    	// RegistrationController registrationcontroller=( RegistrationController)fxmlloader.getController();
	    	//registrationcontroller.Getuser(usernamev.getText());
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

	    
	/*    public LoginController()
	    {
	    	connection=DataSource.connectdb();
	    } */
	    
	 
	    
	    // method to login the user
	    @FXML
	    void CLogin(ActionEvent event) 
	    {
	    	boolean isTextFieldNotEmpty=FieldValidation.isTextFieldNotEmpty(tusername, usernamev, "Field Cannot be Left Empty");
	    	boolean isTextFieldNotEmpty1=FieldValidation.isTextFieldNotEmpty1(tpassword, passwordv, "Field Cannot be Left Empty");
	    	try
	    	{
	    		if(isTextFieldNotEmpty && isTextFieldNotEmpty1)
	    		{
	    //	if(l.isLogin(tusername.getText(),tpassword.getText()))
	    			if(l.isLogin(tusername.getText()))
	    	{
	    		
	    	
	    		isConnected.setText("username and password is correct");
	    		 infobox("Welcome..You can go to the next page!!",null,"Success");
			   		Node node=(Node) event.getSource();
			   		dialogStage=(Stage)node.getScene().getWindow();
			   		dialogStage.close();
			   		scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/Userwelcome.fxml")));
			   		dialogStage.setScene(scene);
			   		dialogStage.show();
			   		
				  
			   		
	    		
	    		
	    		
	    	}
	    	else
	    	{
	    		 infobox("Your loginID and Password does not match with our records!!",null,"Failed");
	    		isConnected.setText("Not correct");
	    	}
	    	}
	    	}
	    	catch(Exception e)
	    	{
	    		error.setText("Not correct");
	    		e.printStackTrace();
	    		
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
	    	
	    	
	    	
	    	
				//method call to signout from session
	public void signout(ActionEvent event)
	{
		try
		  {
  		((Node)event.getSource()).getScene().getWindow().hide(); 
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/sample.fxml"));
		  Parent root1 = (Parent)fxmlloader.load(); 
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		  stage.setTitle("WELCOME");
		  stage.setScene(new Scene(root1));
		  stage.show();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
		  
		
		
	}
	     
	    //method call to sign up or registration
	    @FXML
	    void gotosignuppagefromlogin(ActionEvent event)
	    {
	    	 try
			  {
	    		((Node)event.getSource()).getScene().getWindow().hide(); 
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Registration.fxml"));
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



@Override
		public void initialize(URL location, ResourceBundle resources)
		
		{
		
			if(l.isDbConnected())
			{
				
				isConnected.setText("connected");
			}
			else
			{
				isConnected.setText("not connected");
			}
			// TODO Auto-generated method stub
			
		}
	    

public static Login getUser() {
	return getUser();
}

   
	    
	    } //end of class
	
