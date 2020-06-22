package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.LifeInsurance;

import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.ValidityArea;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.InjuryInsurance;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class InjuryInsuranceRes extends LifeInsuranceRes <InjuryInsurance> {
    @DecimalMin("0")
    private double PermanentInjury;
    @DecimalMin("0")
    private double DeathInjury;
    @DecimalMin("0")
    private double DailyHosp;
    @NotNull
    private ValidityArea ValidityArea;

    public InjuryInsuranceRes(InjuryInsurance insurance)
    {
        super(insurance);
        this.setPermanentInjury(insurance.getPermanentInjury());
        this.setDeathInjury(insurance.getDeathInjury());
        this.setDailyHosp(insurance.getDailyHosp());
        this.setValidityArea(insurance.getValidityArea());
    }

    public InjuryInsurance newInsurance()
    {
        return new InjuryInsurance(getInsurerID(),getDateOfCreation(),getEffectiveBy(),getExpirationDate(), getInsuranceValue(),getMonthlyFee(),getInsured(),getPermanentInjury(),getDeathInjury(),getDailyHosp(),getValidityArea());
    }

    @Override
    public InjuryInsurance editInsurance(InjuryInsurance insurance)
    {
        insurance = super.editInsurance(insurance);
        insurance.setPermanentInjury(getPermanentInjury());
        insurance.setDeathInjury(getDeathInjury());
        insurance.setDailyHosp(getDailyHosp());
        insurance.setValidityArea(getValidityArea());
        return insurance;
    }
}
