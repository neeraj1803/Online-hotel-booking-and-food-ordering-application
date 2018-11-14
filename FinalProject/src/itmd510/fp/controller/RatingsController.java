package itmd510.fp.controller;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RatingsController 
{

    @FXML
    private RadioButton rb1;

    @FXML
    private ToggleGroup mygroup;

    @FXML
    private RadioButton rb3;

    @FXML
    private RadioButton rb2;

    @FXML
    private RadioButton rb5;

    @FXML
    private RadioButton rb4;

    @FXML
    private Label message;
    
    //method to print message on select of different radio buttons 
    public void radioselect(ActionEvent event)
    {
    	if(rb1.isSelected())
    	{
    		message.setText("You rated us Excellent..Thank You!!!");
    	
    	}
    	if(rb2.isSelected())
    	{
    		message.setText("You rated us V Good..Thank You!!!");
    		
    	}
    	if(rb3.isSelected())
    	{
    		message.setText("You rated us Good..Thank You!!!");
    		
    	}
    	if(rb4.isSelected())
    	{
    		message.setText("You rated us Fair..Thank You!!!");
    		
    	}
    	if(rb5.isSelected())
    	{
    		message.setText("You rated us Bad.We will improve.Thank You!!!");
    		
    	}
    	
    }

}
//end of class