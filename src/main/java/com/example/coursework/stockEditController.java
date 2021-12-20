package com.example.coursework;


import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class stockEditController {

    @FXML
    private TextField StockRemovaAmountField;

    @FXML
    private Button addStockBtn;

    @FXML
    private Label addStockLbl;

    @FXML
    private Button removeStockBtn;

    @FXML
    private Label removeStockLbl;

    @FXML
    private TextField stockAddAmountField;
    @FXML
    private TextField removeStockProductNameField;
    @FXML
    private TextField addStockProductNameField;
    @FXML
    private Button addStockClearBtn;
    @FXML
    private Button removeStockClearBtn;

    //adding to stock
    @FXML
    void AddStock(ActionEvent event) {
        try {
            Integer addStock = Integer.parseInt(stockAddAmountField.getText());
            String productName = addStockProductNameField.getText();
            DbConnection connection = DbConnection.getConnection();
            MongoCollection collection = connection.getCollectionByName("products");

            BasicDBObject newDocument = new BasicDBObject().append("$inc", new BasicDBObject().append("stock", addStock));

            collection.updateOne(new BasicDBObject().append("name", productName), newDocument);
            addStockLbl.setText("Stock Added");
        }catch (Exception ex){
            addStockLbl.setText("Enter Valid Values");
        }

    }
    //removing stock
    @FXML
    void removeStock(ActionEvent event) {
        try {


        Integer removeStock = Integer.parseInt(StockRemovaAmountField.getText());
        Integer removeStock1 = (-removeStock);
        String productName1 = removeStockProductNameField.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("products");

        BasicDBObject newDocument = new BasicDBObject().append("$inc",new BasicDBObject().append("stock", removeStock1));

        collection.updateOne(new BasicDBObject().append("name",productName1),newDocument);
        removeStockLbl.setText("Stock Removed");
        }catch (Exception ex){
            removeStockLbl.setText("Enter valid Values");
        }

    }
    @FXML
    void AddStockClear(ActionEvent event) {
        addStockProductNameField.clear();
        stockAddAmountField.clear();
        addStockLbl.setText("");



    }
    @FXML
    void removeStockClear(ActionEvent event) {
        removeStockLbl.setText("");
        removeStockProductNameField.clear();
        StockRemovaAmountField.clear();

    }

}
