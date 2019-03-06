package com.inventory.controller;

import com.inventory.model.Item;
import com.inventory.repository.repository;
import org.springframework.beans.BeanUtils;
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


}
