package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife;


import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlatHouseInsurance extends NoLifeInsurance {

    private boolean garageInsurance;

    public FlatHouseInsurance(long insurer, LocalDateTime dateTime, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, HouseType houseType, Address address, double houseValue, boolean garageInsurance) {
        super(insurer,dateTime, effectiveBy, expirationDate, value, monthlyFee, houseType, address, houseValue);
        setGarageInsurance(garageInsurance);
    }

    public void setGarageInsurance(boolean garageInsured) {
        this.garageInsurance = garageInsured;
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }
}
