package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Insurance {


    private long InsurerID;
    private long InsuranceID;
    private LocalDateTime creationDate;
    private LocalDate effectiveBy;
    private LocalDate expirationDate;
    private double value;
    private double monthlyFee;

    private static final AtomicLong idGenerator = new AtomicLong();

    public Insurance(long InsurerID,LocalDateTime creationDate, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee) {
        this.setInsuranceID(idGenerator.getAndIncrement());
        this.creationDate = LocalDateTime.now();
        setEffectiveBy(effectiveBy);
        setExpirationDate(expirationDate);
        setValue(value);
        setMonthlyFee(monthlyFee);
        this.setInsurerID(InsurerID);
    }

    public long getInsuranceID() {
        return InsuranceID;
    }

    private void setInsuranceID(long id) {
        if(id < 0) throw new IllegalArgumentException("ID cannot be less than 0");
        this.InsuranceID = id;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
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

    public void setValue(double value) {
        if (value < 0) throw new IllegalArgumentException("Insurance value cannot be negative");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setMonthlyFee(double monthlyFee) {
        if (monthlyFee < 0) throw new IllegalArgumentException("Monthly fee cannot be less than 0");
        this.monthlyFee = monthlyFee;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public long getInsurerID() {
        return InsurerID;
    }

    public void setInsurerID(long insurerID) {
        InsurerID = insurerID;
    }
}
