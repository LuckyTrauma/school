package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Life;

public enum TravelTarget {

    WORK("Work"),
    RECREATIONAL("Recreational"),
    SPORT("Sport"),
    OTHER("Other");

    private String focus;

    TravelTarget(String focus) {
        this.focus = focus;
    }
}
