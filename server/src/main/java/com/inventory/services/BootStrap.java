package com.inventory.services;

import com.inventory.controller.ItemController;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

public class BootStrap {

    private String serverUri;
    private String serverId;
    private String lifetime;

    public String bootStrapDB(String name) throws JSONException, org.json.JSONException {

        BasicDBObject obj = new BasicDBObject().append("id", 1);
        obj.append("uri",1);
        obj.append("time",1);

        BasicDBObject queryObj = new BasicDBObject().append("name", name);
        DBCursor queryResult = ItemController.bootStrapDb.find(queryObj, obj);

        BasicDBObject fields = (BasicDBObject) queryResult.next();

        this.serverId = fields.getString("id");
        this.serverUri = fields.getString("uri");
        this.lifetime = fields.getString("time");

        String devices[] = new String[3];
        String values[] = new String[3];

        devices[0]="/"+0+"/"+1+"/"+0;
        values[0]=serverUri;

        devices[1]="/"+1+"/"+1+"/"+0;
        values[1]=serverId;

        devices[2]="/"+1+"/"+1+"/"+1;
        values[2]=lifetime;

        JSONArray json = new JSONArray();
        for(int i=0;i<3;i++)
        {
            json.put(new JSONObject()
                    .put("resource", devices[i])
                    .put("value",values[i]));
        }

        return json.toString();

    }

}
