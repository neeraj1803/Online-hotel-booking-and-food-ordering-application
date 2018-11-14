package itmd510.fp.model;

import com.sun.glass.ui.Window;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox
{
	
	public static void display(String Title,String Message)
	{
		
		Stage Window=new Stage();
		
		Window.initModality(Modality.APPLICATION_MODAL);
		Window.setTitle(Title);
		Window.setMinWidth(700);
		Window.setMaxHeight(1750);
		
		
		Label label=new Label();
		label.setText(Message);
		Button closebutton=new Button("CLOSE");
		closebutton.setOnAction(e -> Window.close());
		
		VBox layout=new VBox(20);
		layout.getChildren().addAll(label,closebutton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene=new Scene(layout);
		Window.setScene(scene);
		Window.showAndWait();
		
	}
	
	
	

}
