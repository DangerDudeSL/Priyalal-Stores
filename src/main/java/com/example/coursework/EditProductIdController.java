package com.example.coursework;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditProductIdController {

    @FXML
    private TextField NewProductIdField;

    @FXML
    private Button editBtn;

    @FXML
    private Button editIdCleanBtn;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField oldProductIdField;


    @FXML
    void ProductIdEdit(ActionEvent event) {
        String oldId = oldProductIdField.getText();
        String newId = NewProductIdField.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("products");

        BasicDBObject oldQuery = new BasicDBObject();
        oldQuery.put("id", oldId);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("id", newId);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set",newDocument);
        collection.updateOne(oldQuery,updateObject);
        nameLabel.setText("Id updated");

    }

    @FXML
    void clearIdFields(ActionEvent event) {
        nameLabel.setText("");
        oldProductIdField.clear();
        NewProductIdField.clear();

    }

}