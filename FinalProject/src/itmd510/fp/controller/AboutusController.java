package itmd510.fp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AboutusController implements Initializable 


{


    @FXML
    private ListView<String> listview;

    @FXML
    private Label label;

    ObservableList<String> data = FXCollections.observableArrayList("I am Neeraj R Iyer currently pursuing my Masters in Information Technology and Management with the specialization DataManagement",
    																"This system has been created by me for online hotel room booking , Food ordering and Also Restaurant table booking",
    																 "I have created this as the final project for Object Oriented Application Development Course.",
    																 " Your comments and suggestions are most welcome. "," ","  "," ");
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		listview.setItems(data);
	}

    
    
    
	
	
}
