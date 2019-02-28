package dbTables;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CUSTOMERS", schema = "MA_STUDENT")
public class Customers implements java.io.Serializable {
    private BigDecimal custNum;
    private String company;
    private Salesreps custRep;
    private Double creditLimit;

    public Customers() {
    }

    public Customers(BigDecimal custNum, String company, Salesreps custRep, Double creditLimit) {
        this.custNum = custNum;
        this.company = company;
        this.custRep = custRep;
        this.creditLimit = creditLimit;
    }

    @Id
    @Column(name = "CUST_NUM")
    public BigDecimal getCustNum() {
        return custNum;
    }

    public void setCustNum(BigDecimal custNum) {
        this.custNum = custNum;
    }

    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "CUST_REP")
    public Salesreps getCustRep() {
        return custRep;
    }

    public void setCustRep(Salesreps custRep) {
        this.custRep = custRep;
    }

    @Column(name = "CREDIT_LIMIT")
    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "custNum=" + custNum +
                ", company='" + company + '\'' +
                ", custRep=" + custRep +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
