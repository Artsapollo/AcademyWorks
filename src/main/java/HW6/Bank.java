package HW6;

public class Bank <T extends Assets> {
    private String name;
    private String country;
    private String address;
    private T assets;

    public Bank(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public T getAssets() {
        return assets;
    }

    public void setAssets(T assets) {
        this.assets = assets;
    }
}
