package com.example.coursework;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class DbConnection {

    //instance variables
    private MongoDatabase mongoDatabase;
    //static variables
    private static DbConnection dbConnection;
    //constants
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "LalSoresDatabase";

    private DbConnection(){
        MongoClient client = new MongoClient(HOSTNAME, PORT);
        mongoDatabase = client.getDatabase(DB_NAME);
    }

    public static DbConnection getConnection(){
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }
        return dbConnection;

    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public MongoCollection getCollectionByName(String collectionName){
        return mongoDatabase.getCollection(collectionName);
    }
    public void createCollection(String collectionName){
        mongoDatabase.createCollection(collectionName);
    }
    public void removeCollection(String collectionName){
        MongoCollection collection = mongoDatabase.getCollection(collectionName);
        collection.drop();
    }
    public MongoIterable<String> collection_list (){
        MongoIterable<String> collectionList = mongoDatabase.listCollectionNames();

        return collectionList;

    }
    public MongoCollection getCatogoriesCollection(){
        MongoCollection collection =mongoDatabase.getCollection("catogories");


        return (collection);
    }
    public  MongoCollection getProductCollection(){
        MongoCollection collection = mongoDatabase.getCollection("products");
        return  collection;
    }








}

