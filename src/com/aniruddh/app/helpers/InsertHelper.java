package com.aniruddh.app.helpers;

import com.aniruddh.app.util.Constants;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Created by Aniruddh on 26-09-2017.
 */
public class InsertHelper extends MongoHelper {

    public void insertDocument(String name, String email, String phone, String address, String dob, String password){
        MongoCollection<Document> collection = database.getCollection(Constants.collectionName);
        Document document = new Document("name", name)
                .append("email", email)
                .append("phone", phone)
                .append("address", address)
                .append("dob", dob)
                .append("password", password);
        collection.insertOne(document);
        System.out.println("Document inserted Successfully");
    }
}
