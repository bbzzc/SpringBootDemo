package com.SpringBootDemo.service;

import com.SpringBootDemo.model.Address;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public abstract class AddressService implements IAddressService {

    private Address addressRepo;

    @Override
    public List<Address> findAll() {

        ArrayList<Address> addresses = new ArrayList<Address>();

        addresses.add(new Address(1L, "Jeremy Pralle", "22305 S 96th St", "Hickman", "NE", 68327));
        addresses.add(new Address(2L, "Heather Vokun", "1982 Jacks Creek Rd", "Richmond", "KY", 40475));
        addresses.add(new Address(3L, "CJ Mark", " 107 Titan Loop", "Whiteman AFB", "MO", 65305));
        addresses.add(new Address(4L, "ZC Glenn", "1106 Fox Blvd", "Honolulu", "HI", 96818));
        addresses.add(new Address(5L, "ER Amber", "107 Tinker", "Honolulu", "HI", 96818));
        addresses.add(new Address(6L, "Abigail Kenda", "25582 E 5th Place", "Aurora", "CO", 80018));
        addresses.add(new Address(7L, "Sonya Lutze", "151 S Canal", "Newark", "IL", 60541));
        addresses.add(new Address(8L, "Steve Roberts", "5805 Davis Rd", "Waxhaw", "NC", 28173));

        Files.write(Paths.get("com/SpringBootDemo/output/output.txt"), addresses.getBytes());

        return addresses;
    }

    @Override
    public void createAddress(String name, String address, String city, String state, int zip){
        long id = addressRepo.getId() +1;
        addressRepo.put(id, name, address, city, state, zip);
    };

    @Override
    public void updateAddress(Long id, String name, String address, String city, String state, int zip) {
        addressRepo.remove(id);
        addressRepo.setId(id);
        addressRepo.put(id, name, address, city, state, zip);
    }

    @Override
    public void deleteAddress(Long id){
        addressRepo.remove(id);
    };


}
