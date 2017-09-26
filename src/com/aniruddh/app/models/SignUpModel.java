package com.aniruddh.app.models;

import com.aniruddh.app.helpers.InsertHelper;

/**
 * Created by Aniruddh on 26-09-2017.
 */
public class SignUpModel {
    String name, address, dob, phone, password, email;

    public SignUpModel(String name, String email, String address, String dob, String phone, String password){
        this.name = name;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.password = password;
    }

    public void putRequest(){
        InsertHelper insert = new InsertHelper();
        insert.insertDocument(name, email, phone, address, dob, password);
    }
}
