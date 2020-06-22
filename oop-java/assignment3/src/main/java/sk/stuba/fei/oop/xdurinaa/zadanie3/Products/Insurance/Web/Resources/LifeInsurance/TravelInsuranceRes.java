package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.LifeInsurance;


import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.TravelTarget;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.TravelInsurance;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class TravelInsuranceRes extends LifeInsuranceRes <TravelInsurance> {

    private boolean EU;
    @NotNull
    private TravelTarget travelTarget;

    public TravelInsuranceRes(TravelInsurance contract)
    {
        super(contract);
        this.setEU(contract.getEU());
        this.setTravelTarget(contract.getTravelTarget());
    }

    @Override
    public TravelInsurance newInsurance() {
        return new TravelInsurance(getInsurerID(),getDateOfCreation(),getEffectiveBy(),getExpirationDate(), getInsuranceValue(),getMonthlyFee(),getInsured(),isEU(),getTravelTarget());
    }

    @Override
    public TravelInsurance editInsurance(TravelInsurance insurance)
    {
        insurance = super.editInsurance(insurance);
        insurance.setEU(isEU());
        insurance.setTravelTarget(getTravelTarget());
        return insurance;
    }
}
