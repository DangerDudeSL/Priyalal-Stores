//https:// b.objectrocket.com/mongo-db/how-to-update-a-document-in-mongodb-using-java-384
package com.example.coursework;


import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditProductNameController {

    @FXML
    private TextField NewProductNameField;

    @FXML
    private Button editBtn;

    @FXML
    private Button editCategoryCleanBtn;

    @FXML
    private TextField oldProductNameField;
    @FXML
    private Label nameLabel;


    //Product Name editing
    @FXML
    void ProductNameEdit(ActionEvent event) {
        String oldName = oldProductNameField.getText();
        String newName = NewProductNameField.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("products");

        BasicDBObject oldQuery = new BasicDBObject();
        oldQuery.put("name", oldName);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", newName);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set",newDocument);
        collection.updateOne(oldQuery,updateObject);
        nameLabel.setText("Name updated");

    }
    //clearing Text Fields
    @FXML
    void clearNameFields(ActionEvent event) {
        nameLabel.setText("");
        NewProductNameField.clear();
        oldProductNameField.clear();

    }
}
