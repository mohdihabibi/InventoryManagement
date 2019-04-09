package com.inventory.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.inventory.controller.ItemController;
import com.mongodb.BasicDBObject;

public class RegisterDevice {
    private String rID;
    public void setrID(String rID) {
        this.rID = rID;
    }
    public String getrID() {
        return rID;
    }

    public String registerDB(String name, String time) {
        int sizeOfArray = 10;

        ArrayList<Integer> arr = new ArrayList<Integer>(sizeOfArray);
        for (int i = 1; i <= sizeOfArray; i++) { arr.add(i); }
        Random random = new Random();
        int id = random.nextInt(arr.size());
        String rID = Integer.toString(id);
        BasicDBObject doc = new BasicDBObject();
        doc.put("Name",name);
        doc.put("ID",rID);
        doc.put("time",time);
        doc.put("date",new Date());

        ItemController.registerationDb.insert(doc);

        return rID;
    }

}
