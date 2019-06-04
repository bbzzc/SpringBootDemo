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

    private ArrayList<Address> addressRepo = new ArrayList<Address>();
    Path path = Paths.get("C:\"Users\"j96179\"dev\"RubberDuckieSandbox\"SpringBootDemo\"SpringBootDemo\"SpringBootDemo\"src\"main\"resources\"output.txt");
    
    private static FileWriter path;
    private static BufferedWriter writer;
    
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

        try (BufferedWriter writer = Files.newBufferedWriter(path)){
    		writer.write(addresses);
    	} catch (IOException e){
    		System.err.println("couldn't create output file");
    	}
        return addresses;
    }

    @Override
    public void createAddress(String name, String address, String city, String state, int zip){
        long id = addressRepo.getId() +1;
        ArrayList<Address> address = new ArrayList<Address>();
        
        try {
	        BufferedReader reader = new BufferedReader(new FileReader(path));
	        while (reader.ready()) {
	        	String input = reader.readLine();
	        	address.add(input);
	        }
	        reader.close();
	        address.add(id, name, address, city, state, zip);
        }
        catch (IOException io) {
        	System.err.pringln("error in \"createAddress\"");
        }
        
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
        	writer.write(address);
        }
    };
    

    @Override
    public void updateAddress(Long id, String name, String address, String city, String state, int zip) {
        ArrayList<Address> address = new ArrayList<Address>();
        
        try {
	        BufferedReader reader = new BufferedReader(new FileReader(path));
	        while (reader.ready()) {
	        	String input = reader.readLine();
	        	if (input[0] == id) {
	        		input[1] = name;
	        		input[2] = address;
	        		input[3] = city;
	        		input[4] = state;
	        		input[5] = zip;
	        	}
	        	address.add(input);
	        }
	        reader.close();
        }
        catch (IOException io) {
        	System.err.pringln("error in \"updateAddress\"");
        }
        
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
        	writer.write(address);
        }
    }

    @Override
    public void deleteAddress(Long id){
        ArrayList<Address> address = new ArrayList<Address>();
        
        try {
	        BufferedReader reader = new BufferedReader(new FileReader(path));
	        while (reader.ready()) {
	        	String input = reader.readLine();
	        	if (input[0] != id) {
	        		address.add(input);
	        	}
	        }
	        reader.close();
        }
        catch (IOException io) {
        	System.err.pringln("error in \"deleteAddress\"");
        }
        
        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
        	writer.write(address);
        }
    };
}
