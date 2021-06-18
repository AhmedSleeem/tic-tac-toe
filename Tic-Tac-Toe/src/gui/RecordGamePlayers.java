/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Hp450
 */

import database.Mysql;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class RecordGamePlayers extends AnchorPane {
    
    Mysql mysql =new Mysql();
    
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn tableColumn0;
    protected final TableColumn tableColumn1;
    protected final Button back;
    String userEmail;
    public RecordGamePlayers(String username){
    
        this.userEmail=username;
     tableView = new TableView();
        tableColumn = new TableColumn();
        tableColumn0 = new TableColumn();
        tableColumn1 = new TableColumn();
        back = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(450.0);
        setPrefWidth(360.0);
        setStyle("-fx-background-color: #4EB9F5;");

        AnchorPane.setBottomAnchor(tableView, 59.0);
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setRightAnchor(tableView, 0.0);
        AnchorPane.setTopAnchor(tableView, 0.0);
        tableView.setLayoutY(2.0);
        tableView.setPrefHeight(391.0);
        tableView.setPrefWidth(360.0);
        tableView.setStyle("-fx-background-color: #4EB9F5;");

        tableColumn.setPrefWidth(120.0);
        tableColumn.setStyle("-fx-background-color: #F2EC3F;");
        tableColumn.setText("P1_E-mail");

        tableColumn0.setPrefWidth(120.0);
        tableColumn0.setStyle("-fx-background-color: #F2EC3F;");
        tableColumn0.setText("P2_E-mail");

        tableColumn1.setPrefWidth(120.0);
        tableColumn1.setStyle("-fx-background-color: #F2EC3F;");
        tableColumn1.setText("Win OR loss");

        back.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        back.setLayoutX(119.0);
        back.setLayoutY(391.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(32.0);
        back.setPrefWidth(123.0);
        back.setStyle("-fx-background-color: #F2EC3F; -fx-background-radius: 20px;");
        back.setText("Back");
        
        back.setOnAction(e->{
         try {
             back.getParent().getScene().setRoot(new Base());
         } catch (FileNotFoundException ex) {
             Logger.getLogger(RecordGamePlayers.class.getName()).log(Level.SEVERE, null, ex);
         }
        });
            
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn0);
        tableView.getColumns().add(tableColumn1);
        getChildren().add(tableView);
        getChildren().add(back);
    
    }
    
}
