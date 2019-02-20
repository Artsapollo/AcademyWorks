package Lesson21.factory.firstSocksFactory;

import Lesson21.factory.Sockss;

public class InvisibleSocks extends Sockss {
    private int invisibilityType;

    public InvisibleSocks(int size, String collor, int invisibilityType) {
        this.size = size;
        this.collor = collor;
        this.invisibilityType = invisibilityType;
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

    public int getInvisibilityType() {
        return invisibilityType;
    }

    public void setInvisibilityType(int invisibilityType) {
        this.invisibilityType = invisibilityType;
    }

    @Override
    public String toString() {
        return "InvisibleSocks{ " +
                "invisibilityType = " + invisibilityType +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
