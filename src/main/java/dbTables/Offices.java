package dbTables;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "OFFICES", schema = "MA_STUDENT")
public class Offices implements java.io.Serializable {

    private BigDecimal office;
    private String city;
    private String region;
    private BigDecimal mgr;
    private BigDecimal target;
    private Double sales;

    public Offices() {
    }

    public Offices(String city) {
        this.city = city;
    }

    public Offices(BigDecimal office, String city, String region, BigDecimal mgr, BigDecimal target, Double sales) {
        this.office = office;
        this.city = city;
        this.region = region;
        this.mgr = mgr;
        this.target = target;
        this.sales = sales;
    }

    @Id
//    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "OFFICE")
    public BigDecimal getOffice() {
        return office;
    }

    public void setOffice(BigDecimal office) {
        this.office = office;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "MGR")
    public BigDecimal getMgr() {
        return mgr;
    }

    public void setMgr(BigDecimal mgr) {
        this.mgr = mgr;
    }

    @Column(name = "TARGET")
    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    @Column(name = "SALES")
    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Offices{ " +
                " office= " + office +
                ", city= '" + city + '\'' +
                ", region= '" + region + '\'' +
                ", mgr= " + mgr +
                ", target= " + target +
                ", sales= " + sales +
                '}';
    }
}
