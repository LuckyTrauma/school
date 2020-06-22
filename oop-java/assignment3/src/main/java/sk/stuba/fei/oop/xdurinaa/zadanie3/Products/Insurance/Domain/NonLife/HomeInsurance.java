package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife;

import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HomeInsurance extends NoLifeInsurance{

    private double equipmentValue;

    public HomeInsurance(long insurer, LocalDateTime dateTime, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, HouseType houseType, Address address, double houseValue, double equipmentValue) {
        super(insurer,dateTime,effectiveBy, expirationDate, value, monthlyFee, houseType, address, houseValue);
        setEquipmentValue(equipmentValue);
    }

    public void setEquipmentValue(double equipmentValue) {
        if (equipmentValue < 0) throw new IllegalArgumentException("Value of exuipment cannot be less than 0");
        this.equipmentValue = equipmentValue;
    }

    public double getEquipmentValue() {
        return equipmentValue;
    }
}


