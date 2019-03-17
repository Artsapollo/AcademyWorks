package lesson22UsingHibernate;

import lesson16.entity.Customer;
import lesson16.entity.Product;
import lesson16.entity.Salesrep;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "MA_STUDENT")
public class OrderModel implements java.io.Serializable {

    private BigDecimal orderNum;
    private Date orderDate;
    private String mfr;
    private Product product;
    private BigDecimal qty;
    private BigDecimal amount;
    private Customer customer;
    private Salesrep salesrep;

    public OrderModel() {
    }

    public OrderModel(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public OrderModel(BigDecimal orderNum, Date orderDate, String mfr, Product product, BigDecimal qty, BigDecimal amount) {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUST")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REP")
    public Salesrep getSalesrep() {
        return salesrep;
    }

    public void setSalesrep(Salesrep salesrep) {
        this.salesrep = salesrep;
    }

    @Override
    public String toString() {
        return "Orders{ " +
                " orderNum= " + orderNum +
                ", orderDate= " + orderDate +
                ", mfr= '" + mfr + '\'' +
                ", product= " + product.getProductId() +
                ", qty= " + qty +
                ", amount= " + amount +
                '}';
    }
}
