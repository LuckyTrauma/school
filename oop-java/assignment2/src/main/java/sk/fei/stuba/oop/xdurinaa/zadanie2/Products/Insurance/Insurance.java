package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;
import java.time.LocalDate;
import java.util.UUID;

public abstract class Insurance {

    private UUID InsuranceID;
    private Client creator;
    private LocalDate creationDate;
    private LocalDate effectiveBy;
    private LocalDate expirationDate;
    private double value;
    private double monthlyFee;

    public Insurance(Client creator, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee) {
        InsuranceID = UUID.randomUUID();
        creationDate = LocalDate.now();
        setCreator(creator);
        setEffectiveBy(effectiveBy);
        setExpirationDate(expirationDate);
        setInsuranceValue(value);
        setMonthlyFee(monthlyFee);
    }

    public UUID getInsuranceId() {
        return InsuranceID;
    }

    public LocalDate getDateTime() {
        return creationDate;
    }

    public void setCreator(Client creator) {
        if (creator == null) throw new IllegalArgumentException("creator cannot be null");
        this.creator = creator;
    }

    public Client getCreator() {
        return creator;
    }

    public void setEffectiveBy(LocalDate effectiveBy) {
        if (effectiveBy == null) throw new IllegalArgumentException("Value of effective date cannot be null.");
        this.effectiveBy = effectiveBy;
    }

    public LocalDate getEffectiveBy() {
        return effectiveBy;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) throw new IllegalArgumentException("Value of expiration date cannot be null.");
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setInsuranceValue(double value) {
        if (value < 0) throw new IllegalArgumentException("Insurance value cannot be negative");
        this.value = value;
    }

    public double getInsuranceValue() {
        return value;
    }

    public void setMonthlyFee(double monthlyFee) {
        if (monthlyFee < 0) throw new IllegalArgumentException("Monthly fee cannot be less than 0");
        this.monthlyFee = monthlyFee;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

}
