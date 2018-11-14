package itmd510.fp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import itmd510.fp.model.AdmindeleteMenu;
import itmd510.fp.model.AdminupdateMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminmenuupdatedeleteController 
{
	AdmindeleteMenu AD = new AdmindeleteMenu();  // object creation of admindeletemenu  model
	
	AdminupdateMenu AU =new AdminupdateMenu();   // object creation of adminupdatemenu  model
	
	 Stage dialogStage= new Stage();
	    Scene scene;
	    Connection connection=null;
	    PreparedStatement statement=null;
	    ResultSet set=null;
	    
    @FXML
    private TextField rate;

    @FXML
    private TextField food;

    @FXML
    void updatemenu(ActionEvent event) 
    {
    	try
		{
		if(AU.Updatemenu(rate.getText(),food.getText()))
		{
			
			infobox("You have Updated the Rate of the Food item the Menu",null,"Success");
	   		Node node=(Node) event.getSource();
	   		dialogStage=(Stage)node.getScene().getWindow();
	   		dialogStage.close();
	   		//scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/Adminmenu.fxml")));
	   		//dialogStage.setScene(scene);
	   		//dialogStage.show();
	   		
			
		}
		else
		{
			
			infobox("Sorry we cannot get the Rate updated as we have observed some input issues",null,"Failed");
		}
		
		}
		catch(Exception e)
		{
			infobox("Sorry we cannot get the Rate updated as we have observed some input issues",null,"Failed");
		}
    	
    }  // End of update menu method

    //method to delete menu
    @FXML
    void deletemenu(ActionEvent event) 
    {
    	try
		{
		if(AD.Deletemenu(food.getText()))
		{
			
			infobox("You have deleted the food item from the Menu",null,"Success");
	   		Node node=(Node) event.getSource();
	   		dialogStage=(Stage)node.getScene().getWindow();
	   		dialogStage.close();
	   	//	scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/Adminmenu.fxml")));
	   	//	dialogStage.setScene(scene);
	   		//dialogStage.show();
	   	//	 System.out.println("Inserted");
			
		}
		else
		{
			
			infobox("Sorry we cannot get the item deleted as we have observed some input issues",null,"Failed");
		}
		
		}
		catch(Exception e)
		{
			infobox("Sorry we cannot get the item deleted as we have observed some input issues",null,"Failed");
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

}
