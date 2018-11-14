package itmd510.fp.controller;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import java.beans.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import itmd510.fp.Main;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.FieldValidation;
import itmd510.fp.model.Login;
import itmd510.fp.model.Registration;

public class RegistrationController implements Initializable

{
	public Registration R = new Registration();
	
	
    @FXML
    private Label usercheck;
	  @FXML
	    private TextField fname;

	    @FXML
	    private TextField lname;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private TextField Number;

	    @FXML
	    private Label label;

	    @FXML
	    private PasswordField confirmpassword;

	    @FXML
	    private TextField username;
	    
	    @FXML
	    private Label numvalidate;
	    
	    @FXML
	    private Label usernameerror;
	    

	    @FXML
	    private Label passworderror;
	    

	    @FXML
	    private Label fnamev;
	    
	    @FXML
	    private Label lnamev;
	    
	    Stage dialogStage= new Stage();
	    Scene scene;
	  
		
	    Connection connection=null;
	    PreparedStatement statement=null;
	    ResultSet set=null;
	    
	    public RegistrationController()
	    {
	    	connection=DataSource.connectdb();
	    }
	    
	    @FXML
	    void GOHOME(ActionEvent event)
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
	    
	    @FXML
	    void createmyaccount(ActionEvent event) throws SQLException,IOException
	    {	
	    	
	    	
	    	boolean isValidEmail=FieldValidation.isValidEmail(username, usernameerror, "Please enter valid email id again!!!");
	    	boolean isPasswordMatched=FieldValidation.isPasswordMatched(password, confirmpassword, passworderror, "Password does not match!! Please type the same passwords");
	    	boolean isTextFieldNotEmpty=FieldValidation.isTextFieldNotEmpty(fname, fnamev, "Field Cannot be Left Empty");
	    	boolean isTextFieldNotEmpty1=FieldValidation.isTextFieldNotEmpty1(lname, lnamev, "Field Cannot be Left Empty");
	    	boolean isMobileNumber=FieldValidation.isMobileNumber(Number, numvalidate, "Enter a Valid Mobile Number");
	    	if(isValidEmail && isPasswordMatched && isTextFieldNotEmpty && isTextFieldNotEmpty1 && isMobileNumber)
	    	{
	    		usernameerror.setText("Valid Email");
	    		passworderror.setText("Passwords Match");
	    		
	    		try
	    		{
	    		if(R.RegisterMe(fname.getText(),lname.getText(),username.getText(),password.getText(),confirmpassword.getText(),Number.getText()))
	    		{
	    			
	    			infobox("You have successfully registered!! You can Login now.",null,"Success");
			   		Node node=(Node) event.getSource();
			   		dialogStage=(Stage)node.getScene().getWindow();
			   		dialogStage.close();
			   		scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/Login.fxml")));
			   		
			   		dialogStage.setScene(scene);
			   		dialogStage.show();
			   		
	    		}
	    		else
	    		{
	    			
	    			infobox("Sorry we cannot get you registered as we have observed some input issues",null,"Failed");
	    		}
	    		
	    		}
	    		catch(Exception e)
	    		{
	    			infobox("Sorry we cannot get you registered as we have observed some input issues",null,"Failed");
	    		}
	    		
	    		
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

		public void Getuser(String user)
		{
			
			usercheck.setText(user);
		}
		@Override
		public void initialize(URL location, ResourceBundle resources) 
		{
			// TODO Auto-generated method stub
			
			
		}
		
	    	
	    	
	    	
	    }


