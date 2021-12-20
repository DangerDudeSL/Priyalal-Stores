package com.example.coursework;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoNamespace;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.bson.Document;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.util.Optional;


public class HelloController {

    @FXML
    PasswordField password;

    @FXML
    TextField userName;
    @FXML
    Button loginBtn;
    @FXML
    Button clearBtn;

    @FXML
    void clear(ActionEvent event) {
        userName.clear();
        password.clear();



    }

    @FXML
    void logIn(ActionEvent event) throws IOException {

        if (userName.getText().equals("Priyalal") && password.getText().equals("priyalal123")){
            Stage home = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("Home.fxml"));
            Scene scene = new Scene(fxmlLoader.load() );
            home.setTitle("Home");
            home.setScene(scene);
            home.show();

            Stage firstStage = (Stage) loginBtn.getScene().getWindow();
            firstStage.close();
        }
        else {
            Alert fail = new Alert(Alert.AlertType.WARNING);
            fail.setHeaderText("Login failed");
            fail.setContentText("Username or Password is invalid. Please try again");
            Optional<ButtonType> result = fail.showAndWait();
            ButtonType button = result.orElse(ButtonType.CANCEL);
            if (button == ButtonType.OK){
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                stage.close();
                Stage home = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 670, 380);
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
            }

        }

    }

    @FXML
    private MenuItem category1;

    @FXML
    private MenuItem category2;

    @FXML
    private MenuItem category3;

    @FXML
    private MenuItem category4;

    @FXML
    private Menu home;

    @FXML
    private Menu logout;

    @FXML
    private MenuItem product1;

    @FXML
    private MenuItem product2;

    @FXML
    private MenuItem product3;

    @FXML
    private MenuItem product4;

    @FXML
    private MenuItem product5;

    @FXML
    private MenuItem stock1;

    @FXML
    private MenuItem stock2;

    @FXML
    private MenuItem stock3;

    @FXML
    private MenuItem stock4;

    @FXML
    void category1 () throws IOException{
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add_category.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Category Adding");
        category1Stage.setScene(scene);
        category1Stage.show();

    }

    @FXML
    void category3(ActionEvent event)throws IOException{
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit_category.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Category editing");
        category1Stage.setScene(scene);
        category1Stage.show();

    }

    @FXML
    void category4()throws IOException {
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delete_category.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Category Deleting");
        category1Stage.setScene(scene);
        category1Stage.show();

    }

    @FXML
    void cattegory2(ActionEvent event)throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewCategoryTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Category Table");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void home(ActionEvent event) {

    }

    @FXML
    private Button logOutBtn;

    @FXML
    void logout(ActionEvent event) throws IOException{
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
        Stage home = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();




    }

    @FXML
    void product1()throws IOException {
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("product_add.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Product Adding");
        category1Stage.setScene(scene);
        category1Stage.show();

    }

    @FXML
    void product2(ActionEvent event) throws IOException{
        Stage category1Stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view_product.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        category1Stage.setTitle("Product Searching");
        category1Stage.setScene(scene);
        category1Stage.show();

    }

    @FXML
    void product3(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewProductTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Product Table");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void product4(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewProductTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Product Table");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void product5(ActionEvent event)throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Product Delete");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void stock1(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stockEdit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stock Edit");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void stock2(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stockEdit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stock Edit");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void stock3(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewProductTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Product Table");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void stock4(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view_product.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Search Product");
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    private Button addBtn;

    @FXML
    private Button categoryCleanBtn;

    @FXML
    private TextField categoryIdField;

    @FXML
    private TextField categoryNameField;
    @FXML Label addCategoryLbl;

    //category Adding
    @FXML
    void categoryAdd(ActionEvent event) {
        String categoryName = categoryNameField.getText();
        String categoryId = categoryIdField.getText();

        if(categoryName != "" && categoryId != "") {
            DbConnection connection = DbConnection.getConnection();
            MongoCollection collection = connection.getCatogoriesCollection();
            connection.createCollection(categoryName);
            // this last line is for the purpose of the dropdown.It doesn't interfere with the main process

            Document document = new Document();
            document.put("name", categoryName);
            document.put("id", categoryId);
            collection.insertOne(document);
            addCategoryLbl.setText("category added");
        }
        else {
            addCategoryLbl.setText("Please fill both fields");
        }

        }

    @FXML
    void categoryClean(ActionEvent event1) {
        categoryNameField.clear();
        categoryIdField.clear();


    }
    @FXML
    private Button editBtn;

    @FXML
    private Button editCategoryCleanBtn;

    @FXML
    private TextField editCategoryNewName;

    @FXML
    private TextField editCategoryOldName;
    @FXML
    private Label editCategoryLabel;

    //Category Details Editing
    @FXML
    void categoryEdit(ActionEvent event) {
        String oldName = editCategoryOldName.getText();
        String newName = editCategoryNewName.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("catogories");

        BasicDBObject oldQuery = new BasicDBObject();
        oldQuery.put("name", oldName);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", newName);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set",newDocument);
        collection.updateOne(oldQuery,updateObject);
        editCategoryLabel.setText("Category Name Updated");
    }

    @FXML
    void editCategoryClean(ActionEvent event) {
        editCategoryNewName.clear();
        editCategoryOldName.clear();

    }
    @FXML
    private Button categoryDeleteBtn;

    @FXML
    private TextField deleteCategory;
    @FXML Label deleteLbl;



    @FXML
    void deleteCategoryClear(ActionEvent event) {
        deleteLbl.setText("");
        deleteCategory.clear();
    }
    //category Deleting
    @FXML
    void categoryDelete(ActionEvent event) {
        deleteLbl.setText("");
        String name = deleteCategory.getText();
        DbConnection connection = DbConnection.getConnection();
        MongoCollection collection = connection.getCollectionByName("catogories");
        collection.deleteOne(Filters.eq("name",name));
        deleteLbl.setText("category deleted");
    }
    @FXML
    void categoryManagement(ActionEvent event)throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewCategoryTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Category Table");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void productAndStockManagement(ActionEvent event)throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewProductTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Product Table");
        stage.setScene(scene);
        stage.show();
    }






}