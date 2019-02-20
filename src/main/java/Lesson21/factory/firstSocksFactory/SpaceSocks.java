package Lesson21.factory.firstSocksFactory;

import Lesson21.factory.Sockss;

public class SpaceSocks extends Sockss {
    private int protectionLevel;

    public SpaceSocks(int size, String collor, int protectionLevel) {
        this.size = size;
        this.collor = collor;
        this.protectionLevel = protectionLevel;
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

    public int getProtectionLevel() {
        return protectionLevel;
    }

    public void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    @Override
    public String toString() {
        return "SpaceSocks{ " +
                "protectionLevel = " + protectionLevel +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
