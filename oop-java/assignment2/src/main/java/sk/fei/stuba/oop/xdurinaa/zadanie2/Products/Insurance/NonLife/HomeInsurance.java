package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.NonLife;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Address;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;

import java.time.LocalDate;

public class HomeInsurance extends NoLifeInsurance{

        private float equipmentValue;

        public HomeInsurance(Client creator, LocalDate effectiveBy, LocalDate expirationDate, float value, float monthlyFee, HouseType houseType, Address address, float houseValue, float equipmentValue) {
            super(creator, effectiveBy, expirationDate, value, monthlyFee, houseType, address, houseValue);
            setEquipmentValue(equipmentValue);
        }

        public void setEquipmentValue(float equipmentValue) {
            if (equipmentValue < 0) throw new IllegalArgumentException("Value of exuipment cannot be negative");
            this.equipmentValue = equipmentValue;
        }

        public float getEquipmentValue() {
            return equipmentValue;
        }
}


