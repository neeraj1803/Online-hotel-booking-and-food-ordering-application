package itmd510.fp.model;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FieldValidation 
{
	
	
	public static boolean isValidEmail(TextField tf)
	{
		boolean b=false;
		String pattern="\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		if(tf.getText().matches(pattern))
			b=true;
		return b;
		
	}

	
	public static boolean isValidEmail(TextField tf,Label lb,String ErrorMessage)
	{
		
		boolean b=true;
		String msg=null;
		tf.getStyleClass().remove("error");
			if(!isValidEmail(tf))
			{
				
				b=false;
				msg=ErrorMessage;
				tf.getStyleClass().add("error");
				
			}
		lb.setText(msg);
		
		return b;
	}
	
	public static boolean isTextFieldNotEmpty(TextField tf)
	{
		
		boolean b=false;
		if(tf.getText().length()!=0 || !tf.getText().isEmpty())
			b=true;
		return b;
		
	}
	
	
	public static boolean isTextFieldNotEmpty(TextField tf,Label lb,String ErrorMessage)
	{
		
		boolean b=true;
		String msg=null;
		tf.getStyleClass().remove("error");
	
		if(!isTextFieldNotEmpty(tf))
		{
			b=false;
			msg=ErrorMessage;
			tf.getStyleClass().add("error");
			
		}
		lb.setText(msg);
		
		return b;
		
		
	}
	
	public static boolean isTextFieldNotEmpty1(TextField tf)
	{
		
		boolean b=false;
		if(tf.getText().length()!=0 || !tf.getText().isEmpty())
			b=true;
		return b;
		
	}
	
	
	public static boolean isTextFieldNotEmpty1(TextField tf,Label lb,String ErrorMessage)
	{
		
		boolean b=true;
		String msg=null;
		tf.getStyleClass().remove("error");
	
		if(!isTextFieldNotEmpty(tf))
		{
			b=false;
			msg=ErrorMessage;
			tf.getStyleClass().add("error");
			
		}
		lb.setText(msg);
		
		return b;
		
		
	}
	public static boolean isPasswordMatched(PasswordField tf1,PasswordField tf2)
	{
		
		boolean b=false;
		if(tf1.getText().equals(tf2.getText()))
			b=true;
		return b;
		
	}
	
	public static boolean isPasswordMatched(PasswordField tf1,PasswordField tf2,Label lb,String errorMessage)
	{
		
		boolean b=true;
		String msg=null;
		tf2.getStyleClass().remove("error");
		if(!isPasswordMatched(tf1,tf2))
		{
			b=false;
			msg=errorMessage;
			tf2.getStyleClass().add("error");
			
		}
		lb.setText(msg);
		
		return b;
		
		
	}
	

	public static boolean isMobileNumber(TextField tf)
	{
		boolean b=false;
		String pattern="^(([+]|[0]{2})([\\d]{1,3})([\\s-]{0,1}))?([\\d]{10})$";
		if(tf.getText().matches(pattern))
			b=true;
		return b;
		
	}

	
	public static boolean isMobileNumber(TextField tf,Label lb,String ErrorMessage)
	{
		
		boolean b=true;
		String msg=null;
		tf.getStyleClass().remove("error");
			if(!isMobileNumber(tf))
			{
				
				b=false;
				msg=ErrorMessage;
				tf.getStyleClass().add("error");
				
			}
		lb.setText(msg);
		
		return b;
	}
	
	public static boolean isTextFieldNotEmpty2(TextField tf,Label lb,String ErrorMessage)
	{
		
		boolean b=true;
		String msg=null;
		tf.getStyleClass().remove("error");
	
		if(!isTextFieldNotEmpty(tf))
		{
			b=false;
			msg=ErrorMessage;
			tf.getStyleClass().add("error");
			
		}
		lb.setText(msg);
		
		return b;
		
		
	}
	
	public static boolean isTextFieldNotEmpty2(TextField tf)
	{
		
		boolean b=false;
		if(tf.getText().length()!=0 || !tf.getText().isEmpty())
			b=true;
		return b;
		
	}
	
}
