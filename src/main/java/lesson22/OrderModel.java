package lesson22;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ORDERS", schema = "MA_STUDENT")
public class OrderModel implements java.io.Serializable {

    private BigDecimal orderNum;
    private Date orderDate;
    private String mfr;
    private String product;
    private BigDecimal qty;
    private BigDecimal amount;

    public OrderModel() {
    }

    public OrderModel(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public OrderModel(BigDecimal orderNum, Date orderDate, String mfr, String product, BigDecimal qty, BigDecimal amount) {
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

    @Column(name = "PRODUCT")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderModel)) return false;
        OrderModel that = (OrderModel) o;
        return getOrderNum().equals(that.getOrderNum()) &&
                getOrderDate().equals(that.getOrderDate()) &&
                getMfr().equals(that.getMfr()) &&
                getProduct().equals(that.getProduct()) &&
                getQty().equals(that.getQty()) &&
                getAmount().equals(that.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNum(), getOrderDate(), getMfr(), getProduct(), getQty(), getAmount());
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderNum=" + orderNum +
                ", orderDate=" + orderDate +
                ", mfr='" + mfr + '\'' +
                ", product='" + product + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
