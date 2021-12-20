package com.example.coursework;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.bson.Document;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {


    @FXML
    private Button addProductBtn;



    @FXML
    private TextField productNameField;
    @FXML
    private ChoiceBox<String> categoryChoiceBox;
    @FXML
    private TextField productIdField;

    @FXML
    private Button productCleanBtn;
    @FXML
    private Label resultLbl;
    @FXML
    private  TextField stockField;


    @FXML
    void categorySelect(ActionEvent event) {



    }

    @FXML
    void productAdd(ActionEvent event) {
        try {


            if (productNameField.getText() == "" || productIdField.getText() == "") {
                resultLbl.setText("Please input Name and Id  values correctly");
            } else if (categoryChoiceBox.getValue() == "catogories") {
                resultLbl.setText("Please choose another category this is for the developer only");
            } else if (productNameField.getText() != "" || productIdField.getText() != "" && categoryChoiceBox.getValue() != "catogories") {
                String category = categoryChoiceBox.getValue();
                String id = productIdField.getText();
                Integer stock = Integer.parseInt(stockField.getText());
                DbConnection connection = DbConnection.getConnection();
                MongoCollection collection = connection.getCollectionByName(category);


                String productName = productNameField.getText();

                Document document = new Document();
                document.put("name", productName);
                document.put("id", id);
                document.put("stock", stock);
                collection.insertOne(document);
                resultLbl.setText("Product Added");


                MongoCollection collection1 = connection.getProductCollection();
                collection1.insertOne(document);

            }
        }catch (Exception exception){
            resultLbl.setText("error in entering values");
        }





    }

    @FXML
    void productClean(ActionEvent event) {
    productNameField.clear();
    productIdField.clear();
    stockField.clear();
    resultLbl.setText("");



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DbConnection connection = DbConnection.getConnection();
        MongoIterable<String> collection =connection.collection_list();
        List<String> collection1 = new ArrayList<>();
        for (String name:collection){
            collection1.add(name);
        }
        boolean isRemoved = collection1.remove("catogories");
        boolean isRemoved1 = collection1.remove("products");
        categoryChoiceBox.getItems().addAll(collection1);

    }
}
