package com.SpringBootDemo.model;


import java.util.Objects;


public class Address {

    private Long id;

    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;

    public Address() {
    }

    public Address(Long id, String name, String address, String city, String state, int zip) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return zip == address1.zip &&
                Objects.equals(id, address1.id) &&
                Objects.equals(name, address1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, city, state, zip);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", zip=").append(zip);
        sb.append('}');
        return sb.toString();
    }
}
