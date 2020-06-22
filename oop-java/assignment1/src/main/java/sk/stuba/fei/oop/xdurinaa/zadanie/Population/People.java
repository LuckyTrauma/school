package sk.stuba.fei.oop.xdurinaa.zadanie.Population;

public class People {

    private double suspectible;
    private double infectious;
    private double removed;

    public People(double suspectible, double infectious, double removed) {
        this.setSuspectible(suspectible);
        this.setInfectious(infectious);
        this.setRemoved(removed);
    }
    public People(double suspectible, double infectious) {
        this.setSuspectible(suspectible);
        this.setInfectious(infectious);
    }

    public void setSuspectible(double suspectible) {
        if ( suspectible < 1) throw  new IllegalArgumentException("Suspectible cannot be below 0");
        this.suspectible = suspectible;

    }

    public void setInfectious(double infectious) {
        if ( infectious < 1) throw  new IllegalArgumentException("Number cannot be below 0");
        this.infectious = infectious;
    }

    public void setRemoved(double removed) {
        if(removed < 0 || removed > 1) throw new IllegalArgumentException("Number must be in <0,1> interval");
        this.removed = removed;
    }


    public double getSuspectible() {
        return suspectible;
    }

    public double getInfectious() {
        return infectious;
    }

    public double getRemoved() {
        return removed;
    }





}
