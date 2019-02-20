package Lesson21.factory.premiumFactory;

import Lesson21.factory.Sockss;

public class PremiumAuntGalyaSocks extends Sockss {
    private String withLove;

    public PremiumAuntGalyaSocks (int size, String collor, String withLove) {
        this.size = size;
        this.collor = collor;
        this.withLove = withLove;
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

    public String getWithLove() {
        return withLove;
    }

    public void setWithLove(String withLove) {
        this.withLove = withLove;
    }

    @Override
    public String toString() {
        return "PremiumAuntGalyaSocks{" +
                "withLove = '" + withLove + '\'' +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
