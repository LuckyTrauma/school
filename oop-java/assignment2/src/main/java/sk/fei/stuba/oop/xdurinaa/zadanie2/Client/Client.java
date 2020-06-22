package sk.fei.stuba.oop.xdurinaa.zadanie2.Client;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {

    private UUID userID;
    private String name;
    private String surname;
    private String birth;
    private String email;
    private Address address;
    private Address crpAddress;
    private List<Insurance> insurances;

    public Client(String name, String surname, String birth, Address address, String email) {
        setName(name);
        setSurname(surname);
        setBirth(birth);
        setEmail(email);
        setAddress(address);
        setCorrespAddress(address);
        userID = UUID.randomUUID();
        insurances = new ArrayList<>();
    }
    public Client(String name, String surname, String birth, Address address, Address crpAddress, String email) {
        setName(name);
        setSurname(surname);
        setBirth(birth);
        setEmail(email);
        setAddress(address);
        setCorrespAddress(crpAddress);
        userID = UUID.randomUUID();
        insurances = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.trim() == null) throw new IllegalArgumentException("Name must be included");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        if (surname.trim() == null) throw new IllegalArgumentException("Surname must be included");
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setBirth(String birth) {
        if (birth == null) throw new IllegalArgumentException("Birth must be included");
        this.birth = birth;
    }

    public String getBirth() {
        return birth;
    }

    public void setAddress(Address address) {
        if (address == null) throw new IllegalArgumentException("Address cannot be null");
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setCorrespAddress(Address correspAddress) {
        this.crpAddress = correspAddress;
    }

    public Address getCorrespAddress() {
        return crpAddress != null ? crpAddress : address;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email must be included");
        if (!email.contains("@") && !email.contains(".")) throw new IllegalArgumentException("Email is not in valid format");
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public UUID getUserID() {
        return userID;
    }

    public void addInsurance(Insurance insurance) {
        if (insurance == null) throw new IllegalArgumentException("Type of insurance must be included");
        insurances.add(insurance);
    }

    public List<Insurance> getInsurances(){
        return insurances;
    }

    @Override
    public String toString() {
        return "Client  ID : " + userID + "\nName : " + name + "\nSurname : " + surname + "\nList of Insurances : " + insurances + "\nBirth : " + birth + "\nAddress : " + address + "\ncorrespAddress : " + crpAddress + "\ne-mail : " + email;
    }

}
