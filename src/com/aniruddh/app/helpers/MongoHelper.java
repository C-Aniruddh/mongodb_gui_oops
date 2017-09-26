package com.aniruddh.app.helpers;

import com.aniruddh.app.util.Constants;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

/**
 * Created by Aniruddh on 26-09-2017.
 */
public class MongoHelper {
    MongoCredential creds = MongoCredential.createCredential(Constants.USER, Constants.dbName, Constants.PASS.toCharArray());
    MongoClient mongo = new MongoClient(new ServerAddress(Constants.SERVER, Constants.PORT), Arrays.asList(creds));
    MongoDatabase database = mongo.getDatabase(Constants.dbName);
}
