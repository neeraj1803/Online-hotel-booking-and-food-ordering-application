package itmd510.fp.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class designController implements Initializable
{
	
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private Label hi;


	@Override
	public void initialize(URL location, ResourceBundle resources)
{
		// TODO Auto-generated method stub
		
		try {
			 FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/itmd510/fp/view/First.fxml"));
			  Parent root1 = (Parent)fxmlloader.load();
			  Stage stage=new Stage();
			  stage.initStyle(StageStyle.DECORATED);
			  stage.setTitle("Welcome");
			  stage.setScene(new Scene(root1));
			  stage.show();
			drawer.setSidePane(root1);
			
			HamburgerBackArrowBasicTransition burgertask2 = new HamburgerBackArrowBasicTransition(hamburger);
			burgertask2.setRate(-1);
			hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)-> {
				burgertask2.setRate(burgertask2.getRate() * -1);
				burgertask2.play();
				
				if(drawer.isShown())
				{
					drawer.close();
				}
				else
				{
					drawer.isResizableOnDrag();
				}
			});
			
			//  drawer.setSidePane(root1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
	}
    
    

}
