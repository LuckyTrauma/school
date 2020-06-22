package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.NonLife;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Address;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Insurance;

import java.time.LocalDate;

public class FlatHouseInsurance extends NoLifeInsurance {

        private boolean garageInsurance;

        FlatHouseInsurance(Client creator, LocalDate effectiveBy, LocalDate expirationDate, float value, float monthlyFee, HouseType houseType, Address address, float houseValue, boolean garageInsurance) {
            super(creator, effectiveBy, expirationDate, value, monthlyFee, houseType, address, houseValue);
            setGarageInsurance(garageInsurance);
        }

        public void setGarageInsurance(boolean garageInsured) {
            this.garageInsurance = garageInsured;
        }

        public boolean isGarageInsurance() {
            return garageInsurance;
        }
}


