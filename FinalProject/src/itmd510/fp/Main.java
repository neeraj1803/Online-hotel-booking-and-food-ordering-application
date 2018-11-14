package itmd510.fp;

import com.sun.prism.paint.Color;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * Main class where call to application is made.
 * 
 */

public class Main extends Application

{
	public static Stage stage;
	@Override
	public void start(Stage primaryStage)
	{
		
		
		try {
			stage = primaryStage;
			Parent root1 = (Parent)FXMLLoader.load(getClass().getResource("/itmd510/fp/view/sample.fxml"));
			Scene scene = new Scene(root1);
			
			stage.setTitle("Online Hotel Booking,Table Booking & Food Ordering Application");
			stage.setScene(scene);
			stage.show();
		 
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
