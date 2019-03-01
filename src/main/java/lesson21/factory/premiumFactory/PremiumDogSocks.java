package lesson21.factory.premiumFactory;

import lesson21.factory.Sockss;

public class PremiumDogSocks extends Sockss {
    private String dogType;

    public PremiumDogSocks (int size, String collor, String dogType) {
        this.size = size;
        this.collor = collor;
        this.dogType = dogType;
    }

    public String getDogType() {
        return dogType;
    }

    public void setDogType(String dogType) {
        this.dogType = dogType;
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public String getCollor() {
        return collor;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void setCollor(String collor) {
        this.collor = collor;
    }

    @Override
    public String toString() {
        return "PremiumDogSocks{ " +
                "dogType = '" + dogType + '\'' +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
