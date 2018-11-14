package itmd510.fp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.AdminaddMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminaddMenuController 
{
	
	public AdminaddMenu AD = new AdminaddMenu();
	
	
    
  @FXML
    private TextField addrate;

    @FXML
    private Label admin;

    @FXML
    private TextField addfood;
    
    Stage dialogStage= new Stage();
    Scene scene;
    Connection connection=null;
    PreparedStatement statement=null;
    ResultSet set=null;
    
    public AdminaddMenuController()
	{
		// call to Datasource class to establish database connection
		connection=DataSource.connectdb();
	}
    

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


    @FXML
    void AddMenu(ActionEvent event) 
    {
    	
    	try
		{
		if(AD.Addmenu(addfood.getText(),addrate.getText()))
		{
			((Node)event.getSource()).getScene().getWindow().hide(); 
			infobox("You have added the new Food item into the Menu",null,"Success");  // alert box post a successful result.
	   		//Node node=(Node) event.getSource();
	   		//dialogStage=(Stage)node.getScene().getWindow();
	   		//dialogStage.close();
	   		// scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/AdminType.fxml")));
	   		//dialogStage.setScene(scene);
	   	//	dialogStage.show();
	   		
			
		}
		else
		{
			
			infobox("Sorry we cannot get the item added as we have observed some input issues",null,"Failed");
		}
		
		}
		catch(Exception e)
		{
			infobox("Sorry we cannot get the item added as we have observed some input issues",null,"Failed");
		}
		
		
	}
			
    //method to create a alert box
    public static void infobox(String infomessage,String headerText,String title)
	{
	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infomessage);
		alert.setHeaderText(headerText);
		alert.setTitle(title);
		alert.showAndWait();
		
		
	}
    
    // call to view menu method
    @FXML
    void viewmenu(ActionEvent event)
    {
    	try
		  {
		 ((Node)event.getSource()).getScene().getWindow().hide(); 
		  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/viewmenu.fxml"));
		  Parent root1 = (Parent)fxmlloader.load();
		  Stage stage=new Stage();
		  stage.initStyle(StageStyle.DECORATED);
		 
		  stage.setTitle("MENU");
		  stage.setScene(new Scene(root1));
		  stage.show();
		 
		  }
		  catch(Exception e)
		  {
			  System.out.println("Cannot load new window");
		  }
    }

    
    }	// end of the class
    	
    	
	
	
	


