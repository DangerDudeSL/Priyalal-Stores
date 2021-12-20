package com.example.coursework;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;
import org.bson.conversions.Bson;

public class viewProductController {

    @FXML
    private Label productId;

    @FXML
    private Label productName;

    @FXML
    private Label productStock;

    @FXML
    private Button viewByIdBtn;

    @FXML
    private TextField viewByIdField;

    @FXML
    private Button viewByNameBtn;

    @FXML
    private TextField viewByNameField;
    @FXML
    private TableColumn idColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableView productTable;

    @FXML
    private TableColumn stockColumn;

    //searching for a product By id and displaying that single product's details on a Table
    @FXML
    void idProductview(ActionEvent event) {
        String Id = viewByIdField.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("products");



        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        stockColumn.setCellValueFactory(new PropertyValueFactory("stock") );

        FindIterable<Document> doc2 = collection.find(eq("id",Id));
        ObservableList productList = FXCollections.observableArrayList();

        for (Document doc: doc2){
            Products products = new Products();
            products.setName(doc.getString("name"));
            products.setId(doc.getString("id"));
            products.setStock(doc.getInteger("stock"));
            productList.add(products);

        }
        productTable.setItems(productList);


    }
    //Search By NAME  and display product details
    @FXML
    void nameProductview(ActionEvent event) {
       String name = viewByNameField.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("products");



        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        stockColumn.setCellValueFactory(new PropertyValueFactory("stock") );

        FindIterable<Document> doc2 = collection.find(eq("name",name));
        ObservableList productList = FXCollections.observableArrayList();

        for (Document doc: doc2){
            Products products = new Products();
            products.setName(doc.getString("name"));
            products.setId(doc.getString("id"));
            products.setStock(doc.getInteger("stock"));
            productList.add(products);

        }
        productTable.setItems(productList);



    }

}