package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife;

import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Address;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Insurance;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class NoLifeInsurance extends Insurance {

    private Address address;
    private HouseType houseType;
    private double houseValue;

    public NoLifeInsurance(long insurer, LocalDateTime dateTime, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, HouseType houseType, Address address, double houseValue) {
        super(insurer,dateTime,effectiveBy, expirationDate, value, monthlyFee);
        setHouseType(houseType);
        setAddress(address);
        setHouseValue(houseValue);
    }

    public void setAddress(Address address) {
        if (address == null) throw new IllegalArgumentException("Address cannot be null");
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setHouseType(HouseType houseType) {
        if (houseType == null) throw new IllegalArgumentException("House type cannot be null");
        this.houseType = houseType;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseValue(double houseValue) {
        if (houseValue < 0) throw new IllegalArgumentException("House value cannot be less than 0");
        this.houseValue = houseValue;
    }

    public double getHouseValue() {
        return houseValue;
    }
}


