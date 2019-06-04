package com.SpringBootDemo.service;

import com.SpringBootDemo.model.Address;
import java.util.List;

public interface IAddressService {
    public List<Address> findAll();

    public abstract void createAddress(String name, String address, String city, String state, int zip);

    public abstract void updateAddress(Long id, String name, String address, String city, String state, int zip);

    public abstract void deleteAddress(Long id);
}
