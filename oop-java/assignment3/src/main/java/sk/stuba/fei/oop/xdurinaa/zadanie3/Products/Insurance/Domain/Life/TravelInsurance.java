package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TravelInsurance extends LifeInsurance {

    private boolean EU;
    private TravelTarget travelFocus;
    private long insured;

    public TravelInsurance(long insurer, LocalDateTime dateTime, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, long insured, boolean EU, TravelTarget travelFocus) {
        super(insurer,dateTime,effectiveBy ,expirationDate, value, monthlyFee, insured);
        setEU(EU);
        setTravelTarget(travelFocus);
        setInsured(insured);
    }

    public void setTravelTarget(TravelTarget target) {
        if (target == null) throw new IllegalArgumentException("target cannot be null");
        this.travelFocus = target;
    }

    public TravelTarget getTravelTarget() {
        return travelFocus;
    }

    public void setEU(boolean EU) {
        this.EU = EU;
    }

    public boolean getEU() {
        return EU;
    }
}


