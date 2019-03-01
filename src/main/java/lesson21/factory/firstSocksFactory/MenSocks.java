package lesson21.factory.firstSocksFactory;

import lesson21.factory.Sockss;

public class MenSocks extends Sockss {
    public String smell;

    public MenSocks(int size, String collor, String smell) {
        this.size = size;
        this.collor = collor;
        this.smell = smell;
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

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    @Override
    public String toString() {
        return "MenSocks{ " +
                "smell = '" + smell + '\'' +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
