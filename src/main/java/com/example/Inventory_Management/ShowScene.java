package com.example.Inventory_Management;

import com.example.Inventory_Management.DBconn.DatabaseConnection;
import com.example.Inventory_Management.Model.ProductDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.sql.ResultSet;

public class ShowScene {

    @FXML
    protected void back() {
        MainScene.back_display();
    }

    @FXML
    private TableView<ProductDetails> tableView;
    @FXML
    private TableColumn<ProductDetails, String> ID, Name, Price, Quantity, MFD, Expiry;

    @FXML
    private TableColumn<ProductDetails, String> EDIT,DELETE;

    private ObservableList<ProductDetails> list = FXCollections.observableArrayList();


    public static String p_ID, p_Name, p_Price, p_Quantity, p_MFD, p_Expiry;


    @FXML
    public void initialize() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ID.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        Name.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        Price.setCellValueFactory(cellData -> cellData.getValue().PriceProperty());
        Quantity.setCellValueFactory(cellData -> cellData.getValue().QuantityProperty());
        MFD.setCellValueFactory(cellData -> cellData.getValue().mfdProperty());
        Expiry.setCellValueFactory(cellData -> cellData.getValue().ExpiryProperty());

        EDIT.setCellValueFactory(new PropertyValueFactory<>(""));


        Callback<TableColumn<ProductDetails, String>, TableCell<ProductDetails, String>> cellFactory =
                new Callback<TableColumn<ProductDetails, String>, TableCell<ProductDetails, String>>() {
                    @Override
                    public TableCell call(final TableColumn<ProductDetails, String> param) {
                        final TableCell<ProductDetails, String> cell = new TableCell<ProductDetails, String>() {
                            //                             String test=cell.getId();
                            final Button btn = new Button("Edit");
                          //  final Button btn1= new Button("Delete");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {

                                    btn.setOnAction(event -> {
                                        ProductDetails productDetails = getTableView().getItems().get(getIndex());
                                        System.out.println(productDetails.IDProperty());
                                        p_ID = productDetails.IDProperty().get();
                                        p_Name = productDetails.NameProperty().get();
                                        p_Price = productDetails.PriceProperty().get();
                                        p_Quantity = productDetails.QuantityProperty().get();
                                        p_MFD = productDetails.mfdProperty().get();
                                        p_Expiry = productDetails.ExpiryProperty().get();
                                        MainScene.updateproduct();
                                    });
//                                    btn1.setOnAction(event ->{
//                                        ProductDetails productDetails = getTableView().getItems().get(getIndex());
//                                        System.out.println(productDetails.IDProperty());
//                                        p_ID = productDetails.IDProperty().get();
//                                        p_Name = productDetails.NameProperty().get();
//                                        p_Price = productDetails.PriceProperty().get();
//                                        p_Quantity = productDetails.QuantityProperty().get();
//                                        p_MFD = productDetails.mfdProperty().get();
//                                        p_Expiry = productDetails.ExpiryProperty().get();
//                                        MainScene.Deleteproduct();
//                                    });

                                    setGraphic(btn);
                                  //  setGraphic(btn1);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        EDIT.setCellFactory(cellFactory);

        DELETE.setCellValueFactory(new PropertyValueFactory<>(""));


        Callback<TableColumn<ProductDetails, String>, TableCell<ProductDetails, String>> cellFactory1 =
                new Callback<TableColumn<ProductDetails, String>, TableCell<ProductDetails, String>>() {
                    @Override
                    public TableCell call(final TableColumn<ProductDetails, String> param) {
                        final TableCell<ProductDetails, String> cell1 = new TableCell<ProductDetails, String>() {
                            //                             String test=cell.getId();
                            final Button btn1= new Button("Delete");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                  btn1.setOnAction(event ->{
                                  ProductDetails productDetails = getTableView().getItems().get(getIndex());
                                  System.out.println(productDetails.IDProperty());
                                  p_ID = productDetails.IDProperty().get();
                                  MainScene.Deleteproduct();
                              });
                                   setGraphic(btn1);
                                   setText(null);
                                }
                            }
                        };
                        return cell1;
                    }
                };

        DELETE.setCellFactory(cellFactory1);
    try{
        ResultSet rs =databaseConnection.databaseConnection().executeQuery("select * from productdetails");
        while (rs.next()){
            list.add(new ProductDetails(String.valueOf(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    tableView.setItems(list);
    }
}