package itmd510.fp.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import itmd510.fp.dao.DataSource;
import itmd510.fp.model.Foodmenu;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewmenuController implements Initializable 
{


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

	
	   ObservableList<String> list = FXCollections.observableArrayList("Extra Rate for Mineral bottle of water. ","Tips Accepted.","Take care of your belongings.","Wallet Parking available if car parking is Full.","Extra cost for extra Bread ordered.");
	    
	   //constructor to establish database connection
	public ViewmenuController()
	{
		
		connection=DataSource.connectdb();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	
	{
		listview.setItems(list);
		data = FXCollections.observableArrayList();
		
		setcelltable();
		try {
			LoadData();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//method to set column of a table
	private void setcelltable()
	{
		col2.setCellValueFactory(new PropertyValueFactory<>("Food"));
		col1.setCellValueFactory(new PropertyValueFactory<>("Rate"));
	}	
	
	//method to load data from database
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
	
}
//end of class