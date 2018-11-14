package itmd510.fp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ContactusController implements Initializable 

{
	@FXML
    private ListView<String> listview;
	
	 ObservableList<String> data = FXCollections.observableArrayList("In case of any comments and suggestions you can always get back to me with the below contact details",
				"Mobile Number - +1 (312)522-6558",
				 "Whatsapp me on - +91 (9619642703).",
				 "Email-ID - neerajiyer@ymail.com , niyer4@hawk.iit.edu. ",
				 "Facebook Link -https://www.facebook.com/neeraj.iyer.7 ",
				 "Linkedin URL -https://www.linkedin.com/in/neerajiyer  "," ");

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{

		listview.setItems(data);
		
	}


}
