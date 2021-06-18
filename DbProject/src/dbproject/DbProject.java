/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class DbProject extends Application {
    
    DataBaseUI ui;
    DBTraining dbObj;
    @Override
    public void start(Stage stage) throws Exception {
        ui=new DataBaseUI();
        dbObj=new DBTraining();
        
        Scene scene = new Scene(ui);
        
        stage.setScene(scene);
        stage.show();
        //new
        ui.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(ui.textField.getText().trim().length()>0&&ui.textField0.getText().trim().length()>0&&ui.textField1.getText().trim().length()>0)
                {
                    int id=Integer.parseInt(ui.textField.getText());
                double salary=Double.parseDouble(ui.textField1.getText());
                String query="insert into Employee values("+id+",'"+ui.textField0.getText()+"',"+salary+");";
                    int dbInsert = dbObj.dbInsert(query);
                    if(dbInsert!=-1){
                ui.textField.setText("");
                         ui.textField0.setText("");
                          ui.textField1.setText("");
                        try {
                            dbObj.rs= dbObj.st.executeQuery("select id,Emp_Name,salary from Employee");
                            dbObj.rs.first();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                
                }
                
            }
        });
        
        //first
        ui.button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                   dbObj.rs.first();
                 
                        ui.textField.setText(dbObj.rs.getString(1));
                         ui.textField0.setText(dbObj.rs.getString(2));
                          ui.textField1.setText(dbObj.rs.getString(3));
                    
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        //last
        ui.button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dbObj.rs.last();
                 
                        boolean processResultSet = dbObj.processResultSet(0);
                    
                    if(processResultSet){
                        ui.textField.setText(dbObj.rs.getString(1));
                         ui.textField0.setText(dbObj.rs.getString(2));
                          ui.textField1.setText(dbObj.rs.getString(3));
                        
                    }else{
                        ui.textField.setText("");
                         ui.textField0.setText("");
                          ui.textField1.setText("");
                    }
                    
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        
        //next
        ui.button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean processResultSet = dbObj.processResultSet(1);
                    
                    if(processResultSet){
                        ui.textField.setText(dbObj.rs.getString(1));
                         ui.textField0.setText(dbObj.rs.getString(2));
                          ui.textField1.setText(dbObj.rs.getString(3));
                        
                    }else{
                        ui.textField.setText("");
                         ui.textField0.setText("");
                          ui.textField1.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        //previous
        ui.button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean processResultSet = dbObj.processResultSet(2);
                    if(processResultSet){
                        ui.textField.setText(dbObj.rs.getString(1));
                         ui.textField0.setText(dbObj.rs.getString(2));
                          ui.textField1.setText(dbObj.rs.getString(3));
                        
                    }else{
                        ui.textField.setText("");
                         ui.textField0.setText("");
                          ui.textField1.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        
        //delete
        ui.button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dbObj.rs.deleteRow();
                   dbObj.rs.first();
                    
                } catch (SQLException ex) {
ex.printStackTrace();              
                }
                
            }
        });
        
        
        //update
         ui.button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    dbObj.rs.updateString(2, ui.textField0.getText());
                    dbObj.rs.updateDouble(3, Double.parseDouble(ui.textField0.getText()));
                    dbObj.rs.updateRow();
                    
                    
                    
                } catch (SQLException ex) {
                 ex.printStackTrace();              
                }
                
            }
        });
         
         
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
