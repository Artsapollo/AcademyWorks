package Lesson21.factory;

public class Sockss implements Socks {
    public int size;
    public String collor;

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
        return "Sockss{" +
                "size=" + size +
                ", collor='" + collor + '\'' +
                '}';
    }
}
