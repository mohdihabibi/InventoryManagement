package com.inventory.controller;

import com.inventory.model.Item;
import com.inventory.repository.repository;
import com.inventory.services.BootStrap;
import com.inventory.services.RegisterDevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

@RestController
@RequestMapping("api/machine/")
public class ItemController {

    MongoClient client = new MongoClient("localhost", 27017);

    DB database = client.getDB("cmpe273");

    public DBCollection bootstrap = database.getCollection("bootstrap");
    public DBCollection registerInfo = database.getCollection("registerInfo");
    public DBCollection serverDb = database.getCollection("server");

    @Autowired
    private repository Repository;

    public ItemController() throws UnknownHostException {
    }

    @RequestMapping(value = "items", method = RequestMethod.GET)
    public List<Item> list(){
        return Repository.findAll();
    }

    @RequestMapping(value = "items", method = RequestMethod.POST)
    public Item create(@RequestBody Item item){
        return Repository.saveAndFlush(item);
    }

    @RequestMapping(value = "items/{id}", method = RequestMethod.GET)
    public Item get(@PathVariable Long id){
        return Repository.findById(id).orElse(null);
    }

    @RequestMapping(value = "items/{id}", method = RequestMethod.PUT)
    public Item update(@PathVariable Long id, @RequestBody Item shipwreck){
        Item existingone = Repository.findById(id).orElse(null);
        BeanUtils.copyProperties(shipwreck, existingone);
        return Repository.saveAndFlush(existingone);
    }

    @RequestMapping(value = "items/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        Repository.deleteById(id);
    }

    @RequestMapping(value = "items/bs", method = RequestMethod.POST)
    public String bootstrap(@RequestParam("epn") String endpoint){
        System.out.println("Making bootstrap for endpoint =  " + endpoint);
        BootStrap bs = new BootStrap();
        String temp1;
        temp1 = bs.bootStrapDB(endpoint).replace("\\", "");
        return temp1;
    }

    @RequestMapping(value = "items/rd", method = RequestMethod.POST)
    public String registerDevice(String params, @RequestParam("epn") String endpoint, @RequestParam("t") String time){
        System.out.println("Making register device for endpoint =  " + endpoint);
        System.out.println("Payload is: " + params);
        RegisterDevice rd = new RegisterDevice();
        String rdID = "";
        rdID = rd.registerDB(endpoint, time);
        return rdID;
    }


}
