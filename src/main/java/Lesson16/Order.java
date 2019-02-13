package Lesson16;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private BigDecimal orderNum;
    private Product product;
    private Date orderDate;
    private String mfr;
    private BigDecimal qty;
    private BigDecimal amount;

    public Order(){

    }

    public Order(BigDecimal orderNum, Product product) {
        this.orderNum = orderNum;
        this.product = product;
    }

    public Order(BigDecimal orderNum, Product product, Date orderDate, String mfr, BigDecimal qty, BigDecimal amount) {
        this.orderNum = orderNum;
        this.product = product;
        this.orderDate = orderDate;
        this.mfr = mfr;
        this.qty = qty;
        this.amount = amount;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{ " +
                "Order number = " + orderNum +
                ", product = " + product +
                ", order Date = " + orderDate +
                ", mfr = '" + mfr + '\'' +
                ", qty = " + qty +
                ", amount = " + amount +
                '}';
    }
}
