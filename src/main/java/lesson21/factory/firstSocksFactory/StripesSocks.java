package lesson21.factory.firstSocksFactory;

import lesson21.factory.Sockss;

public class StripesSocks extends Sockss {
    private String stripeType;

    public StripesSocks(int size, String color, String stripeType) {
        this.size = size;
        this.collor = color;
        this.stripeType = stripeType;
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

    public String getStripeType() {
        return stripeType;
    }

    public void setStripeType(String stripeType) {
        this.stripeType = stripeType;
    }

    @Override
    public String toString() {
        return "StripesSocks{ " +
                "stripeType = '" + stripeType + '\'' +
                ", size = " + size +
                ", collor = '" + collor + '\'' +
                '}';
    }
}
