package com.example.Inventory_Management;

import javafx.fxml.FXML;

public class MainController {

    @FXML
    public void addProduct(){
        MainScene.Addscene();
    }

    @FXML
    public void showDetails()
    {
        MainScene.Showscene();
    }
}
