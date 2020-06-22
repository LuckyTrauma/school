package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InjuryInsurance extends LifeInsurance {

    private double permanentInjury;
    private double deathInjury;
    private double dailyHosp;
    private ValidityArea area;

    public InjuryInsurance(long insurer, LocalDateTime dateTime, LocalDate effectiveBy, LocalDate ExpirationDate, double value, double monthlyFee, long insured, double permanentInjury, double deathInjury, double dailyHosp, ValidityArea area) {
        super(insurer,dateTime,effectiveBy, ExpirationDate, value, monthlyFee, insured);
        setPermanentInjury(permanentInjury);
        setDeathInjury(deathInjury);
        setDailyHosp(dailyHosp);
        setValidityArea(area);
    }

    public void setPermanentInjury(double permanentInjury) {
        if (permanentInjury < 0) throw new IllegalArgumentException("Value of permanent injury cannot be less than 0");
        this.permanentInjury = permanentInjury;
    }

    public double getPermanentInjury() {
        return permanentInjury;
    }

    public void setDeathInjury(double deathInjury) {
        if (deathInjury < 0) throw new IllegalArgumentException("Value of death injury cannot be cannot be less than 0 ");
        this.deathInjury = deathInjury;
    }

    public double getDeathInjury() {
        return deathInjury;
    }

    public void setDailyHosp(double dailyHosp) {
        if (dailyHosp < 0) throw new IllegalArgumentException("Value of hospitalization  cannot be less than 0");
        this.dailyHosp = dailyHosp;
    }

    public double getDailyHosp() {
        return dailyHosp;
    }

    public void setValidityArea(ValidityArea area) {
        if (area == null) throw new IllegalArgumentException("Area cannot be null");
        this.area = area;
    }

    public ValidityArea getValidityArea() {
        return area;
    }
}


