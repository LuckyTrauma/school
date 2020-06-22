package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.NonLifeInsurance;
import com.sun.nio.sctp.IllegalReceiveException;
import lombok.Data;
import lombok.NoArgsConstructor;

import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.NoLifeInsurance;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Address;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.HouseType;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.InsuranceResource;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor

public abstract class NonLifeInsurance <T extends NoLifeInsurance> extends InsuranceResource<T> {
        @NotNull
        private HouseType HouseType;
        @NotNull
        @DecimalMin("0")
        private int ZIP;
        @NotNull
        @NotEmpty
        private String City;
        @NotNull
        @NotEmpty
        private String Street;
        @NotNull
        @DecimalMin("0")
        private int HouseNumber;
        @DecimalMin("0")
        private double HouseValue;

        public NonLifeInsurance(T insurance)
        {
            super(insurance);
            this.setHouseType(insurance.getHouseType());
            this.setAddress(insurance.getAddress());
            this.setHouseValue(insurance.getValue());
        }

        public void setAddress(Address address)
        {
            if(address == null) throw new IllegalReceiveException("Cannot set property address null");
            this.setZIP(address.getZIP());
            this.setCity(address.getCity());
            this.setStreet(address.getStreet());
            this.setHouseNumber(address.getHouseNumber());
        }

        public Address getAddress()
        {
            return new Address(ZIP, City, Street, HouseNumber);
        }

        @Override
        public T editInsurance(T insurance)
        {
            insurance = super.editInsurance(insurance);
            insurance.setHouseType(getHouseType());
            insurance.setAddress(getAddress());
            insurance.setHouseValue(getHouseValue());
            return insurance;
        }

    }

