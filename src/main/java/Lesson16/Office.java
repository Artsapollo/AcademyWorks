package Lesson16;

import java.math.BigDecimal;
import java.util.Objects;

public class Office {

    private String office;
    private String city;
    private String region;
    private BigDecimal mgr;
    private BigDecimal target;
    private double sales;

    public Office() {

    }

    public Office(String city) {
        this.city = city;
    }

    public Office(String office, String city, String region, BigDecimal mgr, BigDecimal target, double sales) {
        this.office = office;
        this.city = city;
        this.region = region;
        this.mgr = mgr;
        this.target = target;
        this.sales = sales;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getMgr() {
        return mgr;
    }

    public void setMgr(BigDecimal mgr) {
        this.mgr = mgr;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office)) return false;
        Office office1 = (Office) o;
        return Double.compare(office1.getSales(), getSales()) == 0 &&
                getOffice().equals(office1.getOffice()) &&
                getCity().equals(office1.getCity()) &&
                getRegion().equals(office1.getRegion()) &&
                getMgr().equals(office1.getMgr()) &&
                getTarget().equals(office1.getTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOffice(), getCity(), getRegion(), getMgr(), getTarget(), getSales());
    }

    @Override
    public String toString() {
        return "Office{" +
                "office='" + office + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", mgr=" + mgr +
                ", target=" + target +
                ", sales=" + sales +
                '}';
    }
}
