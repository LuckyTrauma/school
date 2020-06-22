package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.NonLifeInsurance;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.FlatHouseInsurance;

@Data
@NoArgsConstructor
public class FlatHouseInsuranceRes extends NonLifeInsurance<FlatHouseInsurance>  {

        private boolean GarageInsurance;

        public FlatHouseInsuranceRes(FlatHouseInsurance insurance)
        {
            super(insurance);
            this.setGarageInsurance(insurance.isGarageInsurance());
        }

        @Override
        public FlatHouseInsurance newInsurance() {
            return new FlatHouseInsurance(getInsurerID(),getDateOfCreation(),getEffectiveBy(),getExpirationDate(),getHouseValue(),getMonthlyFee(),getHouseType(), getAddress(),getHouseValue(),isGarageInsurance());
        }

        @Override
        public FlatHouseInsurance editInsurance(FlatHouseInsurance insurance) {
            insurance = super.editInsurance(insurance);
            insurance.setGarageInsurance(isGarageInsurance());
            return insurance;
        }
}

