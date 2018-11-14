package itmd510.fp.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.FieldValidation;
import itmd510.fp.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oracle.jdbc.OracleResultSet;

public class TablebookController implements Initializable
{
	Table T=new Table();   //object creation of Table Model
	Connection connection=null;
    PreparedStatement statement=null;
    ResultSet set=null;
    
    
	 @FXML
	    private TextField mbnumber;

	    @FXML
	    private Button tab3;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextField cid;

	    @FXML
	    private Button tab1;

	    @FXML
	    private Button tab2;


	    @FXML
	    private ComboBox<String> time;

	    @FXML
	    private Label timel;

	    @FXML
	    private Button tab4;
	    
	    @FXML
	    private Button tab9;

	    @FXML
	    private Button tab7;

	    @FXML
	    private Button tab8;

	    @FXML
	    private Button tab5;
	    
	    @FXML
	    private Button tab6;
	    
	    @FXML
	    private Label error1;

	    @FXML
	    private Label error;
	    
	    @FXML
	    private Label print;
	    
	    Stage dialogStage= new Stage();
	    Scene scene;
	    
	   

//observable list
	    ObservableList<String> list = (ObservableList<String>) FXCollections.observableArrayList("12PM","1PM","2PM","7PM","8PM","9PM","10PM","11PM");
	    
		@Override
		public void initialize(URL location, ResourceBundle resources)
		{
			cid.setText(autoCustomerID());
			time.setItems(list);
			tab1.setOnAction(e -> booktable1());
			tab7.setOnAction(e -> booktable1());
			
			tab2.setOnAction(e -> booktable1());
			tab4.setOnAction(e -> booktable1());
			tab8.setOnAction(e -> booktable1());
			tab9.setOnAction(e -> booktable1());
			
			tab3.setOnAction(e -> booktable1());
			tab5.setOnAction(e -> booktable1());
			tab6.setOnAction(e -> booktable1());
			
			
			
		}

		
		  void loadtime(ActionEvent event)
		    {
		    	String guest=time.getSelectionModel().getSelectedItem().toString();
		    	timel.setText(time.toString());
		    }
		  
		  //method to insert booked table into database
	     public void booktable1() 
	     {
	    	 boolean isTextFieldNotEmpty=FieldValidation.isTextFieldNotEmpty(name, error, "Field Cannot be Left Empty");
		    	boolean isTextFieldNotEmpty1=FieldValidation.isTextFieldNotEmpty1(mbnumber, error1, "Field Cannot be Left Empty");
		    	
		    	if(isTextFieldNotEmpty && isTextFieldNotEmpty1)
		    	{
		    		try
		    		{
		    		if(T.tablebook(cid.getText(),name.getText(),mbnumber.getText(),time.getSelectionModel().getSelectedItem().toString()))
		    		{
		    			infobox("You have booked a table!! Be on Time or else we will have to reserve it someone else!!!",null,"Success");
		    			
				   		scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/sample.fxml")));
				   		dialogStage.setScene(scene);
				   		dialogStage.show();
				   		scene.getWindow().hide();
				   		
		    			
		    		}
		    		else
		    		{
		    			
		    			infobox("Sorry we cannot process your request as have observed some input issues on your side",null,"Failed");
		    		}
		    		
		    		}
		    		catch(Exception e)
		    		{
		    			infobox("Sorry we cannot process your request as have observed some input issues on your side",null,"Failed");
		    		}
		    		
		    		
		    		
		    	}
			
		}  // end of booktable1
	     
	     public static void infobox(String infomessage,String headerText,String title)
			{
			
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText(infomessage);
				alert.setHeaderText(headerText);
				alert.setTitle(title);
				alert.showAndWait();
				
				
			}
	     
		//constructor
		 public TablebookController()
		    {
		    	connection=DataSource.connectdb();
		    }
		 
		 
		private String autoCustomerID()
		{
		String cid="";
		String sql="select count(cid) from tablebooking";
		try
		{
			PreparedStatement statement=connection.prepareStatement(sql);
		    OracleResultSet set=(OracleResultSet) statement.executeQuery();
		    set.next();
		    if(set.getInt(1)==0)
		    	cid="C001";
		    else
		    {
		    	 sql="select max(cid) from tablebooking";
		    	statement=connection.prepareStatement(sql);
		    	set=(OracleResultSet) statement.executeQuery();
		    	set.next();
		    	cid=set.getString(1);
		    	int x=Integer.parseInt(cid.substring(1))+1;
		    	int n=String.valueOf(x).length();
		    	cid=cid.substring(0, 4-n) + String.valueOf(x);
		    	
		    }
		    	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return cid;
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
	    


}
//end of class