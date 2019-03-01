package lesson21.factory.firstSocksFactory;

import lesson21.factory.Sockss;

public class SweatSocks extends Sockss {
    private String isItSweat;

    public SweatSocks (int size, String collor, String isItSweat) {
        this.size = size;
        this.collor = collor;
        this.isItSweat = isItSweat;
    }

    public String getIsItSweat() {
        return isItSweat;
    }

    public void setIsItSweat(String isItSweat) {
        this.isItSweat = isItSweat;
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
        return "SweatSocks{ " +
                "isItSweat = '" + isItSweat + '\'' +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
