package sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain;

import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Insurance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Client {

    private long clientID;
    private String name;
    private String surname;
    private String birth;
    private String email;
    private Address address;
    private Address crpAddress;
    private Map<Long, Insurance> insurances;

    private static final AtomicLong idGenerator = new AtomicLong();

    public Client(String name, String surname, String birth, Address address, String email) {
        setName(name);
        setSurname(surname);
        setBirth(birth);
        setEmail(email);
        setAddress(address);
        setCorrespAddress(address);
        this.setInsurances(new HashMap<>());
        this.setClientID(idGenerator.getAndIncrement());
    }
    public Client(String name, String surname, String birth, Address address, Address crpAddress, String email) {
        setName(name);
        setSurname(surname);
        setBirth(birth);
        setEmail(email);
        setAddress(address);
        setCorrespAddress(crpAddress);
        this.setInsurances(new HashMap<>());
        this.setClientID(idGenerator.getAndIncrement());
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

    public Map<Long, Insurance> getInsurances() {   return insurances;    }

    private void setInsurances(Map<Long, Insurance> insurances)
    {
        this.insurances = insurances;
    }

    public long getClientID() {
        return clientID;
    }

    private void setClientID(long id) {
        if(id < 0) throw new IllegalArgumentException("User ID cannot be less than 0");
        this.clientID = id;
    }
    public boolean hasSeparateCrpAddress()
    {
        return (!this.crpAddress.equals(this.address));
    }
    @Override
    public String toString() {
        return "Client  ID : " + clientID + "\nName : " + name + "\nSurname : " + surname + "\nList of Insurances : " + insurances + "\nBirth : " + birth + "\nAddress : " + address + "\ncorrespAddress : " + crpAddress + "\ne-mail : " + email;
    }

}
