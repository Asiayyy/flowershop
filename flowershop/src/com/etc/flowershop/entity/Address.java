package com.etc.flowershop.entity;

import java.util.Objects;

public class Address {
    private Tuser tuser;
    private int addressid;
    private String city;
    private String country;
    private String address;

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCoutry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address() {
    }

    public Address(Tuser tuser, int addressid, String city, String coutry, String address) {
        this.tuser = tuser;
        this.addressid = addressid;
        this.city = city;
        this.country = coutry;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return addressid == address1.addressid &&
                Objects.equals(tuser, address1.tuser) &&
                Objects.equals(city, address1.city) &&
                Objects.equals(country, address1.country) &&
                Objects.equals(address, address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tuser, addressid, city, country, address);
    }

    @Override
    public String toString() {
        return "Address{" +
                "tuser=" + tuser +
                ", addressid=" + addressid +
                ", city='" + city + '\'' +
                ", coutry='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
