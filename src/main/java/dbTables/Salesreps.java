package dbTables;

import Lesson16.Office;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SALESREPS", schema = "MA_STUDENT")
public class Salesreps implements java.io.Serializable {

    private BigDecimal emplNum;
    private String name;
    private BigDecimal age;
    private Offices repOffice;
    private String title;
    private Date hireDate;
    private BigDecimal manager;
    private BigDecimal quota;
    private Double sales;

    public Salesreps() {
    }

    public Salesreps(BigDecimal emplNum, String name, BigDecimal age, Offices repOffice, String title, Date hireDate, BigDecimal manager, BigDecimal quota, Double sales) {
        this.emplNum = emplNum;
        this.name = name;
        this.age = age;
        this.repOffice = repOffice;
        this.title = title;
        this.hireDate = hireDate;
        this.manager = manager;
        this.quota = quota;
        this.sales = sales;
    }

    @Id
    @Column(name = "EMPL_NUM")
    public BigDecimal getEmplNum() {
        return emplNum;
    }

    public void setEmplNum(BigDecimal emplNum) {
        this.emplNum = emplNum;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "AGE")
    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "REP_OFFICE")
    public Offices getRepOffice() {
        return repOffice;
    }

    public void setRepOffice(Offices repOffice) {
        this.repOffice = repOffice;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "HIRE_DATE")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "MANAGER")
    public BigDecimal getManager() {
        return manager;
    }

    public void setManager(BigDecimal manager) {
        this.manager = manager;
    }

    @Column(name = "QUOTA")
    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
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
        return "Salesreps{" +
                "emplNum=" + emplNum +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", repOffice=" + repOffice +
                ", title='" + title + '\'' +
                ", hireDate=" + hireDate +
                ", manager=" + manager +
                ", quota=" + quota +
                ", sales=" + sales +
                '}';
    }
}
