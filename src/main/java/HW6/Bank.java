package HW6;

public class Bank <A extends Assets> {
    private String name;
    private String country;
    private String address;
    public A assets;

    public Bank(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }
}
