package sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.NonLife;

public enum HouseType {

    FLAT("Byt"),
    BRICKHOUSE("Rodinny dom - murovany"),
    WOODENHOUSE("Rodinny dom - dreveny");

    private String name;

    HouseType(String name) {
        this.name = name;
    }
}
