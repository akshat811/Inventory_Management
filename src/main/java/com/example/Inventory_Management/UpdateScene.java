package com.example.Inventory_Management;

import com.example.Inventory_Management.DBconn.DatabaseConnection;
import com.example.Inventory_Management.Model.ProductDetails;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UpdateScene implements Initializable {
    String m_ID,m_Name,m_Price,m_Quantity,m_mfd,m_Expiry;
    @FXML
    protected void back(){
        MainScene.Showscene();
    }

    @FXML
    TextField Name,Price,Quantity;

    @FXML
    DatePicker mfd,Expiry;

    @FXML
    Label msg;

    @FXML
    public void UpdateDetails() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Statement statement = databaseConnection.databaseConnection();
        try {
            String sql1 = "UPDATE productdetails " + "SET Name = '"+Name.getText()+"' WHERE id in ("+m_ID+")";
            statement.executeUpdate(sql1);

            String sql2 = "UPDATE productdetails " + "SET Price = '"+Price.getText()+"' WHERE id in ("+m_ID+")";
            statement.executeUpdate(sql2);

            String sql3 = "UPDATE productdetails " + "SET Quantity = '"+Quantity.getText()+"' WHERE id in ("+m_ID+")";
            statement.executeUpdate(sql3);

            String sql4 = "UPDATE productdetails " + "SET mfd = '"+mfd.getValue()+"' WHERE id in ("+m_ID+")";
            statement.executeUpdate(sql4);

            String sql5 = "UPDATE productdetails " + "SET Expiry = '"+Expiry.getValue()+"' WHERE id in ("+m_ID+")";
            statement.executeUpdate(sql5);

            msg.setText("Updated");
            timer();
        } catch (Exception e) {
          //  e.printStackTrace();
            msg.setText("Error");
            timer();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        m_ID=ShowScene.p_ID;
        m_Name=ShowScene.p_Name;
        m_Price=ShowScene.p_Price;
        m_Quantity=ShowScene.p_Quantity;
        m_mfd=ShowScene.p_MFD;
        m_Expiry=ShowScene.p_Expiry;

        Name.setText(m_Name);
        Price.setText(m_Price);
        Quantity.setText(m_Quantity);
        mfd.setValue(LocalDate.parse(m_mfd));
        Expiry.setValue(LocalDate.parse(m_Expiry));
    }




    public void timer() {
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(3));
        pauseTransition.setOnFinished(e -> msg.setText(""));
        pauseTransition.play();
    }
}
