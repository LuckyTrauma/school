package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life;

public enum ValidityArea {

    SLOVAKIA("Slovensko"),
    WORLD("Svet"),
    BOTH("Slovensko + Svet");

    private String name;

    ValidityArea(String name) {
        this.name = name;
    }
    public String getName(){return name;}
}