package com.example.Inventory_Management;

import com.example.Inventory_Management.DBconn.DatabaseConnection;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AddScene implements Initializable {
    @FXML
    protected void back() {
        MainScene.back_display();
    }

    @FXML
    TextField name, price, quantity;

    @FXML
    DatePicker mfd,expiry;

    @FXML
    Label msg;

    @FXML
    protected void AddProduct() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        if (name.getText().length() > 0 && price.getText().length() > 0 && quantity.getText().length() > 0 && mfd.getValue().toString().length()>0 && expiry.getValue().toString().length()>0) {

            try {
                int result = databaseConnection.databaseConnection().executeUpdate(
                        "insert into productdetails(Name,Price,Quantity,mfd,Expiry) values(" +
                                "'"+name.getText()+"',"+
                                "'"+price.getText()+"',"+
                                "'"+quantity.getText()+"',"+
                                "'"+mfd.getValue().toString()+"',"+
                                "'"+expiry.getValue().toString()+"'"+
                                ")");


                if (result > 0) {
                    msg.setText("Successfully Inserted");
                    timer();
                } else {
                    msg.setText("Error");
                    timer();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            msg.setText("Please Enter all the Details");
            timer();
        }
    }

    public void timer() {
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(3));
        pauseTransition.setOnFinished(e -> msg.setText(""));
        pauseTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        MainScene.numericOnly(mfd);
//    }
}

