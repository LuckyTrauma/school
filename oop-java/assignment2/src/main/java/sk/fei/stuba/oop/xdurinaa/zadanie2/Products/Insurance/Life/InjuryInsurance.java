package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Life;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;

import java.time.LocalDate;

public class InjuryInsurance extends LifeInsurance {

        private double permanentInjury;
        private double deathInjury;
        private double dailyHosp;
        private ValidityArea area;

        public InjuryInsurance(Client creator, LocalDate validFrom, LocalDate validTo, float value, float monthlyFee, Client insured, float permanentInjury, float deathInjury, float dailyHosp, ValidityArea area) {
            super(creator, validFrom, validTo, value, monthlyFee, insured);
            setPermanentInjury(permanentInjury);
            setDeathInjury(deathInjury);
            setDailyHosp(dailyHosp);
            setValidityArea(area);
        }

        public void setPermanentInjury(float permanentInjury) {
            if (permanentInjury < 0) throw new IllegalArgumentException("Value of permanent injury cannot be negative");
            this.permanentInjury = permanentInjury;
        }

        public double getPermanentInjury() {
            return permanentInjury;
        }

        public void setDeathInjury(float deathInjury) {
            if (deathInjury < 0) throw new IllegalArgumentException("Value of death injury cannot be negative ");
            this.deathInjury = deathInjury;
        }

        public double getDeathInjury() {
            return deathInjury;
        }

        public void setDailyHosp(float dailyHosp) {
            if (dailyHosp < 0) throw new IllegalArgumentException("Value of hospitalization cannot be negative");
            this.dailyHosp = dailyHosp;
        }

        public double getHospitalization() {
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


