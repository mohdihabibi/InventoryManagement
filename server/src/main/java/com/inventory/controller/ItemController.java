package com.inventory.controller;

import com.inventory.model.Item;
import com.inventory.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ItemController {

    @Autowired
    private repository Repository;
    @RequestMapping(value = "items", method = RequestMethod.GET)
    public List<Item> list(){
        return Repository.findAll();
    }

    @RequestMapping(value = "items", method = RequestMethod.POST)
    public Item create(@RequestBody Item item){
        return Repository.saveAndFlush(item);
    }

//    @RequestMapping(value = "items/{id}", method = RequestMethod.GET)
//    public Item get(@PathVariable Long id){
//        return Repository.findOne(id);
//    }
//
//    @RequestMapping(value = "items/{id}", method = RequestMethod.PUT)
//    public Item update(@PathVariable Long id, @RequestBody Item shipwreck){
//        Item existingone = Repository.findOne(id);
//        BeanUtils.copyProperties(shipwreck, existingone);
//        return Repository.saveAndFlush(existingone);
//    }
//
//    @RequestMapping(value = "items/{id}", method = RequestMethod.DELETE)
//    public Item delete(@PathVariable Long id){
//        Item existingone = Repository.findOne(id);
//        Repository.delete(existingone);
//        return existingone;
//    }


}
