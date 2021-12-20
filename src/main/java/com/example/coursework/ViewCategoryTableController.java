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

public class ViewCategoryTableController {

    @FXML
    private TableView categoryTable;

    @FXML
    private TableColumn idColumn;

    @FXML
    private TableColumn nameColumn;
    @FXML
    private Button deleteCategoryClearButton;
    @FXML
    private Button addCategoryBtn;



    @FXML
    private Button deleteCategoryTableBtn;

    @FXML
    private Button editCategoryTableBtn;



    @FXML
    private Button refreshBtn;

    @FXML
    void DeleteCategoryTable(ActionEvent event)throws IOException {
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delete_category.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Category Deleting");
        category1Stage.setScene(scene);
        category1Stage.show();


    }

    @FXML
    void refreshCategoryTable(ActionEvent event)throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewCategoryTable.fxml"));
        currentStage.setTitle("Category Table");
        Scene scene = new Scene(fxmlLoader.load());
        currentStage.setScene(scene);

    }

    @FXML
    void tableAddCategory(ActionEvent event) throws IOException{
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add_category.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Category Adding");
        category1Stage.setScene(scene);
        category1Stage.show();


    }

    @FXML
    void tableEditCategory(ActionEvent event) throws IOException{
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit_category.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Category editing");
        category1Stage.setScene(scene);
        category1Stage.show();

    }




    @FXML
    public  void  initialize(){
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("catogories");


        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));

        FindIterable<Document> productIterable = collection.find();
        ObservableList categoryList = FXCollections.observableArrayList();

        for (Document doc: productIterable){
            Categories category = new Categories();
            category.setName(doc.getString("name"));
            category.setId(doc.getString("id"));
            categoryList.add(category);

        }
        categoryTable.setItems(categoryList);

    }
}
