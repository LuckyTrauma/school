package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.LifeInsurance;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.InsuranceResource;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.LifeInsurance;


import javax.validation.constraints.Min;


@Data
@NoArgsConstructor
public abstract class LifeInsuranceRes <T extends LifeInsurance> extends InsuranceResource<T>
    {
        @Min(0)
        private long Insured;

        public LifeInsuranceRes(T insurance)
        {
            super(insurance);
            this.setInsured(insurance.getInsured());
        }

    }
