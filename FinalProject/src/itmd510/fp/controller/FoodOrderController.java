package itmd510.fp.controller;



import java.beans.EventHandler;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.ResourceBundle;

import com.sun.glass.events.MouseEvent;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.AlertBox;
import itmd510.fp.model.FieldValidation;
import itmd510.fp.model.Foodmenu;
import itmd510.fp.model.Order;
import itmd510.fp.model.Registration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oracle.jdbc.OracleResultSet;
import oracle.net.aso.e;
import javafx.scene.Node;

public class FoodOrderController implements Initializable
{
	
	public Order O = new Order();  //Object creation of Order Model
	
	 Stage dialogStage= new Stage();
	    Scene scene;
	    
	Connection connection=null;
    PreparedStatement statement=null;
    ResultSet set=null;
    
    private ObservableList<Foodmenu> data;

    @FXML
    private ListView<String> listview;

      @FXML
        private TableView<Foodmenu> tableview;

        @FXML
        private TableColumn<?,?> col2;

       @FXML
        private TableColumn<?,?> col1;
       
       @FXML
       private Label o1;

       @FXML
       private Label fnamev;


	@FXML
       private Label o2;


       @FXML
       private Button confirm;

       @FXML
       private TextField t1;

       @FXML
       private TextField t2;


       @FXML
       private TextField number;
       
       @FXML
       private TextArea Address;

       @FXML
       private TextField name;
	

       @FXML
       private TextField cid;
       @FXML
       private Label numberv;

       
       
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	
	{   
		cid.setText(autoCustomerID());   // method to auto initialize customer id
		// TODO Auto-generated method stub
		// combobox.setItems(list);
		//ObservableList<Object> data = FXCollections.observableArrayList();
	
		data = FXCollections.observableArrayList();
		
		setcelltable();
		try {
			LoadData();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		
				
	/*tableview.setOnMousePressed(new EventHandler<MouseEvent>()  {
						@Override
						public void handle(MouseEvent mouseEvent)
						{
							mouseEvent.consume();
							System.out.println("you clicked me");
						}
				
					} ); */
		
		
		// event which selects an row from table and prints in the Textfield
		tableview.setOnMouseClicked(e -> 
		{  System.out.println("Hello");
		
		{
			//String a=tableview.getSelectionModel().getSelectedItem().getFood().valueOf(i);
	  	t1.setText(tableview.getSelectionModel().getSelectedItem().getFood());
		
		t2.setText(tableview.getSelectionModel().getSelectedItem().getRate());	
		
		
		}
		});
		
		
		//button calling method Orderfood()
		confirm.setOnAction(e -> Orderfood());
		
		
		

		}  // end of initialize method
		
	
	// to create auto customer id
	private String autoCustomerID()
	{
	String cid="";
	String sql="select count(cid) from cus_order";
	try
	{
		PreparedStatement statement=connection.prepareStatement(sql);
	    OracleResultSet set=(OracleResultSet) statement.executeQuery();
	    set.next();
	    if(set.getInt(1)==0)
	    	cid="C001";
	    else
	    {
	    	 sql="select max(cid) from cus_order";
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
	

		public void Orderfood() 
		{
	
			try
    		{
			
				
				
    		if(O.Confirmorder(cid.getText(),t1.getText(),t2.getText(),name.getText(),Address.getText(),number.getText()))
    		{
    			
		   	
    			
    	    	
    	    	
    	   
		   		try
				  {
		   			
		   			infobox("We will redirect you to Payment Gateway..Trust us its really quick!!",null,"Success");
				  FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Payment.fxml"));
				  Parent root1 = (Parent)fxmlloader.load();
				  Stage stage=new Stage();
				  stage.initStyle(StageStyle.DECORATED);
				  stage.setTitle("PAYNEERAJ");
				  stage.setScene(new Scene(root1));
				  stage.show();
				  }
    	    	
    	    
    	 
    	    
				  catch(Exception e)
				  {
					  e.printStackTrace();
					  System.out.println("Cannot load new window");
				    }
    	    	}
    		
    		else
    		{
    			
    			infobox("Sorry we cannot read your card details as we have observed some input issues",null,"Failed");
    		} }
    		
    		
    		catch(Exception e)
    		{
    			infobox("Sorry we cannot read your card details as we have observed some input issues",null,"Failed");
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


private void setcelltable()
{
	col2.setCellValueFactory(new PropertyValueFactory<>("Food"));
	col1.setCellValueFactory(new PropertyValueFactory<>("Rate"));
}	


private void LoadData() throws SQLException
{
	try {
		statement=connection.prepareStatement("select * from menu");
		
		set=statement.executeQuery();
		
	
	
	while(set.next())

	{
		try {
			data.add(new Foodmenu(set.getString(1),set.getString(2)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	catch (SQLException e1)
	{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	tableview.setItems(data);
	
	 
   
    
	

	
}
	
				
public FoodOrderController()
{
	connection=DataSource.connectdb();
} 


@FXML
void rateus(ActionEvent event) 
{
	 try
	  {
		((Node)event.getSource()).getScene().getWindow().hide(); 
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
