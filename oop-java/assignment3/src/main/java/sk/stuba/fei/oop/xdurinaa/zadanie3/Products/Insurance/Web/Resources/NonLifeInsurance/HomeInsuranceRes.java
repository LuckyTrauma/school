package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.NonLifeInsurance;


import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.HomeInsurance;
import javax.validation.constraints.DecimalMin;

@Data
@NoArgsConstructor

public class HomeInsuranceRes extends NonLifeInsurance<HomeInsurance> {
    @DecimalMin("0")
    private double EquipmentValue;

    public HomeInsuranceRes(HomeInsurance insurance)
    {
        super(insurance);
        this.setEquipmentValue(insurance.getEquipmentValue());
    }

    public HomeInsurance newInsurance()
    {
        return new HomeInsurance(getInsurerID(),getDateOfCreation(),getEffectiveBy(),getExpirationDate(),getHouseValue(),getMonthlyFee(),getHouseType(), getAddress(),getHouseValue(),getEquipmentValue());
                   }

    public HomeInsurance editInsurance(HomeInsurance insurance)
    {
        insurance = super.editInsurance(insurance);
        insurance.setEquipmentValue(getEquipmentValue());
        return insurance;
    }
}
