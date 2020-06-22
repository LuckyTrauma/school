package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Life;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;

import java.time.LocalDate;

public class TravelInsurance extends LifeInsurance {

        private boolean EU;
        private TravelTarget travelFocus;

        public TravelInsurance(Client creator, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, Client insured, boolean EU, TravelTarget travelFocus) {
            super(creator, effectiveBy ,expirationDate, value, monthlyFee, insured);
            setEU(EU);
            setTravelTarget(travelFocus);
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


