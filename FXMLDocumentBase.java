package databasedemo;

import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import databasedemo.otd;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class FXMLDocumentBase extends Pane {
    
    

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final TextField id;
    protected final TextField fName;
    protected final TextField mName;
    protected final TextField lName;
    protected final TextField Email;
    protected final TextField Phone;
    protected final Button update;
    protected final Button first;
    protected final Button last;
    protected final Button delete;
    protected final Button next;
    protected final Button prev;
    protected final Button new1;
    protected final Button save;
    protected final Button save1;
    
    ResultSet rsGlobal;
    DataAcessLayer database;

    public FXMLDocumentBase() {
        
        
        DataAcessLayer database =new DataAcessLayer("jdbc:derby://localhost:1527/PhoneBook", "root", "root");
        rsGlobal =  database.select();
        try {
            rsGlobal.next();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        id = new TextField();
        fName = new TextField();
        mName = new TextField();
        lName = new TextField();
        Email = new TextField();
        Phone = new TextField();
        update = new Button();
        first = new Button();
        last = new Button();
        delete = new Button();
        next = new Button();
        prev = new Button();
        new1 = new Button();
        save = new Button();
        save1 = new Button();
        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(88.0);
        label.setLayoutY(72.0);
        label.setText("Personal Details");

        label0.setLayoutX(109.0);
        label0.setLayoutY(101.0);
        label0.setText("ID");

        label1.setLayoutX(103.0);
        label1.setLayoutY(137.0);
        label1.setText("First Name");

        label2.setLayoutX(97.0);
        label2.setLayoutY(174.0);
        label2.setText("Middle Name");

        label3.setLayoutX(102.0);
        label3.setLayoutY(207.0);
        label3.setText("Last Name ");

        label4.setLayoutX(101.0);
        label4.setLayoutY(242.0);
        label4.setText("Email");

        label5.setLayoutX(99.0);
        label5.setLayoutY(274.0);
        label5.setText("Phone");
        
        save1.setVisible(false);
        save.setVisible(false);
        id.setDisable(true);
        id.setLayoutX(241.0);
        id.setLayoutY(97.0);
        

        fName.setDisable(true);
        fName.setLayoutX(241.0);
        fName.setLayoutY(133.0);

        mName.setDisable(true);
        mName.setLayoutX(241.0);
        mName.setLayoutY(170.0);

        lName.setDisable(true);
        lName.setLayoutX(241.0);
        lName.setLayoutY(203.0);

        Email.setDisable(true);
        Email.setLayoutX(241.0);
        Email.setLayoutY(238.0);

        Phone.setDisable(true);
        Phone.setLayoutX(241.0);
        Phone.setLayoutY(270.0);

        update.setLayoutX(135.0);
        update.setLayoutY(326.0);
        update.setMnemonicParsing(false);
        update.setText("Update");
        
        
        save.setLayoutX(135.0);
        save.setLayoutY(326.0);
        save.setMnemonicParsing(false);
        save.setText("Save");

        first.setLayoutX(289.0);
        first.setLayoutY(326.0);
        first.setMnemonicParsing(false);
        first.setText("First");

        last.setLayoutX(526.0);
        last.setLayoutY(326.0);
        last.setMnemonicParsing(false);
        last.setText("Last");

        delete.setLayoutX(208.0);
        delete.setLayoutY(326.0);
        delete.setMnemonicParsing(false);
        delete.setText("Delete");

        next.setLayoutX(452.0);
        next.setLayoutY(326.0);
        next.setMnemonicParsing(false);
        next.setText("Next");

        prev.setLayoutX(378.0);
        prev.setLayoutY(326.0);
        prev.setMnemonicParsing(false);
        prev.setText("Prev");

        new1.setLayoutX(62.0);
        new1.setLayoutY(326.0);
        new1.setMnemonicParsing(false);
        new1.setText("New");
        
        save1.setLayoutX(62.0);
        save1.setLayoutY(326.0);
        save1.setMnemonicParsing(false);
        save1.setText("Save");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(id);
        getChildren().add(fName);
        getChildren().add(mName);
        getChildren().add(lName);
        getChildren().add(Email);
        getChildren().add(Phone);
        getChildren().add(update);
        getChildren().add(first);
        getChildren().add(last);
        getChildren().add(delete);
        getChildren().add(next);
        getChildren().add(prev);
        getChildren().add(new1);
getChildren().add(save);    getChildren().add(save1);


        try {
            id.setText(rsGlobal.getString(1));
            fName.setText(rsGlobal.getString(2));
            mName.setText(rsGlobal.getString(3));
            lName.setText(rsGlobal.getString(4));
            Email.setText(rsGlobal.getString(5));
            Phone.setText(rsGlobal.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        new1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                id.setDisable(false);
                fName.setDisable(false);
                lName.setDisable(false);
                mName.setDisable(false);
                Email.setDisable(false);
                Phone.setDisable(false);
                new1.setVisible(false);
                save1.setVisible(true);
                id.clear();
                fName.clear();
                lName.clear();
                mName.clear();
                Email.clear();
                Phone.clear();
            
              
                

            }
        });
        save1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    otd data = new otd(Integer.parseInt(id.getText()),fName.getText(),mName.getText(),lName.getText(),Email.getText(),Integer.parseInt(Phone.getText()));
                    database.insert(data, rsGlobal);
                    rsGlobal = database.select();
                    if(rsGlobal.first())
                    {
                        
                        id.setText(rsGlobal.getString(1));
                        fName.setText(rsGlobal.getString(2));
                        mName.setText(rsGlobal.getString(3));
                        lName.setText(rsGlobal.getString(4));
                        Email.setText(rsGlobal.getString(5));
                        Phone.setText(rsGlobal.getString(6));
                    }
                    id.setDisable(true);
                    fName.setDisable(true);
                    lName.setDisable(true);
                    mName.setDisable(true);
                    Email.setDisable(true);
                    Phone.setDisable(true);
                    new1.setVisible(true);
                    save1.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              
                

            }
        });
        
        update.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                fName.setDisable(false);
                lName.setDisable(false);
                mName.setDisable(false);
                Email.setDisable(false);
                Phone.setDisable(false);
                update.setVisible(false);
                save.setVisible(true);
            
              
                

            }
        });
        save.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    otd data = new otd(Integer.parseInt(id.getText()),fName.getText(),mName.getText(),lName.getText(),Email.getText(),Integer.parseInt(Phone.getText()));
                    database.update(data, rsGlobal);
                    rsGlobal =  database.select();
                    if(rsGlobal.first())
                    {
                        
                        id.setText(rsGlobal.getString(1));
                        fName.setText(rsGlobal.getString(2));
                        mName.setText(rsGlobal.getString(3));
                        lName.setText(rsGlobal.getString(4));
                        Email.setText(rsGlobal.getString(5));
                        Phone.setText(rsGlobal.getString(6));
                    }
                    fName.setDisable(true);
                    lName.setDisable(true);
                    mName.setDisable(true);
                    Email.setDisable(true);
                    Phone.setDisable(true);
                    update.setVisible(true);
                    save.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              
                

            }
        });
    next.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    if(rsGlobal.next()){

  
                    id.setText(rsGlobal.getString(1));
                    fName.setText(rsGlobal.getString(2));
                    mName.setText(rsGlobal.getString(3));
                    lName.setText(rsGlobal.getString(4));
                    Email.setText(rsGlobal.getString(5));
                    Phone.setText(rsGlobal.getString(6));}else{
                    rsGlobal.last();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              
                

            }
        });
    prev.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    if(rsGlobal.previous()){

  
                    id.setText(rsGlobal.getString(1));
                    fName.setText(rsGlobal.getString(2));
                    mName.setText(rsGlobal.getString(3));
                    lName.setText(rsGlobal.getString(4));
                    Email.setText(rsGlobal.getString(5));
                    Phone.setText(rsGlobal.getString(6));}else{
                    rsGlobal.first();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              
                

            }
        });
    last.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    if(rsGlobal.last()){

  
                    id.setText(rsGlobal.getString(1));
                    fName.setText(rsGlobal.getString(2));
                    mName.setText(rsGlobal.getString(3));
                    lName.setText(rsGlobal.getString(4));
                    Email.setText(rsGlobal.getString(5));
                    Phone.setText(rsGlobal.getString(6));}
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              
                

            }
        });
        first.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    if(rsGlobal.first()){

  
                    id.setText(rsGlobal.getString(1));
                    fName.setText(rsGlobal.getString(2));
                    mName.setText(rsGlobal.getString(3));
                    lName.setText(rsGlobal.getString(4));
                    Email.setText(rsGlobal.getString(5));
                    Phone.setText(rsGlobal.getString(6));}
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              
                

            }
        });
        
        delete.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                
                try {
                    database.delete(rsGlobal);
                    rsGlobal =  database.select();
                    if(rsGlobal.first())
                    {
                        
                        id.setText(rsGlobal.getString(1));
                        fName.setText(rsGlobal.getString(2));
                        mName.setText(rsGlobal.getString(3));
                        lName.setText(rsGlobal.getString(4));
                        Email.setText(rsGlobal.getString(5));
                        Phone.setText(rsGlobal.getString(6));
                    }   } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
              
                

            }
        });
    }
    
    
    
    
}
