package com.example.coursework;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;

public class ProductTableController {
    @FXML
    private TableColumn idColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn stockColumn;

    @FXML
    private TableView productTable;

    @FXML
    private Button editProductIdBtn;

    @FXML
    private Button editProductNameBtn;

    @FXML
    private Button refreshTableBtn;
    @FXML
    private Button stockEditBtn;

    //initializing the Product Table
    @FXML
    public void initialize(){
    DbConnection connection = DbConnection.getConnection();
    MongoCollection collection = connection.getCollectionByName("products");


    nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
    idColumn.setCellValueFactory(new PropertyValueFactory("id"));
    stockColumn.setCellValueFactory(new PropertyValueFactory("stock") );

    FindIterable<Document> productIterable = collection.find();
    ObservableList productList = FXCollections.observableArrayList();

    for (Document doc: productIterable){
        Products products = new Products();
        products.setName(doc.getString("name"));
        products.setId(doc.getString("id"));
        products.setStock(doc.getInteger("stock"));
        productList.add(products);

    }
    productTable.setItems(productList);

    }

    @FXML
    void editProductName(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EditProductName.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Edit Product Name");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void editProductId(ActionEvent event)throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EditProductId.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Edit Product Id");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void refreshTable(ActionEvent event)throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewProductTable.fxml"));
        currentStage.setTitle("Product Table");
        Scene scene = new Scene(fxmlLoader.load());
        currentStage.setScene(scene);

    }

    @FXML
    void stockEdit(ActionEvent event)throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stockEdit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stock Edit");
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    void DeleteProduct1(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Product Delete");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void addProduct1(ActionEvent event) throws IOException {
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("product_add.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Product Adding");
        category1Stage.setScene(scene);
        category1Stage.show();

    }






}
