/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

/**
 *
 * @author PC Gamer
 */
public class Addres {
    private String street;
    private String city;
//    private String state;
//    private String zipCode;
    private String country;
    private String hNumber;

    public Addres() {
    }

    public Addres(String street, String city, String state, String zipCode, String country,String hNumber) {
        this.street = street;
        this.city = city;
        this.hNumber=hNumber;
//        this.state = state;
//        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public String getCountry() {
//        return country;
//    }

    public String gethNumber() {
        return hNumber;
    }

    public void sethNumber(String hNumber) {
        this.hNumber = hNumber;
    }

    
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    
    
}

