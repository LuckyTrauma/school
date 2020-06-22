package sk.fei.stuba.oop.xdurinaa.zadanie2.Client;

public class Address {

    private String city;
    private String street;
    private int houseRef;
    private int ZIP;


    public Address(int ZIP, String city, String street, int houseNumber) {
        setCity(city);
        setStreet(street);
        setHouseNumber(houseNumber);
        setZIP(ZIP);
    }

    public void setCity(String city) {
        if (city.trim() == null) throw new IllegalArgumentException("City must be included");
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        if (street.trim() == null) throw new IllegalArgumentException("street cannot be null");
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setHouseNumber(int houseNumber) {
        if (houseNumber < 1) throw new IllegalArgumentException("HouseNumber must be included");
        this.houseRef = houseNumber;
    }

    public int getHouseNumber() {
        return houseRef;
    }

    public void setZIP(int ZIP) {
        if (ZIP < 0 || ZIP > 99999) throw new IllegalArgumentException("PSC must be included");
        this.ZIP = ZIP;
    }

    public int getZIP() {
        return ZIP;
    }

    @Override
    public String toString() {
        return  getCity()+ " " +  getStreet() + " " + getHouseNumber() + " " + getZIP();
    }
}
