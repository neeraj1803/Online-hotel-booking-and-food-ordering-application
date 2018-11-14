package itmd510.fp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserwelcomeController implements Initializable
{
	
	@FXML
    private Button submit;


	   @FXML
	    private Pane hi;

	    @FXML
	    private Label hello;
	    
	    @FXML
	    public ComboBox<String> combobox;
	    
	    ObservableList<String> list = (ObservableList<String>) FXCollections.observableArrayList("Search Hotel Rooms","Order Food","Book Restaurant Table");
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) 
		{
			// TODO Auto-generated method stub
			combobox.setItems(list);
		}
//method to manage combobox change		
		public void comboChanged(ActionEvent event)
		{
			if(combobox.getValue().equals("Search Hotel Rooms"))
			{
				
				submit.setOnAction(e -> searchhotelroom());
			}
			else if(combobox.getValue().equals("Order Food"))
			{
				submit.setOnAction(e -> viewmenu());
			}
			else
			{
				submit.setOnAction(e -> viewrestauranttable());
			}
		}
		
		private void searchhotelroom()
		{
			try
			  {	
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Searchhotels.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("SEARCH HOTELS");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
		}
		
		private void viewmenu()
		{
			try
			  {	
				
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Foodrestaurants.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("ORDER YOUR FOOD");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }
			
		}
		
		//viewrestauranttable
		
		
		private void viewrestauranttable()
		{
			try
			  {	
			  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/viewtable.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("VIEW RESTAURANT TABLE");
			  stage.setScene(new Scene(root1));
			  stage.show();
			  }
			  catch(Exception e)
			  {
				  System.out.println("Cannot load new window");
			  }

	}
		
		
	    @FXML
	    void GOHOME(ActionEvent event)
	    {
	    	try
			  {	
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
//end	of class