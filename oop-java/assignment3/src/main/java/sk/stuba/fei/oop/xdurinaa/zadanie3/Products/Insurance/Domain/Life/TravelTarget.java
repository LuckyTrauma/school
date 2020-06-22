package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life;

public enum TravelTarget {

    WORK("Work"),
    RECREATIONAL("Recreational"),
    SPORT("Sport"),
    OTHER("Other");

    private String focus;

    TravelTarget(String focus) {
        this.focus = focus;
    }
    public String getFocus() {
        return focus;
    }
}