package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Life;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Insurance;
import java.time.LocalDate;

public abstract class LifeInsurance extends Insurance {

        private Client insured;

        public LifeInsurance(Client insurer, LocalDate effectiveBy, LocalDate expirationDate, double value, double monthlyFee, Client insured) {
            super(insurer, effectiveBy, expirationDate, value, monthlyFee);
            setInsured(insured);
        }

        public void setInsured(Client insured) {
            if (insured == null) throw new IllegalArgumentException("insured cannot be null");
            this.insured = insured;
        }

        public Client getInsured() {
            return insured;
        }
    }

