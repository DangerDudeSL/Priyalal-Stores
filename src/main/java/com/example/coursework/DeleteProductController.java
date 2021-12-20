package com.example.coursework;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteProductController {

    @FXML
    private Button DeleteBYNameCleaarBtn;

    @FXML
    private Button DeleteByIdBtn;

    @FXML
    private Button DeleteByIdClearBtn;

    @FXML
    private TextField DeleteByIdField;

    @FXML
    private Label DeleteByIdLbl;

    @FXML
    private Button DeleteByNameBtn;

    @FXML
    private TextField DeleteByNameField;

    @FXML
    private Label DeleteByNameLbl;

    @FXML
    void DeleteById(ActionEvent event) {
        String id = DeleteByIdField.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("products");
        collection.deleteOne(Filters.eq("id",id));
        DeleteByIdLbl.setText("product deleted");

    }

    @FXML
    void DeleteByIdClear(ActionEvent event) {
        DeleteByIdField.clear();
        DeleteByIdLbl.setText("");

    }

    @FXML
    void DeleteByName(ActionEvent event) {
        String name = DeleteByNameField.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("products");
        collection.deleteOne(Filters.eq("name",name));
        DeleteByNameLbl.setText("product deleted");

    }

    @FXML
    void DeleteByNameClear(ActionEvent event) {
        DeleteByNameField.clear();
        DeleteByNameLbl.setText("");

    }

}