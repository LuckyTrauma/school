package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Life;

public enum ValidityArea {

    SLOVAKIA("Slovensko"),
    WORLD("Svet"),
    BOTH("Slovensko + Svet");

    private String name;

    ValidityArea(String name) {
        this.name = name;
    }
}
