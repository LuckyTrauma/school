package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web;

public enum InsuranceType {
    TRAVEL("travel"),
    INJURY("injury"),
    HOME("home"),
    FLAT_HOUSE("flat-house");

    private String view;

    public String getView() {
        return view;
    }

    InsuranceType(String view) {
        this.view = view;
    }
}