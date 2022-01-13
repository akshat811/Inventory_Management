package com.example.Inventory_Management.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductDetails {
    StringProperty ID;
    StringProperty Name;
    StringProperty Price;
    StringProperty Quantity;
    StringProperty mfd;
    StringProperty Expiry;

    public ProductDetails(String ID, String Name, String Price, String Quantity, String mfd, String Expiry) {
        this.ID =  new SimpleStringProperty(ID);
        this.Name =  new SimpleStringProperty(Name);;
        this.Price =  new SimpleStringProperty(Price);;
        this.Quantity =  new SimpleStringProperty(Quantity);;
        this.mfd =  new SimpleStringProperty(mfd);;
        this.Expiry =  new SimpleStringProperty(Expiry);;
    }



    public StringProperty IDProperty() {
        return ID;
    }

    public StringProperty NameProperty() {
        return Name;
    }

    public StringProperty PriceProperty() {
        return Price;
    }

    public StringProperty QuantityProperty() {
        return Quantity;
    }

    public StringProperty mfdProperty() {
        return mfd;
    }

    public StringProperty ExpiryProperty() {
        return Expiry;
    }

}
