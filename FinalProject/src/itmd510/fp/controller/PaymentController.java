package itmd510.fp.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.sun.glass.ui.Window;

import itmd510.fp.model.FieldValidation;
import itmd510.fp.model.Login;
import itmd510.fp.model.Order;
import itmd510.fp.model.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PaymentController extends FoodOrderController implements Initializable
{
	
	public Payment p = new Payment();  //object creation of Payment model
	
    @FXML
    private TextField mm;

    @FXML
    private TextField number;



    @FXML
    private TextField yyyy;

    @FXML
    private PasswordField cvv;



    @FXML
    private Label label;

    @FXML
    private Label validity;
    
    @FXML
    private Label cvvl;
    
    @FXML
    private Label number1;
    
    @FXML
    private Label carderror;

 
    @FXML
    private Label cvverrror;

    @FXML
    private Label mmyyerror;

  
    Stage dialogStage= new Stage();
    Scene scene;
    
    
    Connection connection=null;
    PreparedStatement statement=null;
    ResultSet set=null;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
	
		//amount.setPromptText(getT2());
		// TODO Auto-generated method stub
		//amount.setText();
		
		
	}
    //method to make payment
	  @FXML
	    void pay(ActionEvent event) 
	    {

		  boolean isTextFieldNotEmpty=FieldValidation.isTextFieldNotEmpty(number, carderror, "Field Cannot be Left Empty");
	    	boolean isTextFieldNotEmpty1=FieldValidation.isTextFieldNotEmpty1(yyyy, mmyyerror, "Field Cannot be Left Empty");
	    	boolean isTextFieldNotEmpty2=FieldValidation.isTextFieldNotEmpty2(cvv, cvverrror, "Field Cannot be Left Empty");
	    	try
	    	{
	    		if(isTextFieldNotEmpty && isTextFieldNotEmpty1 && isTextFieldNotEmpty2)
	    		{
	    //	if(l.isLogin(tusername.getText(),tpassword.getText()))
	    			if(p.payneeraj(number.getText(), mm.getText(), yyyy.getText(),cvv.getText()))
	    	{
	    		
	    	
	    	//	 infobox("Your Payment is Successful!!.If you wish to order anything else you can do so..Enjoy the Food..",null,"Success");
			   		//Node node=(Node) event.getSource();
			      //	 node.getScene().getWindow().hide();
	    		// ((Node)event.getSource()).getScene().getWindow().hide();
			   		//dialogStage=(Stage)node.getScene().getWindow();
			   		//dialogStage.close();
			   		//scene=new Scene(FXMLLoader.load(getClass().getResource("/itmd510/fp/view/Ratings.fxml")));
			   		//dialogStage.setScene(scene);
			   		//dialogStage.show();
			   		
			   		((Node)event.getSource()).getScene().getWindow().hide(); 
			   		infobox("Your Payment is Successful!!.If you wish to order anything else you can do so..Enjoy the Food..",null,"Success");
			   	 FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/Ratings.fxml"));
				  Parent root1 = (Parent)fxmlloader.load();
				  Stage stage=new Stage();
				  stage.initStyle(StageStyle.DECORATED);
				  stage.setTitle("Ratings");
				  stage.setScene(new Scene(root1));
				  stage.show();
				  
			
	    		
	    		
	    		
	    	}
	    	else
	    	{
	    		
	    		System.out.println("We have some issues in your Entered Card details!!!!");
	    	}
	    	}
	    	}
	    	catch(Exception e)
	    	{
	    		
	    		e.printStackTrace();
	    		
	    	}
	    }

   

}  //end of class
