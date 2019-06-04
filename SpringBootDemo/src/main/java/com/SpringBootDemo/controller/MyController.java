package com.SpringBootDemo.controller;

import com.SpringBootDemo.model.Address;
import com.SpringBootDemo.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private IAddressService addressService;

    @GetMapping(value = "/addresses")
    public List<Address> getAddresses() {
        final List<Address> all = addressService.findAll();
        return all;
    }
    
    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateAddress(@PathVariable("id") Long id, @RequestBody String name, String address, String city, String state, int zip) {

        addressService.updateAddress(id, name, address, city, state, zip);
        return new ResponseEntity<>("Address is updated successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity<Object> createAddress(@RequestBody String name, String address, String city, String state, int zip) {
        addressService.createAddress(name, address, city, state, zip);
        return new ResponseEntity<>("Address is created successfully", HttpStatus.CREATED);
    }

}
