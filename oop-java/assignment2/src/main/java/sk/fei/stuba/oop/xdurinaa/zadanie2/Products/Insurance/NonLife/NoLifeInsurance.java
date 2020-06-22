package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.NonLife;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Address;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Insurance;

import java.time.LocalDate;

public abstract class NoLifeInsurance extends Insurance {

        private Address address;
        private HouseType houseType;
        private double houseValue;

        public NoLifeInsurance(Client creator, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, HouseType houseType, Address address, double houseValue) {
            super(creator, effectiveBy, expirationDate, value, monthlyFee);
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
            if (houseValue < 0) throw new IllegalArgumentException("House value cannot be negative");
            this.houseValue = houseValue;
        }

        public double getHouseValue() {
            return houseValue;
        }
}


