package itmd510.fp.controller;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class TariffController implements Initializable 
{
	
	   @FXML
	    private Label room3;
	   @FXML
	    private Label room2;
	   @FXML
	    private Label room1;
	   
	@FXML
	private ListView<String> listview;
	
	ObservableList<String> data = FXCollections.observableArrayList("Approximate Rates","Classic Room - $500 per night","Premiere Suite - $1000","Privilege Suite - $1500"," "," ","  ","Breakfast inlcuded in Priemere and Privilege Rooms.","Check-in Time 9 AM.", "Check-out Time 10AM.","Complimentary Breakfast if stay is more than a Day.","We provide space for Family Functions and parties.","Special Family Suites.","Special Conference room for meetings and presentations");
	@Override
	public void initialize(URL location, ResourceBundle resources)
	
	
	{
		
		
		
		listview.setItems(data); // listview loading observable list items

	}


	
	
}

