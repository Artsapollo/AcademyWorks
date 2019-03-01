package lesson21.factory.firstSocksFactory;

import lesson21.factory.Sockss;

public class WomenSocks extends Sockss {
    private String magic;

    public WomenSocks(int size, String collor, String magic) {
        this.size = size;
        this.collor = collor;
        this.magic = magic;
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

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    @Override
    public String toString() {
        return "WomenSocks{ " +
                "magic = '" + magic + '\'' +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
