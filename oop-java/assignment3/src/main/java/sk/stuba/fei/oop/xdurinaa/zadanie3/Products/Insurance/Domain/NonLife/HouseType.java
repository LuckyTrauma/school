package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife;

public enum HouseType {

    FLAT("Byt"),
    BRICKHOUSE("Rodinny dom - murovany"),
    WOODENHOUSE("Rodinny dom - dreveny");

    private String name;

    HouseType(String name) {
        this.name = name;
    }
    public String getName(){return name;}
}
