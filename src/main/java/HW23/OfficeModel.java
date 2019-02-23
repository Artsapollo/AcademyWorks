package HW23;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "OFFICES", schema = "MA_STUDENT")
public class OfficeModel implements java.io.Serializable {
    private BigDecimal office;
    private String city;
    private String region;
    private BigDecimal mgr;
    private BigDecimal target;
    private Double sales;

    public OfficeModel() {
    }

    public OfficeModel(BigDecimal office, String city, String region, BigDecimal mgr, BigDecimal target, Double sales) {
        this.office = office;
        this.city = city;
        this.region = region;
        this.mgr = mgr;
        this.target = target;
        this.sales = sales;
    }

    @Id
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
        return "OfficeModel{" +
                "office=" + office +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", mgr=" + mgr +
                ", target=" + target +
                ", sales=" + sales +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfficeModel)) return false;
        OfficeModel that = (OfficeModel) o;
        return Objects.equals(getOffice(), that.getOffice()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getRegion(), that.getRegion()) &&
                Objects.equals(getMgr(), that.getMgr()) &&
                Objects.equals(getTarget(), that.getTarget()) &&
                Objects.equals(getSales(), that.getSales());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOffice(), getCity(), getRegion(), getMgr(), getTarget(), getSales());
    }
}
