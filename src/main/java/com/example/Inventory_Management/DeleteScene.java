package com.example.Inventory_Management;

import com.example.Inventory_Management.DBconn.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DeleteScene implements Initializable {
    @FXML
    public void cancel() {
        MainScene.Showscene();
    }

    String m_ID;

    @FXML
    public void DeleteDetails() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Statement statement = databaseConnection.databaseConnection();
        try {
            String sql = "DELETE FROM productdetails " + "WHERE ID =" + m_ID;
            statement.executeUpdate(sql);
            MainScene.Showscene();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        m_ID = ShowScene.p_ID;
    }
}