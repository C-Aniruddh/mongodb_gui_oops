package com.aniruddh.app.helpers;

import com.aniruddh.app.util.Constants;
import com.mongodb.*;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by Aniruddh on 26-09-2017.
 */
public class PopulateHelper extends MongoHelper {

    public DefaultTableModel getData(){
        DBCursor cursor = null;
        DB db = mongo.getDB(Constants.dbName);
        DBCollection coll = db.getCollection(Constants.collectionName);
        cursor = coll.find();

        String[] columnNames = {"ID", "Name", "Email", "Phone", "Address", "DOB", "Password"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            String name = (String) obj.get("name");
            String email = (String) obj.get("email");
            String phone = (String) obj.get("phone");
            String address = (String) obj.get("address");
            String dob = (String) obj.get("dob");
            String password = (String) obj.get("password");
            ObjectId id = (ObjectId) obj.get("_id");
            model.addRow(new Object[]{id, name, email, phone, address, dob, password});
        }
        cursor.close();
        return model;
    }
}
