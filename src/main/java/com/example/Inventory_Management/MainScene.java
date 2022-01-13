package com.example.Inventory_Management;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScene extends Application {
    public static FXMLLoader fxmlLoader;
    public static Scene  scene;
    public static Stage stagemain;

    @Override
    public void start(Stage stage) throws IOException
    {
        stagemain = stage;
        fxmlLoader = new FXMLLoader(MainScene.class.getResource("MainScene.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("2825867.png")));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
    public static void Addscene() {

        try {
            MainScene.fxmlLoader = new FXMLLoader(MainScene.class.getResource("Add_Scene.fxml"));
            MainScene.scene = new Scene(fxmlLoader.load(), 600, 400);
            MainScene.stagemain.setTitle("Inventory Management");
            MainScene.stagemain.setScene(scene);
            MainScene.stagemain.getIcons().add(new Image(MainScene.class.getResourceAsStream("2825867.png")));
            MainScene.stagemain.setResizable(false);
            MainScene.stagemain.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void Showscene(){

            try {
                MainScene.fxmlLoader = new FXMLLoader(MainScene.class.getResource("Show_Scene.fxml"));
                MainScene.scene = new Scene(fxmlLoader.load(), 600, 400);
                MainScene.stagemain.setTitle("Inventory Management");
                MainScene.stagemain.setScene(scene);
                MainScene.stagemain.getIcons().add(new Image(MainScene.class.getResourceAsStream("2825867.png")));
                MainScene.stagemain.setResizable(false);
                MainScene.stagemain.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
            public static void back_display() {
                try {
                    MainScene.fxmlLoader = new FXMLLoader(MainScene.class.getResource("MainScene.fxml"));
                    MainScene.scene = new Scene(fxmlLoader.load(), 600, 400);
                    MainScene.stagemain.setTitle("Inventory Management");
                    MainScene.stagemain.setScene(scene);
                    MainScene.stagemain.getIcons().add(new Image(MainScene.class.getResourceAsStream("2825867.png")));
                    MainScene.stagemain.setResizable(false);
                    MainScene.stagemain.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            public static void updateproduct() {
                try {
                    MainScene.fxmlLoader = new FXMLLoader(MainScene.class.getResource("Update_Scene.fxml"));
                    MainScene.scene = new Scene(fxmlLoader.load(), 600, 400);
                    MainScene.stagemain.setTitle("Inventory Management");
                    MainScene.stagemain.setScene(scene);
                    MainScene.stagemain.getIcons().add(new Image(MainScene.class.getResourceAsStream("2825867.png")));
                    MainScene.stagemain.setResizable(false);
                    MainScene.stagemain.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                public static void Deleteproduct() {
                    try {
                        MainScene.fxmlLoader = new FXMLLoader(MainScene.class.getResource("Delete_Scene.fxml"));
                        MainScene.scene = new Scene(fxmlLoader.load(), 600, 400);
                        MainScene.stagemain.setTitle("Inventory Management");
                        MainScene.stagemain.setScene(scene);
                        MainScene.stagemain.getIcons().add(new Image(MainScene.class.getResourceAsStream("2825867.png")));
                        MainScene.stagemain.setResizable(false);
                        MainScene.stagemain.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

    }
                public static void numericOnly(final TextField field) {
                    field.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(
                                ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                field.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
    }
}

