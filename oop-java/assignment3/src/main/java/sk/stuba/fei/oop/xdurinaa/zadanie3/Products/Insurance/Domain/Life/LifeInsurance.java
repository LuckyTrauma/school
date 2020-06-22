package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life;

import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Insurance;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class LifeInsurance extends Insurance {

    private long insured;

    public LifeInsurance(long insurer, LocalDateTime dateTime, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, long insured) {
        super(insurer,dateTime, effectiveBy, expirationDate, value, monthlyFee);
        setInsured(insured);
    }

    public void setInsured(long insured) {
        if (insured < 0) throw new IllegalArgumentException("insured cannot be null");
        this.insured = insured;
    }

    public long getInsured() {
        return insured;
    }
}


