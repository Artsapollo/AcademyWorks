package dbTables;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "MA_STUDENT")
public class Orders implements java.io.Serializable {

    private BigDecimal orderNum;
    private Date orderDate;
    private String mfr;
    private Products product;
    private BigDecimal qty;
    private BigDecimal amount;

    public Orders() {
    }

    public Orders(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public Orders(BigDecimal orderNum, Date orderDate, String mfr, Products product, BigDecimal qty, BigDecimal amount) {
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        this.mfr = mfr;
        this.product = product;
        this.qty = qty;
        this.amount = amount;
    }

    @Id
    @Column(name = "ORDER_NUM")
    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "MFR")
    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Products.class)
    @JoinColumn(name = "PRODUCT")
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Column(name = "QTY")
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
