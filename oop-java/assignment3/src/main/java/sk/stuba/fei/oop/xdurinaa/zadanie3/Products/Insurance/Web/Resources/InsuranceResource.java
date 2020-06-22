package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Insurance;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public abstract class InsuranceResource<T extends Insurance> {

        @Min(0)
        private long id;
        @NotNull
        @Past
        private LocalDateTime dateOfCreation;
        @Min(0)
        private long InsurerID;
        @NotNull
        private LocalDate EffectiveBy;
        @NotNull
        private LocalDate ExpirationDate;
        @DecimalMin("0")
        private double InsuranceValue;
        @DecimalMin("0")
        private double monthlyFee;

        public InsuranceResource(T insurance)
        {
            if(insurance == null) throw new IllegalArgumentException("Cannot create resource from insurance null");
            this.setId(insurance.getInsuranceID());
            this.setDateOfCreation(insurance.getCreationDate());
            this.setInsurerID(insurance.getInsurerID());
            this.setEffectiveBy(insurance.getEffectiveBy());
            this.setExpirationDate(insurance.getExpirationDate());
            this.setInsuranceValue(insurance.getValue());
            this.setMonthlyFee(insurance.getMonthlyFee());
        }

        public abstract T newInsurance();

        public T editInsurance(T contract)
        {
            if(contract == null) throw new IllegalArgumentException("Cannot edit contract null");
            contract.setEffectiveBy(this.EffectiveBy);
            contract.setExpirationDate(this.ExpirationDate);
            contract.setValue(this.InsuranceValue);
            contract.setMonthlyFee(this.monthlyFee);
            return contract;
        }

}
